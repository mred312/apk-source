package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.d */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3186d<TResult, TContinuationResult> implements C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18770a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Continuation<TResult, TContinuationResult> f18771b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C3204w<TContinuationResult> f18772c;

    public C3186d(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull C3204w<TContinuationResult> wVar) {
        this.f18770a = executor;
        this.f18771b = continuation;
        this.f18772c = wVar;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        this.f18770a.execute(new C3188f(this, task));
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
