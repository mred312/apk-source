package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.am */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1736am implements zzdyb {

    /* renamed from: a */
    private final zzvc f7835a;

    C1736am(zzcno zzcno, zzvc zzvc) {
        this.f7835a = zzvc;
    }

    public final zzdyz zzf(Object obj) {
        zzvc zzvc = this.f7835a;
        String str = (String) obj;
        String str2 = zzvc.zzcgq;
        String str3 = zzvc.zzcgr;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdyr.zzag(jSONObject);
    }
}
