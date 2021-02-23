package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobService extends JobService implements ExecutionListener {

    /* renamed from: c */
    private static final String f5230c = Logger.tagWithPrefix("SystemJobService");

    /* renamed from: a */
    private WorkManagerImpl f5231a;

    /* renamed from: b */
    private final Map<String, JobParameters> f5232b = new HashMap();

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            this.f5231a = instance;
            instance.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(f5230c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f5231a;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    public void onExecuted(@NonNull String str, boolean z) {
        JobParameters remove;
        Logger.get().debug(f5230c, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.f5232b) {
            remove = this.f5232b.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        r2 = null;
        r3 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r3 < 24) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        r2 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        r2.triggeredContentUris = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r2.triggeredContentAuthorities = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (r3 < 28) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r2.network = r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b8, code lost:
        r8.f5231a.startWork(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.WorkManagerImpl r0 = r8.f5231a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = f5230c
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.debug(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            android.os.PersistableBundle r0 = r9.getExtras()
            if (r0 != 0) goto L_0x002b
            androidx.work.Logger r9 = androidx.work.Logger.get()
            java.lang.String r0 = f5230c
            java.lang.String r1 = "No extras in JobParameters."
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.error(r0, r1, r3)
            return r2
        L_0x002b:
            java.lang.String r3 = "EXTRA_WORK_SPEC_ID"
            java.lang.String r0 = r0.getString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0045
            androidx.work.Logger r9 = androidx.work.Logger.get()
            java.lang.String r0 = f5230c
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.error(r0, r1, r3)
            return r2
        L_0x0045:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.f5232b
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.f5232b     // Catch:{ all -> 0x00be }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x0067
            androidx.work.Logger r9 = androidx.work.Logger.get()     // Catch:{ all -> 0x00be }
            java.lang.String r4 = f5230c     // Catch:{ all -> 0x00be }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00be }
            r1[r2] = r0     // Catch:{ all -> 0x00be }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00be }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00be }
            r9.debug(r4, r0, r1)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            return r2
        L_0x0067:
            androidx.work.Logger r4 = androidx.work.Logger.get()     // Catch:{ all -> 0x00be }
            java.lang.String r5 = f5230c     // Catch:{ all -> 0x00be }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00be }
            r7[r2] = r0     // Catch:{ all -> 0x00be }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00be }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00be }
            r4.debug(r5, r6, r2)     // Catch:{ all -> 0x00be }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.f5232b     // Catch:{ all -> 0x00be }
            r2.put(r0, r9)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x00b8
            androidx.work.WorkerParameters$RuntimeExtras r2 = new androidx.work.WorkerParameters$RuntimeExtras
            r2.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L_0x009e
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r2.triggeredContentUris = r4
        L_0x009e:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x00ae
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r2.triggeredContentAuthorities = r4
        L_0x00ae:
            r4 = 28
            if (r3 < r4) goto L_0x00b8
            android.net.Network r9 = r9.getNetwork()
            r2.network = r9
        L_0x00b8:
            androidx.work.impl.WorkManagerImpl r9 = r8.f5231a
            r9.startWork(r0, r2)
            return r1
        L_0x00be:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f5231a == null) {
            Logger.get().debug(f5230c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras == null) {
            Logger.get().error(f5230c, "No extras in JobParameters.", new Throwable[0]);
            return false;
        }
        String string = extras.getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            Logger.get().error(f5230c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(f5230c, String.format("onStopJob for %s", new Object[]{string}), new Throwable[0]);
        synchronized (this.f5232b) {
            this.f5232b.remove(string);
        }
        this.f5231a.stopWork(string);
        return !this.f5231a.getProcessor().isCancelled(string);
    }
}
