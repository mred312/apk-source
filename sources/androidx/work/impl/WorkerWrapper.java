package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkerWrapper implements Runnable {

    /* renamed from: s */
    static final String f5130s = Logger.tagWithPrefix("WorkerWrapper");

    /* renamed from: a */
    private Context f5131a;

    /* renamed from: b */
    private String f5132b;

    /* renamed from: c */
    private List<Scheduler> f5133c;

    /* renamed from: d */
    private WorkerParameters.RuntimeExtras f5134d;

    /* renamed from: e */
    WorkSpec f5135e;

    /* renamed from: f */
    ListenableWorker f5136f;
    @NonNull

    /* renamed from: g */
    ListenableWorker.Result f5137g = ListenableWorker.Result.failure();

    /* renamed from: h */
    private Configuration f5138h;

    /* renamed from: i */
    private TaskExecutor f5139i;

    /* renamed from: j */
    private WorkDatabase f5140j;

    /* renamed from: k */
    private WorkSpecDao f5141k;

    /* renamed from: l */
    private DependencyDao f5142l;

    /* renamed from: m */
    private WorkTagDao f5143m;

    /* renamed from: n */
    private List<String> f5144n;

    /* renamed from: o */
    private String f5145o;
    @NonNull

    /* renamed from: p */
    private SettableFuture<Boolean> f5146p = SettableFuture.create();
    @Nullable

    /* renamed from: q */
    ListenableFuture<ListenableWorker.Result> f5147q = null;

    /* renamed from: r */
    private volatile boolean f5148r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Builder {
        @NonNull

        /* renamed from: a */
        Context f5149a;
        @Nullable

        /* renamed from: b */
        ListenableWorker f5150b;
        @NonNull

        /* renamed from: c */
        TaskExecutor f5151c;
        @NonNull

        /* renamed from: d */
        Configuration f5152d;
        @NonNull

        /* renamed from: e */
        WorkDatabase f5153e;
        @NonNull

        /* renamed from: f */
        String f5154f;

        /* renamed from: g */
        List<Scheduler> f5155g;
        @NonNull

        /* renamed from: h */
        WorkerParameters.RuntimeExtras f5156h = new WorkerParameters.RuntimeExtras();

        public Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.f5149a = context.getApplicationContext();
            this.f5151c = taskExecutor;
            this.f5152d = configuration;
            this.f5153e = workDatabase;
            this.f5154f = str;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        public Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f5156h = runtimeExtras;
            }
            return this;
        }

        public Builder withSchedulers(List<Scheduler> list) {
            this.f5155g = list;
            return this;
        }

        @VisibleForTesting
        public Builder withWorker(ListenableWorker listenableWorker) {
            this.f5150b = listenableWorker;
            return this;
        }
    }

    /* renamed from: androidx.work.impl.WorkerWrapper$a */
    class C1087a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SettableFuture f5157a;

        C1087a(SettableFuture settableFuture) {
            this.f5157a = settableFuture;
        }

        public void run() {
            try {
                Logger.get().debug(WorkerWrapper.f5130s, String.format("Starting work for %s", new Object[]{WorkerWrapper.this.f5135e.workerClassName}), new Throwable[0]);
                WorkerWrapper workerWrapper = WorkerWrapper.this;
                workerWrapper.f5147q = workerWrapper.f5136f.startWork();
                this.f5157a.setFuture(WorkerWrapper.this.f5147q);
            } catch (Throwable th) {
                this.f5157a.setException(th);
            }
        }
    }

    /* renamed from: androidx.work.impl.WorkerWrapper$b */
    class C1088b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SettableFuture f5159a;

        /* renamed from: b */
        final /* synthetic */ String f5160b;

        C1088b(SettableFuture settableFuture, String str) {
            this.f5159a = settableFuture;
            this.f5160b = str;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                ListenableWorker.Result result = (ListenableWorker.Result) this.f5159a.get();
                if (result == null) {
                    Logger.get().error(WorkerWrapper.f5130s, String.format("%s returned a null result. Treating it as a failure.", new Object[]{WorkerWrapper.this.f5135e.workerClassName}), new Throwable[0]);
                } else {
                    Logger.get().debug(WorkerWrapper.f5130s, String.format("%s returned a %s result.", new Object[]{WorkerWrapper.this.f5135e.workerClassName, result}), new Throwable[0]);
                    WorkerWrapper.this.f5137g = result;
                }
            } catch (CancellationException e) {
                Logger.get().info(WorkerWrapper.f5130s, String.format("%s was cancelled", new Object[]{this.f5160b}), e);
            } catch (InterruptedException | ExecutionException e2) {
                Logger.get().error(WorkerWrapper.f5130s, String.format("%s failed because it threw an exception/error", new Object[]{this.f5160b}), e2);
            } catch (Throwable th) {
                WorkerWrapper.this.mo8885d();
                throw th;
            }
            WorkerWrapper.this.mo8885d();
        }
    }

    WorkerWrapper(Builder builder) {
        this.f5131a = builder.f5149a;
        this.f5139i = builder.f5151c;
        this.f5132b = builder.f5154f;
        this.f5133c = builder.f5155g;
        this.f5134d = builder.f5156h;
        this.f5136f = builder.f5150b;
        this.f5138h = builder.f5152d;
        WorkDatabase workDatabase = builder.f5153e;
        this.f5140j = workDatabase;
        this.f5141k = workDatabase.workSpecDao();
        this.f5142l = this.f5140j.dependencyDao();
        this.f5143m = this.f5140j.workTagDao();
    }

    /* renamed from: a */
    private String m3907a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f5132b);
        sb.append(", tags={ ");
        boolean z = true;
        for (String next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    /* renamed from: b */
    private void m3908b(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(f5130s, String.format("Worker result SUCCESS for %s", new Object[]{this.f5145o}), new Throwable[0]);
            if (this.f5135e.isPeriodic()) {
                m3911f();
            } else {
                m3915k();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(f5130s, String.format("Worker result RETRY for %s", new Object[]{this.f5145o}), new Throwable[0]);
            m3910e();
        } else {
            Logger.get().info(f5130s, String.format("Worker result FAILURE for %s", new Object[]{this.f5145o}), new Throwable[0]);
            if (this.f5135e.isPeriodic()) {
                m3911f();
            } else {
                mo8888j();
            }
        }
    }

    /* renamed from: c */
    private void m3909c(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f5141k.getState(str2) != WorkInfo.State.CANCELLED) {
                this.f5141k.setState(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f5142l.getDependentWorkIds(str2));
        }
    }

    /* renamed from: e */
    private void m3910e() {
        this.f5140j.beginTransaction();
        try {
            this.f5141k.setState(WorkInfo.State.ENQUEUED, this.f5132b);
            this.f5141k.setPeriodStartTime(this.f5132b, System.currentTimeMillis());
            this.f5141k.markWorkSpecScheduled(this.f5132b, -1);
            this.f5140j.setTransactionSuccessful();
        } finally {
            this.f5140j.endTransaction();
            m3912g(true);
        }
    }

    /* renamed from: f */
    private void m3911f() {
        this.f5140j.beginTransaction();
        try {
            this.f5141k.setPeriodStartTime(this.f5132b, System.currentTimeMillis());
            this.f5141k.setState(WorkInfo.State.ENQUEUED, this.f5132b);
            this.f5141k.resetWorkSpecRunAttemptCount(this.f5132b);
            this.f5141k.markWorkSpecScheduled(this.f5132b, -1);
            this.f5140j.setTransactionSuccessful();
        } finally {
            this.f5140j.endTransaction();
            m3912g(false);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ all -> 0x0039 }] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3912g(boolean r4) {
        /*
            r3 = this;
            androidx.work.impl.WorkDatabase r0 = r3.f5140j
            r0.beginTransaction()
            androidx.work.impl.WorkDatabase r0 = r3.f5140j     // Catch:{ all -> 0x0039 }
            androidx.work.impl.model.WorkSpecDao r0 = r0.workSpecDao()     // Catch:{ all -> 0x0039 }
            java.util.List r0 = r0.getAllUnfinishedWork()     // Catch:{ all -> 0x0039 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            if (r0 == 0) goto L_0x0025
            android.content.Context r0 = r3.f5131a     // Catch:{ all -> 0x0039 }
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r2 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            androidx.work.impl.utils.PackageManagerHelper.setComponentEnabled(r0, r2, r1)     // Catch:{ all -> 0x0039 }
        L_0x0025:
            androidx.work.impl.WorkDatabase r0 = r3.f5140j     // Catch:{ all -> 0x0039 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0039 }
            androidx.work.impl.WorkDatabase r0 = r3.f5140j
            r0.endTransaction()
            androidx.work.impl.utils.futures.SettableFuture<java.lang.Boolean> r0 = r3.f5146p
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.set(r4)
            return
        L_0x0039:
            r4 = move-exception
            androidx.work.impl.WorkDatabase r0 = r3.f5140j
            r0.endTransaction()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.m3912g(boolean):void");
    }

    /* renamed from: h */
    private void m3913h() {
        WorkInfo.State state = this.f5141k.getState(this.f5132b);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(f5130s, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f5132b}), new Throwable[0]);
            m3912g(true);
            return;
        }
        Logger.get().debug(f5130s, String.format("Status for %s is %s; not doing any work", new Object[]{this.f5132b, state}), new Throwable[0]);
        m3912g(false);
    }

    /* renamed from: i */
    private void m3914i() {
        Data merge;
        if (!m3916l()) {
            this.f5140j.beginTransaction();
            try {
                WorkSpec workSpec = this.f5141k.getWorkSpec(this.f5132b);
                this.f5135e = workSpec;
                if (workSpec == null) {
                    Logger.get().error(f5130s, String.format("Didn't find WorkSpec for id %s", new Object[]{this.f5132b}), new Throwable[0]);
                    m3912g(false);
                } else if (workSpec.state != WorkInfo.State.ENQUEUED) {
                    m3913h();
                    this.f5140j.setTransactionSuccessful();
                    Logger.get().debug(f5130s, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f5135e.workerClassName}), new Throwable[0]);
                    this.f5140j.endTransaction();
                } else {
                    if (workSpec.isPeriodic() || this.f5135e.isBackedOff()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WorkSpec workSpec2 = this.f5135e;
                        if (!(workSpec2.periodStartTime == 0) && currentTimeMillis < workSpec2.calculateNextRunTime()) {
                            Logger.get().debug(f5130s, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f5135e.workerClassName}), new Throwable[0]);
                            m3912g(true);
                            this.f5140j.endTransaction();
                            return;
                        }
                    }
                    this.f5140j.setTransactionSuccessful();
                    this.f5140j.endTransaction();
                    if (this.f5135e.isPeriodic()) {
                        merge = this.f5135e.input;
                    } else {
                        InputMerger fromClassName = InputMerger.fromClassName(this.f5135e.inputMergerClassName);
                        if (fromClassName == null) {
                            Logger.get().error(f5130s, String.format("Could not create Input Merger %s", new Object[]{this.f5135e.inputMergerClassName}), new Throwable[0]);
                            mo8888j();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5135e.input);
                        arrayList.addAll(this.f5141k.getInputsFromPrerequisites(this.f5132b));
                        merge = fromClassName.merge(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f5132b), merge, this.f5144n, this.f5134d, this.f5135e.runAttemptCount, this.f5138h.getExecutor(), this.f5139i, this.f5138h.getWorkerFactory());
                    if (this.f5136f == null) {
                        this.f5136f = this.f5138h.getWorkerFactory().createWorkerWithDefaultFallback(this.f5131a, this.f5135e.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f5136f;
                    if (listenableWorker == null) {
                        Logger.get().error(f5130s, String.format("Could not create Worker %s", new Object[]{this.f5135e.workerClassName}), new Throwable[0]);
                        mo8888j();
                    } else if (listenableWorker.isUsed()) {
                        Logger.get().error(f5130s, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f5135e.workerClassName}), new Throwable[0]);
                        mo8888j();
                    } else {
                        this.f5136f.setUsed();
                        if (!m3917m()) {
                            m3913h();
                        } else if (!m3916l()) {
                            SettableFuture create = SettableFuture.create();
                            this.f5139i.getMainThreadExecutor().execute(new C1087a(create));
                            create.addListener(new C1088b(create, this.f5145o), this.f5139i.getBackgroundExecutor());
                        }
                    }
                }
            } finally {
                this.f5140j.endTransaction();
            }
        }
    }

    /* renamed from: k */
    private void m3915k() {
        this.f5140j.beginTransaction();
        try {
            this.f5141k.setState(WorkInfo.State.SUCCEEDED, this.f5132b);
            this.f5141k.setOutput(this.f5132b, ((ListenableWorker.Result.Success) this.f5137g).getOutputData());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.f5142l.getDependentWorkIds(this.f5132b)) {
                if (this.f5141k.getState(next) == WorkInfo.State.BLOCKED && this.f5142l.hasCompletedAllPrerequisites(next)) {
                    Logger.get().info(f5130s, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.f5141k.setState(WorkInfo.State.ENQUEUED, next);
                    this.f5141k.setPeriodStartTime(next, currentTimeMillis);
                }
            }
            this.f5140j.setTransactionSuccessful();
        } finally {
            this.f5140j.endTransaction();
            m3912g(false);
        }
    }

    /* renamed from: l */
    private boolean m3916l() {
        if (!this.f5148r) {
            return false;
        }
        Logger.get().debug(f5130s, String.format("Work interrupted for %s", new Object[]{this.f5145o}), new Throwable[0]);
        WorkInfo.State state = this.f5141k.getState(this.f5132b);
        if (state == null) {
            m3912g(false);
        } else {
            m3912g(!state.isFinished());
        }
        return true;
    }

    /* renamed from: m */
    private boolean m3917m() {
        this.f5140j.beginTransaction();
        try {
            boolean z = true;
            if (this.f5141k.getState(this.f5132b) == WorkInfo.State.ENQUEUED) {
                this.f5141k.setState(WorkInfo.State.RUNNING, this.f5132b);
                this.f5141k.incrementWorkSpecRunAttemptCount(this.f5132b);
            } else {
                z = false;
            }
            this.f5140j.setTransactionSuccessful();
            return z;
        } finally {
            this.f5140j.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8885d() {
        boolean z = false;
        if (!m3916l()) {
            this.f5140j.beginTransaction();
            try {
                WorkInfo.State state = this.f5141k.getState(this.f5132b);
                if (state == null) {
                    m3912g(false);
                    z = true;
                } else if (state == WorkInfo.State.RUNNING) {
                    m3908b(this.f5137g);
                    z = this.f5141k.getState(this.f5132b).isFinished();
                } else if (!state.isFinished()) {
                    m3910e();
                }
                this.f5140j.setTransactionSuccessful();
            } finally {
                this.f5140j.endTransaction();
            }
        }
        List<Scheduler> list = this.f5133c;
        if (list != null) {
            if (z) {
                for (Scheduler cancel : list) {
                    cancel.cancel(this.f5132b);
                }
            }
            Schedulers.schedule(this.f5138h, this.f5140j, this.f5133c);
        }
    }

    @NonNull
    public ListenableFuture<Boolean> getFuture() {
        return this.f5146p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void interrupt(boolean z) {
        this.f5148r = true;
        m3916l();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.f5147q;
        if (listenableFuture != null) {
            listenableFuture.cancel(true);
        }
        ListenableWorker listenableWorker = this.f5136f;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: j */
    public void mo8888j() {
        this.f5140j.beginTransaction();
        try {
            m3909c(this.f5132b);
            this.f5141k.setOutput(this.f5132b, ((ListenableWorker.Result.Failure) this.f5137g).getOutputData());
            this.f5140j.setTransactionSuccessful();
        } finally {
            this.f5140j.endTransaction();
            m3912g(false);
        }
    }

    @WorkerThread
    public void run() {
        List<String> tagsForWorkSpecId = this.f5143m.getTagsForWorkSpecId(this.f5132b);
        this.f5144n = tagsForWorkSpecId;
        this.f5145o = m3907a(tagsForWorkSpecId);
        m3914i();
    }
}
