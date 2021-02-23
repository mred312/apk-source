package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.i3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2013i3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f9252a;

    C2013i3(zzaop zzaop) {
        this.f9252a = zzaop;
    }

    public final void run() {
        try {
            this.f9252a.f12590a.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
