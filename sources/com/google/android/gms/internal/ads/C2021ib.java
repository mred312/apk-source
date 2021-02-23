package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ib */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2021ib implements Runnable {

    /* renamed from: a */
    private final zzbiu f9308a;

    /* renamed from: b */
    private final Runnable f9309b;

    C2021ib(zzbiu zzbiu, Runnable runnable) {
        this.f9308a = zzbiu;
        this.f9309b = runnable;
    }

    public final void run() {
        zzazj.zzegt.execute(new C2058jb(this.f9308a, this.f9309b));
    }
}
