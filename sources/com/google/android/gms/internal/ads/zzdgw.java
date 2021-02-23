package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgw implements zzdfj<JSONObject> {

    /* renamed from: a */
    private String f15607a;

    /* renamed from: b */
    private String f15608b;

    public zzdgw(String str, String str2) {
        this.f15607a = str;
        this.f15608b = str2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            zzb.put("doritos", this.f15607a);
            zzb.put("doritos_v2", this.f15608b);
        } catch (JSONException unused) {
            zzd.zzee("Failed putting doritos string.");
        }
    }
}
