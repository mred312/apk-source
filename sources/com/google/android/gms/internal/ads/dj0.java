package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class dj0 extends lj0<zzxg> {

    /* renamed from: b */
    private final /* synthetic */ Context f8271b;

    /* renamed from: c */
    private final /* synthetic */ zzvn f8272c;

    /* renamed from: d */
    private final /* synthetic */ String f8273d;

    /* renamed from: e */
    private final /* synthetic */ zzani f8274e;

    /* renamed from: f */
    private final /* synthetic */ zzvx f8275f;

    dj0(zzvx zzvx, Context context, zzvn zzvn, String str, zzani zzani) {
        this.f8275f = zzvx;
        this.f8271b = context;
        this.f8272c = zzvn;
        this.f8273d = str;
        this.f8274e = zzani;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zzc(ObjectWrapper.wrap(this.f8271b), this.f8272c, this.f8273d, this.f8274e, 203404000);
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f8271b, FirebaseAnalytics.Event.APP_OPEN);
        return new zzzs();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f8275f.f17080a.zza(this.f8271b, this.f8272c, this.f8273d, this.f8274e, 4);
    }
}
