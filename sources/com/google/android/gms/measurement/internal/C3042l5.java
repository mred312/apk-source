package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.l5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3042l5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f18211a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18212b;

    C3042l5(zzgy zzgy, boolean z) {
        this.f18212b = zzgy;
        this.f18211a = z;
    }

    public final void run() {
        boolean zzaa = this.f18212b.zzy.zzaa();
        boolean zzz = this.f18212b.zzy.zzz();
        this.f18212b.zzy.mo20352g(this.f18211a);
        if (zzz == this.f18211a) {
            this.f18212b.zzy.zzq().zzw().zza("Default data collection state already set to", Boolean.valueOf(this.f18211a));
        }
        if (this.f18212b.zzy.zzaa() == zzaa || this.f18212b.zzy.zzaa() != this.f18212b.zzy.zzz()) {
            this.f18212b.zzy.zzq().zzj().zza("Default data collection is different than actual status", Boolean.valueOf(this.f18211a), Boolean.valueOf(zzaa));
        }
        this.f18212b.m10835n();
    }
}
