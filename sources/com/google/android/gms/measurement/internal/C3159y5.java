package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.y5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3159y5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ long f18466a;

    /* renamed from: b */
    private final /* synthetic */ zzij f18467b;

    C3159y5(zzij zzij, long j) {
        this.f18467b = zzij;
        this.f18466a = j;
    }

    public final void run() {
        this.f18467b.zzd().zza(this.f18466a);
        this.f18467b.zza = null;
    }
}
