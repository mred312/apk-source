package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* renamed from: com.google.android.gms.internal.ads.z2 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2648z2 implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzano f12251a;

    /* renamed from: b */
    private final /* synthetic */ zzaoe f12252b;

    C2648z2(zzaoe zzaoe, zzano zzano) {
        this.f12252b = zzaoe;
        this.f12251a = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.f12252b.f12562e = mediationRewardedAd;
            this.f12251a.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return new zzawa(this.f12251a);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.f12252b.f12558a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzaza.zzeb(sb.toString());
            this.f12251a.zzc(0, str);
            this.f12251a.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.f12252b.f12558a.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzaza.zzeb(sb.toString());
            this.f12251a.zzc(adError.zzdq());
            this.f12251a.zzc(adError.getCode(), adError.getMessage());
            this.f12251a.onAdFailedToLoad(adError.getCode());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
