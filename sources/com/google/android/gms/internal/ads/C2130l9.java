package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.l9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2130l9 implements Runnable {

    /* renamed from: a */
    private final zzbep f9818a;

    /* renamed from: b */
    private final int f9819b;

    /* renamed from: c */
    private final int f9820c;

    /* renamed from: d */
    private final boolean f9821d;

    /* renamed from: e */
    private final boolean f9822e;

    C2130l9(zzbep zzbep, int i, int i2, boolean z, boolean z2) {
        this.f9818a = zzbep;
        this.f9819b = i;
        this.f9820c = i2;
        this.f9821d = z;
        this.f9822e = z2;
    }

    public final void run() {
        this.f9818a.mo16192b(this.f9819b, this.f9820c, this.f9821d, this.f9822e);
    }
}
