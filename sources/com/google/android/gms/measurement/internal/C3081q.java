package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.q */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3081q implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18308a;

    /* renamed from: b */
    private final /* synthetic */ long f18309b;

    /* renamed from: c */
    private final /* synthetic */ zza f18310c;

    C3081q(zza zza, String str, long j) {
        this.f18310c = zza;
        this.f18308a = str;
        this.f18309b = j;
    }

    public final void run() {
        this.f18310c.m10647h(this.f18308a, this.f18309b);
    }
}
