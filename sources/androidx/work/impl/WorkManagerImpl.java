package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.C1074R;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.Preferences;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;

    /* renamed from: j */
    private static WorkManagerImpl f5116j;

    /* renamed from: k */
    private static WorkManagerImpl f5117k;

    /* renamed from: l */
    private static final Object f5118l = new Object();

    /* renamed from: a */
    private Context f5119a;

    /* renamed from: b */
    private Configuration f5120b;

    /* renamed from: c */
    private WorkDatabase f5121c;

    /* renamed from: d */
    private TaskExecutor f5122d;

    /* renamed from: e */
    private List<Scheduler> f5123e;

    /* renamed from: f */
    private Processor f5124f;

    /* renamed from: g */
    private Preferences f5125g;

    /* renamed from: h */
    private boolean f5126h;

    /* renamed from: i */
    private BroadcastReceiver.PendingResult f5127i;

    /* renamed from: androidx.work.impl.WorkManagerImpl$a */
    class C1085a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SettableFuture f5128a;

        /* renamed from: b */
        final /* synthetic */ Preferences f5129b;

        C1085a(WorkManagerImpl workManagerImpl, SettableFuture settableFuture, Preferences preferences) {
            this.f5128a = settableFuture;
            this.f5129b = preferences;
        }

        public void run() {
            try {
                this.f5128a.set(Long.valueOf(this.f5129b.getLastCancelAllTimeMillis()));
            } catch (Throwable th) {
                this.f5128a.setException(th);
            }
        }
    }

    /* renamed from: androidx.work.impl.WorkManagerImpl$b */
    class C1086b implements Function<List<WorkSpec.WorkInfoPojo>, WorkInfo> {
        C1086b(WorkManagerImpl workManagerImpl) {
        }

        /* renamed from: a */
        public WorkInfo apply(List<WorkSpec.WorkInfoPojo> list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).toWorkInfo();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(C1074R.bool.workmanager_test_configuration));
    }

    /* renamed from: a */
    private WorkContinuationImpl m3903a(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        ExistingWorkPolicy existingWorkPolicy;
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP) {
            existingWorkPolicy = ExistingWorkPolicy.KEEP;
        } else {
            existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, Collections.singletonList(periodicWorkRequest));
    }

    /* renamed from: c */
    private void m3904c(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list, @NonNull Processor processor) {
        Context applicationContext = context.getApplicationContext();
        this.f5119a = applicationContext;
        this.f5120b = configuration;
        this.f5122d = taskExecutor;
        this.f5121c = workDatabase;
        this.f5123e = list;
        this.f5124f = processor;
        this.f5125g = new Preferences(applicationContext);
        this.f5126h = false;
        this.f5122d.executeOnBackgroundThread(new ForceStopRunnable(applicationContext, this));
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance() {
        synchronized (f5118l) {
            WorkManagerImpl workManagerImpl = f5116j;
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            WorkManagerImpl workManagerImpl2 = f5117k;
            return workManagerImpl2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void initialize(@NonNull Context context, @NonNull Configuration configuration) {
        synchronized (f5118l) {
            WorkManagerImpl workManagerImpl = f5116j;
            if (workManagerImpl != null) {
                if (f5117k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class levelJavadoc for more information.");
                }
            }
            if (workManagerImpl == null) {
                Context applicationContext = context.getApplicationContext();
                if (f5117k == null) {
                    f5117k = new WorkManagerImpl(applicationContext, configuration, new WorkManagerTaskExecutor(configuration.getTaskExecutor()));
                }
                f5116j = f5117k;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(WorkManagerImpl workManagerImpl) {
        synchronized (f5118l) {
            f5116j = workManagerImpl;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public LiveData<List<WorkInfo>> mo8862b(@NonNull List<String> list) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.f5121c.workSpecDao().getWorkStatusPojoLiveDataForIds(list), WorkSpec.WORK_INFO_MAPPER, this.f5122d);
    }

    @NonNull
    public WorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, str, existingWorkPolicy, list);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @NonNull
    public WorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @NonNull
    public Operation cancelAllWork() {
        CancelWorkRunnable forAll = CancelWorkRunnable.forAll(this);
        this.f5122d.executeOnBackgroundThread(forAll);
        return forAll.getOperation();
    }

    @NonNull
    public Operation cancelAllWorkByTag(@NonNull String str) {
        CancelWorkRunnable forTag = CancelWorkRunnable.forTag(str, this);
        this.f5122d.executeOnBackgroundThread(forTag);
        return forTag.getOperation();
    }

    @NonNull
    public Operation cancelUniqueWork(@NonNull String str) {
        CancelWorkRunnable forName = CancelWorkRunnable.forName(str, this, true);
        this.f5122d.executeOnBackgroundThread(forName);
        return forName.getOperation();
    }

    @NonNull
    public Operation cancelWorkById(@NonNull UUID uuid) {
        CancelWorkRunnable forId = CancelWorkRunnable.forId(uuid, this);
        this.f5122d.executeOnBackgroundThread(forId);
        return forId.getOperation();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> createSchedulers(Context context, TaskExecutor taskExecutor) {
        return Arrays.asList(new Scheduler[]{Schedulers.m3889a(context, this), new GreedyScheduler(context, taskExecutor, this)});
    }

    @NonNull
    public Operation enqueue(@NonNull List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @NonNull
    public Operation enqueueUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        return m3903a(str, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    @NonNull
    public Operation enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).enqueue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.f5119a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Configuration getConfiguration() {
        return this.f5120b;
    }

    @NonNull
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        SettableFuture create = SettableFuture.create();
        this.f5122d.executeOnBackgroundThread(new C1085a(this, create, this.f5125g));
        return create;
    }

    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.f5125g.getLastCancelAllTimeMillisLiveData();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Preferences getPreferences() {
        return this.f5125g;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.f5124f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.f5123e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.f5121c;
    }

    @NonNull
    public ListenableFuture<WorkInfo> getWorkInfoById(@NonNull UUID uuid) {
        StatusRunnable<WorkInfo> forUUID = StatusRunnable.forUUID(this, uuid);
        this.f5122d.getBackgroundExecutor().execute(forUUID);
        return forUUID.getFuture();
    }

    @NonNull
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(@NonNull UUID uuid) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.f5121c.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(uuid.toString())), new C1086b(this), this.f5122d);
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(@NonNull String str) {
        StatusRunnable<List<WorkInfo>> forTag = StatusRunnable.forTag(this, str);
        this.f5122d.getBackgroundExecutor().execute(forTag);
        return forTag.getFuture();
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@NonNull String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.f5121c.workSpecDao().getWorkStatusPojoLiveDataForTag(str), WorkSpec.WORK_INFO_MAPPER, this.f5122d);
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(@NonNull String str) {
        StatusRunnable<List<WorkInfo>> forUniqueWork = StatusRunnable.forUniqueWork(this, str);
        this.f5122d.getBackgroundExecutor().execute(forUniqueWork);
        return forUniqueWork.getFuture();
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@NonNull String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.f5121c.workSpecDao().getWorkStatusPojoLiveDataForName(str), WorkSpec.WORK_INFO_MAPPER, this.f5122d);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.f5122d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        synchronized (f5118l) {
            this.f5126h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f5127i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f5127i = null;
            }
        }
    }

    @NonNull
    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.f5122d.executeOnBackgroundThread(pruneWorkRunnable);
        return pruneWorkRunnable.getOperation();
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelAll(getApplicationContext());
        }
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f5118l) {
            this.f5127i = pendingResult;
            if (this.f5126h) {
                pendingResult.finish();
                this.f5127i = null;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(String str) {
        startWork(str, (WorkerParameters.RuntimeExtras) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopWork(String str) {
        this.f5122d.executeOnBackgroundThread(new StopWorkRunnable(this, str));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f5122d.executeOnBackgroundThread(new StartWorkRunnable(this, str, runtimeExtras));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, boolean z) {
        Context applicationContext = context.getApplicationContext();
        WorkDatabase create = WorkDatabase.create(applicationContext, configuration.getTaskExecutor(), z);
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        Context context2 = context;
        Configuration configuration2 = configuration;
        TaskExecutor taskExecutor2 = taskExecutor;
        WorkDatabase workDatabase = create;
        List<Scheduler> createSchedulers = createSchedulers(applicationContext, taskExecutor);
        m3904c(context2, configuration2, taskExecutor2, workDatabase, createSchedulers, new Processor(context2, configuration2, taskExecutor2, workDatabase, createSchedulers));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(@NonNull Context context) {
        WorkManagerImpl instance;
        synchronized (f5118l) {
            instance = getInstance();
            if (instance == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Configuration.Provider) {
                    initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                    instance = getInstance(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return instance;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list, @NonNull Processor processor) {
        m3904c(context, configuration, taskExecutor, workDatabase, list, processor);
    }
}
