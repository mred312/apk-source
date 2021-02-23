package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccw implements zzepf<zzcce> {

    /* renamed from: a */
    private final zzccq f14100a;

    private zzccw(zzccq zzccq) {
        this.f14100a = zzccq;
    }

    public static zzccw zzb(zzccq zzccq) {
        return new zzccw(zzccq);
    }

    public static zzcce zzc(zzccq zzccq) {
        return (zzcce) zzepl.zza(zzccq.zzaoa(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.f14100a);
    }
}
