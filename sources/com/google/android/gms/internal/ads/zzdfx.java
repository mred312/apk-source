package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfx implements zzdfj<JSONObject> {

    /* renamed from: a */
    private final AdvertisingIdClient.Info f15567a;

    /* renamed from: b */
    private final String f15568b;

    public zzdfx(AdvertisingIdClient.Info info, String str) {
        this.f15567a = info;
        this.f15568b = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.f15567a;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                zzb.put("pdid", this.f15568b);
                zzb.put("pdidtype", "ssaid");
                return;
            }
            zzb.put("rdid", this.f15567a.getId());
            zzb.put("is_lat", this.f15567a.isLimitAdTrackingEnabled());
            zzb.put("idtype", "adid");
        } catch (JSONException e) {
            zzd.zza("Failed putting Ad ID.", e);
        }
    }
}
