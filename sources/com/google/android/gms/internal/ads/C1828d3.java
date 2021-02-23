package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.d3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1828d3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f8048a;

    C1828d3(zzaop zzaop) {
        this.f8048a = zzaop;
    }

    public final void run() {
        try {
            this.f8048a.f12590a.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
