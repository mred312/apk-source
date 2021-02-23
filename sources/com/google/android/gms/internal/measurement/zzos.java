package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzos implements zzop {

    /* renamed from: a */
    private static final zzdh<Boolean> f17884a;

    /* renamed from: b */
    private static final zzdh<Double> f17885b;

    /* renamed from: c */
    private static final zzdh<Long> f17886c;

    /* renamed from: d */
    private static final zzdh<Long> f17887d;

    /* renamed from: e */
    private static final zzdh<String> f17888e;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17884a = zzdm.zza("measurement.test.boolean_flag", false);
        f17885b = zzdm.zza("measurement.test.double_flag", -3.0d);
        f17886c = zzdm.zza("measurement.test.int_flag", -2);
        f17887d = zzdm.zza("measurement.test.long_flag", -1);
        f17888e = zzdm.zza("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return f17884a.zzc().booleanValue();
    }

    public final double zzb() {
        return f17885b.zzc().doubleValue();
    }

    public final long zzc() {
        return f17886c.zzc().longValue();
    }

    public final long zzd() {
        return f17887d.zzc().longValue();
    }

    public final String zze() {
        return f17888e.zzc();
    }
}
