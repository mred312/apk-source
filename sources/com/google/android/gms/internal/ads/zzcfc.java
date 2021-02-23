package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfc {

    /* renamed from: a */
    private final Executor f14261a;

    /* renamed from: b */
    private final zzces f14262b;

    public zzcfc(Executor executor, zzces zzces) {
        this.f14261a = executor;
        this.f14262b = zzces;
    }

    public final zzdyz<List<zzcfd>> zzg(JSONObject jSONObject, String str) {
        zzdyz<O> zzdyz;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdyr.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : 0;
                }
                if (c == 1) {
                    zzdyz = zzdyr.zzag(new zzcfd(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzdyz = zzdyr.zzb(this.f14262b.zzc(optJSONObject, "image_value"), new C2325qi(optString), this.f14261a);
                }
                arrayList.add(zzdyz);
            }
            zzdyz = zzdyr.zzag(null);
            arrayList.add(zzdyz);
        }
        return zzdyr.zzb(zzdyr.zzi(arrayList), C2288pi.f10634a, this.f14261a);
    }
}
