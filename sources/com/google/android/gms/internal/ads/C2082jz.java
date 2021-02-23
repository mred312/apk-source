package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.jz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2082jz implements zzdyo<zzdpn<AdT>> {

    /* renamed from: a */
    private final /* synthetic */ zzdpv f9549a;

    C2082jz(zzdpv zzdpv) {
        this.f9549a = zzdpv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdpn zzdpn = (zzdpn) obj;
        synchronized (this.f9549a) {
            this.f9549a.f15874g.zza(zzdpn);
            if (this.f9549a.f15872e != C2156lz.f9897b) {
                this.f9549a.f15873f.zza(this.f9549a.f15869b.zzaua(), zzdpn);
            }
            int f = this.f9549a.f15872e;
            int i = C2156lz.f9896a;
            if (f == i) {
                zzdpv zzdpv = this.f9549a;
                zzdpv.m8465j(zzdpv.f15869b);
            }
            int unused = this.f9549a.f15872e = i;
            this.f9549a.f15870c.set(zzdpn);
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.f9549a) {
            this.f9549a.f15874g.zzb(th);
            this.f9549a.f15870c.setException(th);
        }
    }
}
