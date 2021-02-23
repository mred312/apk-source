package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobScheduler implements Scheduler {

    /* renamed from: f */
    private static final String f5224f = Logger.tagWithPrefix("SystemJobScheduler");

    /* renamed from: a */
    private final Context f5225a;

    /* renamed from: b */
    private final JobScheduler f5226b;

    /* renamed from: c */
    private final WorkManagerImpl f5227c;

    /* renamed from: d */
    private final IdGenerator f5228d;

    /* renamed from: e */
    private final C1100a f5229e;

    public SystemJobScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new C1100a(context));
    }

    /* renamed from: a */
    private static void m3962a(@NonNull JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.get().error(f5224f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)}), th);
        }
    }

    @Nullable
    /* renamed from: b */
    private static List<Integer> m3963b(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> c = m3964c(context, jobScheduler);
        if (c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : c) {
            PersistableBundle extras = next.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID") && str.equals(extras.getString("EXTRA_WORK_SPEC_ID"))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: c */
    private static List<JobInfo> m3964c(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(f5224f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void cancelAll(@NonNull Context context) {
        List<JobInfo> c;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (c = m3964c(context, jobScheduler)) != null && !c.isEmpty()) {
            for (JobInfo id : c) {
                m3962a(jobScheduler, id.getId());
            }
        }
    }

    public static void cancelInvalidJobs(@NonNull Context context) {
        List<JobInfo> c;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (c = m3964c(context, jobScheduler)) != null && !c.isEmpty()) {
            for (JobInfo next : c) {
                PersistableBundle extras = next.getExtras();
                if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    m3962a(jobScheduler, next.getId());
                }
            }
        }
    }

    public void cancel(@NonNull String str) {
        List<Integer> b = m3963b(this.f5225a, this.f5226b, str);
        if (b != null && !b.isEmpty()) {
            for (Integer intValue : b) {
                m3962a(this.f5226b, intValue.intValue());
            }
            this.f5227c.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
        }
    }

    /* JADX INFO: finally extract failed */
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        int i;
        List<Integer> b;
        int i2;
        WorkDatabase workDatabase = this.f5227c.getWorkDatabase();
        int length = workSpecArr.length;
        int i3 = 0;
        while (i3 < length) {
            WorkSpec workSpec = workSpecArr[i3];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.f5281id);
                if (workSpec2 == null) {
                    Logger logger = Logger.get();
                    String str = f5224f;
                    logger.warning(str, "Skipping scheduling " + workSpec.f5281id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger logger2 = Logger.get();
                    String str2 = f5224f;
                    logger2.warning(str2, "Skipping scheduling " + workSpec.f5281id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.f5281id);
                    if (systemIdInfo != null) {
                        i = systemIdInfo.systemId;
                    } else {
                        i = this.f5228d.nextJobSchedulerIdWithRange(this.f5227c.getConfiguration().getMinJobSchedulerId(), this.f5227c.getConfiguration().getMaxJobSchedulerId());
                    }
                    if (systemIdInfo == null) {
                        this.f5227c.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workSpec.f5281id, i));
                    }
                    scheduleInternal(workSpec, i);
                    if (Build.VERSION.SDK_INT == 23 && (b = m3963b(this.f5225a, this.f5226b, workSpec.f5281id)) != null) {
                        int indexOf = b.indexOf(Integer.valueOf(i));
                        if (indexOf >= 0) {
                            b.remove(indexOf);
                        }
                        if (!b.isEmpty()) {
                            i2 = b.get(0).intValue();
                        } else {
                            i2 = this.f5228d.nextJobSchedulerIdWithRange(this.f5227c.getConfiguration().getMinJobSchedulerId(), this.f5227c.getConfiguration().getMaxJobSchedulerId());
                        }
                        scheduleInternal(workSpec, i2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
                i3++;
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    @VisibleForTesting
    public void scheduleInternal(WorkSpec workSpec, int i) {
        JobInfo a = this.f5229e.mo8930a(workSpec, i);
        Logger.get().debug(f5224f, String.format("Scheduling work ID %s Job ID %s", new Object[]{workSpec.f5281id, Integer.valueOf(i)}), new Throwable[0]);
        try {
            this.f5226b.schedule(a);
        } catch (IllegalStateException e) {
            List<JobInfo> c = m3964c(this.f5225a, this.f5226b);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(c != null ? c.size() : 0), Integer.valueOf(this.f5227c.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.f5227c.getConfiguration().getMaxSchedulerLimit())});
            Logger.get().error(f5224f, format, new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            Logger.get().error(f5224f, String.format("Unable to schedule %s", new Object[]{workSpec}), th);
        }
    }

    @VisibleForTesting
    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, C1100a aVar) {
        this.f5225a = context;
        this.f5227c = workManagerImpl;
        this.f5226b = jobScheduler;
        this.f5228d = new IdGenerator(context);
        this.f5229e = aVar;
    }
}
