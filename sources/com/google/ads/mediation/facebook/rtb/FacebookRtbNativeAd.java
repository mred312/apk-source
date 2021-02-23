package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.C1484Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {

    /* renamed from: a */
    private MediationNativeAdConfiguration f7046a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> f7047b;

    /* renamed from: c */
    private NativeAdBase f7048c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MediationNativeAdCallback f7049d;

    /* renamed from: e */
    private MediaView f7050e;

    /* renamed from: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd$a */
    class C1534a implements MediaViewListener {
        C1534a() {
        }

        public void onComplete(MediaView mediaView) {
            if (FacebookRtbNativeAd.this.f7049d != null) {
                FacebookRtbNativeAd.this.f7049d.onVideoComplete();
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

    /* renamed from: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd$b */
    private class C1535b extends NativeAd.Image {

        /* renamed from: a */
        private Drawable f7052a;

        /* renamed from: b */
        private Uri f7053b;

        public C1535b(FacebookRtbNativeAd facebookRtbNativeAd) {
        }

        public Drawable getDrawable() {
            return this.f7052a;
        }

        public double getScale() {
            return 1.0d;
        }

        public Uri getUri() {
            return this.f7053b;
        }

        public C1535b(FacebookRtbNativeAd facebookRtbNativeAd, Uri uri) {
            this.f7053b = uri;
        }

        public C1535b(FacebookRtbNativeAd facebookRtbNativeAd, Drawable drawable) {
            this.f7052a = drawable;
        }
    }

    /* renamed from: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd$c */
    private interface C1536c {
        /* renamed from: a */
        void mo11232a();

        /* renamed from: b */
        void mo11233b(String str);
    }

    /* renamed from: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd$d */
    private class C1537d implements AdListener, NativeAdListener {

        /* renamed from: a */
        private WeakReference<Context> f7054a;

        /* renamed from: b */
        private NativeAdBase f7055b;

        /* renamed from: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd$d$a */
        class C1538a implements C1536c {
            C1538a() {
            }

            /* renamed from: a */
            public void mo11232a() {
                FacebookRtbNativeAd facebookRtbNativeAd = FacebookRtbNativeAd.this;
                MediationNativeAdCallback unused = facebookRtbNativeAd.f7049d = (MediationNativeAdCallback) facebookRtbNativeAd.f7047b.onSuccess(FacebookRtbNativeAd.this);
            }

            /* renamed from: b */
            public void mo11233b(String str) {
                String createAdapterError = FacebookMediationAdapter.createAdapterError(108, str);
                Log.w(FacebookMediationAdapter.TAG, createAdapterError);
                FacebookRtbNativeAd.this.f7047b.onFailure(createAdapterError);
            }
        }

        C1537d(Context context, NativeAdBase nativeAdBase) {
            this.f7055b = nativeAdBase;
            this.f7054a = new WeakReference<>(context);
        }

        public void onAdClicked(C1484Ad ad) {
            FacebookRtbNativeAd.this.f7049d.onAdOpened();
            FacebookRtbNativeAd.this.f7049d.onAdLeftApplication();
        }

        public void onAdLoaded(C1484Ad ad) {
            if (ad != this.f7055b) {
                String createAdapterError = FacebookMediationAdapter.createAdapterError(106, "Ad Loaded is not a Native Ad.");
                Log.e(FacebookMediationAdapter.TAG, createAdapterError);
                FacebookRtbNativeAd.this.f7047b.onFailure(createAdapterError);
                return;
            }
            Context context = (Context) this.f7054a.get();
            if (context == null) {
                String createAdapterError2 = FacebookMediationAdapter.createAdapterError(107, "Context is null.");
                Log.e(FacebookMediationAdapter.TAG, createAdapterError2);
                FacebookRtbNativeAd.this.f7047b.onFailure(createAdapterError2);
                return;
            }
            FacebookRtbNativeAd.this.mapNativeAd(context, new C1538a());
        }

        public void onError(C1484Ad ad, AdError adError) {
            String createSdkError = FacebookMediationAdapter.createSdkError(adError);
            Log.w(FacebookMediationAdapter.TAG, createSdkError);
            FacebookRtbNativeAd.this.f7047b.onFailure(createSdkError);
        }

        public void onLoggingImpression(C1484Ad ad) {
        }

        public void onMediaDownloaded(C1484Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }

    public FacebookRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.f7047b = mediationAdLoadCallback;
        this.f7046a = mediationNativeAdConfiguration;
    }

    /* renamed from: d */
    private boolean m5007d(NativeAdBase nativeAdBase) {
        boolean z = (nativeAdBase.getAdHeadline() == null || nativeAdBase.getAdBodyText() == null || nativeAdBase.getAdIcon() == null || nativeAdBase.getAdCallToAction() == null) ? false : true;
        if (nativeAdBase instanceof NativeBannerAd) {
            return z;
        }
        if (!z || nativeAdBase.getAdCoverImage() == null || this.f7050e == null) {
            return false;
        }
        return true;
    }

    public void mapNativeAd(Context context, C1536c cVar) {
        if (!m5007d(this.f7048c)) {
            Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the app install format.");
            cVar.mo11233b("Ad from Facebook doesn't have all assets required for the app install format.");
            return;
        }
        setHeadline(this.f7048c.getAdHeadline());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1535b(this));
        setImages(arrayList);
        setBody(this.f7048c.getAdBodyText());
        if (this.f7048c.getPreloadedIconViewDrawable() != null) {
            setIcon(new C1535b(this, this.f7048c.getPreloadedIconViewDrawable()));
        } else if (this.f7048c.getAdIcon() == null) {
            setIcon(new C1535b(this));
        } else {
            setIcon(new C1535b(this, Uri.parse(this.f7048c.getAdIcon().getUrl())));
        }
        setCallToAction(this.f7048c.getAdCallToAction());
        setAdvertiser(this.f7048c.getAdvertiserName());
        this.f7050e.setListener(new C1534a());
        setHasVideoContent(true);
        setMediaView(this.f7050e);
        setStarRating((Double) null);
        Bundle bundle = new Bundle();
        bundle.putCharSequence(FacebookAdapter.KEY_ID, this.f7048c.getId());
        bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f7048c.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.f7048c, (NativeAdLayout) null));
        cVar.mo11232a();
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.f7046a.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String createAdapterError = FacebookMediationAdapter.createAdapterError(101, "Failed to request ad, placementID is null or empty.");
            Log.e(FacebookMediationAdapter.TAG, createAdapterError);
            this.f7047b.onFailure(createAdapterError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.f7046a);
        this.f7050e = new MediaView(this.f7046a.getContext());
        try {
            this.f7048c = NativeAdBase.fromBidPayload(this.f7046a.getContext(), placementID, this.f7046a.getBidResponse());
            if (!TextUtils.isEmpty(this.f7046a.getWatermark())) {
                this.f7048c.setExtraHints(new ExtraHints.Builder().mediationData(this.f7046a.getWatermark()).build());
            }
            NativeAdBase nativeAdBase = this.f7048c;
            nativeAdBase.loadAd(nativeAdBase.buildLoadAdConfig().withAdListener(new C1537d(this.f7046a.getContext(), this.f7048c)).withBid(this.f7046a.getBidResponse()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e) {
            String createAdapterError2 = FacebookMediationAdapter.createAdapterError(109, "Failed to create native ad from bid payload: " + e.getMessage());
            Log.w(FacebookMediationAdapter.TAG, createAdapterError2);
            this.f7047b.onFailure(createAdapterError2);
        }
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList(map.values());
        ImageView imageView = (ImageView) map.get(UnifiedNativeAdAssetNames.ASSET_ICON);
        NativeAdBase nativeAdBase = this.f7048c;
        if (nativeAdBase instanceof com.facebook.ads.NativeAd) {
            ((com.facebook.ads.NativeAd) nativeAdBase).registerViewForInteraction(view, this.f7050e, imageView, (List<View>) arrayList);
        } else if (nativeAdBase instanceof NativeBannerAd) {
            ((NativeBannerAd) nativeAdBase).registerViewForInteraction(view, imageView, (List<View>) arrayList);
        }
    }

    public void untrackView(View view) {
        NativeAdBase nativeAdBase = this.f7048c;
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
        }
        super.untrackView(view);
    }
}
