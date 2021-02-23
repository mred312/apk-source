package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.c */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1787c implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaaa f7950a;

    C1787c(zzaaa zzaaa) {
        this.f7950a = zzaaa;
    }

    public final void run() {
        if (this.f7950a.f12327a != null) {
            try {
                this.f7950a.f12327a.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
