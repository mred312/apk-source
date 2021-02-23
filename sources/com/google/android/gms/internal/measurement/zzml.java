package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzml implements zzmm {

    /* renamed from: a */
    private static final zzdh<Boolean> f17812a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17813b;

    /* renamed from: c */
    private static final zzdh<Boolean> f17814c;

    /* renamed from: d */
    private static final zzdh<Long> f17815d;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17812a = zzdm.zza("measurement.client.consent_state_v1", false);
        f17813b = zzdm.zza("measurement.client.3p_consent_state_v1", false);
        f17814c = zzdm.zza("measurement.service.consent_state_v1_W36", false);
        f17815d = zzdm.zza("measurement.service.storage_consent_support_version", 203590);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17812a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17813b.zzc().booleanValue();
    }

    public final boolean zzd() {
        return f17814c.zzc().booleanValue();
    }

    public final long zze() {
        return f17815d.zzc().longValue();
    }
}
