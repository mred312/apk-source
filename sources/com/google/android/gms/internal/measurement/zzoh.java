package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzoh implements zzoi {

    /* renamed from: a */
    private static final zzdh<Boolean> f17872a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17873b;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17872a = zzdm.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        f17873b = zzdm.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17872a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17873b.zzc().booleanValue();
    }
}
