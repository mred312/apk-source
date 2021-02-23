package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.e7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2978e7 implements Runnable {

    /* renamed from: a */
    long f18043a;

    /* renamed from: b */
    long f18044b;

    /* renamed from: c */
    final /* synthetic */ C2988f7 f18045c;

    C2978e7(C2988f7 f7Var, long j, long j2) {
        this.f18045c = f7Var;
        this.f18043a = j;
        this.f18044b = j2;
    }

    public final void run() {
        this.f18045c.f18063b.zzp().zza((Runnable) new C3017i7(this));
    }
}
