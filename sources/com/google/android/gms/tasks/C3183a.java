package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* renamed from: com.google.android.gms.tasks.a */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3183a extends CancellationToken {

    /* renamed from: a */
    private final C3204w<Void> f18767a = new C3204w<>();

    C3183a() {
    }

    /* renamed from: a */
    public final void mo20678a() {
        this.f18767a.mo20695f(null);
    }

    public final boolean isCancellationRequested() {
        return this.f18767a.isComplete();
    }

    public final CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
        this.f18767a.addOnSuccessListener(new C3185c(this, onTokenCanceledListener));
        return this;
    }
}
