package com.google.firebase.crashlytics.internal.settings;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

/* renamed from: com.google.firebase.crashlytics.internal.settings.a */
/* compiled from: DefaultSettingsJsonTransform */
class C3454a implements C3455b {
    C3454a() {
    }

    /* renamed from: b */
    private static AppSettingsData m11710b(JSONObject jSONObject) {
        return new AppSettingsData(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), jSONObject.getString(ImagesContract.URL), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
    }

    /* renamed from: c */
    private static FeaturesSettingsData m11711c(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true));
    }

    /* renamed from: d */
    private static SessionSettingsData m11712d(JSONObject jSONObject) {
        return new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    /* renamed from: e */
    static Settings m11713e(CurrentTimeProvider currentTimeProvider) {
        JSONObject jSONObject = new JSONObject();
        return new SettingsData(m11714f(currentTimeProvider, 3600, jSONObject), (AppSettingsData) null, m11712d(jSONObject), m11711c(jSONObject), 0, 3600);
    }

    /* renamed from: f */
    private static long m11714f(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    /* renamed from: a */
    public SettingsData mo21505a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(m11714f(currentTimeProvider, (long) optInt2, jSONObject), m11710b(jSONObject.getJSONObject("app")), m11712d(jSONObject.getJSONObject("session")), m11711c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
