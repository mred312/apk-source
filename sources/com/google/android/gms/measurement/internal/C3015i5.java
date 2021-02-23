package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.i5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3015i5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18165a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18166b;

    C3015i5(zzgy zzgy, AtomicReference atomicReference) {
        this.f18166b = zzgy;
        this.f18165a = atomicReference;
    }

    public final void run() {
        synchronized (this.f18165a) {
            try {
                this.f18165a.set(Integer.valueOf(this.f18166b.zzs().zzb(this.f18166b.zzf().mo20275c(), zzat.zzam)));
                this.f18165a.notify();
            } catch (Throwable th) {
                this.f18165a.notify();
                throw th;
            }
        }
    }
}
