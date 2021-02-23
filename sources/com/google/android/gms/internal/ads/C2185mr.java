package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.mr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2185mr implements zzbrz {

    /* renamed from: a */
    private final zzcxq f10012a;

    /* renamed from: b */
    private final zzajt f10013b;

    C2185mr(zzcxq zzcxq, zzajt zzajt) {
        this.f10012a = zzcxq;
        this.f10013b = zzajt;
    }

    public final void zzk(zzve zzve) {
        zzcxq zzcxq = this.f10012a;
        zzajt zzajt = this.f10013b;
        zzcxq.zzk(zzve);
        if (zzajt != null) {
            try {
                zzajt.zzd(zzve);
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
        if (zzajt != null) {
            try {
                zzajt.onInstreamAdFailedToLoad(zzve.errorCode);
            } catch (RemoteException e2) {
                zzaza.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
