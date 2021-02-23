package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.work.WorkRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzct;
import com.google.android.gms.internal.measurement.zzde;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzat {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static List<zzeg<?>> f18511a = Collections.synchronizedList(new ArrayList());
    public static zzeg<Long> zza;
    public static zzeg<Long> zzaa = m10705a("measurement.upload.retry_time", 1800000L, 1800000L, C2971e0.f18029a);
    public static zzeg<Integer> zzab = m10705a("measurement.upload.retry_count", 6, 6, C2961d0.f18008a);
    public static zzeg<Long> zzac = m10705a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, C2991g0.f18070a);
    public static zzeg<Integer> zzad = m10705a("measurement.lifetimevalue.max_currency_tracked", 4, 4, C2981f0.f18052a);
    public static zzeg<Integer> zzae;
    public static zzeg<Integer> zzaf = m10705a("measurement.upload.max_public_user_properties", 25, 25, (C3156y2) null);
    public static zzeg<Integer> zzag = m10705a("measurement.upload.max_event_name_cardinality", 500, 500, (C3156y2) null);
    public static zzeg<Integer> zzah = m10705a("measurement.upload.max_public_event_params", 25, 25, (C3156y2) null);
    public static zzeg<Long> zzai = m10705a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, C3028k0.f18189a);
    public static zzeg<Boolean> zzaj;
    public static zzeg<String> zzak = m10705a("measurement.test.string_flag", "---", "---", C3046m0.f18220a);
    public static zzeg<Long> zzal = m10705a("measurement.test.long_flag", -1L, -1L, C3037l0.f18203a);
    public static zzeg<Integer> zzam = m10705a("measurement.test.int_flag", -2, -2, C3064o0.f18275a);
    public static zzeg<Double> zzan;
    public static zzeg<Integer> zzao = m10705a("measurement.experiment.max_ids", 50, 50, C3082q0.f18311a);
    public static zzeg<Integer> zzap = m10705a("measurement.max_bundles_per_iteration", 100, 100, C3073p0.f18287a);
    public static zzeg<Boolean> zzaq;
    public static zzeg<Boolean> zzar;
    public static zzeg<Boolean> zzas;
    public static zzeg<Boolean> zzat;
    public static zzeg<Boolean> zzau;
    public static zzeg<Boolean> zzav;
    public static zzeg<Boolean> zzaw;
    public static zzeg<Boolean> zzax;
    public static zzeg<Boolean> zzay;
    public static zzeg<Boolean> zzaz;
    public static zzeg<Long> zzb = m10705a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, C3036l.f18202a);
    public static zzeg<Boolean> zzba;
    public static zzeg<Boolean> zzbb;
    public static zzeg<Boolean> zzbc;
    public static zzeg<Boolean> zzbd;
    public static zzeg<Boolean> zzbe;
    public static zzeg<Boolean> zzbf;
    public static zzeg<Boolean> zzbg;
    public static zzeg<Boolean> zzbh;
    public static zzeg<Boolean> zzbi;
    public static zzeg<Boolean> zzbj;
    public static zzeg<Boolean> zzbk;
    public static zzeg<Boolean> zzbl;
    public static zzeg<Boolean> zzbm;
    public static zzeg<Boolean> zzbn;
    public static zzeg<Boolean> zzbo;
    public static zzeg<Boolean> zzbp;
    public static zzeg<Boolean> zzbq;
    public static zzeg<Boolean> zzbr;
    public static zzeg<Boolean> zzbs;
    public static zzeg<Boolean> zzbt;
    public static zzeg<Boolean> zzbu;
    public static zzeg<Boolean> zzbv;
    public static zzeg<Boolean> zzbw;
    public static zzeg<Boolean> zzbx;
    public static zzeg<Boolean> zzby;
    public static zzeg<Boolean> zzbz;
    public static zzeg<Long> zzc = m10705a("measurement.config.cache_time", 86400000L, 3600000L, C3126v.f18402a);
    public static zzeg<Boolean> zzca;
    public static zzeg<Boolean> zzcb;
    public static zzeg<Boolean> zzcc;
    public static zzeg<Long> zzcd = m10705a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, C3021j2.f18174a);
    public static zzeg<Boolean> zzce;
    public static zzeg<Boolean> zzcf;
    public static zzeg<Boolean> zzcg;
    public static zzeg<Boolean> zzch;
    public static zzeg<Boolean> zzci;
    public static zzeg<Integer> zzcj = m10705a("measurement.service.storage_consent_support_version", 203590, 203590, C3102s2.f18349a);
    public static zzeg<Boolean> zzck;
    public static zzeg<Boolean> zzcl;
    public static zzeg<Boolean> zzcm;
    public static zzeg<Boolean> zzcn;
    public static zzeg<String> zzd = m10705a("measurement.config.url_scheme", "https", "https", C3010i0.f18127a);
    public static zzeg<String> zze = m10705a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", C3100s0.f18348a);
    public static zzeg<Integer> zzf = m10705a("measurement.upload.max_bundles", 100, 100, C2982f1.f18053a);
    public static zzeg<Integer> zzg = m10705a("measurement.upload.max_batch_size", 65536, 65536, C3065o1.f18276a);
    public static zzeg<Integer> zzh = m10705a("measurement.upload.max_bundle_size", 65536, 65536, C2953c2.f17989a);
    public static zzeg<Integer> zzi = m10705a("measurement.upload.max_events_per_bundle", 1000, 1000, C3039l2.f18205a);
    public static zzeg<Integer> zzj = m10705a("measurement.upload.max_events_per_day", 100000, 100000, C3138w2.f18423a);
    public static zzeg<Integer> zzk = m10705a("measurement.upload.max_error_events_per_day", 1000, 1000, C3027k.f18188a);
    public static zzeg<Integer> zzl = m10705a("measurement.upload.max_public_events_per_day", 50000, 50000, C3054n.f18257a);
    public static zzeg<Integer> zzm = m10705a("measurement.upload.max_conversions_per_day", 10000, 10000, C3045m.f18219a);
    public static zzeg<Integer> zzn = m10705a("measurement.upload.max_realtime_events_per_day", 10, 10, C3072p.f18286a);
    public static zzeg<Integer> zzo = m10705a("measurement.store.max_stored_events_per_app", 100000, 100000, C3063o.f18274a);
    public static zzeg<String> zzp = m10705a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", C3099s.f18347a);
    public static zzeg<Long> zzq = m10705a("measurement.upload.backoff_period", 43200000L, 43200000L, C3090r.f18332a);
    public static zzeg<Long> zzr = m10705a("measurement.upload.window_interval", 3600000L, 3600000L, C3117u.f18385a);
    public static zzeg<Long> zzs = m10705a("measurement.upload.interval", 3600000L, 3600000L, C3108t.f18361a);
    public static zzeg<Long> zzt;
    public static zzeg<Long> zzu = m10705a("measurement.upload.debug_upload_interval", 1000L, 1000L, C3153y.f18456a);
    public static zzeg<Long> zzv = m10705a("measurement.upload.minimum_delay", 500L, 500L, C3144x.f18441a);
    public static zzeg<Long> zzw = m10705a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, C2931a0.f17931a);
    public static zzeg<Long> zzx = m10705a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, C3162z.f18470a);
    public static zzeg<Long> zzy = m10705a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, C2951c0.f17987a);
    public static zzeg<Long> zzz = m10705a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, C2941b0.f17955a);

    static {
        Boolean bool = Boolean.FALSE;
        Collections.synchronizedSet(new HashSet());
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        zza = m10705a("measurement.ad_id_cache_time", valueOf, valueOf, C3018j.f18171a);
        zzt = m10705a("measurement.upload.realtime_upload_interval", valueOf, valueOf, C3135w.f18420a);
        Integer valueOf2 = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzae = m10705a("measurement.audience.filter_result_max_count", valueOf2, valueOf2, C3001h0.f18104a);
        zzaj = m10705a("measurement.test.boolean_flag", bool, bool, C3019j0.f18172a);
        Double valueOf3 = Double.valueOf(-3.0d);
        zzan = m10705a("measurement.test.double_flag", valueOf3, valueOf3, C3055n0.f18258a);
        zzaq = m10705a("measurement.validation.internal_limits_internal_event_params", bool, bool, C3109t0.f18362a);
        Boolean bool2 = Boolean.TRUE;
        zzar = m10705a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, C3127v0.f18403a);
        zzas = m10705a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, C3118u0.f18386a);
        zzat = m10705a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, C3145x0.f18442a);
        zzau = m10705a("measurement.client.freeride_engagement_fix", bool2, bool2, C3136w0.f18421a);
        zzav = m10705a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, C3163z0.f18471a);
        zzaw = m10705a("measurement.quality.checksum", bool, bool, (C3156y2) null);
        zzax = m10705a("measurement.sdk.dynamite.allow_remote_dynamite3", bool, bool, C3154y0.f18457a);
        zzay = m10705a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, C2942b1.f17956a);
        zzaz = m10705a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, C2932a1.f17932a);
        zzba = m10705a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, C2962d1.f18009a);
        zzbb = m10705a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, C2952c1.f17988a);
        zzbc = m10705a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, C2972e1.f18030a);
        zzbd = m10705a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, C3002h1.f18105a);
        zzbe = m10705a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, C2992g1.f18071a);
        zzbf = m10705a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, C3020j1.f18173a);
        zzbg = m10705a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, C3011i1.f18128a);
        zzbh = m10705a("measurement.upload.file_lock_state_check", bool, bool, C3038l1.f18204a);
        zzbi = m10705a("measurement.ga.ga_app_id", bool, bool, C3029k1.f18190a);
        zzbj = m10705a("measurement.lifecycle.app_in_background_parameter", bool, bool, C3056n1.f18259a);
        zzbk = m10705a("measurement.integration.disable_firebase_instance_id", bool, bool, C3047m1.f18221a);
        zzbl = m10705a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, C3074p1.f18288a);
        zzbm = m10705a("measurement.collection.service.update_with_analytics_fix", bool, bool, C3092r1.f18336a);
        zzbn = m10705a("measurement.service.use_appinfo_modified", bool, bool, C3083q1.f18312a);
        zzbo = m10705a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, C3119u1.f18387a);
        zzbp = m10705a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, C3110t1.f18363a);
        zzbq = m10705a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, C3137w1.f18422a);
        zzbr = m10705a("measurement.upload.file_truncate_fix", bool, bool, C3128v1.f18404a);
        zzbs = m10705a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, C3155y1.f18458a);
        zzbt = m10705a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, C3146x1.f18443a);
        zzbu = m10705a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, C2933a2.f17933a);
        m10705a("measurement.collection.synthetic_data_mitigation", bool, bool, C3164z1.f18472a);
        zzbv = m10705a("measurement.service.configurable_service_limits", bool2, bool2, C2943b2.f17957a);
        zzbw = m10705a("measurement.client.configurable_service_limits", bool2, bool2, C2973e2.f18031a);
        zzbx = m10705a("measurement.androidId.delete_feature", bool2, bool2, C2963d2.f18010a);
        zzby = m10705a("measurement.client.global_params", bool2, bool2, C2993g2.f18072a);
        zzbz = m10705a("measurement.service.global_params", bool2, bool2, C2983f2.f18054a);
        zzca = m10705a("measurement.service.global_params_in_payload", bool2, bool2, C3012i2.f18129a);
        zzcb = m10705a("measurement.client.string_reader", bool2, bool2, C3003h2.f18106a);
        zzcc = m10705a("measurement.sdk.attribution.cache", bool2, bool2, C3030k2.f18191a);
        zzce = m10705a("measurement.service.database_return_empty_collection", bool2, bool2, C3048m2.f18222a);
        zzcf = m10705a("measurement.service.ssaid_removal", bool2, bool2, C3066o2.f18277a);
        zzcg = m10705a("measurement.client.consent_state_v1", bool2, bool2, C3057n2.f18260a);
        zzch = m10705a("measurement.client.3p_consent_state_v1.dev", bool, bool, C3084q2.f18313a);
        zzci = m10705a("measurement.service.consent_state_v1_W36", bool, bool, C3075p2.f18289a);
        zzck = m10705a("measurement.client.ad_impression", bool2, bool2, C3093r2.f18337a);
        zzcl = m10705a("measurement.service.ad_impression", bool2, bool2, C3129v2.f18405a);
        zzcm = m10705a("measurement.service.separate_public_internal_event_blacklisting", bool2, bool2, C3120u2.f18388a);
        zzcn = m10705a("measurement.service.directly_maybe_log_error_events", bool, bool, C3147x2.f18444a);
    }

    @VisibleForTesting
    /* renamed from: a */
    private static <V> zzeg<V> m10705a(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable C3156y2<V> y2Var) {
        zzeg zzeg = new zzeg(str, v, v2, y2Var);
        f18511a.add(zzeg);
        return zzeg;
    }

    public static Map<String, String> zza(Context context) {
        zzct zza2 = zzct.zza(context.getContentResolver(), zzde.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }
}
