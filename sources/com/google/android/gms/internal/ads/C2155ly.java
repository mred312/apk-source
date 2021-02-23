package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.android.gms.internal.ads.ly */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2155ly extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ zzxj f9894a;

    /* renamed from: b */
    private final /* synthetic */ zzdmo f9895b;

    C2155ly(zzdmo zzdmo, zzxj zzxj) {
        this.f9895b = zzdmo;
        this.f9894a = zzxj;
    }

    public final void onAdMetadataChanged() {
        if (this.f9895b.f15778d != null) {
            try {
                this.f9894a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
