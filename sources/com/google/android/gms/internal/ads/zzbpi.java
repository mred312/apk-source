package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpi implements zzepf<zzbxy<zzva>> {

    /* renamed from: a */
    private final zzeps<zzbpo> f13618a;

    private zzbpi(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        this.f13618a = zzeps;
    }

    public static zzbpi zzb(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        return new zzbpi(zzbpf, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13618a.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
