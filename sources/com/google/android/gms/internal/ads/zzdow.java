package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdow implements zzepf<zzf> {

    /* renamed from: a */
    private final zzdot f15836a;

    /* renamed from: b */
    private final zzeps<zzdor> f15837b;

    private zzdow(zzdot zzdot, zzeps<zzdor> zzeps) {
        this.f15836a = zzdot;
        this.f15837b = zzeps;
    }

    public static zzdow zza(zzdot zzdot, zzeps<zzdor> zzeps) {
        return new zzdow(zzdot, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15836a, this.f15837b.get());
    }

    public static zzf zza(zzdot zzdot, zzdor zzdor) {
        return (zzf) zzepl.zza(zzdor.zzebt, "Cannot return null from a non-@Nullable @Provides method");
    }
}
