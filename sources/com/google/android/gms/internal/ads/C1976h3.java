package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.h3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1976h3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f8826a;

    C1976h3(zzaop zzaop) {
        this.f8826a = zzaop;
    }

    public final void run() {
        try {
            this.f8826a.f12590a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
