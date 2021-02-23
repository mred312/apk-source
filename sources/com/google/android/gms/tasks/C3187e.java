package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.e */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3187e<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18773a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Continuation<TResult, Task<TContinuationResult>> f18774b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C3204w<TContinuationResult> f18775c;

    public C3187e(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull C3204w<TContinuationResult> wVar) {
        this.f18773a = executor;
        this.f18774b = continuation;
        this.f18775c = wVar;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        this.f18773a.execute(new C3189g(this, task));
    }

    public final void onCanceled() {
        this.f18775c.mo20693c();
    }

    public final void onFailure(@NonNull Exception exc) {
        this.f18775c.mo20691a(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f18775c.mo20692b(tcontinuationresult);
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
