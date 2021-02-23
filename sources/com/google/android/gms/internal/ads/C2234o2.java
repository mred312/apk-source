package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.o2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2234o2 implements zzazs {

    /* renamed from: a */
    private final /* synthetic */ zzazq f10244a;

    /* renamed from: b */
    private final /* synthetic */ zzalo f10245b;

    C2234o2(zzamm zzamm, zzazq zzazq, zzalo zzalo) {
        this.f10244a = zzazq;
        this.f10245b = zzalo;
    }

    public final void run() {
        this.f10244a.setException(new zzama("Unable to obtain a JavascriptEngine."));
        this.f10245b.release();
    }
}
