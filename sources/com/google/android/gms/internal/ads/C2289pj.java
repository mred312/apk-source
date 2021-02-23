package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.pj */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2289pj implements Runnable {

    /* renamed from: a */
    private final zzbdv f10636a;

    private C2289pj(zzbdv zzbdv) {
        this.f10636a = zzbdv;
    }

    /* renamed from: a */
    static Runnable m6687a(zzbdv zzbdv) {
        return new C2289pj(zzbdv);
    }

    public final void run() {
        this.f10636a.destroy();
    }
}
