package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.a2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1713a2 implements Runnable {

    /* renamed from: a */
    private final zzako f7778a;

    private C1713a2(zzako zzako) {
        this.f7778a = zzako;
    }

    /* renamed from: a */
    static Runnable m5745a(zzako zzako) {
        return new C1713a2(zzako);
    }

    public final void run() {
        this.f7778a.destroy();
    }
}
