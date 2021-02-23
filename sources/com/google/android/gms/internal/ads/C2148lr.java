package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.lr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2148lr implements zzcyn<zzboc> {

    /* renamed from: a */
    private final /* synthetic */ zzcyh f9886a;

    C2148lr(zzcyh zzcyh) {
        this.f9886a = zzcyh;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.f9886a) {
            boolean unused = this.f9886a.f15060d = false;
            zzyn unused2 = this.f9886a.f15059c = zzboc.zzajz();
            zzboc.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.f9886a) {
            boolean unused = this.f9886a.f15060d = false;
        }
    }
}
