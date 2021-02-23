package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzmq implements zzmn {

    /* renamed from: a */
    private static final zzdh<Boolean> f17820a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17820a = zzdm.zza("measurement.sdk.dynamite.allow_remote_dynamite3", false);
        zzdm.zza("measurement.collection.init_params_control_enabled", true);
        zzdm.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzdm.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean zza() {
        return f17820a.zzc().booleanValue();
    }
}
