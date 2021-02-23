package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgh implements zzdfj<JSONObject> {

    /* renamed from: a */
    private final JSONObject f15582a;

    public zzdgh(JSONObject jSONObject) {
        this.f15582a = jSONObject;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.f15582a;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zzd.zzee("Failed putting app indexing json.");
        }
    }
}
