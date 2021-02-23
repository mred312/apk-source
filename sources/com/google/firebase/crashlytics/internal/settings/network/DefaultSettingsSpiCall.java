package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {

    /* renamed from: f */
    private Logger f19530f;

    public DefaultSettingsSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(str, str2, httpRequestFactory, HttpMethod.GET, Logger.getLogger());
    }

    /* renamed from: b */
    private HttpRequest m11722b(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        m11723c(httpRequest, AbstractSpiCall.HEADER_GOOGLE_APP_ID, settingsRequest.googleAppId);
        m11723c(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        m11723c(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, CrashlyticsCore.getVersion());
        m11723c(httpRequest, AbstractSpiCall.HEADER_ACCEPT, AbstractSpiCall.ACCEPT_JSON_VALUE);
        m11723c(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
        m11723c(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
        m11723c(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
        m11723c(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.installIdProvider.getCrashlyticsInstallId());
        return httpRequest;
    }

    /* renamed from: c */
    private void m11723c(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.header(str, str2);
        }
    }

    /* renamed from: d */
    private JSONObject m11724d(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger logger = this.f19530f;
            logger.mo20860d("Failed to parse settings JSON from " + getUrl(), e);
            Logger logger2 = this.f19530f;
            logger2.mo20859d("Settings response " + str);
            return null;
        }
    }

    /* renamed from: e */
    private Map<String, String> m11725e(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put(FirebaseAnalytics.Param.SOURCE, Integer.toString(settingsRequest.source));
        String str = settingsRequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public JSONObject mo21514f(HttpResponse httpResponse) {
        int code = httpResponse.code();
        Logger logger = this.f19530f;
        logger.mo20859d("Settings result was: " + code);
        if (mo21515g(code)) {
            return m11724d(httpResponse.body());
        }
        Logger logger2 = this.f19530f;
        logger2.mo20861e("Failed to retrieve settings from " + getUrl());
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo21515g(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public JSONObject invoke(SettingsRequest settingsRequest, boolean z) {
        if (z) {
            try {
                Map<String, String> e = m11725e(settingsRequest);
                HttpRequest httpRequest = getHttpRequest(e);
                m11722b(httpRequest, settingsRequest);
                Logger logger = this.f19530f;
                logger.mo20859d("Requesting settings from " + getUrl());
                Logger logger2 = this.f19530f;
                logger2.mo20859d("Settings query params were: " + e);
                HttpResponse execute = httpRequest.execute();
                Logger logger3 = this.f19530f;
                logger3.mo20859d("Settings request ID: " + execute.header(AbstractSpiCall.HEADER_REQUEST_ID));
                return mo21514f(execute);
            } catch (IOException e2) {
                this.f19530f.mo20862e("Settings request failed.", e2);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    DefaultSettingsSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod, Logger logger) {
        super(str, str2, httpRequestFactory, httpMethod);
        this.f19530f = logger;
    }
}
