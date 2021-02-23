package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class jj0 extends lj0<zzaeq> {

    /* renamed from: b */
    private final /* synthetic */ View f9520b;

    /* renamed from: c */
    private final /* synthetic */ HashMap f9521c;

    /* renamed from: d */
    private final /* synthetic */ HashMap f9522d;

    /* renamed from: e */
    private final /* synthetic */ zzvx f9523e;

    jj0(zzvx zzvx, View view, HashMap hashMap, HashMap hashMap2) {
        this.f9523e = zzvx;
        this.f9520b = view;
        this.f9521c = hashMap;
        this.f9522d = hashMap2;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.f9520b), ObjectWrapper.wrap(this.f9521c), ObjectWrapper.wrap(this.f9522d));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f9520b.getContext(), "native_ad_view_holder_delegate");
        return new zzzz();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f9523e.f17086g.zzb(this.f9520b, this.f9521c, this.f9522d);
    }
}
