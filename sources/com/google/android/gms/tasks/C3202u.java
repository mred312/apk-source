package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.u */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3202u implements OnTokenCanceledListener {

    /* renamed from: a */
    private final /* synthetic */ TaskCompletionSource f18807a;

    C3202u(TaskCompletionSource taskCompletionSource) {
        this.f18807a = taskCompletionSource;
    }

    public final void onCanceled() {
        this.f18807a.f18755a.mo20693c();
    }
}
