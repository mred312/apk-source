package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaop<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzano f12590a;

    public zzaop(zzano zzano) {
        this.f12590a = zzano;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onClick.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1754b3(this));
            return;
        }
        try {
            this.f12590a.onAdClicked();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onDismissScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zzfa("#008 Must be called on the main UI thread.");
            zzayr.zzzz.post(new C1902f3(this));
            return;
        }
        try {
            this.f12590a.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzaza.zzeb(sb.toString());
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1865e3(this, errorCode));
            return;
        }
        try {
            this.f12590a.onAdFailedToLoad(zzapb.zza(errorCode));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onLeaveApplication.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1976h3(this));
            return;
        }
        try {
            this.f12590a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onPresentScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1939g3(this));
            return;
        }
        try {
            this.f12590a.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onReceivedAd.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C2050j3(this));
            return;
        }
        try {
            this.f12590a.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onDismissScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C2013i3(this));
            return;
        }
        try {
            this.f12590a.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzaza.zzeb(sb.toString());
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C2124l3(this, errorCode));
            return;
        }
        try {
            this.f12590a.onAdFailedToLoad(zzapb.zza(errorCode));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onLeaveApplication.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C2087k3(this));
            return;
        }
        try {
            this.f12590a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onPresentScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1828d3(this));
            return;
        }
        try {
            this.f12590a.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onReceivedAd.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new C1791c3(this));
            return;
        }
        try {
            this.f12590a.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
