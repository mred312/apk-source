package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzme implements zzmb {

    /* renamed from: a */
    private static final zzdh<Boolean> f17771a;

    /* renamed from: b */
    private static final zzdh<Long> f17772b;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17771a = zzdm.zza("measurement.sdk.attribution.cache", true);
        f17772b = zzdm.zza("measurement.sdk.attribution.cache.ttl", 604800000);
    }

    public final boolean zza() {
        return f17771a.zzc().booleanValue();
    }

    public final long zzb() {
        return f17772b.zzc().longValue();
    }
}
