package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.y6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2615y6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f11989a;

    /* renamed from: b */
    private final /* synthetic */ zzbar f11990b;

    C2615y6(zzbar zzbar, boolean z) {
        this.f11990b = zzbar;
        this.f11989a = z;
    }

    public final void run() {
        this.f11990b.m7654e("windowVisibilityChanged", "isVisible", String.valueOf(this.f11989a));
    }
}
