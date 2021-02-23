package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzadu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class zzd implements zzadu {
    private final UnifiedNativeAdView zzboc;

    zzd(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzboc = unifiedNativeAdView;
    }

    public final void setMediaContent(MediaContent mediaContent) {
        this.zzboc.zza(mediaContent);
    }
}
