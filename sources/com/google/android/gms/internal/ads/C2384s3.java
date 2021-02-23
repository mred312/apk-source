package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* renamed from: com.google.android.gms.internal.ads.s3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2384s3 implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {

    /* renamed from: a */
    private zzano f10844a;

    C2384s3(zzano zzano) {
        this.f10844a = zzano;
    }

    public final void onAdClosed() {
        try {
            this.f10844a.onAdClosed();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            String valueOf = String.valueOf(str);
            zzaza.zzfa(valueOf.length() != 0 ? "Mediated ad failed to show: ".concat(valueOf) : new String("Mediated ad failed to show: "));
            this.f10844a.zzdk(str);
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.f10844a.onAdLeftApplication();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.f10844a.onAdOpened();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.f10844a.zza((zzavc) new zzawd(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.f10844a.onVideoEnd();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoPlay() {
        try {
            this.f10844a.onVideoPlay();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.f10844a.zzun();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.f10844a.onAdClicked();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.f10844a.onAdImpression();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        try {
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 86 + String.valueOf(domain).length());
            sb.append("Mediated ad failed to show: Error Code = ");
            sb.append(code);
            sb.append(". Error Message = ");
            sb.append(message);
            sb.append(" Error Domain = ");
            sb.append(domain);
            zzaza.zzfa(sb.toString());
            this.f10844a.zze(adError.zzdq());
        } catch (RemoteException unused) {
        }
    }
}
