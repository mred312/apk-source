package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface InterstitialAdListener extends AdListener {
    void onInterstitialDismissed(C1484Ad ad);

    void onInterstitialDisplayed(C1484Ad ad);
}
