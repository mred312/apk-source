package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.j5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3024j5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzad f18179a;

    /* renamed from: b */
    private final /* synthetic */ long f18180b;

    /* renamed from: c */
    private final /* synthetic */ int f18181c;

    /* renamed from: d */
    private final /* synthetic */ long f18182d;

    /* renamed from: e */
    private final /* synthetic */ boolean f18183e;

    /* renamed from: f */
    private final /* synthetic */ zzgy f18184f;

    C3024j5(zzgy zzgy, zzad zzad, long j, int i, long j2, boolean z) {
        this.f18184f = zzgy;
        this.f18179a = zzad;
        this.f18180b = j;
        this.f18181c = i;
        this.f18182d = j2;
        this.f18183e = z;
    }

    public final void run() {
        this.f18184f.mo20386c(this.f18179a);
        this.f18184f.mo20385b(this.f18180b, false);
        this.f18184f.m10828d(this.f18179a, this.f18181c, this.f18182d, true, this.f18183e);
    }
}
