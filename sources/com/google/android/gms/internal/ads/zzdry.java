package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdry implements zzepf<zzaml> {

    /* renamed from: a */
    private final zzeps<Context> f15911a;

    /* renamed from: b */
    private final zzeps<zzazh> f15912b;

    public zzdry(zzdrv zzdrv, zzeps<Context> zzeps, zzeps<zzazh> zzeps2) {
        this.f15911a = zzeps;
        this.f15912b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzaml) zzepl.zza(new zzamc().zzb(this.f15911a.get(), this.f15912b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
