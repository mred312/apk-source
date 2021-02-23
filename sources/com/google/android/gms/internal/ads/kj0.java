package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class kj0 extends lj0<zzaen> {

    /* renamed from: b */
    private final /* synthetic */ FrameLayout f9764b;

    /* renamed from: c */
    private final /* synthetic */ FrameLayout f9765c;

    /* renamed from: d */
    private final /* synthetic */ Context f9766d;

    /* renamed from: e */
    private final /* synthetic */ zzvx f9767e;

    kj0(zzvx zzvx, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f9767e = zzvx;
        this.f9764b = frameLayout;
        this.f9765c = frameLayout2;
        this.f9766d = context;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo13605a(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.f9764b), ObjectWrapper.wrap(this.f9765c));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ Object mo13606c() {
        zzvx.m9253b(this.f9766d, "native_ad_view_delegate");
        return new zzzw();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo13607d() {
        return this.f9767e.f17083d.zzb(this.f9766d, this.f9764b, this.f9765c);
    }
}
