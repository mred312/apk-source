package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrl implements zzepf<String> {

    /* renamed from: a */
    private final zzbrg f13737a;

    /* renamed from: b */
    private final zzeps<zzbpo> f13738b;

    private zzbrl(zzbrg zzbrg, zzeps<zzbpo> zzeps) {
        this.f13737a = zzbrg;
        this.f13738b = zzeps;
    }

    public static String zza(zzbrg zzbrg, zzbpo zzbpo) {
        return (String) zzepl.zza(zzbpo.zzws(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbrl zzb(zzbrg zzbrg, zzeps<zzbpo> zzeps) {
        return new zzbrl(zzbrg, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13737a, this.f13738b.get());
    }
}
