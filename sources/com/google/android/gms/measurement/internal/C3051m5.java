package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.m5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3051m5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzad f18251a;

    /* renamed from: b */
    private final /* synthetic */ int f18252b;

    /* renamed from: c */
    private final /* synthetic */ long f18253c;

    /* renamed from: d */
    private final /* synthetic */ boolean f18254d;

    /* renamed from: e */
    private final /* synthetic */ zzgy f18255e;

    C3051m5(zzgy zzgy, zzad zzad, int i, long j, boolean z) {
        this.f18255e = zzgy;
        this.f18251a = zzad;
        this.f18252b = i;
        this.f18253c = j;
        this.f18254d = z;
    }

    public final void run() {
        this.f18255e.mo20386c(this.f18251a);
        this.f18255e.m10828d(this.f18251a, this.f18252b, this.f18253c, false, this.f18254d);
    }
}
