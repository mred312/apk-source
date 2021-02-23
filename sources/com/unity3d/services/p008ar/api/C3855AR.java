package com.unity3d.services.p008ar.api;

import android.content.Context;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.ads.adunit.IAdUnitViewHandler;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import com.unity3d.services.p008ar.ARCheck;
import com.unity3d.services.p008ar.ARError;
import com.unity3d.services.p008ar.ARUtils;
import com.unity3d.services.p008ar.view.ARView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unity3d.services.ar.api.AR */
public class C3855AR {
    @WebViewExposed
    public static void addAnchor(String str, String str2, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().addAnchor(str, str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void advanceFrame(WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().setDrawNextCameraFrame();
        webViewCallback.invoke(new Object[0]);
    }

    private static ARView getARView() {
        IAdUnitViewHandler viewHandler;
        AdUnitActivity adUnitActivity = AdUnit.getAdUnitActivity();
        if (adUnitActivity == null || (viewHandler = adUnitActivity.getViewHandler("arview")) == null) {
            return null;
        }
        return (ARView) viewHandler.getView();
    }

    @WebViewExposed
    public static void getAndroidConfigEnums(WebViewCallback webViewCallback) {
        if (!ARCheck.isFrameworkPresent()) {
            webViewCallback.error(ARError.AR_NOT_SUPPORTED, new Object[0]);
            return;
        }
        webViewCallback.invoke(ARUtils.getConfigEnums());
    }

    @WebViewExposed
    public static void getSupportedVideoFormats(String str, WebViewCallback webViewCallback) {
        webViewCallback.invoke(new JSONArray().toString());
    }

    @WebViewExposed
    public static void hideCameraFeed(WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().setShowCameraFrame(false);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void isARSupported(WebViewCallback webViewCallback) {
        if (!ARCheck.isFrameworkPresent()) {
            Boolean bool = Boolean.FALSE;
            webViewCallback.invoke(bool, bool);
            return;
        }
        Context applicationContext = ClientProperties.getApplicationContext();
        if (applicationContext != null) {
            int isSupported = ARUtils.isSupported(applicationContext);
            webViewCallback.invoke(Boolean.valueOf((isSupported & 2) != 0), Boolean.valueOf((isSupported & 1) != 0));
        }
    }

    @WebViewExposed
    public static void removeAnchor(String str, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().removeAnchor(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void restartSession(JSONObject jSONObject, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        try {
            getARView().restartSession(jSONObject);
            webViewCallback.invoke(new Object[0]);
        } catch (JSONException unused) {
            webViewCallback.error(ARError.ARCONFIG_INVALID, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setDepthFar(Double d, WebViewCallback webViewCallback) {
        if (d == null) {
            webViewCallback.error(ARError.INVALID_VALUE, new Object[0]);
        } else if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
        } else {
            getARView().setArFar(d.floatValue());
            webViewCallback.invoke(new Object[0]);
        }
    }

    @WebViewExposed
    public static void setDepthNear(Double d, WebViewCallback webViewCallback) {
        if (d == null) {
            webViewCallback.error(ARError.INVALID_VALUE, new Object[0]);
        } else if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
        } else {
            getARView().setArNear(d.floatValue());
            webViewCallback.invoke(new Object[0]);
        }
    }

    @WebViewExposed
    public static void setViewRenderMode(Integer num, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        try {
            getARView().setRenderMode(num.intValue());
            webViewCallback.invoke(new Object[0]);
        } catch (IllegalArgumentException unused) {
            webViewCallback.error(ARError.INVALID_VALUE, new Object[0]);
        }
    }

    @WebViewExposed
    public static void showCameraFeed(WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().setShowCameraFrame(true);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void swapBuffers(WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null || getARView() == null) {
            webViewCallback.error(ARError.ARVIEW_NULL, new Object[0]);
            return;
        }
        getARView().swapBuffers();
        webViewCallback.invoke(new Object[0]);
    }
}
