package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpk implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzbpo> f13620a;

    private zzbpk(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        this.f13620a = zzeps;
    }

    public static zzbpk zzd(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        return new zzbpk(zzbpf, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13620a.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
