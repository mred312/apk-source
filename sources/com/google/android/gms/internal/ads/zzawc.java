package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzawc extends zzavl {

    /* renamed from: a */
    private FullScreenContentCallback f12874a;

    /* renamed from: b */
    private OnUserEarnedRewardListener f12875b;

    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.f12874a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.f12874a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.f12874a = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.f12875b = onUserEarnedRewardListener;
    }

    public final void zzh(zzve zzve) {
        FullScreenContentCallback fullScreenContentCallback = this.f12874a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzve.zzpl());
        }
    }

    public final void zza(zzavc zzavc) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.f12875b;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzavv(zzavc));
        }
    }
}
