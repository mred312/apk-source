package com.google.firebase.crashlytics.internal.settings;

import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.google.firebase.crashlytics.internal.settings.c */
/* compiled from: SettingsV3JsonTransform */
class C3456c implements C3455b {
    C3456c() {
    }

    /* renamed from: b */
    private static AppSettingsData m11717b(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String string = jSONObject2.getString(NotificationCompat.CATEGORY_STATUS);
        boolean equals = AppSettingsData.STATUS_NEW.equals(string);
        String string2 = jSONObject.getString("bundle_id");
        String string3 = jSONObject.getString(C3457a.ORGANIZATION_ID_PARAM);
        if (equals) {
            str = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
        } else {
            str = String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", new Object[]{string2});
        }
        String str2 = str;
        Locale locale = Locale.US;
        return new AppSettingsData(string, str2, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", new Object[]{string2}), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", new Object[]{string2}), string2, string3, jSONObject2.optBoolean("update_required", false), jSONObject2.optInt("report_upload_variant", 0), jSONObject2.optInt("native_report_upload_variant", 0));
    }

    /* renamed from: c */
    private static FeaturesSettingsData m11718c(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true));
    }

    /* renamed from: d */
    private static SessionSettingsData m11719d() {
        return new SessionSettingsData(8, 4);
    }

    /* renamed from: e */
    private static long m11720e(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    /* renamed from: a */
    public SettingsData mo21505a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(m11720e(currentTimeProvider, (long) optInt2, jSONObject), m11717b(jSONObject.getJSONObject("fabric"), jSONObject.getJSONObject("app")), m11719d(), m11718c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
