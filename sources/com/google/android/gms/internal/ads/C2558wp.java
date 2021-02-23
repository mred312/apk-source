package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.wp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2558wp implements Runnable {

    /* renamed from: a */
    private final zzcif f11727a;

    private C2558wp(zzcif zzcif) {
        this.f11727a = zzcif;
    }

    /* renamed from: a */
    static Runnable m7137a(zzcif zzcif) {
        return new C2558wp(zzcif);
    }

    public final void run() {
        this.f11727a.zzapd();
    }
}
