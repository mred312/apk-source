package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl;
import java.util.Date;

public class ConfigMetadataClient {
    @VisibleForTesting
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1;

    /* renamed from: d */
    static final Date f20261d = new Date(-1);
    @VisibleForTesting

    /* renamed from: e */
    static final Date f20262e = new Date(-1);

    /* renamed from: a */
    private final SharedPreferences f20263a;

    /* renamed from: b */
    private final Object f20264b = new Object();

    /* renamed from: c */
    private final Object f20265c = new Object();

    /* renamed from: com.google.firebase.remoteconfig.internal.ConfigMetadataClient$a */
    static class C3583a {

        /* renamed from: a */
        private int f20266a;

        /* renamed from: b */
        private Date f20267b;

        C3583a(int i, Date date) {
            this.f20266a = i;
            this.f20267b = date;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Date mo22655a() {
            return this.f20267b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo22656b() {
            return this.f20266a;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.f20263a = sharedPreferences;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3583a mo22639a() {
        C3583a aVar;
        synchronized (this.f20265c) {
            aVar = new C3583a(this.f20263a.getInt("num_failed_fetches", 0), new Date(this.f20263a.getLong("backoff_end_time_in_millis", -1)));
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public String mo22640b() {
        return this.f20263a.getString("last_fetch_etag", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Date mo22641c() {
        return new Date(this.f20263a.getLong("last_fetch_time_in_millis", -1));
    }

    @WorkerThread
    public void clear() {
        synchronized (this.f20264b) {
            this.f20263a.edit().clear().commit();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo22643d() {
        mo22644e(0, f20262e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo22644e(int i, Date date) {
        synchronized (this.f20265c) {
            this.f20263a.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo22645f(String str) {
        synchronized (this.f20264b) {
            this.f20263a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo22646g() {
        synchronized (this.f20264b) {
            this.f20263a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.f20263a.getLong("fetch_timeout_in_seconds", 60);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.f20264b) {
            long j = this.f20263a.getLong("last_fetch_time_in_millis", -1);
            int i = this.f20263a.getInt("last_fetch_status", 0);
            FirebaseRemoteConfigSettings build2 = new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(this.f20263a.getBoolean("is_developer_mode_enabled", false)).setFetchTimeoutInSeconds(this.f20263a.getLong("fetch_timeout_in_seconds", 60)).setMinimumFetchIntervalInSeconds(this.f20263a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build();
            FirebaseRemoteConfigInfoImpl.Builder a = FirebaseRemoteConfigInfoImpl.m12154a();
            a.mo22658b(i);
            FirebaseRemoteConfigInfoImpl.Builder withLastSuccessfulFetchTimeInMillis = a.withLastSuccessfulFetchTimeInMillis(j);
            withLastSuccessfulFetchTimeInMillis.mo22657a(build2);
            build = withLastSuccessfulFetchTimeInMillis.build();
        }
        return build;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.f20263a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo22650h(Date date) {
        synchronized (this.f20264b) {
            this.f20263a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo22651i() {
        synchronized (this.f20264b) {
            this.f20263a.edit().putInt("last_fetch_status", 2).apply();
        }
    }

    public boolean isDeveloperModeEnabled() {
        return this.f20263a.getBoolean("is_developer_mode_enabled", false);
    }

    @WorkerThread
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f20264b) {
            this.f20263a.edit().putBoolean("is_developer_mode_enabled", firebaseRemoteConfigSettings.isDeveloperModeEnabled()).putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f20264b) {
            this.f20263a.edit().putBoolean("is_developer_mode_enabled", firebaseRemoteConfigSettings.isDeveloperModeEnabled()).putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }
}
