package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzavu extends zzavl {

    /* renamed from: a */
    private final RewardedAdCallback f12870a;

    public zzavu(RewardedAdCallback rewardedAdCallback) {
        this.f12870a = rewardedAdCallback;
    }

    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.f12870a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.f12870a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.f12870a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    public final void zza(zzavc zzavc) {
        RewardedAdCallback rewardedAdCallback = this.f12870a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzavv(zzavc));
        }
    }

    public final void zzh(zzve zzve) {
        RewardedAdCallback rewardedAdCallback = this.f12870a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzve.zzpl());
        }
    }
}
