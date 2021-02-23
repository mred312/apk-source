package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.xq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2597xq implements Runnable {

    /* renamed from: a */
    private final zzcxq f11954a;

    private C2597xq(zzcxq zzcxq) {
        this.f11954a = zzcxq;
    }

    /* renamed from: a */
    static Runnable m7269a(zzcxq zzcxq) {
        return new C2597xq(zzcxq);
    }

    public final void run() {
        this.f11954a.onAdLoaded();
    }
}
