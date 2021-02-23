package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CommandHandler implements ExecutionListener {

    /* renamed from: d */
    private static final String f5168d = Logger.tagWithPrefix("CommandHandler");

    /* renamed from: a */
    private final Context f5169a;

    /* renamed from: b */
    private final Map<String, ExecutionListener> f5170b = new HashMap();

    /* renamed from: c */
    private final Object f5171c = new Object();

    CommandHandler(@NonNull Context context) {
        this.f5169a = context;
    }

    /* renamed from: a */
    static Intent m3922a(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* renamed from: b */
    static Intent m3923b(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: c */
    static Intent m3924c(@NonNull Context context, @NonNull String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    /* renamed from: d */
    static Intent m3925d(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* renamed from: e */
    static Intent m3926e(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: f */
    static Intent m3927f(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: g */
    private void m3928g(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(f5168d, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new C1095b(this.f5169a, i, systemAlarmDispatcher).mo8919a();
    }

    /* renamed from: h */
    private void m3929h(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.f5171c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            Logger logger = Logger.get();
            String str = f5168d;
            logger.debug(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f5170b.containsKey(string)) {
                DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f5169a, i, string, systemAlarmDispatcher);
                this.f5170b.put(string, delayMetCommandHandler);
                delayMetCommandHandler.mo8903b();
            } else {
                Logger.get().debug(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    /* renamed from: i */
    private void m3930i(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger.get().debug(f5168d, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        onExecuted(string, z);
    }

    /* renamed from: j */
    private void m3931j(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(f5168d, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        systemAlarmDispatcher.mo8910e().rescheduleEligibleWork();
    }

    /* renamed from: k */
    private void m3932k(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger logger = Logger.get();
        String str = f5168d;
        logger.debug(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase workDatabase = systemAlarmDispatcher.mo8910e().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                Logger logger2 = Logger.get();
                logger2.warning(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (workSpec.state.isFinished()) {
                Logger logger3 = Logger.get();
                logger3.warning(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                workDatabase.endTransaction();
            } else {
                long calculateNextRunTime = workSpec.calculateNextRunTime();
                if (!workSpec.hasConstraints()) {
                    Logger.get().debug(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                    C1094a.m3956c(this.f5169a, systemAlarmDispatcher.mo8910e(), string, calculateNextRunTime);
                } else {
                    Logger.get().debug(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                    C1094a.m3956c(this.f5169a, systemAlarmDispatcher.mo8910e(), string, calculateNextRunTime);
                    systemAlarmDispatcher.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher, m3922a(this.f5169a), i));
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            }
        } finally {
            workDatabase.endTransaction();
        }
    }

    /* renamed from: l */
    private void m3933l(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger.get().debug(f5168d, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        systemAlarmDispatcher.mo8910e().stopWork(string);
        C1094a.m3954a(this.f5169a, systemAlarmDispatcher.mo8910e(), string);
        systemAlarmDispatcher.onExecuted(string, false);
    }

    /* renamed from: m */
    private static boolean m3934m(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo8898n() {
        boolean z;
        synchronized (this.f5171c) {
            z = !this.f5170b.isEmpty();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: o */
    public void mo8899o(@NonNull Intent intent, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            m3928g(intent, i, systemAlarmDispatcher);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            m3931j(intent, i, systemAlarmDispatcher);
        } else {
            if (!m3934m(intent.getExtras(), "KEY_WORKSPEC_ID")) {
                Logger.get().error(f5168d, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
            } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
                m3932k(intent, i, systemAlarmDispatcher);
            } else if ("ACTION_DELAY_MET".equals(action)) {
                m3929h(intent, i, systemAlarmDispatcher);
            } else if ("ACTION_STOP_WORK".equals(action)) {
                m3933l(intent, i, systemAlarmDispatcher);
            } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
                m3930i(intent, i, systemAlarmDispatcher);
            } else {
                Logger.get().warning(f5168d, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
            }
        }
    }

    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.f5171c) {
            ExecutionListener remove = this.f5170b.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z);
            }
        }
    }
}
