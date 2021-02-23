package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.i2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2012i2 implements Runnable {

    /* renamed from: a */
    private final C2049j2 f9247a;

    /* renamed from: b */
    private final zzako f9248b;

    C2012i2(C2049j2 j2Var, zzako zzako) {
        this.f9247a = j2Var;
        this.f9248b = zzako;
    }

    public final void run() {
        C2049j2 j2Var = this.f9247a;
        zzako zzako = this.f9248b;
        j2Var.f9364a.f12515d.zzh(zzako);
        zzako.destroy();
    }
}
