package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.x4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3149x4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ long f18448a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18449b;

    C3149x4(zzgy zzgy, long j) {
        this.f18449b = zzgy;
        this.f18448a = j;
    }

    public final void run() {
        this.f18449b.mo20385b(this.f18448a, true);
        this.f18449b.zzg().zza((AtomicReference<String>) new AtomicReference());
    }
}
