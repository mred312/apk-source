package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkr implements zzepf<zzdkl<zzblg, zzbll>> {

    /* renamed from: a */
    private final zzeps<Context> f15722a;

    /* renamed from: b */
    private final zzeps<zzdpa> f15723b;

    /* renamed from: c */
    private final zzeps<zzdpr> f15724c;

    public zzdkr(zzeps<Context> zzeps, zzeps<zzdpa> zzeps2, zzeps<zzdpr> zzeps3) {
        this.f15722a = zzeps;
        this.f15723b = zzeps2;
        this.f15724c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdkl) zzepl.zza(zzdkp.zza(this.f15722a.get(), this.f15723b.get(), this.f15724c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
