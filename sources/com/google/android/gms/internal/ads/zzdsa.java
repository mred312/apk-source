package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdsa implements zzepf<zzdrx> {

    /* renamed from: a */
    private final zzeps<zzcum> f15915a;

    /* renamed from: b */
    private final zzeps<zzazh> f15916b;

    /* renamed from: c */
    private final zzeps<String> f15917c;

    /* renamed from: d */
    private final zzeps<String> f15918d;

    /* renamed from: e */
    private final zzeps<Context> f15919e;

    /* renamed from: f */
    private final zzeps<zzdni> f15920f;

    /* renamed from: g */
    private final zzeps<Clock> f15921g;

    /* renamed from: h */
    private final zzeps<zzef> f15922h;

    private zzdsa(zzeps<zzcum> zzeps, zzeps<zzazh> zzeps2, zzeps<String> zzeps3, zzeps<String> zzeps4, zzeps<Context> zzeps5, zzeps<zzdni> zzeps6, zzeps<Clock> zzeps7, zzeps<zzef> zzeps8) {
        this.f15915a = zzeps;
        this.f15916b = zzeps2;
        this.f15917c = zzeps3;
        this.f15918d = zzeps4;
        this.f15919e = zzeps5;
        this.f15920f = zzeps6;
        this.f15921g = zzeps7;
        this.f15922h = zzeps8;
    }

    public static zzdsa zza(zzeps<zzcum> zzeps, zzeps<zzazh> zzeps2, zzeps<String> zzeps3, zzeps<String> zzeps4, zzeps<Context> zzeps5, zzeps<zzdni> zzeps6, zzeps<Clock> zzeps7, zzeps<zzef> zzeps8) {
        return new zzdsa(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8);
    }

    public final /* synthetic */ Object get() {
        return new zzdrx(this.f15915a.get(), this.f15916b.get(), this.f15917c.get(), this.f15918d.get(), this.f15919e.get(), this.f15920f.get(), this.f15921g.get(), this.f15922h.get());
    }
}
