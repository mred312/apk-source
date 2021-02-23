package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class ei0 implements Runnable {

    /* renamed from: a */
    private final zzazq f8367a;

    /* renamed from: b */
    private final Future f8368b;

    ei0(zzazq zzazq, Future future) {
        this.f8367a = zzazq;
        this.f8368b = future;
    }

    public final void run() {
        zzazq zzazq = this.f8367a;
        Future future = this.f8368b;
        if (zzazq.isCancelled()) {
            future.cancel(true);
        }
    }
}
