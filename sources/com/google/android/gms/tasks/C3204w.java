package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.tasks.w */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3204w<TResult> extends Task<TResult> {

    /* renamed from: a */
    private final Object f18808a = new Object();

    /* renamed from: b */
    private final C3200s<TResult> f18809b = new C3200s<>();
    @GuardedBy("mLock")

    /* renamed from: c */
    private boolean f18810c;

    /* renamed from: d */
    private volatile boolean f18811d;
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: e */
    private TResult f18812e;
    @GuardedBy("mLock")

    /* renamed from: f */
    private Exception f18813f;

    /* renamed from: com.google.android.gms.tasks.w$a */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static class C3205a extends LifecycleCallback {

        /* renamed from: a */
        private final List<WeakReference<C3201t<?>>> f18814a = new ArrayList();

        private C3205a(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
        }

        /* renamed from: a */
        public static C3205a m11101a(Activity activity) {
            LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
            C3205a aVar = (C3205a) fragment.getCallbackOrNull("TaskOnStopCallback", C3205a.class);
            return aVar == null ? new C3205a(fragment) : aVar;
        }

        /* renamed from: b */
        public final <T> void mo20696b(C3201t<T> tVar) {
            synchronized (this.f18814a) {
                this.f18814a.add(new WeakReference(tVar));
            }
        }

        @MainThread
        public void onStop() {
            synchronized (this.f18814a) {
                for (WeakReference<C3201t<?>> weakReference : this.f18814a) {
                    C3201t tVar = (C3201t) weakReference.get();
                    if (tVar != null) {
                        tVar.zza();
                    }
                }
                this.f18814a.clear();
            }
        }
    }

    C3204w() {
    }

    @GuardedBy("mLock")
    /* renamed from: d */
    private final void m11092d() {
        Preconditions.checkState(this.f18810c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    /* renamed from: g */
    private final void m11093g() {
        if (this.f18810c) {
            throw DuplicateTaskCompletionException.m11061of(this);
        }
    }

    @GuardedBy("mLock")
    /* renamed from: h */
    private final void m11094h() {
        if (this.f18811d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    /* renamed from: i */
    private final void m11095i() {
        synchronized (this.f18808a) {
            if (this.f18810c) {
                this.f18809b.mo20688a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo20691a(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f18808a) {
            m11093g();
            this.f18810c = true;
            this.f18813f = exc;
        }
        this.f18809b.mo20688a(this);
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    /* renamed from: b */
    public final void mo20692b(@Nullable TResult tresult) {
        synchronized (this.f18808a) {
            m11093g();
            this.f18810c = true;
            this.f18812e = tresult;
        }
        this.f18809b.mo20688a(this);
    }

    /* renamed from: c */
    public final boolean mo20693c() {
        synchronized (this.f18808a) {
            if (this.f18810c) {
                return false;
            }
            this.f18810c = true;
            this.f18811d = true;
            this.f18809b.mo20688a(this);
            return true;
        }
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    /* renamed from: e */
    public final boolean mo20694e(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f18808a) {
            if (this.f18810c) {
                return false;
            }
            this.f18810c = true;
            this.f18813f = exc;
            this.f18809b.mo20688a(this);
            return true;
        }
    }

    /* renamed from: f */
    public final boolean mo20695f(@Nullable TResult tresult) {
        synchronized (this.f18808a) {
            if (this.f18810c) {
                return false;
            }
            this.f18810c = true;
            this.f18812e = tresult;
            this.f18809b.mo20688a(this);
            return true;
        }
    }

    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.f18808a) {
            exc = this.f18813f;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.f18808a) {
            m11092d();
            m11094h();
            if (this.f18813f == null) {
                tresult = this.f18812e;
            } else {
                throw new RuntimeExecutionException(this.f18813f);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.f18811d;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f18808a) {
            z = this.f18810c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f18808a) {
            z = this.f18810c && !this.f18811d && this.f18813f == null;
        }
        return z;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        C3204w wVar = new C3204w();
        this.f18809b.mo20689b(new C3199q(zzv.zza(executor), successContinuation, wVar));
        m11095i();
        return wVar;
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f18809b.mo20689b(new C3191i(zzv.zza(executor), onCanceledListener));
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f18809b.mo20689b(new C3192j(zzv.zza(executor), onCompleteListener));
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f18809b.mo20689b(new C3195m(zzv.zza(executor), onFailureListener));
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f18809b.mo20689b(new C3196n(zzv.zza(executor), onSuccessListener));
        m11095i();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        C3204w wVar = new C3204w();
        this.f18809b.mo20689b(new C3186d(zzv.zza(executor), continuation, wVar));
        m11095i();
        return wVar;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        C3204w wVar = new C3204w();
        this.f18809b.mo20689b(new C3187e(zzv.zza(executor), continuation, wVar));
        m11095i();
        return wVar;
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        C3191i iVar = new C3191i(zzv.zza(TaskExecutors.MAIN_THREAD), onCanceledListener);
        this.f18809b.mo20689b(iVar);
        C3205a.m11101a(activity).mo20696b(iVar);
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        C3192j jVar = new C3192j(zzv.zza(TaskExecutors.MAIN_THREAD), onCompleteListener);
        this.f18809b.mo20689b(jVar);
        C3205a.m11101a(activity).mo20696b(jVar);
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        C3195m mVar = new C3195m(zzv.zza(TaskExecutors.MAIN_THREAD), onFailureListener);
        this.f18809b.mo20689b(mVar);
        C3205a.m11101a(activity).mo20696b(mVar);
        m11095i();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        C3196n nVar = new C3196n(zzv.zza(TaskExecutors.MAIN_THREAD), onSuccessListener);
        this.f18809b.mo20689b(nVar);
        C3205a.m11101a(activity).mo20696b(nVar);
        m11095i();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) {
        TResult tresult;
        synchronized (this.f18808a) {
            m11092d();
            m11094h();
            if (cls.isInstance(this.f18813f)) {
                throw ((Throwable) cls.cast(this.f18813f));
            } else if (this.f18813f == null) {
                tresult = this.f18812e;
            } else {
                throw new RuntimeExecutionException(this.f18813f);
            }
        }
        return tresult;
    }
}
