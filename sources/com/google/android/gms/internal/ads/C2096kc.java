package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.ads.kc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2096kc implements Runnable {

    /* renamed from: a */
    private final AtomicReference f9746a;

    C2096kc(AtomicReference atomicReference) {
        this.f9746a = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.f9746a.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
