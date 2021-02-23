package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.u4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3122u4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ long f18392a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18393b;

    C3122u4(zzgy zzgy, long j) {
        this.f18393b = zzgy;
        this.f18392a = j;
    }

    public final void run() {
        this.f18393b.zzr().f18239o.zza(this.f18392a);
        this.f18393b.zzq().zzv().zza("Minimum session duration set", Long.valueOf(this.f18392a));
    }
}
