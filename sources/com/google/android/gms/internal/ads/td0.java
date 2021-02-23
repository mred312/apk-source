package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class td0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f11168a;

    /* renamed from: b */
    private final /* synthetic */ long f11169b;

    /* renamed from: c */
    private final /* synthetic */ long f11170c;

    /* renamed from: d */
    private final /* synthetic */ zzik f11171d;

    td0(zzik zzik, String str, long j, long j2) {
        this.f11171d = zzik;
        this.f11168a = str;
        this.f11169b = j;
        this.f11170c = j2;
    }

    public final void run() {
        this.f11171d.f16466b.zza(this.f11168a, this.f11169b, this.f11170c);
    }
}
