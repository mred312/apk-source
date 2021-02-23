package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.in */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2033in implements zzame<zzcpi> {
    C2033in() {
    }

    public final /* synthetic */ JSONObject zzj(Object obj) {
        zzcpi zzcpi = (zzcpi) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcpi.zzgoh.zzvu());
        jSONObject2.put("signals", zzcpi.zzgoi);
        jSONObject3.put("body", zzcpi.zzgok.f14675c);
        jSONObject3.put("headers", zzp.zzkq().zzj((Map<String, ?>) zzcpi.zzgok.f14674b));
        jSONObject3.put("response_code", zzcpi.zzgok.f14673a);
        jSONObject3.put("latency", zzcpi.zzgok.f14676d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcpi.zzgoh.zzvx());
        return jSONObject;
    }
}
