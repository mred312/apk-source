package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzapx extends zzapr {

    /* renamed from: a */
    private final RtbAdapter f12592a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialAd f12593b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MediationRewardedAd f12594c;

    /* renamed from: d */
    private String f12595d = "";

    public zzapx(RtbAdapter rtbAdapter) {
        this.f12592a = rtbAdapter;
    }

    /* renamed from: a */
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> m7516a(zzapn zzapn, zzano zzano) {
        return new C2310q3(this, zzapn, zzano);
    }

    @Nullable
    /* renamed from: d */
    private static String m7519d(String str, zzvk zzvk) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzvk.zzadn;
        }
    }

    /* renamed from: e */
    private static boolean m7520e(zzvk zzvk) {
        if (zzvk.zzchb) {
            return true;
        }
        zzwq.zzqa();
        return zzayr.zzzd();
    }

    /* renamed from: f */
    private final Bundle m7521f(zzvk zzvk) {
        Bundle bundle;
        Bundle bundle2 = zzvk.zzchf;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.f12592a.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    /* renamed from: g */
    private static Bundle m7522g(String str) {
        String valueOf = String.valueOf(str);
        zzaza.zzfa(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzaza.zzc("", e);
            throw new RemoteException();
        }
    }

    public final zzys getVideoController() {
        RtbAdapter rtbAdapter = this.f12592a;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return null;
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapc zzapc, zzano zzano, zzvn zzvn) {
        zzvk zzvk2 = zzvk;
        zzvn zzvn2 = zzvn;
        try {
            C2198n3 n3Var = new C2198n3(this, zzapc, zzano);
            RtbAdapter rtbAdapter = this.f12592a;
            Bundle g = m7522g(str2);
            Bundle f = m7521f(zzvk2);
            boolean e = m7520e(zzvk);
            Location location = zzvk2.zzmy;
            int i = zzvk2.zzadl;
            int i2 = zzvk2.zzadm;
            String d = m7519d(str2, zzvk);
            AdSize zza = zzb.zza(zzvn2.width, zzvn2.height, zzvn2.zzacv);
            String str3 = this.f12595d;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, g, f, e, location, i, i2, d, zza, str3);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, n3Var);
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        MediationRewardedAd mediationRewardedAd = this.f12594c;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return true;
        }
    }

    public final void zzb(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.f12592a.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, m7522g(str2), m7521f(zzvk2), m7520e(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, m7519d(str2, zzvk), this.f12595d), m7516a(zzapn, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzdn(String str) {
        this.f12595d = str;
    }

    public final zzaqc zzul() {
        return zzaqc.zza(this.f12592a.getVersionInfo());
    }

    public final zzaqc zzum() {
        return zzaqc.zza(this.f12592a.getSDKVersionInfo());
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) {
        MediationInterstitialAd mediationInterstitialAd = this.f12593b;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return true;
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzaph zzaph, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.f12592a.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, m7522g(str2), m7521f(zzvk2), m7520e(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, m7519d(str2, zzvk), this.f12595d), new C2273p3(this, zzaph, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.f12592a.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, m7522g(str2), m7521f(zzvk2), m7520e(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, m7519d(str2, zzvk), this.f12595d), m7516a(zzapn, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapi zzapi, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.f12592a.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, m7522g(str2), m7521f(zzvk2), m7520e(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, m7519d(str2, zzvk), this.f12595d), new C2235o3(this, zzapi, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvn, zzapt zzapt) {
        AdFormat adFormat;
        try {
            C2347r3 r3Var = new C2347r3(this, zzapt);
            RtbAdapter rtbAdapter = this.f12592a;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzvn.width, zzvn.height, zzvn.zzacv)), r3Var);
        } catch (Throwable th) {
            zzaza.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }
}
