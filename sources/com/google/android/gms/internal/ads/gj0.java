package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class gj0 extends lj0<zzxg> {

    /* renamed from: b */
    private final /* synthetic */ Context f8788b;

    /* renamed from: c */
    private final /* synthetic */ zzvn f8789c;

    /* renamed from: d */
    private final /* synthetic */ String f8790d;

    /* renamed from: e */
    private final /* synthetic */ zzvx f8791e;

    gj0(zzvx zzvx, Context context, zzvn zzvn, String str) {
        this.f8791e = zzvx;
        this.f8788b = context;
        this.f8789c = zzvn;
        this.f8790d = str;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.f8788b), this.f8789c, this.f8790d, 203404000);
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f8788b, FirebaseAnalytics.Event.SEARCH);
        return new zzzs();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f8791e.f17080a.zza(this.f8788b, this.f8789c, this.f8790d, (zzani) null, 3);
    }
}
