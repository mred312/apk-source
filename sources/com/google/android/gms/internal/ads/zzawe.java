package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzawe extends RewardedInterstitialAd {

    /* renamed from: a */
    private final zzavh f12878a;

    /* renamed from: b */
    private final Context f12879b;

    /* renamed from: c */
    private final zzawc f12880c = new zzawc();

    public zzawe(Context context, String str) {
        this.f12879b = context.getApplicationContext();
        this.f12878a = zzwq.zzqb().zzc(context, str, new zzanj());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.f12878a.getAdMetadata();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.f12878a.zzkh();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    @NonNull
    public final RewardItem getRewardItem() {
        try {
            zzavc zzre = this.f12878a.zzre();
            if (zzre != null) {
                return new zzavv(zzre);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.f12880c.setFullScreenContentCallback(fullScreenContentCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.f12878a.zza((zzyh) new zzaac(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.f12878a.zza((zzym) new zzaaf(onPaidEventListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.f12878a.zza(new zzavy(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(@Nullable Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.f12880c.zza(onUserEarnedRewardListener);
        try {
            this.f12878a.zza((zzavi) this.f12880c);
            this.f12878a.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            this.f12878a.zzb(zzvl.zza(this.f12879b, zzza), new zzawf(rewardedInterstitialAdLoadCallback, this));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
