package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

public class SettingsJsonParser {

    /* renamed from: a */
    private final CurrentTimeProvider f19529a;

    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.f19529a = currentTimeProvider;
    }

    /* renamed from: a */
    private static C3455b m11709a(int i) {
        if (i != 3) {
            return new C3454a();
        }
        return new C3456c();
    }

    public SettingsData parseSettingsJson(JSONObject jSONObject) {
        return m11709a(jSONObject.getInt("settings_version")).mo21505a(this.f19529a, jSONObject);
    }
}
