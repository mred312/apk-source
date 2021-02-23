package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvg extends zzww {

    /* renamed from: a */
    private final AdListener f17065a;

    public zzvg(AdListener adListener) {
        this.f17065a = adListener;
    }

    public final AdListener getAdListener() {
        return this.f17065a;
    }

    public final void onAdClicked() {
        this.f17065a.onAdClicked();
    }

    public final void onAdClosed() {
        this.f17065a.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.f17065a.onAdFailedToLoad(i);
    }

    public final void onAdImpression() {
        this.f17065a.onAdImpression();
    }

    public final void onAdLeftApplication() {
        this.f17065a.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.f17065a.onAdLoaded();
    }

    public final void onAdOpened() {
        this.f17065a.onAdOpened();
    }

    public final void zzc(zzve zzve) {
        this.f17065a.onAdFailedToLoad(zzve.zzpm());
    }
}
