package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class ij0 extends lj0<zzwz> {

    /* renamed from: b */
    private final /* synthetic */ Context f9332b;

    /* renamed from: c */
    private final /* synthetic */ String f9333c;

    /* renamed from: d */
    private final /* synthetic */ zzani f9334d;

    /* renamed from: e */
    private final /* synthetic */ zzvx f9335e;

    ij0(zzvx zzvx, Context context, String str, zzani zzani) {
        this.f9335e = zzvx;
        this.f9332b = context;
        this.f9333c = str;
        this.f9334d = zzani;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.f9332b), this.f9333c, this.f9334d, 203404000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f9332b, "native_ad");
        return new zzzo();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f9335e.f17081b.zza(this.f9332b, this.f9333c, this.f9334d);
    }
}
