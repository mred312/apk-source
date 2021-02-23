package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgl implements zzdfj<JSONObject> {

    /* renamed from: a */
    private String f15593a;

    public zzdgl(String str) {
        this.f15593a = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.f15593a)) {
                zzb.put("attok", this.f15593a);
            }
        } catch (JSONException e) {
            zzd.zza("Failed putting attestation token.", e);
        }
    }
}
