package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbor implements zzepf<zzdmu> {

    /* renamed from: a */
    private final zzbos f13590a;

    private zzbor(zzbos zzbos) {
        this.f13590a = zzbos;
    }

    public static zzbor zza(zzbos zzbos) {
        return new zzbor(zzbos);
    }

    public static zzdmu zzb(zzbos zzbos) {
        return (zzdmu) zzepl.zza(zzbos.zzakf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.f13590a);
    }
}
