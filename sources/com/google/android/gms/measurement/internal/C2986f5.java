package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.f5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2986f5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18058a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18059b;

    C2986f5(zzgy zzgy, AtomicReference atomicReference) {
        this.f18059b = zzgy;
        this.f18058a = atomicReference;
    }

    public final void run() {
        synchronized (this.f18058a) {
            try {
                this.f18058a.set(Long.valueOf(this.f18059b.zzs().zza(this.f18059b.zzf().mo20275c(), zzat.zzal)));
                this.f18058a.notify();
            } catch (Throwable th) {
                this.f18058a.notify();
                throw th;
            }
        }
    }
}
