package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdan implements zzepf<zzdal> {

    /* renamed from: a */
    private final zzeps<zzdbw<zzdfp>> f15139a;

    /* renamed from: b */
    private final zzeps<zzdnn> f15140b;

    /* renamed from: c */
    private final zzeps<Context> f15141c;

    /* renamed from: d */
    private final zzeps<zzayg> f15142d;

    private zzdan(zzeps<zzdbw<zzdfp>> zzeps, zzeps<zzdnn> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4) {
        this.f15139a = zzeps;
        this.f15140b = zzeps2;
        this.f15141c = zzeps3;
        this.f15142d = zzeps4;
    }

    public static zzdan zzg(zzeps<zzdbw<zzdfp>> zzeps, zzeps<zzdnn> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4) {
        return new zzdan(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdal(this.f15139a.get(), this.f15140b.get(), this.f15141c.get(), this.f15142d.get());
    }
}
