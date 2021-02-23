package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;

/* renamed from: com.google.android.gms.internal.ads.e7 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1869e7 implements Runnable {

    /* renamed from: a */
    private zzbar f8320a;

    /* renamed from: b */
    private boolean f8321b = false;

    C1869e7(zzbar zzbar) {
        this.f8320a = zzbar;
    }

    /* renamed from: c */
    private final void m6010c() {
        zzduw zzduw = zzm.zzedd;
        zzduw.removeCallbacks(this);
        zzduw.postDelayed(this, 250);
    }

    /* renamed from: a */
    public final void mo13869a() {
        this.f8321b = true;
        this.f8320a.mo15976f();
    }

    /* renamed from: b */
    public final void mo13870b() {
        this.f8321b = false;
        m6010c();
    }

    public final void run() {
        if (!this.f8321b) {
            this.f8320a.mo15976f();
            m6010c();
        }
    }
}
