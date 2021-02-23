package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.LegacyConfigsHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@KeepForSdk
public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    @VisibleForTesting
    public static final String DEFAULT_NAMESPACE = "firebase";
    public static final String FETCH_FILE_NAME = "fetch";

    /* renamed from: j */
    private static final Clock f19688j = DefaultClock.getInstance();

    /* renamed from: k */
    private static final Random f19689k = new Random();
    @GuardedBy("this")

    /* renamed from: a */
    private final Map<String, FirebaseRemoteConfig> f19690a;

    /* renamed from: b */
    private final Context f19691b;

    /* renamed from: c */
    private final ExecutorService f19692c;

    /* renamed from: d */
    private final FirebaseApp f19693d;

    /* renamed from: e */
    private final FirebaseInstallationsApi f19694e;

    /* renamed from: f */
    private final FirebaseABTesting f19695f;
    @Nullable

    /* renamed from: g */
    private final AnalyticsConnector f19696g;

    /* renamed from: h */
    private final String f19697h;
    @GuardedBy("this")

    /* renamed from: i */
    private Map<String, String> f19698i;

    RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstallationsApi, firebaseABTesting, analyticsConnector, new LegacyConfigsHandler(context, firebaseApp.getOptions().getApplicationId()), true);
    }

    /* renamed from: b */
    private ConfigCacheClient m11867b(String str, String str2) {
        return getCacheClient(this.f19691b, this.f19697h, str, str2);
    }

    /* renamed from: f */
    private ConfigGetParameterHandler m11868f(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(configCacheClient, configCacheClient2);
    }

    @VisibleForTesting
    /* renamed from: g */
    static ConfigMetadataClient m11869g(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{FirebaseABTesting.OriginService.REMOTE_CONFIG, str, str2, "settings"}), 0));
    }

    public static ConfigCacheClient getCacheClient(Context context, String str, String str2, String str3) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(context, String.format("%s_%s_%s_%s.json", new Object[]{FirebaseABTesting.OriginService.REMOTE_CONFIG, str, str2, str3})));
    }

    /* renamed from: h */
    private static boolean m11870h(FirebaseApp firebaseApp, String str) {
        return str.equals(DEFAULT_NAMESPACE) && m11871i(firebaseApp);
    }

    /* renamed from: i */
    private static boolean m11871i(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public synchronized FirebaseRemoteConfig mo21730a(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2 = str;
        synchronized (this) {
            if (!this.f19690a.containsKey(str2)) {
                FirebaseRemoteConfig firebaseRemoteConfig2 = new FirebaseRemoteConfig(this.f19691b, firebaseApp, firebaseInstallationsApi, m11870h(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
                firebaseRemoteConfig2.mo21700o();
                this.f19690a.put(str2, firebaseRemoteConfig2);
            }
            firebaseRemoteConfig = this.f19690a.get(str2);
        }
        return firebaseRemoteConfig;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public FirebaseRemoteConfig mo21731c() {
        return get(DEFAULT_NAMESPACE);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: d */
    public synchronized ConfigFetchHandler mo21732d(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHandler(this.f19694e, m11871i(this.f19693d) ? this.f19696g : null, this.f19692c, f19688j, f19689k, configCacheClient, mo21733e(this.f19693d.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.f19698i);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: e */
    public ConfigFetchHttpClient mo21733e(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.f19691b, this.f19693d.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    @VisibleForTesting
    @KeepForSdk
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient b;
        ConfigCacheClient b2;
        ConfigCacheClient b3;
        ConfigMetadataClient g;
        b = m11867b(str, FETCH_FILE_NAME);
        b2 = m11867b(str, ACTIVATE_FILE_NAME);
        b3 = m11867b(str, DEFAULTS_FILE_NAME);
        g = m11869g(this.f19691b, this.f19697h, str);
        return mo21730a(this.f19693d, str, this.f19694e, this.f19695f, this.f19692c, b, b2, b3, mo21732d(str, b, g), m11868f(b2, b3), g);
    }

    @VisibleForTesting
    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.f19698i = map;
    }

    @VisibleForTesting
    protected RemoteConfigComponent(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector, LegacyConfigsHandler legacyConfigsHandler, boolean z) {
        this.f19690a = new HashMap();
        this.f19698i = new HashMap();
        this.f19691b = context;
        this.f19692c = executorService;
        this.f19693d = firebaseApp;
        this.f19694e = firebaseInstallationsApi;
        this.f19695f = firebaseABTesting;
        this.f19696g = analyticsConnector;
        this.f19697h = firebaseApp.getOptions().getApplicationId();
        if (z) {
            Tasks.call(executorService, C3520l.m11888a(this));
            legacyConfigsHandler.getClass();
            Tasks.call(executorService, C3521m.m11889a(legacyConfigsHandler));
        }
    }
}
