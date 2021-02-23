package com.unity3d.services.ads.load;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Map;
import org.json.JSONObject;

public class LoadBridge implements ILoadBridge {

    public enum LoadEvent {
        LOAD_PLACEMENTS
    }

    public void loadPlacements(Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
            }
            if (WebViewApp.getCurrentApp() != null) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.LOAD_API, LoadEvent.LOAD_PLACEMENTS, jSONObject);
            }
        } catch (Exception e) {
            DeviceLog.error("An exception was thrown while loading placements " + e.getLocalizedMessage());
        }
    }
}
