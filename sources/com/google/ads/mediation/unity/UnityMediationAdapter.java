package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.unity3d.ads.UnityAds;
import java.util.HashSet;
import java.util.List;

public class UnityMediationAdapter extends Adapter implements MediationRewardedAd {
    static final String KEY_GAME_ID = "gameId";
    static final String KEY_PLACEMENT_ID = "zoneId";
    static final String TAG = "UnityMediationAdapter";
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mMediationRewardedAdCallback;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private UnityAdapterDelegate mUnityAdapterRewardedAdDelegate = new C1543a();

    /* renamed from: com.google.ads.mediation.unity.UnityMediationAdapter$a */
    class C1543a implements UnityAdapterDelegate {
        C1543a() {
        }

        public String getPlacementId() {
            return UnityMediationAdapter.this.mPlacementId;
        }

        public void onUnityAdsClick(String str) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                UnityMediationAdapter.this.mMediationRewardedAdCallback.reportAdClicked();
            }
        }

        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
            if (str.equals(getPlacementId()) && UnityMediationAdapter.this.mMediationAdLoadCallback != null) {
                String str2 = "Failed to load Rewarded ad from Unity Ads: " + unityAdsError.toString();
                Log.w(UnityMediationAdapter.TAG, str2);
                UnityMediationAdapter.this.mMediationAdLoadCallback.onFailure(str2);
            }
        }

        public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                if (finishState == UnityAds.FinishState.COMPLETED) {
                    UnityMediationAdapter.this.mMediationRewardedAdCallback.onVideoComplete();
                    UnityMediationAdapter.this.mMediationRewardedAdCallback.onUserEarnedReward(new UnityReward());
                }
                UnityMediationAdapter.this.mMediationRewardedAdCallback.onAdClosed();
            }
        }

        public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
        }

        public void onUnityAdsReady(String str) {
            if (str.equals(getPlacementId()) && UnityMediationAdapter.this.mMediationAdLoadCallback != null) {
                UnityMediationAdapter unityMediationAdapter = UnityMediationAdapter.this;
                MediationRewardedAdCallback unused = unityMediationAdapter.mMediationRewardedAdCallback = (MediationRewardedAdCallback) unityMediationAdapter.mMediationAdLoadCallback.onSuccess(UnityMediationAdapter.this);
            }
        }

        public void onUnityAdsStart(String str) {
            if (UnityMediationAdapter.this.mMediationRewardedAdCallback != null) {
                UnityMediationAdapter.this.mMediationRewardedAdCallback.onVideoStart();
            }
        }
    }

    private static boolean isValidIds(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        String str3 = TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? "Game ID and Placement ID" : "Game ID" : "Placement ID";
        String str4 = TAG;
        Log.w(str4, str3 + " cannot be empty.");
        return false;
    }

    public VersionInfo getSDKVersionInfo() {
        String version = UnityAds.getVersion();
        String[] split = version.split("\\.");
        if (split.length >= 3) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s.Returning 0.0.0 for SDK version.", new Object[]{version}));
        return new VersionInfo(0, 0, 0);
    }

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        if (split.length >= 4) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s.Returning 0.0.0 for adapter version.", new Object[]{BuildConfig.VERSION_NAME}));
        return new VersionInfo(0, 0, 0);
    }

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        String str;
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("UnityAds SDK requires an Activity context to initialize");
            return;
        }
        HashSet hashSet = new HashSet();
        for (MediationConfiguration serverParameters : list) {
            String string = serverParameters.getServerParameters().getString(KEY_GAME_ID);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the UnityAds SDK", new Object[]{KEY_GAME_ID, hashSet.toString(), str}));
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            initializationCompleteCallback.onInitializationFailed("Initialization failed: Missing or invalid Game ID.");
            return;
        }
        UnitySingleton.getInstance().initializeUnityAds((Activity) context, str);
        initializationCompleteCallback.onInitializationSucceeded();
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Context context = mediationRewardedAdConfiguration.getContext();
        if (!(context instanceof Activity)) {
            mediationAdLoadCallback.onFailure("Context is not an Activity. Unity Ads requires an Activity context to show ads.");
            return;
        }
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        String string = serverParameters.getString(KEY_GAME_ID);
        String string2 = serverParameters.getString(KEY_PLACEMENT_ID);
        this.mPlacementId = string2;
        if (!isValidIds(string, string2)) {
            mediationAdLoadCallback.onFailure("Failed to load ad from UnityAds: Missing or invalid game ID and placement ID.");
            return;
        }
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        UnitySingleton.getInstance().initializeUnityAds((Activity) context, string);
        UnitySingleton.getInstance().loadAd(this.mUnityAdapterRewardedAdDelegate);
    }

    public void showAd(Context context) {
        if (!(context instanceof Activity)) {
            Log.w(TAG, "An activity context is required to show Unity Ads.");
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow("An activity context is required to show Unity Ads.");
                return;
            }
            return;
        }
        Activity activity = (Activity) context;
        if (UnityAds.isReady(this.mPlacementId)) {
            UnitySingleton.getInstance().showAd(this.mUnityAdapterRewardedAdDelegate, activity);
            MediationRewardedAdCallback mediationRewardedAdCallback2 = this.mMediationRewardedAdCallback;
            if (mediationRewardedAdCallback2 != null) {
                mediationRewardedAdCallback2.onAdOpened();
                this.mMediationRewardedAdCallback.reportAdImpression();
                return;
            }
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback3 = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback3 != null) {
            mediationRewardedAdCallback3.onAdFailedToShow("UnityAds placement '" + this.mPlacementId + "' is not ready.");
        }
    }
}
