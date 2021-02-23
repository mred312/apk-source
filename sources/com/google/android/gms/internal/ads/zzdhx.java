package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhx implements zzdfj<JSONObject> {

    /* renamed from: a */
    private final Map<String, Object> f15644a;

    public zzdhx(Map<String, Object> map) {
        this.f15644a = map;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzp.zzkq().zzj((Map<String, ?>) this.f15644a));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzee(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
