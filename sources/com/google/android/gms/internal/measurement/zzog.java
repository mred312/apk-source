package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzog implements zzod {

    /* renamed from: a */
    private static final zzdh<Boolean> f17870a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17871b;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zzdm.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        f17870a = zzdm.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzdm.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        f17871b = zzdm.zza("measurement.lifecycle.app_in_background_parameter", false);
        zzdm.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return f17870a.zzc().booleanValue();
    }

    public final boolean zzb() {
        return f17871b.zzc().booleanValue();
    }
}
