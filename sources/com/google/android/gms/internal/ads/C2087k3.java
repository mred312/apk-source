package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.k3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2087k3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f9562a;

    C2087k3(zzaop zzaop) {
        this.f9562a = zzaop;
    }

    public final void run() {
        try {
            this.f9562a.f12590a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
