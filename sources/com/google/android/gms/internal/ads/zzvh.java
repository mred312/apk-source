package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvh extends zzxm {

    /* renamed from: a */
    private final AdMetadataListener f17066a;

    public zzvh(AdMetadataListener adMetadataListener) {
        this.f17066a = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.f17066a;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
