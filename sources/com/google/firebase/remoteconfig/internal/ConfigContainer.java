package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigContainer {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Date f20228e = new Date(0);

    /* renamed from: a */
    private JSONObject f20229a;

    /* renamed from: b */
    private JSONObject f20230b;

    /* renamed from: c */
    private Date f20231c;

    /* renamed from: d */
    private JSONArray f20232d;

    public static class Builder {

        /* renamed from: a */
        private JSONObject f20233a;

        /* renamed from: b */
        private Date f20234b;

        /* renamed from: c */
        private JSONArray f20235c;

        public ConfigContainer build() {
            return new ConfigContainer(this.f20233a, this.f20234b, this.f20235c);
        }

        public Builder replaceConfigsWith(Map<String, String> map) {
            this.f20233a = new JSONObject(map);
            return this;
        }

        public Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                this.f20235c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.f20234b = date;
            return this;
        }

        private Builder() {
            this.f20233a = new JSONObject();
            this.f20234b = ConfigContainer.f20228e;
            this.f20235c = new JSONArray();
        }

        public Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                this.f20233a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder(ConfigContainer configContainer) {
            this.f20233a = configContainer.getConfigs();
            this.f20234b = configContainer.getFetchTime();
            this.f20235c = configContainer.getAbtExperiments();
        }
    }

    /* renamed from: b */
    static ConfigContainer m12103b(JSONObject jSONObject) {
        return new ConfigContainer(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigContainer)) {
            return false;
        }
        return this.f20229a.toString().equals(((ConfigContainer) obj).toString());
    }

    public JSONArray getAbtExperiments() {
        return this.f20232d;
    }

    public JSONObject getConfigs() {
        return this.f20230b;
    }

    public Date getFetchTime() {
        return this.f20231c;
    }

    public int hashCode() {
        return this.f20229a.hashCode();
    }

    public String toString() {
        return this.f20229a.toString();
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.f20230b = jSONObject;
        this.f20231c = date;
        this.f20232d = jSONArray;
        this.f20229a = jSONObject2;
    }

    public static Builder newBuilder(ConfigContainer configContainer) {
        return new Builder(configContainer);
    }
}
