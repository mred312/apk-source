package com.google.ads.mediation.facebook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.C1532a;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
public final class FacebookAdapter extends FacebookMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    private static final int MAX_STAR_RATING = 5;
    /* access modifiers changed from: private */
    public AtomicBoolean didInterstitialAdClose = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean isNativeBanner;
    /* access modifiers changed from: private */
    public AdView mAdView;
    /* access modifiers changed from: private */
    public MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mInterstitialListener;
    /* access modifiers changed from: private */
    public boolean mIsImpressionRecorded;
    /* access modifiers changed from: private */
    public MediaView mMediaView;
    private NativeAd mNativeAd;
    private NativeBannerAd mNativeBannerAd;
    /* access modifiers changed from: private */
    public MediationNativeListener mNativeListener;
    /* access modifiers changed from: private */
    public FrameLayout mWrappedAdView;
    /* access modifiers changed from: private */
    public AtomicBoolean showInterstitialCalled = new AtomicBoolean();

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$a */
    class C1510a implements C1532a.C1533a {

        /* renamed from: a */
        final /* synthetic */ Context f6969a;

        /* renamed from: b */
        final /* synthetic */ String f6970b;

        /* renamed from: c */
        final /* synthetic */ AdSize f6971c;

        /* renamed from: d */
        final /* synthetic */ MediationAdRequest f6972d;

        /* renamed from: e */
        final /* synthetic */ com.google.android.gms.ads.AdSize f6973e;

        C1510a(Context context, String str, AdSize adSize, MediationAdRequest mediationAdRequest, com.google.android.gms.ads.AdSize adSize2) {
            this.f6969a = context;
            this.f6970b = str;
            this.f6971c = adSize;
            this.f6972d = mediationAdRequest;
            this.f6973e = adSize2;
        }

        /* renamed from: a */
        public void mo11196a(String str) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(104, str));
            if (FacebookAdapter.this.mBannerListener != null) {
                FacebookAdapter.this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) FacebookAdapter.this, 104);
            }
        }

        /* renamed from: b */
        public void mo11197b() {
            AdView unused = FacebookAdapter.this.mAdView = new AdView(this.f6969a, this.f6970b, this.f6971c);
            FacebookAdapter.this.buildAdRequest(this.f6972d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f6973e.getWidthInPixels(this.f6969a), -2);
            FrameLayout unused2 = FacebookAdapter.this.mWrappedAdView = new FrameLayout(this.f6969a);
            FacebookAdapter.this.mAdView.setLayoutParams(layoutParams);
            FacebookAdapter.this.mWrappedAdView.addView(FacebookAdapter.this.mAdView);
            FacebookAdapter.this.mAdView.loadAd(FacebookAdapter.this.mAdView.buildLoadAdConfig().withAdListener(new C1515e(FacebookAdapter.this, (C1510a) null)).build());
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$b */
    class C1511b implements C1532a.C1533a {

        /* renamed from: a */
        final /* synthetic */ Context f6975a;

        /* renamed from: b */
        final /* synthetic */ String f6976b;

        /* renamed from: c */
        final /* synthetic */ MediationAdRequest f6977c;

        C1511b(Context context, String str, MediationAdRequest mediationAdRequest) {
            this.f6975a = context;
            this.f6976b = str;
            this.f6977c = mediationAdRequest;
        }

        /* renamed from: a */
        public void mo11196a(String str) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(104, str));
            if (FacebookAdapter.this.mInterstitialListener != null) {
                FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) FacebookAdapter.this, 104);
            }
        }

        /* renamed from: b */
        public void mo11197b() {
            FacebookAdapter.this.createAndLoadInterstitial(this.f6975a, this.f6976b, this.f6977c);
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$c */
    class C1512c implements C1532a.C1533a {

        /* renamed from: a */
        final /* synthetic */ Context f6979a;

        /* renamed from: b */
        final /* synthetic */ String f6980b;

        /* renamed from: c */
        final /* synthetic */ NativeMediationAdRequest f6981c;

        /* renamed from: d */
        final /* synthetic */ Bundle f6982d;

        C1512c(Context context, String str, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle) {
            this.f6979a = context;
            this.f6980b = str;
            this.f6981c = nativeMediationAdRequest;
            this.f6982d = bundle;
        }

        /* renamed from: a */
        public void mo11196a(String str) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(104, str));
            if (FacebookAdapter.this.mNativeListener != null) {
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 104);
            }
        }

        /* renamed from: b */
        public void mo11197b() {
            FacebookAdapter.this.createAndLoadNativeAd(this.f6979a, this.f6980b, this.f6981c, this.f6982d);
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$e */
    private class C1515e implements AdListener {
        /* synthetic */ C1515e(FacebookAdapter facebookAdapter, C1510a aVar) {
            this();
        }

        public void onAdClicked(C1484Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1484Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C1484Ad ad, AdError adError) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createSdkError(adError));
            FacebookAdapter.this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onLoggingImpression(C1484Ad ad) {
        }

        private C1515e() {
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$f */
    private class C1516f extends NativeAd.Image {

        /* renamed from: a */
        private Drawable f6989a;

        /* renamed from: b */
        private Uri f6990b;

        public C1516f(FacebookAdapter facebookAdapter) {
        }

        public Drawable getDrawable() {
            return this.f6989a;
        }

        public double getScale() {
            return 1.0d;
        }

        public Uri getUri() {
            return this.f6990b;
        }

        public C1516f(FacebookAdapter facebookAdapter, Uri uri) {
            this.f6990b = uri;
        }

        public C1516f(FacebookAdapter facebookAdapter, Drawable drawable) {
            this.f6989a = drawable;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$g */
    private class C1517g implements InterstitialAdExtendedListener {
        /* synthetic */ C1517g(FacebookAdapter facebookAdapter, C1510a aVar) {
            this();
        }

        public void onAdClicked(C1484Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mInterstitialListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1484Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C1484Ad ad, AdError adError) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createSdkError(adError));
            if (FacebookAdapter.this.showInterstitialCalled.get()) {
                FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
                return;
            }
            FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onInterstitialActivityDestroyed() {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }

        public void onInterstitialDismissed(C1484Ad ad) {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }

        public void onInterstitialDisplayed(C1484Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
        }

        public void onLoggingImpression(C1484Ad ad) {
        }

        public void onRewardedAdCompleted() {
        }

        public void onRewardedAdServerFailed() {
        }

        public void onRewardedAdServerSucceeded() {
        }

        private C1517g() {
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$h */
    private interface C1518h {
        /* renamed from: a */
        void mo11204a();

        /* renamed from: b */
        void mo11205b(String str);
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$i */
    private class C1519i implements AdListener, NativeAdListener {

        /* renamed from: a */
        private WeakReference<Context> f6992a;

        /* renamed from: b */
        private NativeBannerAd f6993b;

        /* renamed from: c */
        private NativeMediationAdRequest f6994c;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$i$a */
        class C1520a implements C1518h {

            /* renamed from: a */
            final /* synthetic */ C1525k f6996a;

            C1520a(C1525k kVar) {
                this.f6996a = kVar;
            }

            /* renamed from: a */
            public void mo11204a() {
                FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (UnifiedNativeAdMapper) this.f6996a);
            }

            /* renamed from: b */
            public void mo11205b(String str) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(108, str));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 108);
            }
        }

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$i$b */
        class C1521b implements C1518h {

            /* renamed from: a */
            final /* synthetic */ C1513d f6998a;

            C1521b(C1513d dVar) {
                this.f6998a = dVar;
            }

            /* renamed from: a */
            public void mo11204a() {
                FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (NativeAdMapper) this.f6998a);
            }

            /* renamed from: b */
            public void mo11205b(String str) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(108, str));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 108);
            }
        }

        /* synthetic */ C1519i(FacebookAdapter facebookAdapter, Context context, NativeBannerAd nativeBannerAd, NativeMediationAdRequest nativeMediationAdRequest, C1510a aVar) {
            this(context, nativeBannerAd, nativeMediationAdRequest);
        }

        public void onAdClicked(C1484Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1484Ad ad) {
            if (ad != this.f6993b) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(106, "Ad loaded is not a native banner ad."));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 106);
                return;
            }
            Context context = (Context) this.f6992a.get();
            if (context == null) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(107, "Failed to create ad options view, Context is null."));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 107);
                return;
            }
            NativeAdOptions nativeAdOptions = this.f6994c.getNativeAdOptions();
            if (this.f6994c.isUnifiedNativeAdRequested()) {
                C1525k kVar = new C1525k(this.f6993b, nativeAdOptions);
                kVar.mo11206d(context, new C1520a(kVar));
            } else if (this.f6994c.isAppInstallAdRequested()) {
                C1513d dVar = new C1513d(this.f6993b, nativeAdOptions);
                dVar.mo11198d(context, new C1521b(dVar));
            } else {
                Log.e(FacebookMediationAdapter.TAG, "Content Ads are not supported.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 1);
            }
        }

        public void onError(C1484Ad ad, AdError adError) {
            String createSdkError = FacebookMediationAdapter.createSdkError(adError);
            if (!TextUtils.isEmpty(adError.getErrorMessage())) {
                Log.w(FacebookMediationAdapter.TAG, createSdkError);
            }
            FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onLoggingImpression(C1484Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            boolean unused = FacebookAdapter.this.mIsImpressionRecorded = true;
        }

        public void onMediaDownloaded(C1484Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        private C1519i(Context context, NativeBannerAd nativeBannerAd, NativeMediationAdRequest nativeMediationAdRequest) {
            this.f6992a = new WeakReference<>(context);
            this.f6993b = nativeBannerAd;
            this.f6994c = nativeMediationAdRequest;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$j */
    private class C1522j implements AdListener, NativeAdListener {

        /* renamed from: a */
        private WeakReference<Context> f7000a;

        /* renamed from: b */
        private com.facebook.ads.NativeAd f7001b;

        /* renamed from: c */
        private NativeMediationAdRequest f7002c;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$j$a */
        class C1523a implements C1518h {

            /* renamed from: a */
            final /* synthetic */ C1525k f7004a;

            C1523a(C1525k kVar) {
                this.f7004a = kVar;
            }

            /* renamed from: a */
            public void mo11204a() {
                FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (UnifiedNativeAdMapper) this.f7004a);
            }

            /* renamed from: b */
            public void mo11205b(String str) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(108, str));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 108);
            }
        }

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$j$b */
        class C1524b implements C1518h {

            /* renamed from: a */
            final /* synthetic */ C1513d f7006a;

            C1524b(C1513d dVar) {
                this.f7006a = dVar;
            }

            /* renamed from: a */
            public void mo11204a() {
                FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (NativeAdMapper) this.f7006a);
            }

            /* renamed from: b */
            public void mo11205b(String str) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(108, str));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 108);
            }
        }

        /* synthetic */ C1522j(FacebookAdapter facebookAdapter, Context context, com.facebook.ads.NativeAd nativeAd, NativeMediationAdRequest nativeMediationAdRequest, C1510a aVar) {
            this(context, nativeAd, nativeMediationAdRequest);
        }

        public void onAdClicked(C1484Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1484Ad ad) {
            if (ad != this.f7001b) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(106, "Ad loaded is not a native ad."));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 106);
                return;
            }
            Context context = (Context) this.f7000a.get();
            if (context == null) {
                Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(107, "Failed to create ad options view, Context is null."));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 107);
                return;
            }
            NativeAdOptions nativeAdOptions = this.f7002c.getNativeAdOptions();
            if (this.f7002c.isUnifiedNativeAdRequested()) {
                C1525k kVar = new C1525k(this.f7001b, nativeAdOptions);
                kVar.mo11206d(context, new C1523a(kVar));
            } else if (this.f7002c.isAppInstallAdRequested()) {
                C1513d dVar = new C1513d(this.f7001b, nativeAdOptions);
                dVar.mo11198d(context, new C1524b(dVar));
            } else {
                Log.e(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(105, "App did not request Unified Native Ads"));
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, 105);
            }
        }

        public void onError(C1484Ad ad, AdError adError) {
            String createSdkError = FacebookMediationAdapter.createSdkError(adError);
            if (!TextUtils.isEmpty(adError.getErrorMessage())) {
                Log.w(FacebookMediationAdapter.TAG, createSdkError);
            }
            FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onLoggingImpression(C1484Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            boolean unused = FacebookAdapter.this.mIsImpressionRecorded = true;
        }

        public void onMediaDownloaded(C1484Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        private C1522j(Context context, com.facebook.ads.NativeAd nativeAd, NativeMediationAdRequest nativeMediationAdRequest) {
            this.f7000a = new WeakReference<>(context);
            this.f7001b = nativeAd;
            this.f7002c = nativeMediationAdRequest;
        }
    }

    /* access modifiers changed from: private */
    public void buildAdRequest(MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest == null) {
            return;
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() == 1) {
            AdSettings.setMixedAudience(true);
        } else if (mediationAdRequest.taggedForChildDirectedTreatment() == 0) {
            AdSettings.setMixedAudience(false);
        }
    }

    /* access modifiers changed from: private */
    public void createAndLoadInterstitial(Context context, String str, MediationAdRequest mediationAdRequest) {
        this.mInterstitialAd = new InterstitialAd(context, str);
        buildAdRequest(mediationAdRequest);
        InterstitialAd interstitialAd = this.mInterstitialAd;
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(new C1517g(this, (C1510a) null)).build());
    }

    /* access modifiers changed from: private */
    public void createAndLoadNativeAd(Context context, String str, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle) {
        if (bundle != null) {
            this.isNativeBanner = bundle.getBoolean(FacebookExtras.NATIVE_BANNER);
        }
        if (this.isNativeBanner) {
            this.mNativeBannerAd = new NativeBannerAd(context, str);
            buildAdRequest(nativeMediationAdRequest);
            NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
            nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withAdListener(new C1519i(this, context, this.mNativeBannerAd, nativeMediationAdRequest, (C1510a) null)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
            return;
        }
        this.mMediaView = new MediaView(context);
        this.mNativeAd = new com.facebook.ads.NativeAd(context, str);
        buildAdRequest(nativeMediationAdRequest);
        com.facebook.ads.NativeAd nativeAd = this.mNativeAd;
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new C1522j(this, context, this.mNativeAd, nativeMediationAdRequest, (C1510a) null)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
    }

    @Nullable
    private AdSize getAdSize(@NonNull Context context, @NonNull com.google.android.gms.ads.AdSize adSize) {
        int width = adSize.getWidth();
        if (width < 0) {
            width = Math.round(((float) adSize.getWidthInPixels(context)) / context.getResources().getDisplayMetrics().density);
        }
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(0, new com.google.android.gms.ads.AdSize(width, 50));
        arrayList.add(1, new com.google.android.gms.ads.AdSize(width, 90));
        arrayList.add(2, new com.google.android.gms.ads.AdSize(width, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        String str = FacebookMediationAdapter.TAG;
        Log.i(str, "Potential ad sizes: " + arrayList.toString());
        com.google.android.gms.ads.AdSize findClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (findClosestSize == null) {
            return null;
        }
        Log.i(str, "Found closest ad size: " + findClosestSize.toString());
        int height = findClosestSize.getHeight();
        AdSize adSize2 = AdSize.BANNER_HEIGHT_50;
        if (height == adSize2.getHeight()) {
            return adSize2;
        }
        AdSize adSize3 = AdSize.BANNER_HEIGHT_90;
        if (height == adSize3.getHeight()) {
            return adSize3;
        }
        AdSize adSize4 = AdSize.RECTANGLE_HEIGHT_250;
        if (height == adSize4.getHeight()) {
            return adSize4;
        }
        return null;
    }

    public View getBannerView() {
        return this.mWrappedAdView;
    }

    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        com.facebook.ads.NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.mNativeAd.destroy();
        }
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.destroy();
        }
        NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
            this.mNativeBannerAd.destroy();
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, com.google.android.gms.ads.AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mBannerListener = mediationBannerListener;
        String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(101, "Failed to request ad: placementID is null or empty."));
            this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, 101);
            return;
        }
        AdSize adSize2 = getAdSize(context, adSize);
        if (adSize2 == null) {
            String str = FacebookMediationAdapter.TAG;
            Log.w(str, FacebookMediationAdapter.createAdapterError(102, "There is no matching Facebook ad size for Google ad size: " + adSize.toString()));
            this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, 102);
            return;
        }
        C1532a.m4999a().mo11224b(context, placementID, new C1510a(context, placementID, adSize2, mediationAdRequest, adSize));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mInterstitialListener = mediationInterstitialListener;
        String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty."));
            this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, 101);
            return;
        }
        C1532a.m4999a().mo11224b(context, placementID, new C1511b(context, placementID, mediationAdRequest));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.mNativeListener = mediationNativeListener;
        String placementID = FacebookMediationAdapter.getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty."));
            this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, 101);
            return;
        }
        boolean z = nativeMediationAdRequest.isAppInstallAdRequested() && nativeMediationAdRequest.isContentAdRequested();
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested() || z) {
            C1532a.m4999a().mo11224b(context, placementID, new C1512c(context, placementID, nativeMediationAdRequest, bundle2));
            return;
        }
        Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(105, "Either unified native ads or both app install and content ads must be requested."));
        this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, 105);
    }

    public void showInterstitial() {
        this.showInterstitialCalled.set(true);
        if (!this.mInterstitialAd.show()) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.createAdapterError(110, "Failed to present interstitial ad."));
            MediationInterstitialListener mediationInterstitialListener = this.mInterstitialListener;
            if (mediationInterstitialListener != null) {
                mediationInterstitialListener.onAdOpened(this);
                this.mInterstitialListener.onAdClosed(this);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$d */
    class C1513d extends NativeAppInstallAdMapper {

        /* renamed from: a */
        private com.facebook.ads.NativeAd f6984a;

        /* renamed from: b */
        private NativeBannerAd f6985b;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$d$a */
        class C1514a implements MediaViewListener {
            C1514a() {
            }

            public void onComplete(MediaView mediaView) {
                if (FacebookAdapter.this.mNativeListener != null) {
                    FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
                }
            }

            public void onEnterFullscreen(MediaView mediaView) {
            }

            public void onExitFullscreen(MediaView mediaView) {
            }

            public void onFullscreenBackground(MediaView mediaView) {
            }

            public void onFullscreenForeground(MediaView mediaView) {
            }

            public void onPause(MediaView mediaView) {
            }

            public void onPlay(MediaView mediaView) {
            }

            public void onVolumeChange(MediaView mediaView, float f) {
            }
        }

        public C1513d(com.facebook.ads.NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.f6984a = nativeAd;
        }

        /* renamed from: a */
        private boolean m4972a(com.facebook.ads.NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        /* renamed from: b */
        private boolean m4973b(NativeBannerAd nativeBannerAd) {
            return (nativeBannerAd.getAdHeadline() == null || nativeBannerAd.getAdBodyText() == null || nativeBannerAd.getAdIcon() == null || nativeBannerAd.getAdCallToAction() == null) ? false : true;
        }

        /* renamed from: c */
        private Double m4974c(NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }

        /* renamed from: d */
        public void mo11198d(Context context, C1518h hVar) {
            AdOptionsView adOptionsView;
            if (FacebookAdapter.this.isNativeBanner) {
                if (!m4973b(this.f6985b)) {
                    Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    hVar.mo11205b("Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    return;
                }
                setHeadline(this.f6985b.getAdHeadline());
                setBody(this.f6985b.getAdBodyText());
                if (this.f6985b.getPreloadedIconViewDrawable() != null) {
                    setIcon(new C1516f(FacebookAdapter.this, this.f6985b.getPreloadedIconViewDrawable()));
                } else if (this.f6985b.getAdIcon() == null) {
                    setIcon(new C1516f(FacebookAdapter.this));
                } else {
                    setIcon(new C1516f(FacebookAdapter.this, Uri.parse(this.f6985b.getAdIcon().getUrl())));
                }
                setCallToAction(this.f6985b.getAdCallToAction());
                Bundle bundle = new Bundle();
                bundle.putCharSequence(FacebookAdapter.KEY_ID, this.f6985b.getId());
                bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f6985b.getAdSocialContext());
                setExtras(bundle);
            } else if (!m4972a(this.f6984a)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                hVar.mo11205b("Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                return;
            } else {
                setHeadline(this.f6984a.getAdHeadline());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1516f(FacebookAdapter.this, Uri.parse(this.f6984a.getAdCoverImage().toString())));
                setImages(arrayList);
                setBody(this.f6984a.getAdBodyText());
                if (this.f6984a.getAdIcon() == null) {
                    setIcon(new C1516f(FacebookAdapter.this));
                } else {
                    setIcon(new C1516f(FacebookAdapter.this, Uri.parse(this.f6984a.getAdIcon().getUrl())));
                }
                setCallToAction(this.f6984a.getAdCallToAction());
                FacebookAdapter.this.mMediaView.setListener(new C1514a());
                setMediaView(FacebookAdapter.this.mMediaView);
                setHasVideoContent(true);
                Double c = m4974c(this.f6984a.getAdStarRating());
                if (c != null) {
                    setStarRating(c.doubleValue());
                }
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence(FacebookAdapter.KEY_ID, this.f6984a.getId());
                bundle2.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f6984a.getAdSocialContext());
                setExtras(bundle2);
            }
            NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            if (FacebookAdapter.this.isNativeBanner) {
                adOptionsView = new AdOptionsView(context, this.f6985b, nativeAdLayout);
            } else {
                adOptionsView = new AdOptionsView(context, this.f6984a, nativeAdLayout);
            }
            setAdChoicesContent(adOptionsView);
            hVar.mo11204a();
        }

        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList(map.values());
            ImageView imageView = (ImageView) map.get(UnifiedNativeAdAssetNames.ASSET_ICON);
            if (imageView == null) {
                imageView = (ImageView) map.get(NativeAppInstallAd.ASSET_ICON);
            }
            if (FacebookAdapter.this.isNativeBanner) {
                this.f6985b.registerViewForInteraction(view, imageView);
            } else {
                this.f6984a.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, (List<View>) arrayList);
            }
        }

        public void untrackView(View view) {
            super.untrackView(view);
        }

        public C1513d(NativeBannerAd nativeBannerAd, NativeAdOptions nativeAdOptions) {
            this.f6985b = nativeBannerAd;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$k */
    class C1525k extends UnifiedNativeAdMapper {

        /* renamed from: a */
        private com.facebook.ads.NativeAd f7008a;

        /* renamed from: b */
        private NativeBannerAd f7009b;

        /* renamed from: com.google.ads.mediation.facebook.FacebookAdapter$k$a */
        class C1526a implements MediaViewListener {
            C1526a() {
            }

            public void onComplete(MediaView mediaView) {
                if (FacebookAdapter.this.mNativeListener != null) {
                    FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
                }
            }

            public void onEnterFullscreen(MediaView mediaView) {
            }

            public void onExitFullscreen(MediaView mediaView) {
            }

            public void onFullscreenBackground(MediaView mediaView) {
            }

            public void onFullscreenForeground(MediaView mediaView) {
            }

            public void onPause(MediaView mediaView) {
            }

            public void onPlay(MediaView mediaView) {
            }

            public void onVolumeChange(MediaView mediaView, float f) {
            }
        }

        public C1525k(com.facebook.ads.NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.f7008a = nativeAd;
        }

        /* renamed from: a */
        private boolean m4986a(NativeBannerAd nativeBannerAd) {
            return (nativeBannerAd.getAdHeadline() == null || nativeBannerAd.getAdBodyText() == null || nativeBannerAd.getAdIcon() == null || nativeBannerAd.getAdCallToAction() == null) ? false : true;
        }

        /* renamed from: b */
        private boolean m4987b(com.facebook.ads.NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        /* renamed from: c */
        private Double m4988c(NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }

        /* renamed from: d */
        public void mo11206d(Context context, C1518h hVar) {
            AdOptionsView adOptionsView;
            if (FacebookAdapter.this.isNativeBanner) {
                if (!m4986a(this.f7009b)) {
                    Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    hVar.mo11205b("Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    return;
                }
                setHeadline(this.f7009b.getAdHeadline());
                setBody(this.f7009b.getAdBodyText());
                if (this.f7009b.getPreloadedIconViewDrawable() != null) {
                    setIcon(new C1516f(FacebookAdapter.this, this.f7009b.getPreloadedIconViewDrawable()));
                } else if (this.f7009b.getAdIcon() == null) {
                    setIcon(new C1516f(FacebookAdapter.this));
                } else {
                    setIcon(new C1516f(FacebookAdapter.this, Uri.parse(this.f7009b.getAdIcon().getUrl())));
                }
                setCallToAction(this.f7009b.getAdCallToAction());
                setAdvertiser(this.f7009b.getAdvertiserName());
                Bundle bundle = new Bundle();
                bundle.putCharSequence(FacebookAdapter.KEY_ID, this.f7009b.getId());
                bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f7009b.getAdSocialContext());
                setExtras(bundle);
            } else if (!m4987b(this.f7008a)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Ad format.");
                hVar.mo11205b("Ad from Facebook doesn't have all assets required for the Native Ad format.");
                return;
            } else {
                setHeadline(this.f7008a.getAdHeadline());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1516f(FacebookAdapter.this, Uri.parse(this.f7008a.getAdCoverImage().toString())));
                setImages(arrayList);
                setBody(this.f7008a.getAdBodyText());
                if (this.f7008a.getPreloadedIconViewDrawable() != null) {
                    setIcon(new C1516f(FacebookAdapter.this, this.f7008a.getPreloadedIconViewDrawable()));
                } else if (this.f7008a.getAdIcon() == null) {
                    setIcon(new C1516f(FacebookAdapter.this));
                } else {
                    setIcon(new C1516f(FacebookAdapter.this, Uri.parse(this.f7008a.getAdIcon().getUrl())));
                }
                setCallToAction(this.f7008a.getAdCallToAction());
                setAdvertiser(this.f7008a.getAdvertiserName());
                FacebookAdapter.this.mMediaView.setListener(new C1526a());
                setMediaView(FacebookAdapter.this.mMediaView);
                setHasVideoContent(true);
                Double c = m4988c(this.f7008a.getAdStarRating());
                if (c != null) {
                    setStarRating(c);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence(FacebookAdapter.KEY_ID, this.f7008a.getId());
                bundle2.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f7008a.getAdSocialContext());
                setExtras(bundle2);
            }
            NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            if (FacebookAdapter.this.isNativeBanner) {
                adOptionsView = new AdOptionsView(context, this.f7009b, nativeAdLayout);
            } else {
                adOptionsView = new AdOptionsView(context, this.f7008a, nativeAdLayout);
            }
            setAdChoicesContent(adOptionsView);
            hVar.mo11204a();
        }

        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList();
            ImageView imageView = null;
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(next.getValue());
                if (((String) next.getKey()).equals(NativeAppInstallAd.ASSET_ICON) || ((String) next.getKey()).equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                    imageView = (ImageView) next.getValue();
                }
            }
            if (FacebookAdapter.this.isNativeBanner) {
                this.f7009b.registerViewForInteraction(view, imageView);
            } else {
                this.f7008a.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, (List<View>) arrayList);
            }
        }

        public void untrackView(View view) {
            NativeBannerAd nativeBannerAd;
            if (!FacebookAdapter.this.isNativeBanner || (nativeBannerAd = this.f7009b) == null) {
                com.facebook.ads.NativeAd nativeAd = this.f7008a;
                if (nativeAd != null) {
                    nativeAd.unregisterView();
                }
            } else {
                nativeBannerAd.unregisterView();
            }
            super.untrackView(view);
        }

        public C1525k(NativeBannerAd nativeBannerAd, NativeAdOptions nativeAdOptions) {
            this.f7009b = nativeBannerAd;
        }
    }
}
