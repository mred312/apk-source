package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.b5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1756b5 implements C2052j5 {

    /* renamed from: a */
    static final C2052j5 f7873a = new C1756b5();

    private C1756b5() {
    }

    /* renamed from: a */
    public final Object mo13631a(zzbgf zzbgf) {
        String currentScreenName = zzbgf.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbgf.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
