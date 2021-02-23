package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.v6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2502v6 implements Runnable {

    /* renamed from: a */
    private final zzbap f11471a;

    private C2502v6(zzbap zzbap) {
        this.f11471a = zzbap;
    }

    /* renamed from: a */
    static Runnable m7053a(zzbap zzbap) {
        return new C2502v6(zzbap);
    }

    public final void run() {
        this.f11471a.stop();
    }
}
