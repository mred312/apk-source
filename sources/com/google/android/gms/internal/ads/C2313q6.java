package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.q6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2313q6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f10685a;

    /* renamed from: b */
    private final /* synthetic */ int f10686b;

    /* renamed from: c */
    private final /* synthetic */ zzbac f10687c;

    C2313q6(zzbac zzbac, int i, int i2) {
        this.f10687c = zzbac;
        this.f10685a = i;
        this.f10686b = i2;
    }

    public final void run() {
        if (this.f10687c.f12998p != null) {
            this.f10687c.f12998p.zzk(this.f10685a, this.f10686b);
        }
    }
}
