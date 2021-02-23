package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.c3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1791c3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaop f7959a;

    C1791c3(zzaop zzaop) {
        this.f7959a = zzaop;
    }

    public final void run() {
        try {
            this.f7959a.f12590a.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
