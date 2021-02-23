package com.google.android.gms.ads.formats;

import android.widget.ImageView;
import com.google.android.gms.internal.ads.zzadw;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class zze implements zzadw {
    private final UnifiedNativeAdView zzboc;

    zze(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzboc = unifiedNativeAdView;
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzboc.zza(scaleType);
    }
}
