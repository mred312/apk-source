package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* renamed from: com.google.ads.mediation.b */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1507b implements RewardedVideoAdListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f6960a;

    C1507b(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f6960a = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.f6960a.zzmk.onRewarded(this.f6960a, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.f6960a.zzmk.onAdClosed(this.f6960a);
        InterstitialAd unused = this.f6960a.zzmj = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f6960a.zzmk.onAdFailedToLoad(this.f6960a, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.f6960a.zzmk.onAdLeftApplication(this.f6960a);
    }

    public final void onRewardedVideoAdLoaded() {
        this.f6960a.zzmk.onAdLoaded(this.f6960a);
    }

    public final void onRewardedVideoAdOpened() {
        this.f6960a.zzmk.onAdOpened(this.f6960a);
    }

    public final void onRewardedVideoCompleted() {
        this.f6960a.zzmk.onVideoCompleted(this.f6960a);
    }

    public final void onRewardedVideoStarted() {
        this.f6960a.zzmk.onVideoStarted(this.f6960a);
    }
}
