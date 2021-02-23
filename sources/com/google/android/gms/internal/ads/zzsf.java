package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzsf extends zzsk {

    /* renamed from: a */
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> f16976a;

    public zzsf(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.f16976a = new WeakReference<>(appOpenAdLoadCallback);
    }

    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = (AppOpenAd.AppOpenAdLoadCallback) this.f16976a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    public final void zza(zzsg zzsg) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = (AppOpenAd.AppOpenAdLoadCallback) this.f16976a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzsr(zzsg));
        }
    }

    public final void zza(zzve zzve) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = (AppOpenAd.AppOpenAdLoadCallback) this.f16976a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(zzve.zzpm());
        }
    }
}
