package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.s9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2390s9 implements zzdwf {

    /* renamed from: a */
    private final Context f10858a;

    /* renamed from: b */
    private final zzbfn f10859b;

    /* renamed from: c */
    private final String f10860c;

    /* renamed from: d */
    private final boolean f10861d;

    /* renamed from: e */
    private final boolean f10862e;

    /* renamed from: f */
    private final zzef f10863f;

    /* renamed from: g */
    private final zzacg f10864g;

    /* renamed from: h */
    private final zzazh f10865h;

    /* renamed from: i */
    private final zzabs f10866i = null;

    /* renamed from: j */
    private final zzk f10867j;

    /* renamed from: k */
    private final zzb f10868k;

    /* renamed from: l */
    private final zzts f10869l;

    /* renamed from: m */
    private final zzsu f10870m;

    /* renamed from: n */
    private final boolean f10871n;

    /* renamed from: o */
    private final zzdmu f10872o;

    /* renamed from: p */
    private final zzdmz f10873p;

    C2390s9(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        this.f10858a = context;
        this.f10859b = zzbfn;
        this.f10860c = str;
        this.f10861d = z;
        this.f10862e = z2;
        this.f10863f = zzef;
        this.f10864g = zzacg;
        this.f10865h = zzazh;
        this.f10867j = zzk;
        this.f10868k = zzb;
        this.f10869l = zzts;
        this.f10870m = zzsu;
        this.f10871n = z3;
        this.f10872o = zzdmu;
        this.f10873p = zzdmz;
    }

    public final Object get() {
        Context context = this.f10858a;
        zzbfn zzbfn = this.f10859b;
        String str = this.f10860c;
        boolean z = this.f10861d;
        boolean z2 = this.f10862e;
        zzef zzef = this.f10863f;
        zzacg zzacg = this.f10864g;
        zzazh zzazh = this.f10865h;
        zzabs zzabs = this.f10866i;
        zzk zzk = this.f10867j;
        zzb zzb = this.f10868k;
        zzts zzts = this.f10869l;
        zzsu zzsu = this.f10870m;
        boolean z3 = this.f10871n;
        zzdmu zzdmu = this.f10872o;
        zzdmz zzdmz = this.f10873p;
        zzbfm zzbfm = r3;
        zzbfm zzbfm2 = new zzbfm();
        zzbfm zzbfm3 = zzbfm2;
        zzbfk zzbfk = r0;
        zzbfk zzbfk2 = new zzbfk(context);
        boolean z4 = z2;
        C2468u9 u9Var = new C2468u9(zzbfk, zzbfm, zzbfn, str, z, z2, zzef, zzacg, zzazh, zzabs, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz);
        zzbeg zzbeg = new zzbeg(u9Var);
        u9Var.setWebChromeClient(new zzbdn(zzbeg));
        zzbfm3.mo16209d(zzbeg, z4);
        return zzbeg;
    }
}
