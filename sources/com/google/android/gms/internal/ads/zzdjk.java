package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdjk<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdpn<AdT>> {

    /* renamed from: a */
    private R f15697a;

    /* renamed from: b */
    private final Executor f15698b = zzdzb.zzazo();

    public final zzdyz<zzdpn<AdT>> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzdyz<zzdnj> zzdyz;
        zzbrd<R> zzc = zzdkn.zzc(zzdkm.zzhfk);
        zzc.zza(new zzdkt(true));
        R r = (zzbre) zzc.zzafp();
        this.f15697a = r;
        zzboz zzagh = r.zzagh();
        zzdpn zzdpn = new zzdpn();
        zzatl zzatl = zzdkm.zzhfj;
        if (zzatl != null) {
            zzdyz = zzagh.zza(zzatl);
        } else {
            zzdyz = zzagh.zzaki();
        }
        return zzdyi.zzg(zzdyz).zzb(new C2227nw(this, zzdpn, zzagh), this.f15698b).zza(new C2190mw(zzdpn), this.f15698b);
    }

    public final /* synthetic */ Object zzaty() {
        return this.f15697a;
    }
}
