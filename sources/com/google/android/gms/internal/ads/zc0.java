package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zc0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12277a;

    /* renamed from: b */
    private final /* synthetic */ boolean f12278b;

    /* renamed from: c */
    private final /* synthetic */ zzfa f12279c;

    zc0(zzfa zzfa, int i, boolean z) {
        this.f12279c = zzfa;
        this.f12277a = i;
        this.f12278b = z;
    }

    public final void run() {
        zzcf.zza g = this.f12279c.mo17778g(this.f12277a, this.f12278b);
        zzcf.zza unused = this.f12279c.f16381i = g;
        if (zzfa.m8923e(this.f12277a, g)) {
            this.f12279c.mo17777b(this.f12277a + 1, this.f12278b);
        }
    }
}
