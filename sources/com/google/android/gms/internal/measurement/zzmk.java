package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzmk implements zzmh {

    /* renamed from: a */
    private static final zzdh<Boolean> f17810a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17811b;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17810a = zzdm.zza("measurement.service.configurable_service_limits", true);
        f17811b = zzdm.zza("measurement.client.configurable_service_limits", true);
        zzdm.zza("measurement.id.service.configurable_service_limits", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17810a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17811b.zzc().booleanValue();
    }
}
