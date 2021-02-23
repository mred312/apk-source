package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* renamed from: com.google.android.gms.internal.ads.p3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2273p3 implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzaph f10424a;

    /* renamed from: b */
    private final /* synthetic */ zzano f10425b;

    /* renamed from: c */
    private final /* synthetic */ zzapx f10426c;

    C2273p3(zzapx zzapx, zzaph zzaph, zzano zzano) {
        this.f10426c = zzapx;
        this.f10424a = zzaph;
        this.f10425b = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.f10424a.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.f10426c.f12593b = mediationInterstitialAd;
                this.f10424a.zzuw();
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new C2384s3(this.f10425b);
        }
    }

    public final void onFailure(String str) {
        try {
            this.f10424a.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.f10424a.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
