package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.y4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3158y4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18463a;

    /* renamed from: b */
    private final /* synthetic */ boolean f18464b;

    /* renamed from: c */
    private final /* synthetic */ zzgy f18465c;

    C3158y4(zzgy zzgy, AtomicReference atomicReference, boolean z) {
        this.f18465c = zzgy;
        this.f18463a = atomicReference;
        this.f18464b = z;
    }

    public final void run() {
        this.f18465c.zzg().zza((AtomicReference<List<zzkr>>) this.f18463a, this.f18464b);
    }
}
