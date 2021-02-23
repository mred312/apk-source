package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.jy */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2081jy implements zzcyn<zzchc> {

    /* renamed from: a */
    private final /* synthetic */ zzdmi f9548a;

    C2081jy(zzdmi zzdmi) {
        this.f9548a = zzdmi;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.f9548a) {
            zzchc unused = this.f9548a.f15762f = zzchc;
            this.f9548a.f15762f.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.f9548a) {
            zzchc unused = this.f9548a.f15762f = null;
        }
    }
}
