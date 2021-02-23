package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcko {

    /* renamed from: a */
    private ConcurrentHashMap<String, String> f14505a;

    /* renamed from: b */
    private final zzayq f14506b;

    public zzcko(zzckv zzckv, zzayq zzayq) {
        this.f14505a = new ConcurrentHashMap<>(zzckv.zzgki);
        this.f14506b = zzayq;
    }

    public final void zzc(zzdnj zzdnj) {
        if (zzdnj.zzhik.zzhih.size() > 0) {
            switch (zzdnj.zzhik.zzhih.get(0).zzhgp) {
                case 1:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    this.f14505a.put("as", this.f14506b.zzxm() ? "1" : "0");
                    break;
                default:
                    this.f14505a.put(FirebaseAnalytics.Param.AD_FORMAT, EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
        }
        if (!TextUtils.isEmpty(zzdnj.zzhik.zzerj.zzbvf)) {
            this.f14505a.put("gqi", zzdnj.zzhik.zzerj.zzbvf);
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.f14505a.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.f14505a.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzrx() {
        return this.f14505a;
    }
}
