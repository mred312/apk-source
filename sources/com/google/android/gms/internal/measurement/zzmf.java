package com.google.android.gms.internal.measurement;

import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzmf implements zzmg {

    /* renamed from: A */
    private static final zzdh<Long> f17773A;

    /* renamed from: B */
    private static final zzdh<Long> f17774B;

    /* renamed from: C */
    private static final zzdh<Long> f17775C;

    /* renamed from: D */
    private static final zzdh<Long> f17776D;

    /* renamed from: E */
    private static final zzdh<Long> f17777E;

    /* renamed from: F */
    private static final zzdh<String> f17778F;

    /* renamed from: G */
    private static final zzdh<Long> f17779G;

    /* renamed from: a */
    private static final zzdh<Long> f17780a;

    /* renamed from: b */
    private static final zzdh<Long> f17781b;

    /* renamed from: c */
    private static final zzdh<String> f17782c;

    /* renamed from: d */
    private static final zzdh<String> f17783d;

    /* renamed from: e */
    private static final zzdh<Long> f17784e;

    /* renamed from: f */
    private static final zzdh<Long> f17785f;

    /* renamed from: g */
    private static final zzdh<Long> f17786g;

    /* renamed from: h */
    private static final zzdh<Long> f17787h;

    /* renamed from: i */
    private static final zzdh<Long> f17788i;

    /* renamed from: j */
    private static final zzdh<Long> f17789j;

    /* renamed from: k */
    private static final zzdh<Long> f17790k;

    /* renamed from: l */
    private static final zzdh<Long> f17791l;

    /* renamed from: m */
    private static final zzdh<Long> f17792m;

    /* renamed from: n */
    private static final zzdh<Long> f17793n;

    /* renamed from: o */
    private static final zzdh<Long> f17794o;

    /* renamed from: p */
    private static final zzdh<Long> f17795p;

    /* renamed from: q */
    private static final zzdh<Long> f17796q;

    /* renamed from: r */
    private static final zzdh<Long> f17797r;

    /* renamed from: s */
    private static final zzdh<Long> f17798s;

    /* renamed from: t */
    private static final zzdh<Long> f17799t;

    /* renamed from: u */
    private static final zzdh<Long> f17800u;

    /* renamed from: v */
    private static final zzdh<Long> f17801v;

    /* renamed from: w */
    private static final zzdh<Long> f17802w;

    /* renamed from: x */
    private static final zzdh<Long> f17803x;

    /* renamed from: y */
    private static final zzdh<Long> f17804y;

    /* renamed from: z */
    private static final zzdh<Long> f17805z;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        f17780a = zzdm.zza("measurement.ad_id_cache_time", (long) WorkRequest.MIN_BACKOFF_MILLIS);
        f17781b = zzdm.zza("measurement.config.cache_time", 86400000);
        zzdm.zza("measurement.log_tag", "FA");
        f17782c = zzdm.zza("measurement.config.url_authority", "app-measurement.com");
        f17783d = zzdm.zza("measurement.config.url_scheme", "https");
        f17784e = zzdm.zza("measurement.upload.debug_upload_interval", 1000);
        f17785f = zzdm.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        f17786g = zzdm.zza("measurement.store.max_stored_events_per_app", 100000);
        f17787h = zzdm.zza("measurement.experiment.max_ids", 50);
        f17788i = zzdm.zza("measurement.audience.filter_result_max_count", 200);
        f17789j = zzdm.zza("measurement.alarm_manager.minimum_interval", 60000);
        f17790k = zzdm.zza("measurement.upload.minimum_delay", 500);
        f17791l = zzdm.zza("measurement.monitoring.sample_period_millis", 86400000);
        f17792m = zzdm.zza("measurement.upload.realtime_upload_interval", (long) WorkRequest.MIN_BACKOFF_MILLIS);
        f17793n = zzdm.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzdm.zza("measurement.config.cache_time.service", 3600000);
        f17794o = zzdm.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzdm.zza("measurement.log_tag.service", "FA-SVC");
        f17795p = zzdm.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        f17796q = zzdm.zza("measurement.upload.backoff_period", 43200000);
        f17797r = zzdm.zza("measurement.upload.initial_upload_delay_time", 15000);
        f17798s = zzdm.zza("measurement.upload.interval", 3600000);
        f17799t = zzdm.zza("measurement.upload.max_bundle_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        f17800u = zzdm.zza("measurement.upload.max_bundles", 100);
        f17801v = zzdm.zza("measurement.upload.max_conversions_per_day", 500);
        f17802w = zzdm.zza("measurement.upload.max_error_events_per_day", 1000);
        f17803x = zzdm.zza("measurement.upload.max_events_per_bundle", 1000);
        f17804y = zzdm.zza("measurement.upload.max_events_per_day", 100000);
        f17805z = zzdm.zza("measurement.upload.max_public_events_per_day", 50000);
        f17773A = zzdm.zza("measurement.upload.max_queue_time", 2419200000L);
        f17774B = zzdm.zza("measurement.upload.max_realtime_events_per_day", 10);
        f17775C = zzdm.zza("measurement.upload.max_batch_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        f17776D = zzdm.zza("measurement.upload.retry_count", 6);
        f17777E = zzdm.zza("measurement.upload.retry_time", 1800000);
        f17778F = zzdm.zza("measurement.upload.url", "https://app-measurement.com/a");
        f17779G = zzdm.zza("measurement.upload.window_interval", 3600000);
    }

    public final long zza() {
        return f17780a.zzc().longValue();
    }

    public final long zzaa() {
        return f17773A.zzc().longValue();
    }

    public final long zzab() {
        return f17774B.zzc().longValue();
    }

    public final long zzac() {
        return f17775C.zzc().longValue();
    }

    public final long zzad() {
        return f17776D.zzc().longValue();
    }

    public final long zzae() {
        return f17777E.zzc().longValue();
    }

    public final String zzaf() {
        return f17778F.zzc();
    }

    public final long zzag() {
        return f17779G.zzc().longValue();
    }

    public final long zzb() {
        return f17781b.zzc().longValue();
    }

    public final String zzc() {
        return f17782c.zzc();
    }

    public final String zzd() {
        return f17783d.zzc();
    }

    public final long zze() {
        return f17784e.zzc().longValue();
    }

    public final long zzf() {
        return f17785f.zzc().longValue();
    }

    public final long zzg() {
        return f17786g.zzc().longValue();
    }

    public final long zzh() {
        return f17787h.zzc().longValue();
    }

    public final long zzi() {
        return f17788i.zzc().longValue();
    }

    public final long zzj() {
        return f17789j.zzc().longValue();
    }

    public final long zzk() {
        return f17790k.zzc().longValue();
    }

    public final long zzl() {
        return f17791l.zzc().longValue();
    }

    public final long zzm() {
        return f17792m.zzc().longValue();
    }

    public final long zzn() {
        return f17793n.zzc().longValue();
    }

    public final long zzo() {
        return f17794o.zzc().longValue();
    }

    public final long zzp() {
        return f17795p.zzc().longValue();
    }

    public final long zzq() {
        return f17796q.zzc().longValue();
    }

    public final long zzr() {
        return f17797r.zzc().longValue();
    }

    public final long zzs() {
        return f17798s.zzc().longValue();
    }

    public final long zzt() {
        return f17799t.zzc().longValue();
    }

    public final long zzu() {
        return f17800u.zzc().longValue();
    }

    public final long zzv() {
        return f17801v.zzc().longValue();
    }

    public final long zzw() {
        return f17802w.zzc().longValue();
    }

    public final long zzx() {
        return f17803x.zzc().longValue();
    }

    public final long zzy() {
        return f17804y.zzc().longValue();
    }

    public final long zzz() {
        return f17805z.zzc().longValue();
    }
}
