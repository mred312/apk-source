package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.l4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3041l4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18206a;

    /* renamed from: b */
    private final /* synthetic */ String f18207b;

    /* renamed from: c */
    private final /* synthetic */ String f18208c;

    /* renamed from: d */
    private final /* synthetic */ long f18209d;

    /* renamed from: e */
    private final /* synthetic */ zzfw f18210e;

    C3041l4(zzfw zzfw, String str, String str2, String str3, long j) {
        this.f18210e = zzfw;
        this.f18206a = str;
        this.f18207b = str2;
        this.f18208c = str3;
        this.f18209d = j;
    }

    public final void run() {
        String str = this.f18206a;
        if (str == null) {
            this.f18210e.f18635a.mo20512V().zzu().zza(this.f18207b, (zzig) null);
            return;
        }
        this.f18210e.f18635a.mo20512V().zzu().zza(this.f18207b, new zzig(this.f18208c, str, this.f18209d));
    }
}
