package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zznc implements zzmz {

    /* renamed from: a */
    private static final zzdh<Boolean> f17834a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17834a = zzdm.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzdm.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17834a.zzc().booleanValue();
    }
}
