package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmj;

/* renamed from: com.google.android.gms.measurement.internal.m3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3049m3 extends C3059n4 {
    @VisibleForTesting

    /* renamed from: C */
    static final Pair<String, Long> f18223C = new Pair<>("", 0L);

    /* renamed from: A */
    public final zzfh f18224A = new zzfh(this, "deferred_attribution_cache_timestamp", 0);

    /* renamed from: B */
    public final zzfe f18225B = new zzfe(this, "default_event_parameters", (Bundle) null);

    /* renamed from: b */
    private SharedPreferences f18226b;

    /* renamed from: c */
    public zzfg f18227c;

    /* renamed from: d */
    public final zzfh f18228d = new zzfh(this, "last_upload", 0);

    /* renamed from: e */
    public final zzfh f18229e = new zzfh(this, "last_upload_attempt", 0);

    /* renamed from: f */
    public final zzfh f18230f = new zzfh(this, "backoff", 0);

    /* renamed from: g */
    public final zzfh f18231g = new zzfh(this, "last_delete_stale", 0);

    /* renamed from: h */
    public final zzfh f18232h = new zzfh(this, "midnight_offset", 0);

    /* renamed from: i */
    public final zzfh f18233i = new zzfh(this, "first_open_time", 0);

    /* renamed from: j */
    public final zzfh f18234j = new zzfh(this, "app_install_time", 0);

    /* renamed from: k */
    public final zzfj f18235k = new zzfj(this, "app_instance_id", (String) null);

    /* renamed from: l */
    private String f18236l;

    /* renamed from: m */
    private boolean f18237m;

    /* renamed from: n */
    private long f18238n;

    /* renamed from: o */
    public final zzfh f18239o = new zzfh(this, "time_before_start", WorkRequest.MIN_BACKOFF_MILLIS);

    /* renamed from: p */
    public final zzfh f18240p = new zzfh(this, "session_timeout", 1800000);

    /* renamed from: q */
    public final zzff f18241q = new zzff(this, "start_new_session", true);

    /* renamed from: r */
    public final zzfj f18242r = new zzfj(this, "non_personalized_ads", (String) null);

    /* renamed from: s */
    public final zzff f18243s = new zzff(this, "allow_remote_dynamite", false);

    /* renamed from: t */
    public final zzfh f18244t = new zzfh(this, "last_pause_time", 0);

    /* renamed from: u */
    public boolean f18245u;

    /* renamed from: v */
    public zzff f18246v = new zzff(this, "app_backgrounded", false);

    /* renamed from: w */
    public zzff f18247w = new zzff(this, "deep_link_retrieval_complete", false);

    /* renamed from: x */
    public zzfh f18248x = new zzfh(this, "deep_link_retrieval_attempts", 0);

    /* renamed from: y */
    public final zzfj f18249y = new zzfj(this, "firebase_feature_rollouts", (String) null);

    /* renamed from: z */
    public final zzfj f18250z = new zzfj(this, "deferred_attribution_cache", (String) null);

    C3049m3(zzfv zzfv) {
        super(zzfv);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    /* renamed from: b */
    public final Pair<String, Boolean> mo20036b(String str) {
        zzc();
        long elapsedRealtime = zzl().elapsedRealtime();
        if (this.f18236l != null && elapsedRealtime < this.f18238n) {
            return new Pair<>(this.f18236l, Boolean.valueOf(this.f18237m));
        }
        this.f18238n = elapsedRealtime + zzs().mo20603e(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
            if (advertisingIdInfo != null) {
                this.f18236l = advertisingIdInfo.getId();
                this.f18237m = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f18236l == null) {
                this.f18236l = "";
            }
        } catch (Exception e) {
            zzq().zzv().zza("Unable to get advertising id", e);
            this.f18236l = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.f18236l, Boolean.valueOf(this.f18237m));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo20037c(long j) {
        return j - this.f18240p.zza() > this.f18244t.zza();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: d */
    public final boolean mo20038d(zzad zzad, int i) {
        if (!zzmj.zzb() || !zzs().zza(zzat.zzcg)) {
            return false;
        }
        zzc();
        if (!zza(i)) {
            return false;
        }
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.putString("consent_settings", zzad.zza());
        edit.putInt("consent_source", i);
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: e */
    public final void mo20039e(Boolean bool) {
        if (zzmj.zzb() && zzs().zza(zzat.zzcg)) {
            zzc();
            SharedPreferences.Editor edit = mo20043h().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: f */
    public final void mo20040f(String str) {
        zzc();
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: g */
    public final void mo20041g(boolean z) {
        zzc();
        zzq().zzw().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    /* renamed from: g_ */
    public final void mo20042g_() {
        SharedPreferences sharedPreferences = zzm().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f18226b = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.f18245u = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f18226b.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f18227c = new zzfg(this, "health_monitor", Math.max(0, zzat.zzb.zza(null).longValue()));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: h */
    public final SharedPreferences mo20043h() {
        zzc();
        zzaa();
        return this.f18226b;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: i */
    public final String mo20044i() {
        zzc();
        return mo20043h().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: j */
    public final String mo20045j() {
        zzc();
        return mo20043h().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: k */
    public final Boolean mo20046k() {
        zzc();
        if (!mo20043h().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(mo20043h().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: l */
    public final void mo20047l() {
        zzc();
        Boolean m = mo20048m();
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.clear();
        edit.apply();
        if (m != null) {
            zza(m);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: m */
    public final Boolean mo20048m() {
        zzc();
        if (mo20043h().contains("measurement_enabled")) {
            return Boolean.valueOf(mo20043h().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: n */
    public final Boolean mo20049n() {
        if (!zzmj.zzb() || !zzs().zza(zzat.zzcg)) {
            return null;
        }
        zzc();
        if (mo20043h().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(mo20043h().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: o */
    public final zzad mo20050o() {
        zzc();
        return zzad.zza(mo20043h().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        zzc();
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(String str) {
        zzc();
        SharedPreferences.Editor edit = mo20043h().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzx() {
        zzc();
        String string = mo20043h().getString("previous_os_version", (String) null);
        zzk().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = mo20043h().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzy() {
        return this.f18226b.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(Boolean bool) {
        zzc();
        SharedPreferences.Editor edit = mo20043h().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zza(int i) {
        return zzad.zza(i, mo20043h().getInt("consent_source", 100));
    }
}
