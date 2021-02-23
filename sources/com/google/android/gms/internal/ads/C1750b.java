package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.b */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class C1750b implements Runnable {

    /* renamed from: a */
    private final zzavp f7858a;

    C1750b(zzavp zzavp) {
        this.f7858a = zzavp;
    }

    public final void run() {
        zzavp zzavp = this.f7858a;
        if (zzavp != null) {
            try {
                zzavp.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
