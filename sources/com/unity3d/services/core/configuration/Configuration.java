package com.unity3d.services.core.configuration;

import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class Configuration {
    private String[] _moduleConfigurationList = {"com.unity3d.services.core.configuration.CoreModuleConfiguration", "com.unity3d.services.ads.configuration.AdsModuleConfiguration", "com.unity3d.services.monetization.core.configuration.MonetizationModuleConfiguration", "com.unity3d.services.purchasing.core.configuration.PurchasingModuleConfiguration", "com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration", "com.unity3d.services.ar.configuration.ARModuleConfiguration", "com.unity3d.services.banners.configuration.BannersModuleConfiguration", "com.unity3d.services.store.core.configuration.StoreModuleConfiguration"};
    private Map<String, IModuleConfiguration> _moduleConfigurations;
    private String _url;
    private Class[] _webAppApiClassList;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
    }

    private void createWebAppApiClassList() {
        ArrayList arrayList = new ArrayList();
        for (String moduleConfiguration : getModuleConfigurationList()) {
            IModuleConfiguration moduleConfiguration2 = getModuleConfiguration(moduleConfiguration);
            if (!(moduleConfiguration2 == null || moduleConfiguration2.getWebAppApiClassList() == null)) {
                arrayList.addAll(Arrays.asList(moduleConfiguration2.getWebAppApiClassList()));
            }
        }
        this._webAppApiClassList = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public String buildQueryString() {
        return "?ts=" + System.currentTimeMillis() + "&sdkVersion=" + SdkProperties.getVersionCode() + "&sdkVersionName=" + SdkProperties.getVersionName();
    }

    public String getConfigUrl() {
        return this._url;
    }

    public IModuleConfiguration getModuleConfiguration(String str) {
        Map<String, IModuleConfiguration> map = this._moduleConfigurations;
        if (map != null && map.containsKey(str)) {
            return this._moduleConfigurations.get(str);
        }
        try {
            IModuleConfiguration iModuleConfiguration = (IModuleConfiguration) Class.forName(str).newInstance();
            if (iModuleConfiguration != null) {
                if (this._moduleConfigurations == null) {
                    HashMap hashMap = new HashMap();
                    this._moduleConfigurations = hashMap;
                    hashMap.put(str, iModuleConfiguration);
                }
                return iModuleConfiguration;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String[] getModuleConfigurationList() {
        return this._moduleConfigurationList;
    }

    public Class[] getWebAppApiClassList() {
        if (this._webAppApiClassList == null) {
            createWebAppApiClassList();
        }
        return this._webAppApiClassList;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    /* access modifiers changed from: protected */
    public void makeRequest() {
        if (this._url != null) {
            String str = this._url + buildQueryString();
            DeviceLog.debug("Requesting configuration with: " + str);
            JSONObject jSONObject = new JSONObject(new WebRequest(str, "GET", (Map<String, List<String>>) null).makeRequest());
            this._webViewUrl = jSONObject.getString(ImagesContract.URL);
            if (!jSONObject.isNull("hash")) {
                this._webViewHash = jSONObject.getString("hash");
            } else {
                this._webViewHash = null;
            }
            if (jSONObject.has(MediationMetaData.KEY_VERSION)) {
                this._webViewVersion = jSONObject.getString(MediationMetaData.KEY_VERSION);
            } else {
                this._webViewVersion = null;
            }
            String str2 = this._webViewUrl;
            if (str2 == null || str2.isEmpty()) {
                throw new MalformedURLException("Invalid data. Web view URL is null or empty");
            }
            return;
        }
        throw new MalformedURLException("Base URL is null");
    }

    public void setConfigUrl(String str) {
        this._url = str;
    }

    public void setWebViewData(String str) {
        this._webViewData = str;
    }

    public void setWebViewHash(String str) {
        this._webViewHash = str;
    }

    public void setWebViewUrl(String str) {
        this._webViewUrl = str;
    }

    public Configuration(String str) {
        this._url = str;
    }
}
