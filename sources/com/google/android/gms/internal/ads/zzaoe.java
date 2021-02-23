package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaoe extends zzanm {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f12558a;

    /* renamed from: b */
    private zzaoj f12559b;

    /* renamed from: c */
    private zzauw f12560c;

    /* renamed from: d */
    private IObjectWrapper f12561d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MediationRewardedAd f12562e;

    public zzaoe(@NonNull MediationAdapter mediationAdapter) {
        this.f12558a = mediationAdapter;
    }

    /* renamed from: a */
    private final Bundle m7505a(String str, zzvk zzvk, String str2) {
        String valueOf = String.valueOf(str);
        zzaza.zzeb(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.f12558a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvk != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvk.zzadl);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    /* renamed from: b */
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> m7506b(zzano zzano) {
        return new C2648z2(this, zzano);
    }

    @Nullable
    /* renamed from: e */
    private static String m7509e(String str, zzvk zzvk) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzvk.zzadn;
        }
    }

    /* renamed from: f */
    private static boolean m7510f(zzvk zzvk) {
        if (zzvk.zzchb) {
            return true;
        }
        zzwq.zzqa();
        return zzayr.zzzd();
    }

    /* renamed from: g */
    private final Bundle m7511g(zzvk zzvk) {
        Bundle bundle;
        Bundle bundle2 = zzvk.zzchf;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.f12558a.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    public final void destroy() {
        Object obj = this.f12558a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.f12558a;
        if (obj instanceof zzbgj) {
            return ((zzbgj) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbgj.class.getCanonicalName();
        String canonicalName2 = this.f12558a.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaza.zzfa(sb.toString());
        return new Bundle();
    }

    public final zzys getVideoController() {
        Object obj = this.f12558a;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return null;
        }
    }

    public final boolean isInitialized() {
        Object obj = this.f12558a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f12558a).isInitialized();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.f12560c != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void pause() {
        Object obj = this.f12558a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() {
        Object obj = this.f12558a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        Object obj = this.f12558a;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzeb(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaza.zzc("", th);
        }
    }

    public final void showInterstitial() {
        if (this.f12558a instanceof MediationInterstitialAdapter) {
            zzaza.zzeb("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f12558a).showInterstitial();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() {
        Object obj = this.f12558a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f12558a).showVideo();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.f12562e;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.f12561d));
            } else {
                zzaza.zzey("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvn, zzvk, str, (String) null, zzano);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zzvk zzvk2 = zzvk;
        String str2 = str;
        if (this.f12558a instanceof Adapter) {
            zzaza.zzeb("Requesting rewarded ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b = m7506b(zzano);
                Bundle a = m7505a(str2, zzvk2, (String) null);
                Bundle g = m7511g(zzvk2);
                boolean f = m7510f(zzvk);
                Location location = zzvk2.zzmy;
                int i = zzvk2.zzadl;
                int i2 = zzvk2.zzadm;
                String e = m7509e(str2, zzvk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", a, g, f, location, i, i2, e, "");
                ((Adapter) this.f12558a).loadRewardedAd(mediationRewardedAdConfiguration, b);
            } catch (Exception e2) {
                zzaza.zzc("", e2);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zzvk zzvk2 = zzvk;
        String str2 = str;
        if (this.f12558a instanceof Adapter) {
            zzaza.zzeb("Requesting rewarded interstitial ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b = m7506b(zzano);
                Bundle a = m7505a(str2, zzvk2, (String) null);
                Bundle g = m7511g(zzvk2);
                boolean f = m7510f(zzvk);
                Location location = zzvk2.zzmy;
                int i = zzvk2.zzadl;
                int i2 = zzvk2.zzadm;
                String e = m7509e(str2, zzvk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", a, g, f, location, i, i2, e, "");
                ((Adapter) this.f12558a).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, b);
            } catch (Exception e2) {
                zzaza.zzc("", e2);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.f12558a;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.f12558a instanceof Adapter) {
            zzaza.zzeb("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.f12562e;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzaza.zzey("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final IObjectWrapper zzud() {
        Object obj = this.f12558a;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzanv zzue() {
        NativeAdMapper zzur = this.f12559b.zzur();
        if (zzur instanceof NativeAppInstallAdMapper) {
            return new zzaol((NativeAppInstallAdMapper) zzur);
        }
        return null;
    }

    public final zzanw zzuf() {
        NativeAdMapper zzur = this.f12559b.zzur();
        if (zzur instanceof NativeContentAdMapper) {
            return new zzaok((NativeContentAdMapper) zzur);
        }
        return null;
    }

    public final Bundle zzug() {
        Object obj = this.f12558a;
        if (obj instanceof zzbgk) {
            return ((zzbgk) obj).zzug();
        }
        String canonicalName = zzbgk.class.getCanonicalName();
        String canonicalName2 = this.f12558a.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaza.zzfa(sb.toString());
        return new Bundle();
    }

    public final Bundle zzuh() {
        return new Bundle();
    }

    public final boolean zzui() {
        return this.f12558a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzaff zzuj() {
        NativeCustomTemplateAd zzut = this.f12559b.zzut();
        if (zzut instanceof zzafg) {
            return ((zzafg) zzut).zzte();
        }
        return null;
    }

    public final zzaob zzuk() {
        UnifiedNativeAdMapper zzus = this.f12559b.zzus();
        if (zzus != null) {
            return new zzapd(zzus);
        }
        return null;
    }

    public final zzaqc zzul() {
        Object obj = this.f12558a;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqc.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzaqc zzum() {
        Object obj = this.f12558a;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqc.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, String str2, zzano zzano) {
        Date date;
        AdSize zza;
        zzvn zzvn2 = zzvn;
        zzvk zzvk2 = zzvk;
        String str3 = str;
        if (this.f12558a instanceof MediationBannerAdapter) {
            zzaza.zzeb("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f12558a;
                Bundle bundle = null;
                HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                if (zzvk2.zzcgy == -1) {
                    date = null;
                } else {
                    date = new Date(zzvk2.zzcgy);
                }
                zzaof zzaof = new zzaof(date, zzvk2.zzcgz, hashSet, zzvk2.zzmy, m7510f(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, m7509e(str3, zzvk2));
                Bundle bundle2 = zzvk2.zzchf;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationBannerAdapter.getClass().getName());
                }
                Bundle bundle3 = bundle;
                if (zzvn2.zzchw) {
                    zza = zzb.zza(zzvn2.width, zzvn2.height);
                } else {
                    zza = zzb.zza(zzvn2.width, zzvn2.height, zzvn2.zzacv);
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoj(zzano), m7505a(str3, zzvk2, str2), zza, zzaof, bundle3);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public zzaoe(@NonNull Adapter adapter) {
        this.f12558a = adapter;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvk, str, (String) null, zzano);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano) {
        Date date;
        zzvk zzvk2 = zzvk;
        String str3 = str;
        if (this.f12558a instanceof MediationInterstitialAdapter) {
            zzaza.zzeb("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f12558a;
                Bundle bundle = null;
                HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                if (zzvk2.zzcgy == -1) {
                    date = null;
                } else {
                    date = new Date(zzvk2.zzcgy);
                }
                zzaof zzaof = new zzaof(date, zzvk2.zzcgz, hashSet, zzvk2.zzmy, m7510f(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, m7509e(str3, zzvk2));
                Bundle bundle2 = zzvk2.zzchf;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoj(zzano), m7505a(str3, zzvk2, str2), zzaof, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano, zzadz zzadz, List<String> list) {
        Date date;
        zzvk zzvk2 = zzvk;
        String str3 = str;
        Object obj = this.f12558a;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                if (zzvk2.zzcgy == -1) {
                    date = null;
                } else {
                    date = new Date(zzvk2.zzcgy);
                }
                zzaon zzaon = new zzaon(date, zzvk2.zzcgz, hashSet, zzvk2.zzmy, m7510f(zzvk), zzvk2.zzadl, zzadz, list, zzvk2.zzchk, zzvk2.zzadm, m7509e(str3, zzvk2));
                Bundle bundle2 = zzvk2.zzchf;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.f12559b = new zzaoj(zzano);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.f12559b, m7505a(str3, zzvk2, str2), zzaon, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzauw zzauw, String str2) {
        Bundle bundle;
        zzaof zzaof;
        Date date;
        zzvk zzvk2 = zzvk;
        zzauw zzauw2 = zzauw;
        String str3 = str2;
        Object obj = this.f12558a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f12558a;
                Bundle a = m7505a(str3, zzvk2, (String) null);
                if (zzvk2 != null) {
                    HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                    if (zzvk2.zzcgy == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvk2.zzcgy);
                    }
                    zzaof zzaof2 = new zzaof(date, zzvk2.zzcgz, hashSet, zzvk2.zzmy, m7510f(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, m7509e(str3, zzvk2));
                    Bundle bundle2 = zzvk2.zzchf;
                    bundle = bundle2 != null ? bundle2.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaof = zzaof2;
                } else {
                    zzaof = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaof, str, new zzavb(zzauw2), a, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.f12561d = iObjectWrapper;
            this.f12560c = zzauw2;
            zzauw2.zzaf(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzauw zzauw, List<String> list) {
        if (this.f12558a instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f12558a;
                ArrayList arrayList = new ArrayList();
                for (String a : list) {
                    arrayList.add(m7505a(a, (zzvk) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzavb(zzauw), arrayList);
            } catch (Throwable th) {
                zzaza.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zzvk zzvk, String str) {
        zza(zzvk, str, (String) null);
    }

    public final void zza(zzvk zzvk, String str, String str2) {
        Date date;
        zzvk zzvk2 = zzvk;
        String str3 = str;
        Object obj = this.f12558a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f12558a;
                Bundle bundle = null;
                HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                if (zzvk2.zzcgy == -1) {
                    date = null;
                } else {
                    date = new Date(zzvk2.zzcgy);
                }
                zzaof zzaof = new zzaof(date, zzvk2.zzcgz, hashSet, zzvk2.zzmy, m7510f(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, m7509e(str3, zzvk2));
                Bundle bundle2 = zzvk2.zzchf;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzaof, m7505a(str3, zzvk2, str2), bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.f12561d, zzvk2, str3, new zzaoi((Adapter) obj, this.f12560c));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajb zzajb, List<zzajj> list) {
        AdFormat adFormat;
        if (this.f12558a instanceof Adapter) {
            C1714a3 a3Var = new C1714a3(this, zzajb);
            ArrayList arrayList = new ArrayList();
            for (zzajj next : list) {
                String str = next.zzdhs;
                str.hashCode();
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
                            c = 1;
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
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        adFormat = AdFormat.BANNER;
                        break;
                    case 1:
                        adFormat = AdFormat.NATIVE;
                        break;
                    case 2:
                        adFormat = AdFormat.REWARDED;
                        break;
                    case 3:
                        adFormat = AdFormat.INTERSTITIAL;
                        break;
                    default:
                        throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, next.extras));
            }
            ((Adapter) this.f12558a).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), a3Var, arrayList);
            return;
        }
        throw new RemoteException();
    }
}
