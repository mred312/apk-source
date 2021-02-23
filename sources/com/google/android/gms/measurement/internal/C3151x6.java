package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.x6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3151x6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzej f18453a;

    /* renamed from: b */
    private final /* synthetic */ zzji f18454b;

    C3151x6(zzji zzji, zzej zzej) {
        this.f18454b = zzji;
        this.f18453a = zzej;
    }

    public final void run() {
        synchronized (this.f18454b) {
            boolean unused = this.f18454b.f18679a = false;
            if (!this.f18454b.f18681c.zzaa()) {
                this.f18454b.f18681c.zzq().zzv().zza("Connected to remote service");
                this.f18454b.f18681c.zza(this.f18453a);
            }
        }
    }
}
