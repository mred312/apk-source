package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcau implements zzepf<zzccl> {

    /* renamed from: a */
    private final zzcap f13932a;

    private zzcau(zzcap zzcap) {
        this.f13932a = zzcap;
    }

    public static zzcau zzd(zzcap zzcap) {
        return new zzcau(zzcap);
    }

    public static zzccl zze(zzcap zzcap) {
        return (zzccl) zzepl.zza(zzcap.zzamj(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zze(this.f13932a);
    }
}
