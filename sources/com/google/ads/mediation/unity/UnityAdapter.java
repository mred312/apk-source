package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.ref.WeakReference;

@Keep
public class UnityAdapter extends UnityMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter, BannerView.IListener {
    private MediationBannerListener bannerListener;
    private String bannerPlacementId;
    private WeakReference<Activity> mActivityWeakReference;
    private BannerView mBannerView;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mMediationInterstitialListener;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private final UnityAdapterDelegate mUnityAdapterDelegate = new C1542a();

    /* renamed from: com.google.ads.mediation.unity.UnityAdapter$a */
    class C1542a implements UnityAdapterDelegate {
        C1542a() {
        }

        public String getPlacementId() {
            return UnityAdapter.this.mPlacementId;
        }

        public void onUnityAdsClick(String str) {
            if (UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdClicked(UnityAdapter.this);
                UnityAdapter.this.mMediationInterstitialListener.onAdLeftApplication(UnityAdapter.this);
            }
        }

        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
            if (str.equals(getPlacementId()) && UnityAdapter.this.mMediationInterstitialListener != null) {
                String str2 = UnityMediationAdapter.TAG;
                Log.e(str2, "Failed to load Interstitial ad from Unity Ads: " + unityAdsError.toString());
                UnityAdapter.this.mMediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) UnityAdapter.this, 3);
            }
        }

        public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
            if (UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdClosed(UnityAdapter.this);
            }
        }

        public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
        }

        public void onUnityAdsReady(String str) {
            if (str.equals(getPlacementId()) && UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdLoaded(UnityAdapter.this);
            }
        }

        public void onUnityAdsStart(String str) {
        }
    }

    private static boolean isValidIds(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        String str3 = TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? "Game ID and Placement ID" : "Game ID" : "Placement ID";
        String str4 = UnityMediationAdapter.TAG;
        Log.w(str4, str3 + " cannot be empty.");
        return false;
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public void onBannerClick(BannerView bannerView) {
        this.bannerListener.onAdClicked(this);
    }

    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        String str = UnityMediationAdapter.TAG;
        Log.w(str, "Unity Ads Banner encountered an error: " + bannerErrorInfo.errorMessage);
        if (bannerErrorInfo.errorCode == BannerErrorCode.NO_FILL) {
            this.bannerListener.onAdFailedToLoad((MediationBannerAdapter) this, 3);
        } else {
            this.bannerListener.onAdFailedToLoad((MediationBannerAdapter) this, 0);
        }
    }

    public void onBannerLeftApplication(BannerView bannerView) {
        this.bannerListener.onAdLeftApplication(this);
    }

    public void onBannerLoaded(BannerView bannerView) {
        String str = UnityMediationAdapter.TAG;
        Log.v(str, "Unity Ads Banner finished loading banner for placement: " + this.mBannerView.getPlacementId());
        this.bannerListener.onAdLoaded(this);
    }

    public void onDestroy() {
        BannerView bannerView = this.mBannerView;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.mBannerView = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        String str = UnityMediationAdapter.TAG;
        Log.v(str, "Requesting Unity Ads Banner");
        this.bannerListener = mediationBannerListener;
        String string = bundle.getString("gameId");
        String string2 = bundle.getString("zoneId");
        this.bannerPlacementId = string2;
        if (!isValidIds(string, string2)) {
            MediationBannerListener mediationBannerListener2 = this.bannerListener;
            if (mediationBannerListener2 != null) {
                mediationBannerListener2.onAdFailedToLoad((MediationBannerAdapter) this, 1);
            }
        } else if (context == null || !(context instanceof Activity)) {
            Log.e(str, "Context is not an Activity. Unity Ads requires an Activity context to load ads.");
            MediationBannerListener mediationBannerListener3 = this.bannerListener;
            if (mediationBannerListener3 != null) {
                mediationBannerListener3.onAdFailedToLoad((MediationBannerAdapter) this, 1);
            }
        } else {
            Activity activity = (Activity) context;
            UnitySingleton.getInstance().initializeUnityAds(activity, string);
            float f = context.getResources().getDisplayMetrics().density;
            UnityBannerSize unityBannerSize = new UnityBannerSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            if (this.mBannerView == null) {
                this.mBannerView = new BannerView(activity, this.bannerPlacementId, unityBannerSize);
            }
            this.mBannerView.setListener(this);
            this.mBannerView.load();
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mMediationInterstitialListener = mediationInterstitialListener;
        String string = bundle.getString("gameId");
        String string2 = bundle.getString("zoneId");
        this.mPlacementId = string2;
        if (!isValidIds(string, string2)) {
            MediationInterstitialListener mediationInterstitialListener2 = this.mMediationInterstitialListener;
            if (mediationInterstitialListener2 != null) {
                mediationInterstitialListener2.onAdFailedToLoad((MediationInterstitialAdapter) this, 1);
            }
        } else if (context == null || !(context instanceof Activity)) {
            Log.e(UnityMediationAdapter.TAG, "Context is not an Activity. Unity Ads requires an Activity context to load ads.");
            MediationInterstitialListener mediationInterstitialListener3 = this.mMediationInterstitialListener;
            if (mediationInterstitialListener3 != null) {
                mediationInterstitialListener3.onAdFailedToLoad((MediationInterstitialAdapter) this, 1);
            }
        } else {
            Activity activity = (Activity) context;
            this.mActivityWeakReference = new WeakReference<>(activity);
            UnitySingleton.getInstance().initializeUnityAds(activity, string);
            UnitySingleton.getInstance().loadAd(this.mUnityAdapterDelegate);
        }
    }

    public void showInterstitial() {
        this.mMediationInterstitialListener.onAdOpened(this);
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            Log.w(UnityMediationAdapter.TAG, "Failed to show Unity Ads Interstitial.");
            this.mMediationInterstitialListener.onAdClosed(this);
            return;
        }
        UnitySingleton.getInstance().showAd(this.mUnityAdapterDelegate, (Activity) this.mActivityWeakReference.get());
    }
}
