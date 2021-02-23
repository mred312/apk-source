package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.q */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3199q<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18801a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final SuccessContinuation<TResult, TContinuationResult> f18802b;

    /* renamed from: c */
    private final C3204w<TContinuationResult> f18803c;

    public C3199q(@NonNull Executor executor, @NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation, @NonNull C3204w<TContinuationResult> wVar) {
        this.f18801a = executor;
        this.f18802b = successContinuation;
        this.f18803c = wVar;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        this.f18801a.execute(new C3198p(this, task));
    }

    public final void onCanceled() {
        this.f18803c.mo20693c();
    }

    public final void onFailure(@NonNull Exception exc) {
        this.f18803c.mo20691a(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f18803c.mo20692b(tcontinuationresult);
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
