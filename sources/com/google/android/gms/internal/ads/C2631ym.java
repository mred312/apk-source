package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.ym */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2631ym implements zzdqv {

    /* renamed from: a */
    static final zzdqv f12220a = new C2631ym();

    private C2631ym() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzd.zzee("Ad request signals:");
        zzd.zzee(jSONObject.toString(2));
        return jSONObject;
    }
}
