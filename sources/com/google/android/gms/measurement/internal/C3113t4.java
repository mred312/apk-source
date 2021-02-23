package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.t4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3113t4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ long f18368a;

    /* renamed from: b */
    private final /* synthetic */ zzgy f18369b;

    C3113t4(zzgy zzgy, long j) {
        this.f18369b = zzgy;
        this.f18368a = j;
    }

    public final void run() {
        this.f18369b.zzr().f18240p.zza(this.f18368a);
        this.f18369b.zzq().zzv().zza("Session timeout duration set", Long.valueOf(this.f18368a));
    }
}
