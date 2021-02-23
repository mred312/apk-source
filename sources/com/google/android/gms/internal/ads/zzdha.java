package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdha implements zzdfj<JSONObject> {

    /* renamed from: a */
    private List<String> f15613a;

    public zzdha(List<String> list) {
        this.f15613a = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.f15613a));
        } catch (JSONException unused) {
            zzd.zzee("Failed putting experiment ids.");
        }
    }
}
