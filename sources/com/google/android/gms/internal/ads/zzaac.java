package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaac extends zzyk {

    /* renamed from: a */
    private final OnAdMetadataChangedListener f12328a;

    public zzaac(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f12328a = onAdMetadataChangedListener;
    }

    public final void onAdMetadataChanged() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f12328a;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
