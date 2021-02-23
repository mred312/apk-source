package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class yg0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12202a;

    /* renamed from: b */
    private final /* synthetic */ long f12203b;

    /* renamed from: c */
    private final /* synthetic */ long f12204c;

    /* renamed from: d */
    private final /* synthetic */ zzqj f12205d;

    yg0(zzqj zzqj, String str, long j, long j2) {
        this.f12205d = zzqj;
        this.f12202a = str;
        this.f12203b = j;
        this.f12204c = j2;
    }

    public final void run() {
        this.f12205d.f16894b.zzd(this.f12202a, this.f12203b, this.f12204c);
    }
}
