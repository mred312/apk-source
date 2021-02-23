package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface RewardedVideoAdListener extends AdListener {
    void onLoggingImpression(C1484Ad ad);

    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
