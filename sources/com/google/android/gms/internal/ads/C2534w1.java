package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.w1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2534w1 implements Runnable {

    /* renamed from: a */
    private final zzako f11653a;

    private C2534w1(zzako zzako) {
        this.f11653a = zzako;
    }

    /* renamed from: a */
    static Runnable m7103a(zzako zzako) {
        return new C2534w1(zzako);
    }

    public final void run() {
        this.f11653a.destroy();
    }
}
