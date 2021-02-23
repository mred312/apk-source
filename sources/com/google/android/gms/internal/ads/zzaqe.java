package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqe implements MediationInterstitialAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f12604a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialListener f12605b;

    /* renamed from: c */
    private Uri f12606c;

    public final void onDestroy() {
        zzaza.zzeb("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzaza.zzeb("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzaza.zzeb("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f12605b = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzaza.zzfa("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzaza.zzfa("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f12605b.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(context))) {
                zzaza.zzfa("Default browser does not support custom tabs. Bailing out.");
                this.f12605b.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzaza.zzfa("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f12605b.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.f12604a = (Activity) context;
            this.f12606c = Uri.parse(string);
            this.f12605b.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.f12606c);
        zzm.zzedd.post(new C2425t3(this, new AdOverlayInfoParcel(new zzb(build.intent), (zzva) null, new C2462u3(this), (zzu) null, new zzazh(0, 0, false))));
        zzp.zzku().zzwv();
    }
}
