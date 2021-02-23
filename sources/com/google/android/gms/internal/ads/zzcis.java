package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcis {

    /* renamed from: a */
    private final Map<String, Map<String, JSONObject>> f14441a = new ConcurrentHashMap();

    /* renamed from: b */
    private final Executor f14442b;

    /* renamed from: c */
    private boolean f14443c;

    /* renamed from: d */
    private JSONObject f14444d;

    public zzcis(Executor executor) {
        this.f14442b = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized void mo16882d() {
        Map map;
        this.f14443c = true;
        zzayh zzxv = zzp.zzku().zzwz().zzxv();
        if (zzxv != null) {
            JSONObject zzxi = zzxv.zzxi();
            if (zzxi != null) {
                this.f14444d = zzxi.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzxi.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.f14441a.containsKey(optString2)) {
                                    map = this.f14441a.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.f14441a.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo16881c() {
        this.f14442b.execute(new C1993hk(this));
    }

    public final void zzapi() {
        zzp.zzku().zzwz().zzb(new C1956gk(this));
        this.f14442b.execute(new C2030ik(this));
    }

    @CheckForNull
    public final JSONObject zzq(String str, String str2) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcss)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.f14443c) {
            mo16882d();
        }
        Map map = this.f14441a.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza = zzciv.zza(this.f14444d, str, str2);
        if (zza == null) {
            return null;
        }
        return (JSONObject) map.get(zza);
    }
}
