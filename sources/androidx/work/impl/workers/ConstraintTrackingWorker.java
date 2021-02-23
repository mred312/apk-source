package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";

    /* renamed from: f */
    private static final String f5395f = Logger.tagWithPrefix("ConstraintTrkngWrkr");

    /* renamed from: a */
    private WorkerParameters f5396a;

    /* renamed from: b */
    final Object f5397b = new Object();

    /* renamed from: c */
    volatile boolean f5398c = false;

    /* renamed from: d */
    SettableFuture<ListenableWorker.Result> f5399d = SettableFuture.create();
    @Nullable

    /* renamed from: e */
    private ListenableWorker f5400e;

    /* renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$a */
    class C1149a implements Runnable {
        C1149a() {
        }

        public void run() {
            ConstraintTrackingWorker.this.mo9119c();
        }
    }

    /* renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$b */
    class C1150b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ListenableFuture f5402a;

        C1150b(ListenableFuture listenableFuture) {
            this.f5402a = listenableFuture;
        }

        public void run() {
            synchronized (ConstraintTrackingWorker.this.f5397b) {
                if (ConstraintTrackingWorker.this.f5398c) {
                    ConstraintTrackingWorker.this.mo9118b();
                } else {
                    ConstraintTrackingWorker.this.f5399d.setFuture(this.f5402a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f5396a = workerParameters;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9117a() {
        this.f5399d.set(ListenableWorker.Result.failure());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9118b() {
        this.f5399d.set(ListenableWorker.Result.retry());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9119c() {
        String string = getInputData().getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty(string)) {
            Logger.get().error(f5395f, "No worker to delegate to.", new Throwable[0]);
            mo9117a();
            return;
        }
        ListenableWorker createWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.f5396a);
        this.f5400e = createWorkerWithDefaultFallback;
        if (createWorkerWithDefaultFallback == null) {
            Logger.get().debug(f5395f, "No worker to delegate to.", new Throwable[0]);
            mo9117a();
            return;
        }
        WorkSpec workSpec = getWorkDatabase().workSpecDao().getWorkSpec(getId().toString());
        if (workSpec == null) {
            mo9117a();
            return;
        }
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(getApplicationContext(), getTaskExecutor(), this);
        workConstraintsTracker.replace(Collections.singletonList(workSpec));
        if (workConstraintsTracker.areAllConstraintsMet(getId().toString())) {
            Logger.get().debug(f5395f, String.format("Constraints met for delegate %s", new Object[]{string}), new Throwable[0]);
            try {
                ListenableFuture<ListenableWorker.Result> startWork = this.f5400e.startWork();
                startWork.addListener(new C1150b(startWork), getBackgroundExecutor());
            } catch (Throwable th) {
                Logger logger = Logger.get();
                String str = f5395f;
                logger.debug(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{string}), th);
                synchronized (this.f5397b) {
                    if (this.f5398c) {
                        Logger.get().debug(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        mo9118b();
                    } else {
                        mo9117a();
                    }
                }
            }
        } else {
            Logger.get().debug(f5395f, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{string}), new Throwable[0]);
            mo9118b();
        }
    }

    @VisibleForTesting
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableWorker getDelegate() {
        return this.f5400e;
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkTaskExecutor();
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        Logger.get().debug(f5395f, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f5397b) {
            this.f5398c = true;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f5400e;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new C1149a());
        return this.f5399d;
    }
}
