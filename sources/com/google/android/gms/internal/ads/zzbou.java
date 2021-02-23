package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbou implements zzepf<String> {

    /* renamed from: a */
    private final zzbos f13595a;

    private zzbou(zzbos zzbos) {
        this.f13595a = zzbos;
    }

    public static zzbou zzd(zzbos zzbos) {
        return new zzbou(zzbos);
    }

    public static String zze(zzbos zzbos) {
        return (String) zzepl.zza(zzbos.zzakh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zze(this.f13595a);
    }
}
