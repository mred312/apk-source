package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.u6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2465u6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbac f11251a;

    C2465u6(zzbac zzbac) {
        this.f11251a = zzbac;
    }

    public final void run() {
        if (this.f11251a.f12998p != null) {
            this.f11251a.f12998p.onPaused();
        }
    }
}
