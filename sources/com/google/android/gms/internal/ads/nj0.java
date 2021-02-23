package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class nj0 extends zzwp {

    /* renamed from: c */
    private final /* synthetic */ zzzc f10210c;

    nj0(zzzc zzzc) {
        this.f10210c = zzzc;
    }

    public final void onAdFailedToLoad(int i) {
        this.f10210c.f17153c.zza(this.f10210c.zzdw());
        super.onAdFailedToLoad(i);
    }

    public final void onAdLoaded() {
        this.f10210c.f17153c.zza(this.f10210c.zzdw());
        super.onAdLoaded();
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f10210c.f17153c.zza(this.f10210c.zzdw());
        super.onAdFailedToLoad(loadAdError);
    }
}
