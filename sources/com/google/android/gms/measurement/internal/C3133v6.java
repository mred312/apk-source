package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3133v6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzej f18413a;

    /* renamed from: b */
    private final /* synthetic */ zzji f18414b;

    C3133v6(zzji zzji, zzej zzej) {
        this.f18414b = zzji;
        this.f18413a = zzej;
    }

    public final void run() {
        synchronized (this.f18414b) {
            boolean unused = this.f18414b.f18679a = false;
            if (!this.f18414b.f18681c.zzaa()) {
                this.f18414b.f18681c.zzq().zzw().zza("Connected to service");
                this.f18414b.f18681c.zza(this.f18413a);
            }
        }
    }
}
