package com.google.ads.mediation.unity;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.MobileAds;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class UnitySingleton {

    /* renamed from: f */
    private static UnitySingleton f7067f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HashMap<String, WeakReference<UnityAdapterDelegate>> f7068a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WeakReference<UnityAdapterDelegate> f7069b;

    /* renamed from: c */
    private C1545b f7070c;

    /* renamed from: d */
    private int f7071d;

    /* renamed from: e */
    private int f7072e;

    /* renamed from: com.google.ads.mediation.unity.UnitySingleton$b */
    private final class C1545b implements IUnityAdsExtendedListener {
        private C1545b() {
        }

        public void onUnityAdsClick(String str) {
            UnityAdapterDelegate unityAdapterDelegate;
            if (UnitySingleton.this.f7069b != null && (unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.f7069b.get()) != null) {
                unityAdapterDelegate.onUnityAdsClick(str);
            }
        }

        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
            if (UnitySingleton.this.f7068a.containsKey(str) && ((WeakReference) UnitySingleton.this.f7068a.get(str)).get() != null) {
                ((UnityAdapterDelegate) ((WeakReference) UnitySingleton.this.f7068a.get(str)).get()).onUnityAdsError(unityAdsError, str);
                UnitySingleton.this.f7068a.remove(str);
            }
        }

        public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
            UnityAdapterDelegate unityAdapterDelegate;
            if (UnitySingleton.this.f7069b != null && (unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.f7069b.get()) != null) {
                unityAdapterDelegate.onUnityAdsFinish(str, finishState);
                UnitySingleton.this.f7068a.remove(str);
            }
        }

        public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
        }

        public void onUnityAdsReady(String str) {
            if (UnitySingleton.this.f7068a.containsKey(str) && ((WeakReference) UnitySingleton.this.f7068a.get(str)).get() != null) {
                ((UnityAdapterDelegate) ((WeakReference) UnitySingleton.this.f7068a.get(str)).get()).onUnityAdsReady(str);
            }
        }

        public void onUnityAdsStart(String str) {
            UnityAdapterDelegate unityAdapterDelegate;
            if (UnitySingleton.this.f7069b != null && (unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.f7069b.get()) != null) {
                unityAdapterDelegate.onUnityAdsStart(str);
            }
        }
    }

    private UnitySingleton() {
    }

    /* renamed from: c */
    private C1545b m5014c() {
        if (this.f7070c == null) {
            this.f7070c = new C1545b();
        }
        return this.f7070c;
    }

    public static UnitySingleton getInstance() {
        if (f7067f == null) {
            f7067f = new UnitySingleton();
        }
        return f7067f;
    }

    public boolean initializeUnityAds(Activity activity, String str) {
        if (!UnityAds.isSupported()) {
            Log.w(UnityMediationAdapter.TAG, "The current device is not supported by Unity Ads.");
            return false;
        } else if (UnityAds.isInitialized()) {
            return true;
        } else {
            MediationMetaData mediationMetaData = new MediationMetaData(activity);
            mediationMetaData.setName("AdMob");
            mediationMetaData.setVersion(MobileAds.getVersionString());
            mediationMetaData.set("adapter_version", BuildConfig.VERSION_NAME);
            mediationMetaData.commit();
            UnityAds.initialize(activity, str, f7067f.m5014c(), false, true);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void loadAd(UnityAdapterDelegate unityAdapterDelegate) {
        UnityAds.load(unityAdapterDelegate.getPlacementId());
        if (!UnityAds.isInitialized()) {
            return;
        }
        if (!this.f7068a.containsKey(unityAdapterDelegate.getPlacementId()) || this.f7068a.get(unityAdapterDelegate.getPlacementId()).get() == null) {
            this.f7068a.put(unityAdapterDelegate.getPlacementId(), new WeakReference(unityAdapterDelegate));
            if (UnityAds.isReady(unityAdapterDelegate.getPlacementId())) {
                unityAdapterDelegate.onUnityAdsReady(unityAdapterDelegate.getPlacementId());
                return;
            }
            return;
        }
        String str = UnityMediationAdapter.TAG;
        Log.e(str, "An ad is already loading for placement ID: " + unityAdapterDelegate.getPlacementId());
        unityAdapterDelegate.onUnityAdsError(UnityAds.UnityAdsError.INTERNAL_ERROR, unityAdapterDelegate.getPlacementId());
    }

    /* access modifiers changed from: protected */
    public void showAd(UnityAdapterDelegate unityAdapterDelegate, Activity activity) {
        this.f7069b = new WeakReference<>(unityAdapterDelegate);
        if (UnityAds.isReady(unityAdapterDelegate.getPlacementId())) {
            MediationMetaData mediationMetaData = new MediationMetaData(activity);
            int i = this.f7071d + 1;
            this.f7071d = i;
            mediationMetaData.setOrdinal(i);
            mediationMetaData.commit();
            UnityAds.show(activity, unityAdapterDelegate.getPlacementId());
            return;
        }
        MediationMetaData mediationMetaData2 = new MediationMetaData(activity);
        int i2 = this.f7072e + 1;
        this.f7072e = i2;
        mediationMetaData2.setMissedImpressionOrdinal(i2);
        mediationMetaData2.commit();
    }
}
