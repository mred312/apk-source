package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.f */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2980f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C3050m4 f18050a;

    /* renamed from: b */
    private final /* synthetic */ C2990g f18051b;

    C2980f(C2990g gVar, C3050m4 m4Var) {
        this.f18051b = gVar;
        this.f18050a = m4Var;
    }

    public final void run() {
        this.f18050a.zzt();
        if (zzx.zza()) {
            this.f18050a.zzp().zza((Runnable) this);
            return;
        }
        boolean d = this.f18051b.mo19914d();
        long unused = this.f18051b.f18069c = 0;
        if (d) {
            this.f18051b.mo19827b();
        }
    }
}
