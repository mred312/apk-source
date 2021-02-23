package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.r0 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3091r0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18333a;

    /* renamed from: b */
    private final /* synthetic */ long f18334b;

    /* renamed from: c */
    private final /* synthetic */ zza f18335c;

    C3091r0(zza zza, String str, long j) {
        this.f18335c = zza;
        this.f18333a = str;
        this.f18334b = j;
    }

    public final void run() {
        this.f18335c.m10646g(this.f18333a, this.f18334b);
    }
}
