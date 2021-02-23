package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ag0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ IOException f7816a;

    /* renamed from: b */
    private final /* synthetic */ xf0 f7817b;

    ag0(xf0 xf0, IOException iOException) {
        this.f7817b = xf0;
        this.f7816a = iOException;
    }

    public final void run() {
        this.f7817b.f11912e.zzb(this.f7816a);
    }
}
