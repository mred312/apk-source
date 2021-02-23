package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3131v4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18407a;

    /* renamed from: b */
    private final /* synthetic */ String f18408b;

    /* renamed from: c */
    private final /* synthetic */ Object f18409c;

    /* renamed from: d */
    private final /* synthetic */ long f18410d;

    /* renamed from: e */
    private final /* synthetic */ zzgy f18411e;

    C3131v4(zzgy zzgy, String str, String str2, Object obj, long j) {
        this.f18411e = zzgy;
        this.f18407a = str;
        this.f18408b = str2;
        this.f18409c = obj;
        this.f18410d = j;
    }

    public final void run() {
        this.f18411e.mo20389m(this.f18407a, this.f18408b, this.f18409c, this.f18410d);
    }
}
