package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* renamed from: com.google.android.gms.internal.ads.o3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2235o3 implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzapi f10248a;

    /* renamed from: b */
    private final /* synthetic */ zzano f10249b;

    C2235o3(zzapx zzapx, zzapi zzapi, zzano zzano) {
        this.f10248a = zzapi;
        this.f10249b = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.f10248a.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                this.f10248a.zza(new zzapd(unifiedNativeAdMapper));
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new C2384s3(this.f10249b);
        }
    }

    public final void onFailure(String str) {
        try {
            this.f10248a.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.f10248a.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
