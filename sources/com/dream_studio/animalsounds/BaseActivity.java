package com.dream_studio.animalsounds;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.medio.catchexception.CatchException;
import com.medio.locale.LocaleManager;
import com.medio.myutilities.Utilities;
import java.util.Locale;
import java.util.Random;

public class BaseActivity extends Activity {

    /* renamed from: l */
    private static final int f6527l = Color.parseColor("#44000000");

    /* renamed from: m */
    private static String f6528m = "nonPersonalizedAds";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AdView f6529a = null;
    protected boolean adViewVisible = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f6530b = false;

    /* renamed from: c */
    private Toast f6531c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AdLoader f6532d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6533e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public UnifiedNativeAdView f6534f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public UnifiedNativeAd f6535g = null;

    /* renamed from: h */
    private boolean f6536h;

    /* renamed from: i */
    private boolean f6537i = false;
    protected boolean interstitAdLoadFailed = false;

    /* renamed from: j */
    private boolean f6538j = false;

    /* renamed from: k */
    private BroadcastReceiver f6539k = new C1367a();
    protected boolean lock = false;
    protected long mBannerIdChoice;
    protected boolean mChangeSmartBannerToBanner;
    protected boolean mChangeSmartBannerToNativeBanner;
    protected Context mContext = null;
    protected String mCountry = "";
    protected DrawerLayoutEdgeToggle mDrawerToggle = null;
    protected InterstitialAd mInterstitial = null;
    protected String mLang = "";
    protected Dialog mModelessDialog = null;
    protected boolean mRemoveAds = false;
    protected boolean mShowAdaptiveBanner;
    protected boolean mShowBannerAds;
    protected boolean mShowQuitInterstitial;
    protected boolean mShowTransitionInterstitial;
    protected int mSwitchedPosition = 0;
    protected VolumeControl mVolumeControl = null;
    protected DisplayMetrics metrics = null;

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$a */
    class C1367a extends BroadcastReceiver {
        C1367a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && Utilities.checkNetworkConnection(context)) {
                if (BaseActivity.this.f6529a != null && BaseActivity.this.f6530b) {
                    try {
                        BaseActivity.this.f6529a.loadAd(BaseActivity.this.m4797x());
                    } catch (Exception unused) {
                        boolean unused2 = BaseActivity.this.f6530b = true;
                    }
                }
                if (BaseActivity.this.f6532d != null && BaseActivity.this.f6533e) {
                    try {
                        BaseActivity.this.f6532d.loadAd(BaseActivity.this.m4797x());
                    } catch (Exception unused3) {
                        boolean unused4 = BaseActivity.this.f6533e = true;
                    }
                }
                BaseActivity baseActivity = BaseActivity.this;
                if (baseActivity.mInterstitial != null && baseActivity.interstitAdLoadFailed) {
                    baseActivity.loadInterstitial();
                }
            }
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                BaseActivity.this.setMuteButton();
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$b */
    class C1368b extends AdListener {
        C1368b() {
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            BaseActivity.this.interstitAdLoadFailed = true;
        }

