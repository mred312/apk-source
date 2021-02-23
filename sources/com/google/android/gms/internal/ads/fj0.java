package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class fj0 extends lj0<zzxg> {

    /* renamed from: b */
    private final /* synthetic */ Context f8475b;

    /* renamed from: c */
    private final /* synthetic */ zzvn f8476c;

    /* renamed from: d */
    private final /* synthetic */ String f8477d;

    /* renamed from: e */
    private final /* synthetic */ zzani f8478e;

    /* renamed from: f */
    private final /* synthetic */ zzvx f8479f;

    fj0(zzvx zzvx, Context context, zzvn zzvn, String str, zzani zzani) {
        this.f8479f = zzvx;
        this.f8475b = context;
        this.f8476c = zzvn;
        this.f8477d = str;
        this.f8478e = zzani;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zzb(ObjectWrapper.wrap(this.f8475b), this.f8476c, this.f8477d, this.f8478e, 203404000);
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f8475b, "interstitial");
        return new zzzs();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f8479f.f17080a.zza(this.f8475b, this.f8476c, this.f8477d, this.f8478e, 2);
    }
}
