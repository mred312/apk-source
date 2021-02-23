package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzble {

    /* renamed from: a */
    private final zzckq f13461a;

    /* renamed from: b */
    private final zzdnj f13462b;

    public zzble(zzckq zzckq, zzdnj zzdnj) {
        this.f13461a = zzckq;
        this.f13462b = zzdnj;
    }

    public final void zzb(long j, int i) {
        zzckp zzr = this.f13461a.zzaqg().zza(this.f13462b.zzhik.zzerj).zzr("action", "ad_closed").zzr("show_time", String.valueOf(j)).zzr(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        int i2 = C2657zb.f12275a[i - 1];
        String str = "u";
        switch (i2) {
            case 1:
                str = "bb";
                break;
            case 2:
                str = "h";
                break;
            case 3:
                str = "cc";
                break;
            case 4:
                str = "ac";
                break;
            case 5:
                str = "cb";
                break;
        }
        zzr.zzr("acr", str).zzaqd();
    }
}
