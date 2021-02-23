package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* renamed from: com.google.android.gms.internal.ads.q3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2310q3 implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzapn f10674a;

    /* renamed from: b */
    private final /* synthetic */ zzano f10675b;

    /* renamed from: c */
    private final /* synthetic */ zzapx f10676c;

    C2310q3(zzapx zzapx, zzapn zzapn, zzano zzano) {
        this.f10676c = zzapx;
        this.f10674a = zzapn;
        this.f10675b = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.f10674a.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.f10676c.f12594c = mediationRewardedAd;
                this.f10674a.zzuw();
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new C2384s3(this.f10675b);
        }
    }

    public final void onFailure(String str) {
        try {
            this.f10674a.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.f10674a.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
