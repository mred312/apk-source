package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.bb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1762bb implements zzdmm {

    /* renamed from: a */
    private zzeps<Context> f7890a;

    /* renamed from: b */
    private zzeps<zzdkl<zzchf, zzchc>> f7891b;

    /* renamed from: c */
    private zzeps<zzdlf> f7892c;

    /* renamed from: d */
    private zzeps<zzdni> f7893d;

    /* renamed from: e */
    private zzeps<zzdma> f7894e;

    /* renamed from: f */
    private zzeps<zzdmo> f7895f;

    /* renamed from: g */
    private zzeps<String> f7896g;

    /* renamed from: h */
    private zzeps<zzdmi> f7897h;

    /* renamed from: i */
    private final /* synthetic */ zzbhg f7898i;

    private C1762bb(zzbhg zzbhg, Context context, String str) {
        this.f7898i = zzbhg;
        zzepf zzbb = zzepi.zzbb(context);
        this.f7890a = zzbb;
        this.f7891b = new zzdkq(zzbb, zzbhg.f13298d0, zzbhg.f13300e0);
        this.f7892c = zzepg.zzas(zzdly.zzaq(zzbhg.f13298d0));
        this.f7893d = zzepg.zzas(zzdnl.zzaum());
        zzeps<zzdma> zzas = zzepg.zzas(new zzdmj(this.f7890a, zzbhg.f13297d, zzbhg.f13321y, this.f7891b, this.f7892c, zzdno.zzauo(), this.f7893d));
        this.f7894e = zzas;
        this.f7895f = zzepg.zzas(new zzdmt(zzas, this.f7892c, this.f7893d));
        zzepf zzbc = zzepi.zzbc(str);
        this.f7896g = zzbc;
        this.f7897h = zzepg.zzas(new zzdmn(zzbc, this.f7894e, this.f7890a, this.f7892c, this.f7893d));
    }

    public final zzdmo zzahl() {
        return this.f7895f.get();
    }

    public final zzdmi zzahm() {
        return this.f7897h.get();
    }
}
