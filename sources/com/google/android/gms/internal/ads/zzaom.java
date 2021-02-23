package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaom<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzanm {

    /* renamed from: a */
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f12578a;

    /* renamed from: b */
    private final NETWORK_EXTRAS f12579b;

    public zzaom(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f12578a = mediationAdapter;
        this.f12579b = network_extras;
    }

    /* renamed from: a */
    private static boolean m7513a(zzvk zzvk) {
        if (zzvk.zzchb) {
            return true;
        }
        zzwq.zzqa();
        return zzayr.zzzd();
    }

    /* renamed from: b */
    private final SERVER_PARAMETERS m7514b(String str) {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.f12578a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    public final void destroy() {
        try {
            this.f12578a.destroy();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final zzys getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void pause() {
        throw new RemoteException();
    }

    public final void resume() {
        throw new RemoteException();
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showInterstitial() {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f12578a;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaza.zzfa(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaza.zzeb("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f12578a).showInterstitial();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajb zzajb, List<zzajj> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzauw zzauw, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzauw zzauw, String str2) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano, zzadz zzadz, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvn, zzvk, str, (String) null, zzano);
    }

    public final void zza(zzvk zzvk, String str) {
    }

    public final void zza(zzvk zzvk, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
    }

    public final IObjectWrapper zzud() {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f12578a;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaza.zzfa(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    public final zzanv zzue() {
        return null;
    }

    public final zzanw zzuf() {
        return null;
    }

    public final Bundle zzug() {
        return new Bundle();
    }

    public final Bundle zzuh() {
        return new Bundle();
    }

    public final boolean zzui() {
        return false;
    }

    public final zzaff zzuj() {
        return null;
    }

    public final zzaob zzuk() {
        return null;
    }

    public final zzaqc zzul() {
        return null;
    }

    public final zzaqc zzum() {
        return null;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, String str2, zzano zzano) {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f12578a;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaza.zzfa(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaza.zzeb("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f12578a;
            zzaop zzaop = new zzaop(zzano);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters b = m7514b(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzvn.width && adSizeArr[i].getHeight() == zzvn.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zzb.zza(zzvn.width, zzvn.height, zzvn.zzacv));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzaop, activity, b, adSize, zzapb.zza(zzvk, m7513a(zzvk)), this.f12579b);
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvk, str, (String) null, zzano);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano) {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f12578a;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaza.zzfa(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaza.zzeb("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f12578a).requestInterstitialAd(new zzaop(zzano), (Activity) ObjectWrapper.unwrap(iObjectWrapper), m7514b(str), zzapb.zza(zzvk, m7513a(zzvk)), this.f12579b);
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }
}
