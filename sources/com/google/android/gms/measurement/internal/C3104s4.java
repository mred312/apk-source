package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.s4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3104s4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18352a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18353b;

    C3104s4(zzgy zzgy, AtomicReference atomicReference) {
        this.f18353b = zzgy;
        this.f18352a = atomicReference;
    }

    public final void run() {
        synchronized (this.f18352a) {
            try {
                this.f18352a.set(Boolean.valueOf(this.f18353b.zzs().mo20606h(this.f18353b.zzf().mo20275c())));
                this.f18352a.notify();
            } catch (Throwable th) {
                this.f18352a.notify();
                throw th;
            }
        }
    }
}
