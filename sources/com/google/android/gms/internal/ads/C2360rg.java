package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.rg */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2360rg implements Runnable {

    /* renamed from: a */
    private final zzbdv f10794a;

    private C2360rg(zzbdv zzbdv) {
        this.f10794a = zzbdv;
    }

    /* renamed from: a */
    static Runnable m6812a(zzbdv zzbdv) {
        return new C2360rg(zzbdv);
    }

    public final void run() {
        this.f10794a.destroy();
    }
}
