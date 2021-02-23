package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagx extends zzagb {

    /* renamed from: a */
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener f12460a;

    public zzagx(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.f12460a = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzagj zzagj) {
        this.f12460a.onUnifiedNativeAdLoaded(new zzagk(zzagj));
    }
}
