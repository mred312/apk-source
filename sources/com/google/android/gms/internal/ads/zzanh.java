package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzanh {

    /* renamed from: a */
    private final List<String> f12550a;

    /* renamed from: b */
    private final List<String> f12551b;

    /* renamed from: c */
    private final List<String> f12552c;

    /* renamed from: d */
    private final List<String> f12553d;

    /* renamed from: e */
    private final List<String> f12554e;
    public final List<zzane> zzdlr;

    public zzanh(JSONObject jSONObject) {
        boolean z;
        if (zzaza.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzd.zzee(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzane zzane = new zzane(jSONArray.getJSONObject(i2));
                boolean equalsIgnoreCase = "banner".equalsIgnoreCase(zzane.zzdlp);
                arrayList.add(zzane);
                if (i < 0) {
                    Iterator<String> it = zzane.zzdkw.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zzdlr = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzp.zzli();
            this.f12550a = zzang.zza(optJSONObject, "click_urls");
            zzp.zzli();
            this.f12551b = zzang.zza(optJSONObject, "imp_urls");
            zzp.zzli();
            this.f12552c = zzang.zza(optJSONObject, "downloaded_imp_urls");
            zzp.zzli();
            this.f12553d = zzang.zza(optJSONObject, "nofill_urls");
            zzp.zzli();
            this.f12554e = zzang.zza(optJSONObject, "remote_ping_urls");
            optJSONObject.optBoolean("render_in_browser", false);
            int i3 = (optJSONObject.optLong("refresh", -1) > 0 ? 1 : (optJSONObject.optLong("refresh", -1) == 0 ? 0 : -1));
            zzava zza = zzava.zza(optJSONObject.optJSONArray("rewards"));
            if (zza != null) {
                String str = zza.type;
                int i4 = zza.zzdxu;
            }
            optJSONObject.optBoolean("use_displayed_impression", false);
            optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            optJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
