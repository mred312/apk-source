package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.n1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2196n1 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f10028a;

    /* renamed from: b */
    private final /* synthetic */ zzakq f10029b;

    C2196n1(zzakq zzakq, String str) {
        this.f10029b = zzakq;
        this.f10028a = str;
    }

    public final void run() {
        this.f10029b.f12502a.loadUrl(this.f10028a);
    }
}
