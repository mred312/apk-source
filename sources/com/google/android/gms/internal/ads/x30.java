package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class x30 extends zzdxo.C2695k<Void> implements Runnable {

    /* renamed from: h */
    private final Runnable f11757h;

    public x30(Runnable runnable) {
        this.f11757h = (Runnable) zzdvv.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.f11757h.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdwe.zzj(th);
        }
    }
}
