package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagw extends zzagh {

    /* renamed from: a */
    private final UnifiedNativeAd.UnconfirmedClickListener f12459a;

    public zzagw(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.f12459a = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickCancelled() {
        this.f12459a.onUnconfirmedClickCancelled();
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.f12459a.onUnconfirmedClickReceived(str);
    }
}
