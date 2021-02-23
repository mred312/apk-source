package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class vj0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzzs f11627a;

    vj0(zzzs zzzs) {
        this.f11627a = zzzs;
    }

    public final void run() {
        if (this.f11627a.f17197a != null) {
            try {
                this.f11627a.f17197a.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
