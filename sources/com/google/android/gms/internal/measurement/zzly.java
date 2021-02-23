package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzly implements zzlv {

    /* renamed from: a */
    private static final zzdh<Boolean> f17765a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17765a = zzdm.zza("measurement.androidId.delete_feature", true);
        zzdm.zza("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return f17765a.zzc().booleanValue();
    }
}
