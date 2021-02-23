package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdov implements zzepf<zzdor> {

    /* renamed from: a */
    private final zzeps<zzdop> f15834a;

    /* renamed from: b */
    private final zzeps<String> f15835b;

    private zzdov(zzdot zzdot, zzeps<zzdop> zzeps, zzeps<String> zzeps2) {
        this.f15834a = zzeps;
        this.f15835b = zzeps2;
    }

    public static zzdov zza(zzdot zzdot, zzeps<zzdop> zzeps, zzeps<String> zzeps2) {
        return new zzdov(zzdot, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzdor) zzepl.zza(this.f15834a.get().zzgs(this.f15835b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
