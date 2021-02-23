package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzane {

    /* renamed from: a */
    private final List<String> f12541a;

    /* renamed from: b */
    private final List<String> f12542b;

    /* renamed from: c */
    private final List<String> f12543c;

    /* renamed from: d */
    private final List<String> f12544d;

    /* renamed from: e */
    private final List<String> f12545e;

    /* renamed from: f */
    private final List<String> f12546f;

    /* renamed from: g */
    private final List<String> f12547g;

    /* renamed from: h */
    private final List<String> f12548h;
    @Nullable

    /* renamed from: i */
    private final List<String> f12549i;
    public final List<String> zzdkw;
    public final String zzdle;
    @Nullable
    public final String zzdlp;

    public zzane(JSONObject jSONObject) {
        List<String> list;
        jSONObject.optString(FacebookAdapter.KEY_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdkw = Collections.unmodifiableList(arrayList);
        jSONObject.optString("allocation_id", (String) null);
        zzp.zzli();
        this.f12541a = zzang.zza(jSONObject, "clickurl");
        zzp.zzli();
        this.f12542b = zzang.zza(jSONObject, "imp_urls");
        zzp.zzli();
        this.f12543c = zzang.zza(jSONObject, "downloaded_imp_urls");
        zzp.zzli();
        this.f12545e = zzang.zza(jSONObject, "fill_urls");
        zzp.zzli();
        this.f12546f = zzang.zza(jSONObject, "video_start_urls");
        zzp.zzli();
        this.f12548h = zzang.zza(jSONObject, "video_complete_urls");
        zzp.zzli();
        this.f12547g = zzang.zza(jSONObject, "video_reward_urls");
        jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzp.zzli();
            list = zzang.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.f12544d = list;
        if (optJSONObject != null) {
            optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdle = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            optJSONObject2.optString("class_name");
        }
        jSONObject.optString("html_template", (String) null);
        jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        if (optJSONObject3 != null) {
            optJSONObject3.toString();
        }
        zzp.zzli();
        this.f12549i = zzang.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject4 != null) {
            optJSONObject4.toString();
        }
        this.zzdlp = jSONObject.optString("response_type", (String) null);
        jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
