package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdez implements zzepf<zzdex> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15525a;

    /* renamed from: b */
    private final zzeps<Context> f15526b;

    /* renamed from: c */
    private final zzeps<zzazh> f15527c;

    private zzdez(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<zzazh> zzeps3) {
        this.f15525a = zzeps;
        this.f15526b = zzeps2;
        this.f15527c = zzeps3;
    }

    public static zzdez zzw(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<zzazh> zzeps3) {
        return new zzdez(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdex(this.f15525a.get(), this.f15526b.get(), this.f15527c.get());
    }
}
