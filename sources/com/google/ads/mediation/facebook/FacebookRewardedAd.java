package com.google.ads.mediation.facebook;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.ads.mediation.facebook.C1532a;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener {

    /* renamed from: a */
    private MediationRewardedAdConfiguration f7014a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f7015b;

    /* renamed from: c */
    private RewardedVideoAd f7016c;

    /* renamed from: d */
    private AtomicBoolean f7017d = new AtomicBoolean();

    /* renamed from: e */
    private MediationRewardedAdCallback f7018e;

    /* renamed from: f */
    private boolean f7019f = false;

    /* renamed from: g */
    private AtomicBoolean f7020g = new AtomicBoolean();

    /* renamed from: com.google.ads.mediation.facebook.FacebookRewardedAd$a */
    class C1528a implements C1532a.C1533a {

        /* renamed from: a */
        final /* synthetic */ Context f7021a;

        /* renamed from: b */
        final /* synthetic */ String f7022b;

        C1528a(Context context, String str) {
            this.f7021a = context;
            this.f7022b = str;
        }

        /* renamed from: a */
        public void mo11196a(String str) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(104, "Failed to load ad from Facebook: " + str);
            Log.w(FacebookMediationAdapter.TAG, createAdapterError);
            if (FacebookRewardedAd.this.f7015b != null) {
                FacebookRewardedAd.this.f7015b.onFailure(createAdapterError);
            }
        }

        /* renamed from: b */
        public void mo11197b() {
            FacebookRewardedAd.this.m4994c(this.f7021a, this.f7022b);
        }
    }

    public FacebookRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.f7014a = mediationRewardedAdConfiguration;
        this.f7015b = mediationAdLoadCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4994c(Context context, String str) {
        RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(context, str);
        this.f7016c = rewardedVideoAd;
        rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withAdExperience(mo11221d()).build());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: d */
    public AdExperienceType mo11221d() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public void onAdClicked(C1484Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f7018e;
        if (mediationRewardedAdCallback != null && !this.f7019f) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    public void onAdLoaded(C1484Ad ad) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.f7015b;
        if (mediationAdLoadCallback != null) {
            this.f7018e = mediationAdLoadCallback.onSuccess(this);
        }
    }

    public void onError(C1484Ad ad, AdError adError) {
        String createSdkError = FacebookMediationAdapter.createSdkError(adError);
        if (this.f7017d.get()) {
            String str = FacebookMediationAdapter.TAG;
            Log.w(str, "Failed to present rewarded ad: " + createSdkError);
            MediationRewardedAdCallback mediationRewardedAdCallback = this.f7018e;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(createSdkError);
            }
        } else {
            String str2 = FacebookMediationAdapter.TAG;
            Log.w(str2, "Failed to load rewarded ad: " + createSdkError);
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.f7015b;
            if (mediationAdLoadCallback != null) {
                mediationAdLoadCallback.onFailure(createSdkError);
            }
        }
        this.f7016c.destroy();
    }

    public void onLoggingImpression(C1484Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f7018e;
        if (mediationRewardedAdCallback != null && !this.f7019f) {
            mediationRewardedAdCallback.reportAdImpression();
        }
    }

    public void onRewardedVideoActivityDestroyed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.f7020g.getAndSet(true) && (mediationRewardedAdCallback = this.f7018e) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.f7016c;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    public void onRewardedVideoClosed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.f7020g.getAndSet(true) && (mediationRewardedAdCallback = this.f7018e) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.f7016c;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    public void onRewardedVideoCompleted() {
        this.f7018e.onVideoComplete();
        this.f7018e.onUserEarnedReward(new FacebookReward());
    }

    public void render() {
        Context context = this.f7014a.getContext();
        String placementID = FacebookMediationAdapter.getPlacementID(this.f7014a.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty.");
            Log.e(FacebookMediationAdapter.TAG, createAdapterError);
            this.f7015b.onFailure(createAdapterError);
            return;
        }
        String bidResponse = this.f7014a.getBidResponse();
        if (!TextUtils.isEmpty(bidResponse)) {
            this.f7019f = true;
        }
        FacebookMediationAdapter.setMixedAudience(this.f7014a);
        if (this.f7019f) {
            this.f7016c = new RewardedVideoAd(context, placementID);
            if (!TextUtils.isEmpty(this.f7014a.getWatermark())) {
                this.f7016c.setExtraHints(new ExtraHints.Builder().mediationData(this.f7014a.getWatermark()).build());
            }
            RewardedVideoAd rewardedVideoAd = this.f7016c;
            rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withBid(bidResponse).withAdExperience(mo11221d()).build());
            return;
        }
        C1532a.m4999a().mo11224b(context, placementID, new C1528a(context, placementID));
    }

    public void showAd(Context context) {
        this.f7017d.set(true);
        if (!this.f7016c.show()) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(110, "Failed to present rewarded ad.");
            Log.w(FacebookMediationAdapter.TAG, createAdapterError);
            MediationRewardedAdCallback mediationRewardedAdCallback = this.f7018e;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(createAdapterError);
            }
            this.f7016c.destroy();
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.f7018e;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onVideoStart();
            this.f7018e.onAdOpened();
        }
    }
}
