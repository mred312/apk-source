package com.unity3d.services.monetization.placementcontent.ads;

import android.app.Activity;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.monetization.placementcontent.core.RewardablePlacementContent;
import java.util.HashMap;
import java.util.Map;

public class ShowAdPlacementContent extends RewardablePlacementContent {
    private static Map<String, IShowAdListener> listenerMap = new HashMap();

    public ShowAdPlacementContent(String str, Map<String, Object> map) {
        super(str, map);
    }

    public static void sendAdFinished(String str, UnityAds.FinishState finishState) {
        IShowAdListener remove = listenerMap.remove(str);
        if (remove != null) {
            remove.onAdFinished(str, finishState);
        }
    }

    public static void sendAdStarted(String str) {
        IShowAdListener iShowAdListener = listenerMap.get(str);
        if (iShowAdListener != null) {
            iShowAdListener.onAdStarted(str);
        }
    }

    public void show(Activity activity, IShowAdListener iShowAdListener) {
        listenerMap.put(this.placementId, iShowAdListener);
        if (UnityAds.isReady(this.placementId)) {
            UnityAds.show(activity, this.placementId);
        } else {
            sendAdFinished(this.placementId, UnityAds.FinishState.ERROR);
        }
    }
}
