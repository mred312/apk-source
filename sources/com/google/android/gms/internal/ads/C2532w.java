package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.w */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2532w implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f11649a;

    /* renamed from: b */
    private final /* synthetic */ long f11650b;

    /* renamed from: c */
    private final /* synthetic */ zzaa f11651c;

    C2532w(zzaa zzaa, String str, long j) {
        this.f11651c = zzaa;
        this.f11649a = str;
        this.f11650b = j;
    }

    public final void run() {
        this.f11651c.zzao.mo15615a(this.f11649a, this.f11650b);
        this.f11651c.zzao.mo15616b(this.f11651c.toString());
    }
}
