package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.d9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1834d9 implements zzdwf {

    /* renamed from: a */
    private final Context f8061a;

    /* renamed from: b */
    private final zzbfn f8062b;

    /* renamed from: c */
    private final String f8063c;

    /* renamed from: d */
    private final boolean f8064d;

    /* renamed from: e */
    private final boolean f8065e;

    /* renamed from: f */
    private final zzef f8066f;

    /* renamed from: g */
    private final zzacg f8067g;

    /* renamed from: h */
    private final zzazh f8068h;

    /* renamed from: i */
    private final zzk f8069i;

    /* renamed from: j */
    private final zzb f8070j;

    /* renamed from: k */
    private final zzts f8071k;

    /* renamed from: l */
    private final zzsu f8072l;

    /* renamed from: m */
    private final boolean f8073m;

    /* renamed from: n */
    private final zzdmu f8074n;

    /* renamed from: o */
    private final zzdmz f8075o;

    C1834d9(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        this.f8061a = context;
        this.f8062b = zzbfn;
        this.f8063c = str;
        this.f8064d = z;
        this.f8065e = z2;
        this.f8066f = zzef;
        this.f8067g = zzacg;
        this.f8068h = zzazh;
        this.f8069i = zzk;
        this.f8070j = zzb;
        this.f8071k = zzts;
        this.f8072l = zzsu;
        this.f8073m = z3;
        this.f8074n = zzdmu;
        this.f8075o = zzdmz;
    }

    public final Object get() {
        Context context = this.f8061a;
        zzbfn zzbfn = this.f8062b;
        String str = this.f8063c;
        boolean z = this.f8064d;
        boolean z2 = this.f8065e;
        zzef zzef = this.f8066f;
        zzacg zzacg = this.f8067g;
        zzazh zzazh = this.f8068h;
        zzk zzk = this.f8069i;
        zzb zzb = this.f8070j;
        zzts zzts = this.f8071k;
        zzsu zzsu = this.f8072l;
        boolean z3 = this.f8073m;
        boolean z4 = z3;
        zzbeg zzbeg = new zzbeg(C1982h9.m6141n(context, zzbfn, str, z, z2, zzef, zzacg, zzazh, (zzabs) null, zzk, zzb, zzts, zzsu, z4, this.f8074n, this.f8075o));
        zzbeg.setWebViewClient(zzp.zzks().zza(zzbeg, zzts, z2));
        zzbeg.setWebChromeClient(new zzbdn(zzbeg));
        return zzbeg;
    }
}
