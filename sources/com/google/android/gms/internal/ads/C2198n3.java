package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.n3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2198n3 implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzapc f10033a;

    /* renamed from: b */
    private final /* synthetic */ zzano f10034b;

    C2198n3(zzapx zzapx, zzapc zzapc, zzano zzano) {
        this.f10033a = zzapc;
        this.f10034b = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.f10033a.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                this.f10033a.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new C2384s3(this.f10034b);
        }
    }

    public final void onFailure(String str) {
        try {
            this.f10033a.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.f10033a.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
