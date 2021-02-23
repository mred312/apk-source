package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* renamed from: com.google.android.gms.internal.ads.a3 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1714a3 implements InitializationCompleteCallback {

    /* renamed from: a */
    private final /* synthetic */ zzajb f7779a;

    C1714a3(zzaoe zzaoe, zzajb zzajb) {
        this.f7779a = zzajb;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.f7779a.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.f7779a.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
