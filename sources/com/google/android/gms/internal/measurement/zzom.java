package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzom implements zzoj {

    /* renamed from: a */
    private static final zzdh<Long> f17878a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zzdm.zza("measurement.id.max_bundles_per_iteration", 0);
        f17878a = zzdm.zza("measurement.max_bundles_per_iteration", 2);
    }

    public final long zza() {
        return f17878a.zzc().longValue();
    }
}