        public void onAdLoaded() {
            BaseActivity.this.interstitAdLoadFailed = false;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$c */
    class C1369c extends AdListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6542a;

        C1369c(RelativeLayout relativeLayout) {
            this.f6542a = relativeLayout;
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (!BaseActivity.this.f6530b) {
                BaseActivity.this.m4795v(this.f6542a);
            }
            boolean unused = BaseActivity.this.f6530b = true;
        }

        public void onAdLoaded() {
            boolean unused = BaseActivity.this.f6530b = false;
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.m4798y(this.f6542a, baseActivity.f6529a);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$d */
    class C1370d extends AdListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6544a;

        C1370d(RelativeLayout relativeLayout) {
            this.f6544a = relativeLayout;
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            BaseActivity baseActivity = BaseActivity.this;
            if (baseActivity.mShowAdaptiveBanner) {
                baseActivity.m4794u(this.f6544a);
            } else if (!baseActivity.f6530b) {
                BaseActivity.this.m4794u(this.f6544a);
            }
            boolean unused = BaseActivity.this.f6530b = true;
        }

        public void onAdLoaded() {
            boolean unused = BaseActivity.this.f6530b = false;
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.m4798y(this.f6544a, baseActivity.f6529a);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$e */
    class C1371e extends AdListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6546a;

        C1371e(RelativeLayout relativeLayout) {
            this.f6546a = relativeLayout;
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            BaseActivity.this.m4796w(this.f6546a);
            boolean unused = BaseActivity.this.f6530b = true;
        }

        public void onAdLoaded() {
            boolean unused = BaseActivity.this.f6530b = false;
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.m4798y(this.f6546a, baseActivity.f6529a);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$f */
    class C1372f extends AdListener {
        C1372f() {
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Log.e("BaseActivity", "The native ad failed to load");
            boolean unused = BaseActivity.this.f6533e = true;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BaseActivity$g */
    class C1373g implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6549a;

        C1373g(RelativeLayout relativeLayout) {
            this.f6549a = relativeLayout;
        }

        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            if (BaseActivity.this.f6535g != null) {
                BaseActivity.this.f6535g.destroy();
            }
            if (BaseActivity.this.isFinishing()) {
                unifiedNativeAd.destroy();
                return;
            }
            UnifiedNativeAd unused = BaseActivity.this.f6535g = unifiedNativeAd;
            UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) BaseActivity.this.getLayoutInflater().inflate(C1441R.layout.unified_nativead_banner, (ViewGroup) null);
            BaseActivity.this.registerNativeAdView(unifiedNativeAdView);
            BaseActivity.this.populateNativeAdView(unifiedNativeAd, unifiedNativeAdView);
            UnifiedNativeAdView unused2 = BaseActivity.this.f6534f = unifiedNativeAdView;
            BaseActivity.this.m4798y(this.f6549a, unifiedNativeAdView);
            boolean unused3 = BaseActivity.this.f6533e = false;
        }
    }

    public static boolean getNonPersonalizationAdsStatus(Context context) {
        return context.getApplicationContext().getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getBoolean(f6528m, false);
    }

    /* renamed from: o */
    private void m4789o(RelativeLayout relativeLayout) {
        try {
            AdView adView = this.f6529a;
            if (adView != null) {
                adView.removeAllViews();
                this.f6529a.pause();
                this.f6529a.destroy();
                this.f6529a = null;
            }
        } catch (Exception unused) {
            this.f6529a = null;
        }
        this.f6534f = null;
        UnifiedNativeAd unifiedNativeAd = this.f6535g;
        if (unifiedNativeAd != null) {
            unifiedNativeAd.destroy();
            this.f6535g = null;
        }
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.adViewVisible = false;
        }
    }

    /* renamed from: p */
    private AdSize m4790p() {
        DisplayMetrics displayMetrics = this.metrics;
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    /* renamed from: q */
    private String m4791q() {
        int i = (int) this.mBannerIdChoice;
        if (i == 1) {
            return getString(C1441R.string.AD_UNIT_PUBLISHER_ID_LOWER_BANNER1);
        }
        if (i == 2) {
            return getString(C1441R.string.AD_UNIT_PUBLISHER_ID_LOWER_BANNER2);
        }
        if (i != 3) {
            return getString(C1441R.string.AD_UNIT_PUBLISHER_ID_LOWER_BANNER);
        }
        return getString(C1441R.string.AD_UNIT_PUBLISHER_ID_LOWER_BANNER3);
    }

    /* renamed from: r */
    private int m4792r() {
        int nextInt = new Random().nextInt(5);
        return getResources().getIdentifier(String.format(Locale.ENGLISH, "bg_ad_bottom_banner_bt%d", new Object[]{Integer.valueOf(nextInt)}), "drawable", getPackageName());
    }

    public static void storeNonPersonalizationAdsStatus(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putBoolean(f6528m, z);
        edit.commit();
    }

    /* renamed from: t */
    private void m4793t(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            m4789o(relativeLayout);
            AdView adView = new AdView(this);
            this.f6529a = adView;
            adView.setAdSize(m4790p());
            this.f6529a.setAdUnitId(m4791q());
            this.f6529a.setAdListener(new C1369c(relativeLayout));
            try {
                if (Utilities.checkNetworkConnection(this.mContext)) {
                    this.f6529a.loadAd(m4797x());
                } else {
                    this.f6530b = true;
                }
            } catch (Exception unused) {
                this.f6530b = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m4794u(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            m4789o(relativeLayout);
            if (getResources().getConfiguration().orientation != 2 || this.metrics.heightPixels > 500) {
                AdView adView = new AdView(this);
                this.f6529a = adView;
                com.dream_studio.animalsounds.util.Utilities.fitBannerAds(this, adView);
                this.f6529a.setAdUnitId(m4791q());
                this.f6529a.setAdListener(new C1371e(relativeLayout));
                try {
                    if (Utilities.checkNetworkConnection(this.mContext)) {
                        this.f6529a.loadAd(m4797x());
                    } else {
                        this.f6530b = true;
                    }
                } catch (Exception unused) {
                    this.f6530b = true;
                }
            } else {
                m4796w(relativeLayout);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m4795v(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            m4789o(relativeLayout);
            AdView adView = new AdView(this);
            this.f6529a = adView;
            adView.setAdSize(AdSize.SMART_BANNER);
            this.f6529a.setAdUnitId(m4791q());
            this.f6529a.setAdListener(new C1370d(relativeLayout));
            try {
                if (Utilities.checkNetworkConnection(this.mContext)) {
                    this.f6529a.loadAd(m4797x());
                } else {
                    this.f6530b = true;
                }
            } catch (Exception unused) {
                this.f6530b = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m4796w(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            m4789o(relativeLayout);
            this.f6532d = new AdLoader.Builder((Context) this, getString(C1441R.string.AD_UNIT_PUBLISHER_ID_NATIVE)).forUnifiedNativeAd(new C1373g(relativeLayout)).withAdListener(new C1372f()).build();
            if (Utilities.checkNetworkConnection(this.mContext)) {
                this.f6532d.loadAd(m4797x());
            } else {
                this.f6533e = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public AdRequest m4797x() {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (this.f6536h) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        if (Utilities.isDebugable(this.mContext)) {
            builder.addTestDevice("B3EEABB8EE11C2BE770B684D95219ECB");
            builder.addTestDevice("A8A119BAF5BB666F5B1C7AB17463D346");
            builder.addTestDevice("414C8FD9DF6E8B4E2EDD011EC3A9D7DB");
            builder.addTestDevice("CE91DFB8B51D6B1E140BDE9F9360619B");
            builder.addTestDevice("1B30FF9EB6E93EEB5D2523C98019DBFC");
            builder.addTestDevice("8E48DEBF183B87D24E721ABC420DE461");
            builder.addTestDevice("2E5566BC4D8A442CCA26ACF4207126F2");
            builder.addTestDevice("409ACB3A6CA9D9C84A6CD8EDE17AC83F");
            builder.addTestDevice("8FF876BB66B0FA2680D367D3F8575AF0");
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m4798y(RelativeLayout relativeLayout, View view) {
        if (!this.adViewVisible && relativeLayout != null && view != null) {
            this.adViewVisible = true;
            relativeLayout.setBackgroundColor(f6527l);
            relativeLayout.removeAllViews();
            relativeLayout.addView(view);
            relativeLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        this.mLang = LocaleManager.getLanguage(context);
        this.mCountry = LocaleManager.getCountry(context);
        super.attachBaseContext(LocaleManager.updateConfig(context, this.mLang));
    }

    /* access modifiers changed from: protected */
    public void createAds() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1441R.C1443id.adViewLowerBox);
        if (!this.mRemoveAds) {
            if (!this.mShowBannerAds || relativeLayout == null) {
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            } else if (this.mChangeSmartBannerToNativeBanner) {
                m4796w(relativeLayout);
            } else if (this.mChangeSmartBannerToBanner) {
                m4794u(relativeLayout);
            } else if (this.mShowAdaptiveBanner) {
                m4793t(relativeLayout);
            } else {
                m4795v(relativeLayout);
            }
            if (this.mShowTransitionInterstitial || this.mShowQuitInterstitial) {
                InterstitialAd interstitialAd = new InterstitialAd(this);
                this.mInterstitial = interstitialAd;
                interstitialAd.setAdUnitId(getString(C1441R.string.AD_UNIT_PUBLISHER_ID_FULL_SCREEN_BANNER));
                this.mInterstitial.setAdListener(new C1368b());
                loadInterstitial();
            }
        } else if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void createAdsIfInitialized(boolean z, boolean z2) {
        boolean z3 = z | this.f6537i;
        this.f6537i = z3;
        boolean z4 = z2 | this.f6538j;
        this.f6538j = z4;
        if (this.mShowQuitInterstitial && z4 && z3) {
            createAds();
        }
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        InterstitialAd interstitialAd = this.mInterstitial;
        if (interstitialAd != null && !interstitialAd.isLoading() && !this.mInterstitial.isLoaded()) {
            try {
                if (Utilities.checkNetworkConnection(this.mContext)) {
                    this.mInterstitial.loadAd(m4797x());
                } else {
                    this.interstitAdLoadFailed = true;
                }
            } catch (Exception unused) {
                this.interstitAdLoadFailed = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        int i3;
        super.onActivityResult(i, i2, intent);
        if (!(intent == null || (extras = intent.getExtras()) == null || this.mVolumeControl == null || (i3 = extras.getInt("playerVolume", -1)) == -1)) {
            this.mVolumeControl.setPlayerVolume(i3);
        }
        setMuteButton();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
        LocaleManager.updateConfig(this.mContext, configuration);
        m4789o((RelativeLayout) findViewById(C1441R.C1443id.adViewLowerBox));
        Dialog dialog = this.mModelessDialog;
        if (dialog != null) {
            try {
                dialog.dismiss();
                this.mModelessDialog = null;
            } catch (Exception e) {
                CatchException.logException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
        this.mRemoveAds = getIntent().getBooleanExtra("paid", false);
        this.mShowTransitionInterstitial = getIntent().getBooleanExtra("showTransInterstitial", false);
        this.mShowQuitInterstitial = getIntent().getBooleanExtra("showQuitInterstitial", false);
        this.mShowBannerAds = getIntent().getBooleanExtra("showBannerAds", false);
        this.mChangeSmartBannerToBanner = getIntent().getBooleanExtra("changeSmartBannerToBanner", false);
        this.mChangeSmartBannerToNativeBanner = getIntent().getBooleanExtra("changeSmartBannerToNativeBanner", false);
        this.mShowAdaptiveBanner = getIntent().getBooleanExtra("showAdaptiveBanner", false);
        this.mBannerIdChoice = getIntent().getLongExtra("bannerIdChoice", 0);
        boolean z = getApplicationContext().getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getBoolean(f6528m, false);
        this.f6536h = z;
        TermsAndPolicyAcceptance.setGDPRConsentForUnity(this.mContext, z);
        VolumeControl volumeControl = new VolumeControl(this.mContext, false);
        this.mVolumeControl = volumeControl;
        if (bundle != null) {
            volumeControl.setPlayerVolume(bundle.getInt("playerVolume", 100));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m4789o((RelativeLayout) findViewById(C1441R.C1443id.adViewLowerBox));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            this.mVolumeControl.controlSysVolume(1, true, false);
            return true;
        } else if (i != 25) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.mVolumeControl.controlSysVolume(-1, true, false);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            BroadcastReceiver broadcastReceiver = this.f6539k;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
        try {
            AdView adView = this.f6529a;
            if (adView != null) {
                adView.pause();
            }
        } catch (Exception e2) {
            CatchException.logException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(this.f6539k, intentFilter);
        setMuteButton();
        AdView adView = this.f6529a;
        if (adView != null) {
            adView.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("playerVolume", this.mVolumeControl.getPlayerVolume());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Toast toast = this.f6531c;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void populateNativeAdView(UnifiedNativeAd unifiedNativeAd, UnifiedNativeAdView unifiedNativeAdView) {
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        ((Button) unifiedNativeAdView.getCallToActionView()).setBackgroundResource(m4792r());
        NativeAd.Image icon = unifiedNativeAd.getIcon();
        if (icon == null) {
            unifiedNativeAdView.getIconView().setVisibility(4);
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(icon.getDrawable());
            unifiedNativeAdView.getIconView().setVisibility(0);
        }
        unifiedNativeAdView.getMediaView().setVisibility(8);
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
    }

    public void registerNativeAdView(UnifiedNativeAdView unifiedNativeAdView) {
        unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(C1441R.C1443id.ad_media));
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_icon));
        unifiedNativeAdView.setPriceView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_price));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_stars));
        unifiedNativeAdView.setStoreView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_store));
        unifiedNativeAdView.setAdvertiserView(unifiedNativeAdView.findViewById(C1441R.C1443id.ad_advertiser));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo10301s() {
        try {
            AdView adView = this.f6529a;
            if (adView != null) {
                adView.pause();
                this.f6529a.setVisibility(4);
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
        UnifiedNativeAdView unifiedNativeAdView = this.f6534f;
        if (unifiedNativeAdView != null) {
            unifiedNativeAdView.setVisibility(4);
        }
    }

    public void setMuteButton() {
        ToggleButton toggleButton = (ToggleButton) findViewById(C1441R.C1443id.mute);
        if (toggleButton != null) {
            toggleButton.setChecked(this.mVolumeControl.refreshMute());
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitialAndCloseActivity() {
        InterstitialAd interstitialAd;
        if (!this.mRemoveAds && this.mShowTransitionInterstitial && (interstitialAd = this.mInterstitial) != null && interstitialAd.isLoaded()) {
            this.mInterstitial.show();
        }
        finish();
    }

    public void switchAdsPersonalization() {
        boolean nonPersonalizationAdsStatus = getNonPersonalizationAdsStatus(this.mContext);
        if (nonPersonalizationAdsStatus != this.f6536h) {
            this.f6536h = nonPersonalizationAdsStatus;
            TermsAndPolicyAcceptance.setGDPRConsentForUnity(this.mContext, nonPersonalizationAdsStatus);
            createAdsIfInitialized(false, false);
        }
    }

    /* access modifiers changed from: protected */
    public void toastBottom(int i) {
        Toast toast = this.f6531c;
        if (toast != null) {
            toast.cancel();
        }
        View inflate = getLayoutInflater().inflate(C1441R.layout.toast_layout, (ViewGroup) findViewById(C1441R.C1443id.toast_layout_root));
        ((TextView) inflate.findViewById(C1441R.C1443id.text)).setText(getString(i));
        Toast toast2 = new Toast(getApplicationContext());
        this.f6531c = toast2;
        toast2.setGravity(81, 0, 100);
        this.f6531c.setView(inflate);
        this.f6531c.show();
    }

    /* access modifiers changed from: protected */
    public void toastTop(int i) {
        Toast toast = this.f6531c;
        if (toast != null) {
            toast.cancel();
        }
        View inflate = getLayoutInflater().inflate(C1441R.layout.toast_layout, (ViewGroup) findViewById(C1441R.C1443id.toast_layout_root));
        ((TextView) inflate.findViewById(C1441R.C1443id.text)).setText(getString(i));
        Toast toast2 = new Toast(getApplicationContext());
        this.f6531c = toast2;
        toast2.setGravity(49, 0, 150);
        this.f6531c.setView(inflate);
        this.f6531c.show();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public void mo10309z() {
        try {
            AdView adView = this.f6529a;
            if (adView != null) {
                adView.resume();
                this.f6529a.setVisibility(0);
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
        UnifiedNativeAdView unifiedNativeAdView = this.f6534f;
        if (unifiedNativeAdView != null) {
            unifiedNativeAdView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void toastBottom(String str) {
        Toast toast = this.f6531c;
        if (toast != null) {
            toast.cancel();
        }
        View inflate = getLayoutInflater().inflate(C1441R.layout.toast_layout, (ViewGroup) findViewById(C1441R.C1443id.toast_layout_root));
        ((TextView) inflate.findViewById(C1441R.C1443id.text)).setText(str);
        Toast toast2 = new Toast(getApplicationContext());
        this.f6531c = toast2;
        toast2.setGravity(81, 0, 100);
        this.f6531c.setView(inflate);
        this.f6531c.show();
    }

    /* access modifiers changed from: protected */
    public void toastTop(String str) {
        Toast toast = this.f6531c;
        if (toast != null) {
            toast.cancel();
        }
        if (str != null && !str.equals("")) {
            View inflate = getLayoutInflater().inflate(C1441R.layout.toast_layout, (ViewGroup) findViewById(C1441R.C1443id.toast_layout_root));
            ((TextView) inflate.findViewById(C1441R.C1443id.text)).setText(str);
            Toast toast2 = new Toast(getApplicationContext());
            this.f6531c = toast2;
            toast2.setGravity(49, 0, 150);
            this.f6531c.setView(inflate);
            this.f6531c.show();
        }
    }
}
