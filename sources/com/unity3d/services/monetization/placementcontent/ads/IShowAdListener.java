package com.unity3d.services.monetization.placementcontent.ads;

import com.unity3d.ads.UnityAds;

public interface IShowAdListener {
    void onAdFinished(String str, UnityAds.FinishState finishState);

    void onAdStarted(String str);
}
