package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.dv */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1856dv implements zzdfi<zzdfj<JSONObject>> {

    /* renamed from: a */
    private final JSONObject f8291a;

    C1856dv(Context context) {
        this.f8291a = zzatx.zzw(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo13844a(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.f8291a);
        } catch (JSONException unused) {
            zzd.zzee("Failed putting version constants.");
        }
    }

    public final zzdyz<zzdfj<JSONObject>> zzasm() {
        return zzdyr.zzag(new C1819cv(this));
    }
}
