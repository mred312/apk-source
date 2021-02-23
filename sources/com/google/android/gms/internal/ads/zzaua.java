package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaua implements zzatp {

    /* renamed from: a */
    private zzamd<JSONObject, JSONObject> f12849a;

    /* renamed from: b */
    private zzamd<JSONObject, JSONObject> f12850b;

    public zzaua(Context context) {
        zzaml zza = zzp.zzld().zza(context, zzazh.zzzi());
        zzamh<JSONObject> zzamh = zzamg.zzdjy;
        this.f12849a = zza.zza("google.afma.request.getAdDictionary", zzamh, zzamh);
        this.f12850b = zzp.zzld().zza(context, zzazh.zzzi()).zza("google.afma.sdkConstants.getSdkConstants", zzamh, zzamh);
    }

    public final zzamd<JSONObject, JSONObject> zzvs() {
        return this.f12850b;
    }
}
