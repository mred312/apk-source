package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.my */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2192my implements zzcyn<zzchc> {

    /* renamed from: a */
    private final /* synthetic */ zzdmo f10022a;

    C2192my(zzdmo zzdmo) {
        this.f10022a = zzdmo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.f10022a) {
            zzchc unused = this.f10022a.f15778d = zzchc;
            this.f10022a.f15778d.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.f10022a) {
            zzchc unused = this.f10022a.f15778d = null;
        }
    }
}
