package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.c5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2956c5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17998a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f17999b;

    C2956c5(zzgy zzgy, AtomicReference atomicReference) {
        this.f17999b = zzgy;
        this.f17998a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17998a) {
            try {
                this.f17998a.set(this.f17999b.zzs().mo20607i(this.f17999b.zzf().mo20275c()));
                this.f17998a.notify();
            } catch (Throwable th) {
                this.f17998a.notify();
                throw th;
            }
        }
    }
}
