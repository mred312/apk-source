package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zznp implements zznq {

    /* renamed from: a */
    private static final zzdh<Boolean> f17847a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17848b;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17847a = zzdm.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f17848b = zzdm.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzdm.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return f17847a.zzc().booleanValue();
    }

    public final boolean zzb() {
        return f17848b.zzc().booleanValue();
    }
}
