package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayh {

    /* renamed from: a */
    private final long f12938a;

    /* renamed from: b */
    private final List<String> f12939b = new ArrayList();

    /* renamed from: c */
    private final List<String> f12940c = new ArrayList();

    /* renamed from: d */
    private final Map<String, zzanh> f12941d = new HashMap();

    /* renamed from: e */
    private String f12942e;

    /* renamed from: f */
    private String f12943f;

    /* renamed from: g */
    private JSONObject f12944g;

    /* renamed from: h */
    private boolean f12945h;

    public zzayh(String str, long j) {
        JSONObject optJSONObject;
        this.f12945h = false;
        this.f12943f = str;
        this.f12938a = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f12944g = jSONObject;
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1) != 1) {
                    this.f12945h = false;
                    zzaza.zzfa("App settings could not be fetched successfully.");
                    return;
                }
                this.f12945h = true;
                this.f12942e = this.f12944g.optString("app_id");
                JSONArray optJSONArray = this.f12944g.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("format");
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.f12940c.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.f12941d.put(optString2, new zzanh(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.f12944g.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.f12939b.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzaza.zzd("Exception occurred while processing app setting json", e);
                zzp.zzku().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzxd() {
        return this.f12938a;
    }

    public final boolean zzxe() {
        return this.f12945h;
    }

    public final String zzxf() {
        return this.f12943f;
    }

    public final String zzxg() {
        return this.f12942e;
    }

    public final Map<String, zzanh> zzxh() {
        return this.f12941d;
    }

    public final JSONObject zzxi() {
        return this.f12944g;
    }
}
