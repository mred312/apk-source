package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.ExtraHints;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

public class FacebookRtbBannerAd implements MediationBannerAd, AdListener {

    /* renamed from: a */
    private MediationBannerAdConfiguration f7035a;

    /* renamed from: b */
    private MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> f7036b;

    /* renamed from: c */
    private AdView f7037c;

    /* renamed from: d */
    private FrameLayout f7038d;

    /* renamed from: e */
    private MediationBannerAdCallback f7039e;

    public FacebookRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.f7035a = mediationBannerAdConfiguration;
        this.f7036b = mediationAdLoadCallback;
    }

    @NonNull
    public View getView() {
        return this.f7038d;
    }

    public void onAdClicked(C1484Ad ad) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f7039e;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
            this.f7039e.onAdLeftApplication();
        }
    }

    public void onAdLoaded(C1484Ad ad) {
        this.f7039e = this.f7036b.onSuccess(this);
    }

    public void onError(C1484Ad ad, AdError adError) {
        String createSdkError = FacebookMediationAdapter.createSdkError(adError);
        Log.w(FacebookMediationAdapter.TAG, createSdkError);
        this.f7036b.onFailure(createSdkError);
    }

    public void onLoggingImpression(C1484Ad ad) {
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.f7035a.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty.");
            Log.e(FacebookMediationAdapter.TAG, createAdapterError);
            this.f7036b.onFailure(createAdapterError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.f7035a);
        try {
            this.f7037c = new AdView(this.f7035a.getContext(), placementID, this.f7035a.getBidResponse());
            if (!TextUtils.isEmpty(this.f7035a.getWatermark())) {
                this.f7037c.setExtraHints(new ExtraHints.Builder().mediationData(this.f7035a.getWatermark()).build());
            }
            Context context = this.f7035a.getContext();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f7035a.getAdSize().getWidthInPixels(context), -2);
            this.f7038d = new FrameLayout(context);
            this.f7037c.setLayoutParams(layoutParams);
            this.f7038d.addView(this.f7037c);
            AdView adView = this.f7037c;
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(this).withBid(this.f7035a.getBidResponse()).build());
        } catch (Exception e) {
            String createAdapterError2 = FacebookMediationAdapter.createAdapterError(111, "Failed to create banner ad: " + e.getMessage());
            Log.e(FacebookMediationAdapter.TAG, createAdapterError2);
            this.f7036b.onFailure(createAdapterError2);
        }
    }
}
