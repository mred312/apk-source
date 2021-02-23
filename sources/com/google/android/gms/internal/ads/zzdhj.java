package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhj implements zzdfj<JSONObject> {

    /* renamed from: a */
    private Bundle f15632a;

    public zzdhj(Bundle bundle) {
        this.f15632a = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.f15632a != null) {
            try {
                zzbk.zzb(zzbk.zzb(jSONObject, "device"), "play_store").put("parental_controls", zzp.zzkq().zzc(this.f15632a));
            } catch (JSONException unused) {
                zzd.zzee("Failed putting parental controls bundle.");
            }
        }
    }
}
