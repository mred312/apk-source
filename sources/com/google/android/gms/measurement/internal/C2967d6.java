package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.d6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2967d6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f18020a;

    /* renamed from: b */
    private final /* synthetic */ zzkr f18021b;

    /* renamed from: c */
    private final /* synthetic */ zzn f18022c;

    /* renamed from: d */
    private final /* synthetic */ zzio f18023d;

    C2967d6(zzio zzio, boolean z, zzkr zzkr, zzn zzn) {
        this.f18023d = zzio;
        this.f18020a = z;
        this.f18021b = zzkr;
        this.f18022c = zzn;
    }

    public final void run() {
        zzej q = this.f18023d.f18673c;
        if (q == null) {
            this.f18023d.zzq().zze().zza("Discarding data. Failed to set user property");
            return;
        }
        this.f18023d.mo20457e(q, this.f18020a ? null : this.f18021b, this.f18022c);
        this.f18023d.zzaj();
    }
}
