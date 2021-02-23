package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzls implements zzlp {

    /* renamed from: a */
    private static final zzdh<Boolean> f17757a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17758b;

    /* renamed from: c */
    private static final zzdh<Boolean> f17759c;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17757a = zzdm.zza("measurement.client.ad_impression", true);
        f17758b = zzdm.zza("measurement.service.separate_public_internal_event_blacklisting", false);
        f17759c = zzdm.zza("measurement.service.ad_impression", false);
        zzdm.zza("measurement.id.service.ad_impression", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17757a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17758b.zzc().booleanValue();
    }

    public final boolean zzd() {
        return f17759c.zzc().booleanValue();
    }
}
