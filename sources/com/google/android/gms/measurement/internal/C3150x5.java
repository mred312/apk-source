package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.x5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3150x5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzig f18450a;

    /* renamed from: b */
    private final /* synthetic */ long f18451b;

    /* renamed from: c */
    private final /* synthetic */ zzij f18452c;

    C3150x5(zzij zzij, zzig zzig, long j) {
        this.f18452c = zzij;
        this.f18450a = zzig;
        this.f18451b = j;
    }

    public final void run() {
        this.f18452c.m10858g(this.f18450a, false, this.f18451b);
        zzij zzij = this.f18452c;
        zzij.zza = null;
        zzij.zzg().zza((zzig) null);
    }
}
