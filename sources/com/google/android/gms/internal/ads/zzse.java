package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzse extends zzsp {

    /* renamed from: a */
    private final AppOpenAdPresentationCallback f16975a;

    public zzse(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.f16975a = appOpenAdPresentationCallback;
    }

    public final void onAppOpenAdClosed() {
        this.f16975a.onAppOpenAdClosed();
    }
}
