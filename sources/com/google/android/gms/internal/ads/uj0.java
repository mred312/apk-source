package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class uj0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ sj0 f11427a;

    uj0(sj0 sj0) {
        this.f11427a = sj0;
    }

    public final void run() {
        if (this.f11427a.f11092a.f17196a != null) {
            try {
                this.f11427a.f11092a.f17196a.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
