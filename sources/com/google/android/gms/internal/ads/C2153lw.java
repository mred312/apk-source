package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.lw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2153lw implements zzcyn<zzblv> {

    /* renamed from: a */
    private final /* synthetic */ zzdjf f9890a;

    C2153lw(zzdjf zzdjf) {
        this.f9890a = zzdjf;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzblv zzblv = (zzblv) obj;
        synchronized (this.f9890a) {
            zzblv zzblv2 = this.f9890a.zzhee;
            if (zzblv2 != null) {
                zzblv2.destroy();
            }
            zzdjf zzdjf = this.f9890a;
            zzdjf.zzhee = zzblv;
            zzdjf.m8390b(zzblv);
            zzdir a = this.f9890a.f15694f;
            zzdjf zzdjf2 = this.f9890a;
            a.zzb((zzsg) new zzbly(zzblv, zzdjf2, zzdjf2.f15694f));
            zzblv.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.f9890a) {
            this.f9890a.zzhee = null;
        }
    }
}
