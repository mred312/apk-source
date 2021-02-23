package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.t6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2428t6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbac f11136a;

    C2428t6(zzbac zzbac) {
        this.f11136a = zzbac;
    }

    public final void run() {
        if (this.f11136a.f12998p != null) {
            this.f11136a.f12998p.onPaused();
            this.f11136a.f12998p.zzzu();
        }
    }
}
