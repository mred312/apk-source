package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class SettingsController implements SettingsDataProvider {

    /* renamed from: a */
    private final Context f19519a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final SettingsRequest f19520b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final SettingsJsonParser f19521c;

    /* renamed from: d */
    private final CurrentTimeProvider f19522d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final CachedSettingsIo f19523e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final SettingsSpiCall f19524f;

    /* renamed from: g */
    private final DataCollectionArbiter f19525g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final AtomicReference<Settings> f19526h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicReference<TaskCompletionSource<AppSettingsData>> f19527i = new AtomicReference<>(new TaskCompletionSource());

    /* renamed from: com.google.firebase.crashlytics.internal.settings.SettingsController$a */
    class C3453a implements SuccessContinuation<Void, Void> {
        C3453a() {
        }

        @NonNull
        /* renamed from: a */
        public Task<Void> then(@Nullable Void voidR) {
            JSONObject invoke = SettingsController.this.f19524f.invoke(SettingsController.this.f19520b, true);
            if (invoke != null) {
                SettingsData parseSettingsJson = SettingsController.this.f19521c.parseSettingsJson(invoke);
                SettingsController.this.f19523e.writeCachedSettings(parseSettingsJson.getExpiresAtMillis(), invoke);
                SettingsController.this.m11705l(invoke, "Loaded settings: ");
                SettingsController settingsController = SettingsController.this;
                boolean unused = settingsController.m11706m(settingsController.f19520b.instanceId);
                SettingsController.this.f19526h.set(parseSettingsJson);
                ((TaskCompletionSource) SettingsController.this.f19527i.get()).trySetResult(parseSettingsJson.getAppSettingsData());
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.trySetResult(parseSettingsJson.getAppSettingsData());
                SettingsController.this.f19527i.set(taskCompletionSource);
            }
            return Tasks.forResult(null);
        }
    }

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.f19526h = atomicReference;
        this.f19519a = context;
        this.f19520b = settingsRequest;
        this.f19522d = currentTimeProvider;
        this.f19521c = settingsJsonParser;
        this.f19523e = cachedSettingsIo;
        this.f19524f = settingsSpiCall;
        this.f19525g = dataCollectionArbiter;
        atomicReference.set(C3454a.m11713e(currentTimeProvider));
    }

    public static SettingsController create(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, String str4, DataCollectionArbiter dataCollectionArbiter) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
        String str5 = str4;
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(str5, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", new Object[]{str}), httpRequestFactory);
        String modelName = idManager.getModelName();
        String osBuildVersionString = idManager.getOsBuildVersionString();
        String osDisplayVersionString = idManager.getOsDisplayVersionString();
        String createInstanceIdFrom = CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2);
        return new SettingsController(context, new SettingsRequest(str, modelName, osBuildVersionString, osDisplayVersionString, idManager, createInstanceIdFrom, str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter);
    }

    /* renamed from: j */
    private SettingsData m11703j(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.f19523e.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData parseSettingsJson = this.f19521c.parseSettingsJson(readCachedSettings);
                if (parseSettingsJson != null) {
                    m11705l(readCachedSettings, "Loaded cached settings: ");
                    long currentTimeMillis = this.f19522d.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().mo20859d("Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Logger.getLogger().mo20859d("Returning cached settings.");
                        return parseSettingsJson;
                    } catch (Exception e) {
                        e = e;
                        settingsData = parseSettingsJson;
                        Logger.getLogger().mo20862e("Failed to get cached settings", e);
                        return settingsData;
                    }
                } else {
                    Logger.getLogger().mo20862e("Failed to parse cached settings data.", (Throwable) null);
                    return null;
                }
            } else {
                Logger.getLogger().mo20859d("No cached settings data found.");
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            Logger.getLogger().mo20862e("Failed to get cached settings", e);
            return settingsData;
        }
    }

    /* renamed from: k */
    private String m11704k() {
        return CommonUtils.getSharedPrefs(this.f19519a).getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m11705l(JSONObject jSONObject, String str) {
        Logger logger = Logger.getLogger();
        logger.mo20859d(str + jSONObject.toString());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: m */
    public boolean m11706m(String str) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.f19519a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    public Task<AppSettingsData> getAppSettings() {
        return this.f19527i.get().getTask();
    }

    public Settings getSettings() {
        return this.f19526h.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo21500i() {
        return !m11704k().equals(this.f19520b.instanceId);
    }

    public Task<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        SettingsData j;
        if (mo21500i() || (j = m11703j(settingsCacheBehavior)) == null) {
            SettingsData j2 = m11703j(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            if (j2 != null) {
                this.f19526h.set(j2);
                this.f19527i.get().trySetResult(j2.getAppSettingsData());
            }
            return this.f19525g.waitForDataCollectionPermission().onSuccessTask(executor, new C3453a());
        }
        this.f19526h.set(j);
        this.f19527i.get().trySetResult(j.getAppSettingsData());
        return Tasks.forResult(null);
    }
}
