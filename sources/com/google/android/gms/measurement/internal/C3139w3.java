package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.w3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3139w3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18424a;

    /* renamed from: b */
    private final /* synthetic */ zzfw f18425b;

    C3139w3(zzfw zzfw, zzw zzw) {
        this.f18425b = zzfw;
        this.f18424a = zzw;
    }

    public final void run() {
        this.f18425b.f18635a.mo20510T();
        if (this.f18424a.zzc.zza() == null) {
            this.f18425b.f18635a.mo20504L(this.f18424a);
        } else {
            this.f18425b.f18635a.mo20520r(this.f18424a);
        }
    }
}
