package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.ads.l3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C2124l3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AdRequest.ErrorCode f9798a;

    /* renamed from: b */
    private final /* synthetic */ zzaop f9799b;

    C2124l3(zzaop zzaop, AdRequest.ErrorCode errorCode) {
        this.f9799b = zzaop;
        this.f9798a = errorCode;
    }

    public final void run() {
        try {
            this.f9799b.f12590a.onAdFailedToLoad(zzapb.zza(this.f9798a));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
