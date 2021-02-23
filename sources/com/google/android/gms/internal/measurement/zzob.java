package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzob implements zzoc {

    /* renamed from: a */
    private static final zzdh<Boolean> f17862a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17863b;

    /* renamed from: c */
    private static final zzdh<Boolean> f17864c;

    /* renamed from: d */
    private static final zzdh<Boolean> f17865d;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17862a = zzdm.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        f17863b = zzdm.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        f17864c = zzdm.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f17865d = zzdm.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zzdm.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return f17862a.zzc().booleanValue();
    }

    public final boolean zzb() {
        return f17863b.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17864c.zzc().booleanValue();
    }

    public final boolean zzd() {
        return f17865d.zzc().booleanValue();
    }
}
