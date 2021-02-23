package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbow implements zzepf<zzdnj> {

    /* renamed from: a */
    private final zzbos f13598a;

    private zzbow(zzbos zzbos) {
        this.f13598a = zzbos;
    }

    public static zzbow zzf(zzbos zzbos) {
        return new zzbow(zzbos);
    }

    public static zzdnj zzg(zzbos zzbos) {
        return (zzdnj) zzepl.zza(zzbos.zzake(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzg(this.f13598a);
    }
}
