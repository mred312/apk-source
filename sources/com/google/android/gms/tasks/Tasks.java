package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
public final class Tasks {

    /* renamed from: com.google.android.gms.tasks.Tasks$a */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    interface C3180a extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* renamed from: com.google.android.gms.tasks.Tasks$c */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static final class C3182c implements C3180a {

        /* renamed from: a */
        private final Object f18759a = new Object();

        /* renamed from: b */
        private final int f18760b;

        /* renamed from: c */
        private final C3204w<Void> f18761c;
        @GuardedBy("mLock")

        /* renamed from: d */
        private int f18762d;
        @GuardedBy("mLock")

        /* renamed from: e */
        private int f18763e;
        @GuardedBy("mLock")

        /* renamed from: f */
        private int f18764f;
        @GuardedBy("mLock")

        /* renamed from: g */
        private Exception f18765g;
        @GuardedBy("mLock")

        /* renamed from: h */
        private boolean f18766h;

        public C3182c(int i, C3204w<Void> wVar) {
            this.f18760b = i;
            this.f18761c = wVar;
        }

        @GuardedBy("mLock")
        /* renamed from: a */
        private final void m11067a() {
            if (this.f18762d + this.f18763e + this.f18764f != this.f18760b) {
                return;
            }
            if (this.f18765g != null) {
                C3204w<Void> wVar = this.f18761c;
                int i = this.f18763e;
                int i2 = this.f18760b;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i);
                sb.append(" out of ");
                sb.append(i2);
                sb.append(" underlying tasks failed");
                wVar.mo20691a(new ExecutionException(sb.toString(), this.f18765g));
            } else if (this.f18766h) {
                this.f18761c.mo20693c();
            } else {
                this.f18761c.mo20692b(null);
            }
        }

        public final void onCanceled() {
            synchronized (this.f18759a) {
                this.f18764f++;
                this.f18766h = true;
                m11067a();
            }
        }

        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.f18759a) {
                this.f18763e++;
                this.f18765g = exc;
                m11067a();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.f18759a) {
                this.f18762d++;
                m11067a();
            }
        }
    }

    private Tasks() {
    }

    /* renamed from: a */
    private static <TResult> TResult m11063a(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return m11063a(task);
        }
        C3181b bVar = new C3181b((C3207y) null);
        m11064b(task, bVar);
        bVar.mo20676a();
        return m11063a(task);
    }

    /* renamed from: b */
    private static void m11064b(Task<?> task, C3180a aVar) {
        Executor executor = TaskExecutors.f18756a;
        task.addOnSuccessListener(executor, (OnSuccessListener<? super Object>) aVar);
        task.addOnFailureListener(executor, (OnFailureListener) aVar);
        task.addOnCanceledListener(executor, (OnCanceledListener) aVar);
    }

    @NonNull
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        C3204w wVar = new C3204w();
        wVar.mo20693c();
        return wVar;
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        C3204w wVar = new C3204w();
        wVar.mo20691a(exc);
        return wVar;
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        C3204w wVar = new C3204w();
        wVar.mo20692b(tresult);
        return wVar;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        C3204w wVar = new C3204w();
        C3182c cVar = new C3182c(collection.size(), wVar);
        for (Task b : collection) {
            m11064b(b, cVar);
        }
        return wVar;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(new C3208z(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWith(new C3184b(collection));
    }

    /* renamed from: com.google.android.gms.tasks.Tasks$b */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static final class C3181b implements C3180a {

        /* renamed from: a */
        private final CountDownLatch f18758a;

        private C3181b() {
            this.f18758a = new CountDownLatch(1);
        }

        /* renamed from: a */
        public final void mo20676a() {
            this.f18758a.await();
        }

        /* renamed from: b */
        public final boolean mo20677b(long j, TimeUnit timeUnit) {
            return this.f18758a.await(j, timeUnit);
        }

        public final void onCanceled() {
            this.f18758a.countDown();
        }

        public final void onFailure(@NonNull Exception exc) {
            this.f18758a.countDown();
        }

        public final void onSuccess(Object obj) {
            this.f18758a.countDown();
        }

        /* synthetic */ C3181b(C3207y yVar) {
            this();
        }
    }

    @NonNull
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        C3204w wVar = new C3204w();
        executor.execute(new C3207y(wVar, callable));
        return wVar;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return m11063a(task);
        }
        C3181b bVar = new C3181b((C3207y) null);
        m11064b(task, bVar);
        if (bVar.mo20677b(j, timeUnit)) {
            return m11063a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }
}
