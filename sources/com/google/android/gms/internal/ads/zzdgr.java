package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgr implements zzdfj<JSONObject> {

    /* renamed from: a */
    private JSONObject f15603a;

    public zzdgr(JSONObject jSONObject) {
        this.f15603a = jSONObject;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.f15603a);
        } catch (JSONException unused) {
            zzd.zzee("Unable to get cache_state");
        }
    }
}
