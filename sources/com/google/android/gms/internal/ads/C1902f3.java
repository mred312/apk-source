package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.f3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1902f3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f8423a;

    C1902f3(zzaop zzaop) {
        this.f8423a = zzaop;
    }

    public final void run() {
        try {
            this.f8423a.f12590a.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
