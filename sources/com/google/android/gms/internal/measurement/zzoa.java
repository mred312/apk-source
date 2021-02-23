package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzoa implements zznx {

    /* renamed from: a */
    private static final zzdh<Boolean> f17859a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17860b;

    /* renamed from: c */
    private static final zzdh<Boolean> f17861c;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17859a = zzdm.zza("measurement.client.global_params", true);
        f17860b = zzdm.zza("measurement.service.global_params_in_payload", true);
        f17861c = zzdm.zza("measurement.service.global_params", true);
        zzdm.zza("measurement.id.service.global_params", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17859a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17860b.zzc().booleanValue();
    }

    public final boolean zzd() {
        return f17861c.zzc().booleanValue();
    }
}
