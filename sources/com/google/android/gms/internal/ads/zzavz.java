package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzavz extends zzavo {

    /* renamed from: a */
    private final RewardedAdLoadCallback f12872a;

    public zzavz(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f12872a = rewardedAdLoadCallback;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f12872a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }

    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f12872a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    public final void zzi(zzve zzve) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f12872a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(zzve.zzpm());
        }
    }
}
