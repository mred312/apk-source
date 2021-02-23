package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.kr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2111kr implements zzcyn<zzbyx> {

    /* renamed from: a */
    private final /* synthetic */ zzcyg f9774a;

    C2111kr(zzcyg zzcyg) {
        this.f9774a = zzcyg;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyx zzbyx = (zzbyx) obj;
        synchronized (this.f9774a) {
            zzbyx unused = this.f9774a.f15055g = zzbyx;
            this.f9774a.f15055g.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.f9774a) {
            zzbyx unused = this.f9774a.f15055g = null;
        }
    }
}
