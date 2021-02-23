package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzawf extends zzavo {

    /* renamed from: a */
    private final RewardedInterstitialAdLoadCallback f12881a;

    /* renamed from: b */
    private final zzawe f12882b;

    public zzawf(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzawe zzawe) {
        this.f12881a = rewardedInterstitialAdLoadCallback;
        this.f12882b = zzawe;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.f12881a;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    public final void onRewardedAdLoaded() {
        zzawe zzawe;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.f12881a;
        if (rewardedInterstitialAdLoadCallback != null && (zzawe = this.f12882b) != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzawe);
        }
    }

    public final void zzi(zzve zzve) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.f12881a;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(zzve.zzpm());
        }
    }
}
