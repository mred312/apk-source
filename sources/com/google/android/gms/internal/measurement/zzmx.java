package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzmx implements zzmy {

    /* renamed from: a */
    private static final zzdh<Boolean> f17827a;

    /* renamed from: b */
    private static final zzdh<Boolean> f17828b;

    /* renamed from: c */
    private static final zzdh<Boolean> f17829c;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zzdm.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f17827a = zzdm.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        f17828b = zzdm.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f17829c = zzdm.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return f17827a.zzc().booleanValue();
    }

    public final boolean zzc() {
        return f17828b.zzc().booleanValue();
    }

    public final boolean zzd() {
        return f17829c.zzc().booleanValue();
    }
}
