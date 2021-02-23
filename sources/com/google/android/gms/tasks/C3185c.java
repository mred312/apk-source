package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.c */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3185c implements OnSuccessListener<Void> {

    /* renamed from: a */
    private final /* synthetic */ OnTokenCanceledListener f18769a;

    C3185c(C3183a aVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.f18769a = onTokenCanceledListener;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        this.f18769a.onCanceled();
    }
}
