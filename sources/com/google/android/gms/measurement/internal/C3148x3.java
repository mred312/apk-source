package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.x3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3148x3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18445a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18446b;

    /* renamed from: c */
    private final /* synthetic */ zzfw f18447c;

    C3148x3(zzfw zzfw, zzw zzw, zzn zzn) {
        this.f18447c = zzfw;
        this.f18445a = zzw;
        this.f18446b = zzn;
    }

    public final void run() {
        this.f18447c.f18635a.mo20510T();
        if (this.f18445a.zzc.zza() == null) {
            this.f18447c.f18635a.mo20505M(this.f18445a, this.f18446b);
        } else {
            this.f18447c.f18635a.mo20521s(this.f18445a, this.f18446b);
        }
    }
}
