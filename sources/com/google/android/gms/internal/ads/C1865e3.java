package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.ads.e3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1865e3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AdRequest.ErrorCode f8309a;

    /* renamed from: b */
    private final /* synthetic */ zzaop f8310b;

    C1865e3(zzaop zzaop, AdRequest.ErrorCode errorCode) {
        this.f8310b = zzaop;
        this.f8309a = errorCode;
    }

    public final void run() {
        try {
            this.f8310b.f12590a.onAdFailedToLoad(zzapb.zza(this.f8309a));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
