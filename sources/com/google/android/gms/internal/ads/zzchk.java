package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzchk implements zzepf<zzcqz<zzchc>> {

    /* renamed from: a */
    private final zzeps<zzcvy<zzchc, zzdoe, zzcsw>> f14375a;

    /* renamed from: b */
    private final zzeps<zzcvy<zzchc, zzdoe, zzcst>> f14376b;

    /* renamed from: c */
    private final zzeps<zzdnn> f14377c;

    public zzchk(zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzeps, zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzeps2, zzeps<zzdnn> zzeps3) {
        this.f14375a = zzeps;
        this.f14376b = zzeps2;
        this.f14377c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        zzcqz zzcqz;
        zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzeps = this.f14375a;
        zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzeps2 = this.f14376b;
        if (C2326qj.f10724a[this.f14377c.get().zzhiv.zzhia - 1] != 1) {
            zzcqz = zzeps2.get();
        } else {
            zzcqz = zzeps.get();
        }
        return (zzcqz) zzepl.zza(zzcqz, "Cannot return null from a non-@Nullable @Provides method");
    }
}
