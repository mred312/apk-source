package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.b3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1754b3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f7869a;

    C1754b3(zzaop zzaop) {
        this.f7869a = zzaop;
    }

    public final void run() {
        try {
            this.f7869a.f12590a.onAdClicked();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
