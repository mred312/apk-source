package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzatr {

    /* renamed from: a */
    private final List<String> f12807a;

    /* renamed from: b */
    private final String f12808b;

    /* renamed from: c */
    private final String f12809c;

    /* renamed from: d */
    private final boolean f12810d;

    /* renamed from: e */
    private String f12811e;

    /* renamed from: f */
    private final int f12812f;

    /* renamed from: g */
    private final JSONObject f12813g;

    /* renamed from: h */
    private final String f12814h;

    public zzatr(JSONObject jSONObject) {
        List<String> list;
        this.f12811e = jSONObject.optString(ImagesContract.URL);
        this.f12808b = jSONObject.optString("base_uri");
        this.f12809c = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.f12810d = optString != null && (optString.equals("1") || optString.equals("true"));
        jSONObject.optString("request_id");
        jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        if (optString2 == null) {
            list = null;
        } else {
            list = Arrays.asList(optString2.split(","));
        }
        this.f12807a = list;
        this.f12812f = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.f12813g = optJSONObject == null ? new JSONObject() : optJSONObject;
        jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.f12814h = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.f12812f;
    }

    public final String getUrl() {
        return this.f12811e;
    }

    public final List<String> zzvt() {
        return this.f12807a;
    }

    public final String zzvu() {
        return this.f12808b;
    }

    public final String zzvv() {
        return this.f12809c;
    }

    public final boolean zzvw() {
        return this.f12810d;
    }

    public final JSONObject zzvx() {
        return this.f12813g;
    }

    public final String zzvy() {
        return this.f12814h;
    }
}
