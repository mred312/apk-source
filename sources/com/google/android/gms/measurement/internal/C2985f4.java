package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.f4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2985f4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzar f18055a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18056b;

    /* renamed from: c */
    private final /* synthetic */ zzfw f18057c;

    C2985f4(zzfw zzfw, zzar zzar, zzn zzn) {
        this.f18057c = zzfw;
        this.f18055a = zzar;
        this.f18056b = zzn;
    }

    public final void run() {
        zzar e = this.f18057c.mo20384e(this.f18055a, this.f18056b);
        this.f18057c.f18635a.mo20510T();
        this.f18057c.f18635a.mo20515j(e, this.f18056b);
    }
}
