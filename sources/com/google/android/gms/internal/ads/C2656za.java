package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.za */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2656za implements zzdld {

    /* renamed from: a */
    private zzeps<Context> f12267a;

    /* renamed from: b */
    private zzeps<zzvn> f12268b;

    /* renamed from: c */
    private zzeps<String> f12269c;

    /* renamed from: d */
    private zzeps<zzcxq> f12270d;

    /* renamed from: e */
    private zzeps<zzdlf> f12271e;

    /* renamed from: f */
    private zzeps<zzdkv> f12272f;

    /* renamed from: g */
    private zzeps<zzcyg> f12273g;

    /* renamed from: h */
    private final /* synthetic */ zzbhg f12274h;

    private C2656za(zzbhg zzbhg, Context context, String str, zzvn zzvn) {
        this.f12274h = zzbhg;
        this.f12267a = zzepi.zzbb(context);
        this.f12268b = zzepi.zzbb(zzvn);
        this.f12269c = zzepi.zzbb(str);
        this.f12270d = zzepg.zzas(zzcxz.zzarv());
        this.f12271e = zzepg.zzas(zzdly.zzaq(zzbhg.f13298d0));
        zzeps<zzdkv> zzas = zzepg.zzas(new zzdla(this.f12267a, zzbhg.f13297d, zzbhg.f13321y, this.f12270d, this.f12271e, zzdno.zzauo()));
        this.f12272f = zzas;
        this.f12273g = zzepg.zzas(new zzcyi(this.f12267a, this.f12268b, this.f12269c, zzas, this.f12270d, this.f12271e));
    }

    public final zzcyg zzahj() {
        return this.f12273g.get();
    }
}
