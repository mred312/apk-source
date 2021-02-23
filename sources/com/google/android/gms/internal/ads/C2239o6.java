package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.o6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2239o6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f10257a;

    /* renamed from: b */
    private final /* synthetic */ String f10258b;

    /* renamed from: c */
    private final /* synthetic */ zzbac f10259c;

    C2239o6(zzbac zzbac, String str, String str2) {
        this.f10259c = zzbac;
        this.f10257a = str;
        this.f10258b = str2;
    }

    public final void run() {
        if (this.f10259c.f12998p != null) {
            this.f10259c.f12998p.zzm(this.f10257a, this.f10258b);
        }
    }
}
