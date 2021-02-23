package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.fp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1924fp implements zzcaf {

    /* renamed from: a */
    private final zzcrb f8484a;

    C1924fp(zzcrb zzcrb) {
        this.f8484a = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.f8484a;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).showInterstitial();
        } catch (zzdnr e) {
            zzaza.zzez("Cannot show interstitial.");
            throw new zzcai(e.getCause());
        }
    }
}
