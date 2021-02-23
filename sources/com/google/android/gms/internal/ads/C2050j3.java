package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.j3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2050j3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f9369a;

    C2050j3(zzaop zzaop) {
        this.f9369a = zzaop;
    }

    public final void run() {
        try {
            this.f9369a.f12590a.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
