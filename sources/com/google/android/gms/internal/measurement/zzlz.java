package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzlz implements zzma {

    /* renamed from: a */
    private static final zzdh<Boolean> f17766a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17766a = zzdm.zza("measurement.service.directly_maybe_log_error_events", false);
        zzdm.zza("measurement.id.service.directly_maybe_log_error_events", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17766a.zzc().booleanValue();
    }
}
