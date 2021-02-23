package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaza;

@KeepName
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: a */
    private View f6961a;
    @VisibleForTesting

    /* renamed from: b */
    private CustomEventBanner f6962b;
    @VisibleForTesting

    /* renamed from: c */
    private CustomEventInterstitial f6963c;

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    static final class C1508a implements CustomEventBannerListener {

        /* renamed from: a */
        private final CustomEventAdapter f6964a;

        /* renamed from: b */
        private final MediationBannerListener f6965b;

        public C1508a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f6964a = customEventAdapter;
            this.f6965b = mediationBannerListener;
        }

        public final void onClick() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6965b.onClick(this.f6964a);
        }

        public final void onDismissScreen() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6965b.onDismissScreen(this.f6964a);
        }

        public final void onFailedToReceiveAd() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6965b.onFailedToReceiveAd(this.f6964a, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6965b.onLeaveApplication(this.f6964a);
        }

        public final void onPresentScreen() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6965b.onPresentScreen(this.f6964a);
        }

        public final void onReceivedAd(View view) {
            zzaza.zzeb("Custom event adapter called onReceivedAd.");
            this.f6964a.m4963a(view);
            this.f6965b.onReceivedAd(this.f6964a);
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    class C1509b implements CustomEventInterstitialListener {

        /* renamed from: a */
        private final CustomEventAdapter f6966a;

        /* renamed from: b */
        private final MediationInterstitialListener f6967b;

        public C1509b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f6966a = customEventAdapter;
            this.f6967b = mediationInterstitialListener;
        }

        public final void onDismissScreen() {
            zzaza.zzeb("Custom event adapter called onDismissScreen.");
            this.f6967b.onDismissScreen(this.f6966a);
        }

        public final void onFailedToReceiveAd() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.f6967b.onFailedToReceiveAd(this.f6966a, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzaza.zzeb("Custom event adapter called onLeaveApplication.");
            this.f6967b.onLeaveApplication(this.f6966a);
        }

        public final void onPresentScreen() {
            zzaza.zzeb("Custom event adapter called onPresentScreen.");
            this.f6967b.onPresentScreen(this.f6966a);
        }

        public final void onReceivedAd() {
            zzaza.zzeb("Custom event adapter called onReceivedAd.");
            this.f6967b.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m4963a(View view) {
        this.f6961a = view;
    }

    /* renamed from: c */
    private static <T> T m4965c(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzaza.zzfa(sb.toString());
            return null;
        }
    }

    public final void destroy() {
        CustomEventBanner customEventBanner = this.f6962b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f6963c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.f6961a;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventBanner customEventBanner = (CustomEventBanner) m4965c(customEventServerParameters.className);
        this.f6962b = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.f6962b.requestBannerAd(new C1508a(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) m4965c(customEventServerParameters.className);
        this.f6963c = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.f6963c.requestInterstitialAd(new C1509b(this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }

    public final void showInterstitial() {
        this.f6963c.showInterstitial();
    }
}
