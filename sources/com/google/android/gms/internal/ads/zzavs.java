package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzavs {

    /* renamed from: a */
    private final zzavh f12868a;

    /* renamed from: b */
    private final Context f12869b;

    public zzavs(Context context, String str) {
        this.f12869b = context.getApplicationContext();
        this.f12868a = zzwq.zzqb().zzc(context, str, new zzanj());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.f12868a.getAdMetadata();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.f12868a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.f12868a.zzkh();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzavc zzre = this.f12868a.zzre();
            if (zzre == null) {
                return null;
            }
            return new zzavv(zzre);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoaded() {
        try {
            return this.f12868a.isLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.f12868a.zza((zzyh) new zzaac(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.f12868a.zza((zzym) new zzaaf(onPaidEventListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.f12868a.zza(new zzavy(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.f12868a.zza((zzavi) new zzavu(rewardedAdCallback));
            this.f12868a.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.f12868a.zza(zzvl.zza(this.f12869b, zzza), (zzavp) new zzavz(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.f12868a.zza((zzavi) new zzavu(rewardedAdCallback));
            this.f12868a.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
