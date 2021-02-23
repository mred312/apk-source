package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdju<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdjy<AdT>> {

    /* renamed from: a */
    private final zzdpd f15709a;

    /* renamed from: b */
    private final Executor f15710b;

    /* renamed from: c */
    private zzdyo<Void> f15711c = new C2528vw(this);

    public zzdju(zzdpd zzdpd, Executor executor) {
        this.f15709a = zzdpd;
        this.f15710b = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17129a(zzdkm zzdkm, zzdkn zzdkn, zzdkj zzdkj) {
        zzdpq zzdpq = zzdkj.zzhex;
        zzatl zzatl = zzdkj.zzgnh;
        zzdpn<?> zza = zzdpq != null ? this.f15709a.zza(zzdpq) : null;
        if (zzdpq == null) {
            return zzdyr.zzag(null);
        }
        if (!(zza == null || zzatl == null)) {
            zzdyr.zza(((zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp()).zzagh().zzc(zzatl), this.f15711c, this.f15710b);
        }
        return zzdyr.zzag(new zzdjy(zzdpq, zzatl, zza));
    }

    public final zzdyz<zzdjy<AdT>> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        return zzdyi.zzg(new C2641yw(this.f15709a, zzdkm.zzhfk, zzdkn, this.f15710b).mo15071c()).zzb(new C2491uw(this, zzdkm, zzdkn), this.f15710b).zza(Exception.class, new C2454tw(this), this.f15710b);
    }

    public final /* bridge */ /* synthetic */ Object zzaty() {
        return null;
    }
}
