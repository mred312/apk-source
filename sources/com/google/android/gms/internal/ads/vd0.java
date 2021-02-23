package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class vd0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f11601a;

    /* renamed from: b */
    private final /* synthetic */ long f11602b;

    /* renamed from: c */
    private final /* synthetic */ long f11603c;

    /* renamed from: d */
    private final /* synthetic */ zzik f11604d;

    vd0(zzik zzik, int i, long j, long j2) {
        this.f11604d = zzik;
        this.f11601a = i;
        this.f11602b = j;
        this.f11603c = j2;
    }

    public final void run() {
        this.f11604d.f16466b.zza(this.f11601a, this.f11602b, this.f11603c);
    }
}
