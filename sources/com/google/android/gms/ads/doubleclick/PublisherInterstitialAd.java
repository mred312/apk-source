package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class PublisherInterstitialAd {
    private final zzze zzadh;

    public PublisherInterstitialAd(Context context) {
        this.zzadh = new zzze(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadh.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadh.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadh.getAppEventListener();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadh.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadh.getOnCustomRenderedAdLoadedListener();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.zzadh.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.zzadh.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadh.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadh.zza(publisherAdRequest.zzds());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadh.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadh.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadh.setAppEventListener(appEventListener);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadh.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadh.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzadh.show();
    }
}
