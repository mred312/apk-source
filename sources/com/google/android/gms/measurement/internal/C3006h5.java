package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.h5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3006h5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18116a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18117b;

    C3006h5(zzgy zzgy, AtomicReference atomicReference) {
        this.f18117b = zzgy;
        this.f18116a = atomicReference;
    }

    public final void run() {
        synchronized (this.f18116a) {
            try {
                this.f18116a.set(Double.valueOf(this.f18117b.zzs().zzc(this.f18117b.zzf().mo20275c(), zzat.zzan)));
                this.f18116a.notify();
            } catch (Throwable th) {
                this.f18116a.notify();
                throw th;
            }
        }
    }
}
