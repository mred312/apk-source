package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener {

    /* renamed from: a */
    private MediationInterstitialAdConfiguration f7040a;

    /* renamed from: b */
    private MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> f7041b;

    /* renamed from: c */
    private InterstitialAd f7042c;

    /* renamed from: d */
    private MediationInterstitialAdCallback f7043d;

    /* renamed from: e */
    private AtomicBoolean f7044e = new AtomicBoolean();

    /* renamed from: f */
    private AtomicBoolean f7045f = new AtomicBoolean();

    public FacebookRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.f7040a = mediationInterstitialAdConfiguration;
        this.f7041b = mediationAdLoadCallback;
    }

    public void onAdClicked(C1484Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f7043d;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdLeftApplication();
        }
    }

    public void onAdLoaded(C1484Ad ad) {
        this.f7043d = this.f7041b.onSuccess(this);
    }

    public void onError(C1484Ad ad, AdError adError) {
        String createSdkError = FacebookMediationAdapter.createSdkError(adError);
        Log.w(FacebookMediationAdapter.TAG, createSdkError);
        if (this.f7044e.get()) {
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f7043d;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdOpened();
                this.f7043d.onAdClosed();
                return;
            }
            return;
        }
        this.f7041b.onFailure(createSdkError);
    }

    public void onInterstitialActivityDestroyed() {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (!this.f7045f.getAndSet(true) && (mediationInterstitialAdCallback = this.f7043d) != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    public void onInterstitialDismissed(C1484Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (!this.f7045f.getAndSet(true) && (mediationInterstitialAdCallback = this.f7043d) != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    public void onInterstitialDisplayed(C1484Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f7043d;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    public void onLoggingImpression(C1484Ad ad) {
    }

    public void onRewardedAdCompleted() {
    }

    public void onRewardedAdServerFailed() {
    }

    public void onRewardedAdServerSucceeded() {
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.f7040a.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty.");
            Log.e(FacebookMediationAdapter.TAG, createAdapterError);
            this.f7041b.onFailure(createAdapterError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.f7040a);
        this.f7042c = new InterstitialAd(this.f7040a.getContext(), placementID);
        if (!TextUtils.isEmpty(this.f7040a.getWatermark())) {
            this.f7042c.setExtraHints(new ExtraHints.Builder().mediationData(this.f7040a.getWatermark()).build());
        }
        InterstitialAd interstitialAd = this.f7042c;
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withBid(this.f7040a.getBidResponse()).withAdListener(this).build());
    }

    public void showAd(Context context) {
        this.f7044e.set(true);
        if (!this.f7042c.show()) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(110, "Failed to present interstitial ad."));
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f7043d;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdOpened();
                this.f7043d.onAdClosed();
            }
        }
    }
}
