package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zznj implements zznk {

    /* renamed from: a */
    private static final zzdh<Boolean> f17841a;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17841a = zzdm.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzdm.zza("measurement.client.sessions.check_on_startup", true);
        zzdm.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17841a.zzc().booleanValue();
    }
}
