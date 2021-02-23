package com.unity3d.services.ads;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.properties.AdsProperties;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.adunit.AdUnitOpen;
import com.unity3d.services.ads.load.LoadModule;
import com.unity3d.services.ads.placement.Placement;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import org.json.JSONException;
import org.json.JSONObject;

public final class UnityAdsImplementation {
    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.addListener(iUnityAdsListener);
    }

    public static boolean getDebugMode() {
        return UnityServices.getDebugMode();
    }

    public static String getDefaultPlacement() {
        return Placement.getDefaultPlacement();
    }

    @Deprecated
    public static IUnityAdsListener getListener() {
        return AdsProperties.getListener();
    }

    public static UnityAds.PlacementState getPlacementState() {
        if (!isSupported() || !isInitialized()) {
            return UnityAds.PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState();
    }

    public static String getVersion() {
        return UnityServices.getVersion();
    }

    /* access modifiers changed from: private */
    public static void handleShowError(final String str, final UnityAds.UnityAdsError unityAdsError, String str2) {
        final String str3 = "Unity Ads show failed: " + str2;
        DeviceLog.error(str3);
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener next : AdsProperties.getListeners()) {
                    next.onUnityAdsError(unityAdsError, str3);
                    String str = str;
                    if (str != null) {
                        next.onUnityAdsFinish(str, UnityAds.FinishState.ERROR);
                    } else {
                        next.onUnityAdsFinish("", UnityAds.FinishState.ERROR);
                    }
                }
            }
        });
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener) {
        initialize(activity, str, iUnityAdsListener, false);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public static boolean isReady() {
        return isSupported() && isInitialized() && Placement.isReady();
    }

    public static boolean isSupported() {
        return UnityServices.isSupported();
    }

    public static void load(String str) {
        LoadModule.getInstance().load(str);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.removeListener(iUnityAdsListener);
    }

    public static void setDebugMode(boolean z) {
        UnityServices.setDebugMode(z);
    }

    @Deprecated
    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        AdsProperties.setListener(iUnityAdsListener);
    }

    public static void show(Activity activity) {
        if (Placement.getDefaultPlacement() != null) {
            show(activity, Placement.getDefaultPlacement());
        } else {
            handleShowError("", UnityAds.UnityAdsError.NOT_INITIALIZED, "Unity Ads default placement is not initialized");
        }
    }

    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z) {
        initialize(activity, str, iUnityAdsListener, z, false);
    }

    public static boolean isReady(String str) {
        return isSupported() && isInitialized() && str != null && Placement.isReady(str);
    }

    public static void initialize(Activity activity, String str, final IUnityAdsListener iUnityAdsListener, boolean z, boolean z2) {
        DeviceLog.entered();
        addListener(iUnityAdsListener);
        UnityServices.initialize(activity, str, new IUnityServicesListener() {
            public void onUnityServicesError(UnityServices.UnityServicesError unityServicesError, String str) {
                if (unityServicesError == UnityServices.UnityServicesError.INIT_SANITY_CHECK_FAIL) {
                    iUnityAdsListener.onUnityAdsError(UnityAds.UnityAdsError.INIT_SANITY_CHECK_FAIL, str);
                } else if (unityServicesError == UnityServices.UnityServicesError.INVALID_ARGUMENT) {
                    iUnityAdsListener.onUnityAdsError(UnityAds.UnityAdsError.INVALID_ARGUMENT, str);
                }
            }
        }, z, z2);
    }

    public static UnityAds.PlacementState getPlacementState(String str) {
        if (!isSupported() || !isInitialized() || str == null) {
            return UnityAds.PlacementState.NOT_AVAILABLE;
        }
        return Placement.getPlacementState(str);
    }

    public static void show(final Activity activity, final String str) {
        if (activity == null) {
            handleShowError(str, UnityAds.UnityAdsError.INVALID_ARGUMENT, "Activity must not be null");
        } else if (isReady(str)) {
            DeviceLog.info("Unity Ads opening new ad unit for placement " + str);
            ClientProperties.setActivity(activity);
            new Thread(new Runnable() {
                public void run() {
                    Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("requestedOrientation", activity.getRequestedOrientation());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("rotation", defaultDisplay.getRotation());
                        if (Build.VERSION.SDK_INT >= 13) {
                            Point point = new Point();
                            defaultDisplay.getSize(point);
                            jSONObject2.put("width", point.x);
                            jSONObject2.put("height", point.y);
                        } else {
                            jSONObject2.put("width", defaultDisplay.getWidth());
                            jSONObject2.put("height", defaultDisplay.getHeight());
                        }
                        jSONObject.put("display", jSONObject2);
                    } catch (JSONException e) {
                        DeviceLog.exception("JSON error while constructing show options", e);
                    }
                    try {
                        if (!AdUnitOpen.open(str, jSONObject)) {
                            UnityAdsImplementation.handleShowError(str, UnityAds.UnityAdsError.INTERNAL_ERROR, "Webapp timeout, shutting down Unity Ads");
                        }
                    } catch (NoSuchMethodException e2) {
                        DeviceLog.exception("Could not get callback method", e2);
                        UnityAdsImplementation.handleShowError(str, UnityAds.UnityAdsError.SHOW_ERROR, "Could not get com.unity3d.ads.properties.showCallback method");
                    }
                }
            }).start();
        } else if (!isSupported()) {
            handleShowError(str, UnityAds.UnityAdsError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        } else if (!isInitialized()) {
            handleShowError(str, UnityAds.UnityAdsError.NOT_INITIALIZED, "Unity Ads is not initialized");
        } else {
            UnityAds.UnityAdsError unityAdsError = UnityAds.UnityAdsError.SHOW_ERROR;
            handleShowError(str, unityAdsError, "Placement \"" + str + "\" is not ready");
        }
    }
}
