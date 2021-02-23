package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.qa */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2317qa implements zzdij {

    /* renamed from: a */
    private zzeps<Context> f10699a;

    /* renamed from: b */
    private zzeps<String> f10700b;

    /* renamed from: c */
    private zzeps<zzdkl<zzblg, zzbll>> f10701c;

    /* renamed from: d */
    private zzeps<zzdir> f10702d;

    /* renamed from: e */
    private zzeps<zzdib> f10703e;

    /* renamed from: f */
    private zzeps<zzdid> f10704f;

    /* renamed from: g */
    private zzeps<zzdkl<zzblp, zzblv>> f10705g;

    /* renamed from: h */
    private zzeps<zzdjd> f10706h;

    /* renamed from: i */
    private zzeps<zzdjf> f10707i;

    /* renamed from: j */
    private final /* synthetic */ zzbhg f10708j;

    private C2317qa(zzbhg zzbhg, Context context, String str) {
        this.f10708j = zzbhg;
        this.f10699a = zzepi.zzbb(context);
        this.f10700b = zzepi.zzbb(str);
        this.f10701c = new zzdkr(this.f10699a, zzbhg.f13298d0, zzbhg.f13300e0);
        this.f10702d = zzepg.zzas(new zzdja(zzbhg.f13298d0));
        this.f10703e = zzepg.zzas(new zzdia(this.f10699a, zzbhg.f13297d, zzbhg.f13321y, this.f10701c, this.f10702d, zzdno.zzauo()));
        this.f10704f = zzepg.zzas(new zzdig(zzbhg.f13321y, this.f10699a, this.f10700b, this.f10703e, this.f10702d, zzbhg.f13308l));
        this.f10705g = new zzdko(this.f10699a, zzbhg.f13298d0, zzbhg.f13300e0);
        this.f10706h = zzepg.zzas(new zzdjc(this.f10699a, zzbhg.f13297d, zzbhg.f13321y, this.f10705g, this.f10702d, zzdno.zzauo()));
        this.f10707i = zzepg.zzas(new zzdjl(zzbhg.f13321y, this.f10699a, this.f10700b, this.f10706h, this.f10702d));
    }

    public final zzdid zzagu() {
        return this.f10704f.get();
    }

    public final zzdjf zzagv() {
        return this.f10707i.get();
    }
}
