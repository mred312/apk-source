package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zg0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12296a;

    /* renamed from: b */
    private final /* synthetic */ int f12297b;

    /* renamed from: c */
    private final /* synthetic */ int f12298c;

    /* renamed from: d */
    private final /* synthetic */ float f12299d;

    /* renamed from: e */
    private final /* synthetic */ zzqj f12300e;

    zg0(zzqj zzqj, int i, int i2, int i3, float f) {
        this.f12300e = zzqj;
        this.f12296a = i;
        this.f12297b = i2;
        this.f12298c = i3;
        this.f12299d = f;
    }

    public final void run() {
        this.f12300e.f16894b.zza(this.f12296a, this.f12297b, this.f12298c, this.f12299d);
    }
}
