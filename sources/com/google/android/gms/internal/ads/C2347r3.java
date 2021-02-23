package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* renamed from: com.google.android.gms.internal.ads.r3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2347r3 implements SignalCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzapt f10761a;

    C2347r3(zzapx zzapx, zzapt zzapt) {
        this.f10761a = zzapt;
    }

    public final void onFailure(String str) {
        try {
            this.f10761a.onFailure(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.f10761a.zzdo(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.f10761a.zzg(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
