package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.g4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2995g4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzkr f18079a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18080b;

    /* renamed from: c */
    private final /* synthetic */ zzfw f18081c;

    C2995g4(zzfw zzfw, zzkr zzkr, zzn zzn) {
        this.f18081c = zzfw;
        this.f18079a = zzkr;
        this.f18080b = zzn;
    }

    public final void run() {
        this.f18081c.f18635a.mo20510T();
        if (this.f18079a.zza() == null) {
            this.f18081c.f18635a.mo20502J(this.f18079a, this.f18080b);
        } else {
            this.f18081c.f18635a.mo20518p(this.f18079a, this.f18080b);
        }
    }
}
