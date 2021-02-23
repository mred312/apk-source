package com.unity3d.services.monetization.core.placementcontent;

import com.unity3d.services.monetization.UnityMonetization;
import com.unity3d.services.monetization.placementcontent.core.CustomEvent;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;
import java.util.HashMap;
import java.util.Map;

public class PlacementContents {
    private static final PlacementContent NOT_AVAILABLE = getNotAvailablePlacementContent();
    private static Map<String, PlacementContent> placementContentsMap = new HashMap();

    private static final class NotAvailablePlacementContent extends PlacementContent {
        public NotAvailablePlacementContent(String str, Map<String, Object> map) {
            super(str, map);
        }

        /* access modifiers changed from: protected */
        public String getDefaultEventCategory() {
            return "NOT_AVAILABLE";
        }

        public UnityMonetization.PlacementContentState getState() {
            return UnityMonetization.PlacementContentState.NOT_AVAILABLE;
        }

        public boolean isReady() {
            return false;
        }

        public void sendCustomEvent(CustomEvent customEvent) {
        }
    }

    private static PlacementContent getNotAvailablePlacementContent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "NOT_AVAILABLE");
        return new NotAvailablePlacementContent("", hashMap);
    }

    public static PlacementContent getPlacementContent(String str) {
        PlacementContent placementContent = placementContentsMap.get(str);
        return placementContent == null ? NOT_AVAILABLE : placementContent;
    }

    public static boolean isReady(String str) {
        PlacementContent placementContent = getPlacementContent(str);
        return placementContent != null && placementContent.isReady();
    }

    public static PlacementContent putPlacementContent(String str, PlacementContent placementContent) {
        return placementContentsMap.put(str, placementContent);
    }

    public static void removePlacementContent(String str) {
        placementContentsMap.remove(str);
    }

    public static void setPlacementContentState(String str, UnityMonetization.PlacementContentState placementContentState) {
        PlacementContent placementContent = getPlacementContent(str);
        if (placementContent != null) {
            placementContent.setState(placementContentState);
        }
    }

    public static <T extends PlacementContent> T getPlacementContent(String str, Class<T> cls) {
        PlacementContent placementContent = getPlacementContent(str);
        if (cls.isInstance(placementContent)) {
            return (PlacementContent) cls.cast(placementContent);
        }
        return null;
    }
}
