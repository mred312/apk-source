package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
class DynamicLoaderFallback {
    /* access modifiers changed from: private */
    public static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    /* renamed from: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback$a */
    class C1496a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ List f6927a;

        /* renamed from: b */
        final /* synthetic */ Map f6928b;

        /* renamed from: c */
        final /* synthetic */ List f6929c;

        /* renamed from: d */
        final /* synthetic */ List f6930d;

        /* renamed from: e */
        final /* synthetic */ Map f6931e;

        /* renamed from: f */
        final /* synthetic */ List f6932f;

        /* renamed from: g */
        final /* synthetic */ List f6933g;

        /* renamed from: h */
        final /* synthetic */ Method f6934h;

        /* renamed from: i */
        final /* synthetic */ Method f6935i;

        C1496a(List list, Map map, List list2, List list3, Map map2, List list4, List list5, Method method, Method method2) {
            this.f6927a = list;
            this.f6928b = map;
            this.f6929c = list2;
            this.f6930d = list3;
            this.f6931e = map2;
            this.f6932f = list4;
            this.f6933g = list5;
            this.f6934h = method;
            this.f6935i = method2;
        }

        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (method.getReturnType().isPrimitive()) {
                if (!method.getReturnType().equals(Void.TYPE)) {
                    return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                }
                Iterator it = this.f6927a.iterator();
                while (it.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it.next()) || !DynamicLoaderFallback.reportError(obj, this.f6928b))) {
                }
                for (Method access$100 : this.f6929c) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$100) && DynamicLoaderFallback.reportError(obj, this.f6928b)) {
                        return null;
                    }
                }
                return null;
            } else if (method.getReturnType().equals(String.class)) {
                return "";
            } else {
                if (method.getReturnType().equals(obj.getClass().getInterfaces()[0])) {
                    obj2 = obj;
                } else {
                    obj2 = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                }
                Iterator it2 = this.f6930d.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (DynamicLoaderFallback.equalsMethods(method, (Method) it2.next())) {
                            DynamicLoaderFallback.sApiProxyToAdListenersMap.put(this.f6931e.get(obj), objArr[0]);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                for (Method access$1002 : this.f6932f) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$1002)) {
                        this.f6931e.put(obj2, obj);
                    }
                }
                for (Method access$1003 : this.f6933g) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$1003)) {
                        for (C1484Ad ad : objArr) {
                            if (ad instanceof C1484Ad) {
                                this.f6928b.put(obj2, ad);
                            }
                        }
                    }
                }
                if (DynamicLoaderFallback.equalsMethods(method, this.f6934h)) {
                    this.f6928b.put(objArr[1], objArr[0]);
                }
                if (DynamicLoaderFallback.equalsMethods(method, this.f6935i)) {
                    this.f6928b.put(objArr[1], objArr[0]);
                }
                return obj2;
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback$b */
    class C1497b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdListener f6936a;

        /* renamed from: b */
        final /* synthetic */ C1484Ad f6937b;

        C1497b(AdListener adListener, C1484Ad ad) {
            this.f6936a = adListener;
            this.f6937b = ad;
        }

        public void run() {
            this.f6936a.onError(this.f6937b, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
        }
    }

    DynamicLoaderFallback() {
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    /* access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    static DynamicLoader makeFallbackLoader() {
        Class cls = DynamicLoader.class;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        C1498c cVar = new C1498c((C1496a) null);
        DynamicLoader dynamicLoader = (DynamicLoader) cVar.mo11080c(cls);
        dynamicLoader.createInterstitialAd((Context) null, (String) null, (InterstitialAd) null);
        arrayList5.add(cVar.mo11079b());
        dynamicLoader.createRewardedVideoAd((Context) null, (String) null, (RewardedVideoAd) null);
        arrayList5.add(cVar.mo11079b());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList5.add(cVar.mo11079b());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList5.add(cVar.mo11079b());
        dynamicLoader.createNativeAdApi((NativeAd) null, (NativeAdBaseApi) null);
        Method b = cVar.mo11079b();
        dynamicLoader.createNativeBannerAdApi((NativeBannerAd) null, (NativeAdBaseApi) null);
        Method b2 = cVar.mo11079b();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) cVar.mo11080c(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(cVar.mo11079b());
        nativeAdBaseApi.loadAd((NativeAdBase.NativeLoadAdConfig) null);
        arrayList2.add(cVar.mo11079b());
        nativeAdBaseApi.buildLoadAdConfig((NativeAdBase) null);
        arrayList4.add(cVar.mo11079b());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) cVar.mo11080c(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(cVar.mo11079b());
        interstitialAdApi.loadAd((InterstitialAd.InterstitialLoadAdConfig) null);
        arrayList2.add(cVar.mo11079b());
        interstitialAdApi.buildLoadAdConfig();
        arrayList4.add(cVar.mo11079b());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) cVar.mo11080c(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(cVar.mo11079b());
        rewardedVideoAdApi.loadAd((RewardedVideoAd.RewardedVideoLoadAdConfig) null);
        arrayList2.add(cVar.mo11079b());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList4.add(cVar.mo11079b());
        AdViewApi adViewApi = (AdViewApi) cVar.mo11080c(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(cVar.mo11079b());
        adViewApi.loadAd((AdView.AdViewLoadConfig) null);
        arrayList2.add(cVar.mo11079b());
        adViewApi.buildLoadAdConfig();
        arrayList4.add(cVar.mo11079b());
        ((AdView.AdViewLoadConfigBuilder) cVar.mo11080c(AdView.AdViewLoadConfigBuilder.class)).withAdListener((AdListener) null);
        arrayList3.add(cVar.mo11079b());
        ((NativeAdBase.NativeAdLoadConfigBuilder) cVar.mo11080c(NativeAdBase.NativeAdLoadConfigBuilder.class)).withAdListener((NativeAdListener) null);
        arrayList3.add(cVar.mo11079b());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) cVar.mo11080c(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener((InterstitialAdListener) null);
        arrayList3.add(cVar.mo11079b());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) cVar.mo11080c(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener((RewardedVideoAdListener) null);
        arrayList3.add(cVar.mo11079b());
        C1496a aVar = new C1496a(arrayList, hashMap, arrayList2, arrayList3, hashMap2, arrayList4, arrayList5, b, b2);
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, aVar);
    }

    /* access modifiers changed from: private */
    public static boolean reportError(@Nullable Object obj, Map<Object, C1484Ad> map) {
        if (obj == null) {
            return false;
        }
        AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        C1484Ad ad = map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new C1497b(adListener, ad), 500);
        return true;
    }

    /* renamed from: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback$c */
    private static class C1498c {
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a */
        public Method f6938a;

        /* renamed from: b */
        private final InvocationHandler f6939b;

        /* renamed from: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback$c$a */
        class C1499a implements InvocationHandler {
            C1499a() {
            }

            @Nullable
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if ("toString".equals(method.getName())) {
                    return null;
                }
                Method unused = C1498c.this.f6938a = method;
                return null;
            }
        }

        private C1498c() {
            this.f6939b = new C1499a();
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: b */
        public Method mo11079b() {
            return this.f6938a;
        }

        /* renamed from: c */
        public <T> T mo11080c(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.f6939b));
        }

        /* synthetic */ C1498c(C1496a aVar) {
            this();
        }
    }
}
