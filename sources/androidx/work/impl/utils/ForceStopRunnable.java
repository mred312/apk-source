package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {

    /* renamed from: c */
    private static final String f5317c = Logger.tagWithPrefix("ForceStopRunnable");

    /* renamed from: d */
    private static final long f5318d = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a */
    private final Context f5319a;

    /* renamed from: b */
    private final WorkManagerImpl f5320b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a */
        private static final String f5321a = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.get().verbose(f5321a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.m4023c(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.f5319a = context.getApplicationContext();
        this.f5320b = workManagerImpl;
    }

    @VisibleForTesting
    /* renamed from: a */
    static Intent m4021a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    /* renamed from: b */
    private static PendingIntent m4022b(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, m4021a(context), i);
    }

    /* renamed from: c */
    static void m4023c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent b = m4022b(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f5318d;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, b);
        } else {
            alarmManager.set(0, currentTimeMillis, b);
        }
    }

    @VisibleForTesting
    public boolean cleanUp() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelInvalidJobs(this.f5319a);
        }
        WorkDatabase workDatabase = this.f5320b.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            boolean z = runningWork != null && !runningWork.isEmpty();
            if (z) {
                for (WorkSpec next : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, next.f5281id);
                    workSpecDao.markWorkSpecScheduled(next.f5281id, -1);
                }
            }
            workDatabase.setTransactionSuccessful();
            return z;
        } finally {
            workDatabase.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: d */
    public boolean mo9059d() {
        return this.f5320b.getPreferences().needsReschedule();
    }

    @VisibleForTesting
    public boolean isForceStopped() {
        if (m4022b(this.f5319a, 536870912) != null) {
            return false;
        }
        m4023c(this.f5319a);
        return true;
    }

    public void run() {
        Logger logger = Logger.get();
        String str = f5317c;
        logger.debug(str, "Performing cleanup operations.", new Throwable[0]);
        boolean cleanUp = cleanUp();
        if (mo9059d()) {
            Logger.get().debug(str, "Rescheduling Workers.", new Throwable[0]);
            this.f5320b.rescheduleEligibleWork();
            this.f5320b.getPreferences().setNeedsReschedule(false);
        } else if (isForceStopped()) {
            Logger.get().debug(str, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f5320b.rescheduleEligibleWork();
        } else if (cleanUp) {
            Logger.get().debug(str, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.schedule(this.f5320b.getConfiguration(), this.f5320b.getWorkDatabase(), this.f5320b.getSchedulers());
        }
        this.f5320b.onForceStopRunnableCompleted();
    }
}
