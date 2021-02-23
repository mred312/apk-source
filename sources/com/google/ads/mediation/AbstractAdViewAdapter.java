package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzys;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbgj {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmf;
    private InterstitialAd zzmg;
    private AdLoader zzmh;
    private Context zzmi;
    /* access modifiers changed from: private */
    public InterstitialAd zzmj;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzmk;
    @VisibleForTesting
    private final RewardedVideoAdListener zzml = new C1507b(this);

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$a */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static class C1500a extends NativeContentAdMapper {

        /* renamed from: a */
        private final NativeContentAd f6945a;

        public C1500a(NativeContentAd nativeContentAd) {
            this.f6945a = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f6945a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.f6945a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$b */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static class C1501b extends NativeAppInstallAdMapper {

        /* renamed from: a */
        private final NativeAppInstallAd f6946a;

        public C1501b(NativeAppInstallAd nativeAppInstallAd) {
            this.f6946a = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f6946a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.f6946a);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$c */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static final class C1502c extends AdListener implements AppEventListener, zzva {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f6947a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationBannerListener f6948b;

        public C1502c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f6947a = abstractAdViewAdapter;
            this.f6948b = mediationBannerListener;
        }

        public final void onAdClicked() {
            this.f6948b.onAdClicked(this.f6947a);
        }

        public final void onAdClosed() {
            this.f6948b.onAdClosed(this.f6947a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f6948b.onAdFailedToLoad((MediationBannerAdapter) this.f6947a, i);
        }

        public final void onAdLeftApplication() {
            this.f6948b.onAdLeftApplication(this.f6947a);
        }

        public final void onAdLoaded() {
            this.f6948b.onAdLoaded(this.f6947a);
        }

        public final void onAdOpened() {
            this.f6948b.onAdOpened(this.f6947a);
        }

        public final void onAppEvent(String str, String str2) {
            this.f6948b.zza(this.f6947a, str, str2);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$d */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static class C1503d extends UnifiedNativeAdMapper {

        /* renamed from: a */
        private final UnifiedNativeAd f6949a;

        public C1503d(UnifiedNativeAd unifiedNativeAd) {
            this.f6949a = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzn(unifiedNativeAd.zzjw());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.f6949a);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f6949a);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$e */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static final class C1504e extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f6950a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationNativeListener f6951b;

        public C1504e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f6950a = abstractAdViewAdapter;
            this.f6951b = mediationNativeListener;
        }

        public final void onAdClicked() {
            this.f6951b.onAdClicked(this.f6950a);
        }

        public final void onAdClosed() {
            this.f6951b.onAdClosed(this.f6950a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f6951b.onAdFailedToLoad((MediationNativeAdapter) this.f6950a, i);
        }

        public final void onAdImpression() {
            this.f6951b.onAdImpression(this.f6950a);
        }

        public final void onAdLeftApplication() {
            this.f6951b.onAdLeftApplication(this.f6950a);
        }

        public final void onAdLoaded() {
        }

        public final void onAdOpened() {
            this.f6951b.onAdOpened(this.f6950a);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f6951b.onAdLoaded((MediationNativeAdapter) this.f6950a, (NativeAdMapper) new C1501b(nativeAppInstallAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f6951b.onAdLoaded((MediationNativeAdapter) this.f6950a, (NativeAdMapper) new C1500a(nativeContentAd));
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.f6951b.zza(this.f6950a, nativeCustomTemplateAd, str);
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.f6951b.zza(this.f6950a, nativeCustomTemplateAd);
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.f6951b.onAdLoaded((MediationNativeAdapter) this.f6950a, (UnifiedNativeAdMapper) new C1503d(unifiedNativeAd));
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$f */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static final class C1505f extends AdListener implements zzva {
        @VisibleForTesting

        /* renamed from: a */
        private final AbstractAdViewAdapter f6952a;
        @VisibleForTesting

        /* renamed from: b */
        private final MediationInterstitialListener f6953b;

        public C1505f(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f6952a = abstractAdViewAdapter;
            this.f6953b = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            this.f6953b.onAdClicked(this.f6952a);
        }

        public final void onAdClosed() {
            this.f6953b.onAdClosed(this.f6952a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f6953b.onAdFailedToLoad((MediationInterstitialAdapter) this.f6952a, i);
        }

        public final void onAdLeftApplication() {
            this.f6953b.onAdLeftApplication(this.f6952a);
        }

        public final void onAdLoaded() {
            this.f6953b.onAdLoaded(this.f6952a);
        }

        public final void onAdOpened() {
            this.f6953b.onAdOpened(this.f6952a);
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzwq.zzqa();
            builder.addTestDevice(zzayr.zzbn(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public View getBannerView() {
        return this.zzmf;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdw(1).zzaed();
    }

    public zzys getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmf;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdw();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmi = context.getApplicationContext();
        this.zzmk = mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzmk != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmi;
        if (context == null || this.zzmk == null) {
            zzaza.zzey("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzmj = interstitialAd;
        interstitialAd.zzd(true);
        this.zzmj.setAdUnitId(getAdUnitId(bundle));
        this.zzmj.setRewardedVideoAdListener(this.zzml);
        this.zzmj.setAdMetadataListener(new C1506a(this));
        this.zzmj.loadAd(zza(this.zzmi, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.destroy();
            this.zzmf = null;
        }
        if (this.zzmg != null) {
            this.zzmg = null;
        }
        if (this.zzmh != null) {
            this.zzmh = null;
        }
        if (this.zzmj != null) {
            this.zzmj = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmg;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmj;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    public void onPause() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.zzmf = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmf.setAdUnitId(getAdUnitId(bundle));
        this.zzmf.setAdListener(new C1502c(this, mediationBannerListener));
        this.zzmf.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzmg = interstitialAd;
        interstitialAd.setAdUnitId(getAdUnitId(bundle));
        this.zzmg.setAdListener(new C1505f(this, mediationInterstitialListener));
        this.zzmg.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        C1504e eVar = new C1504e(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString("pubid")).withAdListener(eVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(eVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(eVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(eVar);
        }
        if (nativeMediationAdRequest.zzuu()) {
            for (String next : nativeMediationAdRequest.zzuv().keySet()) {
                withAdListener.forCustomTemplateAd(next, eVar, nativeMediationAdRequest.zzuv().get(next).booleanValue() ? eVar : null);
            }
        }
        AdLoader build = withAdListener.build();
        this.zzmh = build;
        build.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzmg.show();
    }

    public void showVideo() {
        this.zzmj.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
