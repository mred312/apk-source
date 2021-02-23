package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import com.google.android.gms.internal.ads.zzue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdjp<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, AdT> {

    /* renamed from: a */
    private final zzdkl<R, AdT> f15704a;

    /* renamed from: b */
    private final zzdkl<R, zzdjy<AdT>> f15705b;

    /* renamed from: c */
    private final zzdpv<AdT> f15706c;
    @GuardedBy("this")

    /* renamed from: d */
    private R f15707d;

    /* renamed from: e */
    private final Executor f15708e;

    public zzdjp(zzdkl<R, AdT> zzdkl, zzdkl<R, zzdjy<AdT>> zzdkl2, zzdpv<AdT> zzdpv, Executor executor) {
        this.f15704a = zzdkl;
        this.f15705b = zzdkl2;
        this.f15706c = zzdpv;
        this.f15708e = executor;
    }

    /* renamed from: c */
    private final zzdyz<AdT> m8395c(zzdpn<AdT> zzdpn, zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzbrd<R> zzc = zzdkn.zzc(zzdkm.zzhfk);
        if (zzdpn.zzhmc != null) {
            zzbre zzbre = (zzbre) zzc.zzafp();
            if (zzbre.zzagp() != null) {
                zzdpn.zzhmc.zzaka().zzb(zzbre.zzagp());
            }
            return zzdyr.zzag(zzdpn.zzhmc);
        }
        zzc.zza(zzdpn.zzext);
        zzdyz<AdT> zza = this.f15704a.zza(zzdkm, new C2339qw(zzc));
        this.f15707d = (zzbre) this.f15704a.zzaty();
        return zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final synchronized R zzaty() {
        return this.f15707d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17127a(zzdkm zzdkm, C2376rw rwVar, zzdkn zzdkn, zzdjy zzdjy) {
        if (zzdjy != null) {
            C2376rw rwVar2 = new C2376rw(rwVar.f10827a, rwVar.f10828b, rwVar.f10829c, rwVar.f10830d, rwVar.f10831e, rwVar.f10832f, zzdjy.zzhex);
            if (zzdjy.zzhfe != null) {
                this.f15707d = null;
                this.f15706c.zzb(rwVar2);
                return m8395c(zzdjy.zzhfe, zzdkm, zzdkn);
            }
            zzdyz<zzdpz<AdT>> zzc = this.f15706c.zzc(rwVar2);
            if (zzc != null) {
                this.f15707d = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
                return zzdyr.zzb(zzc, new C2302pw(this, zzdkn), this.f15708e);
            }
            this.f15706c.zzb(rwVar2);
            zzdkm = new zzdkm(zzdkm.zzhfk, zzdjy.zzgnh);
        }
        zzdyz<AdT> zza = this.f15704a.zza(zzdkm, zzdkn);
        this.f15707d = (zzbre) this.f15704a.zzaty();
        return zza;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo17128b(zzdkn zzdkn, zzdpz zzdpz) {
        zzdqb zzdqb;
        if (zzdpz == null || zzdpz.zzhfe == null || (zzdqb = zzdpz.zzhmr) == null) {
            throw new zzcme(zzdok.INTERNAL_ERROR, "Empty prefetch");
        }
        zzdpz.zzhfe.zzhmb.zzakk().zze((zzue.zzb) ((zzekh) zzue.zzb.zznk().zza(zzue.zzb.zza.zznm().zza(zzue.zzb.C3994zzb.IN_MEMORY).zza(zzue.zzb.zzd.zzno())).zzbhv()));
        return m8395c(zzdpz.zzhfe, ((C2376rw) zzdqb).f10828b, zzdkn);
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzdnn zzago;
        zzdkn<R> zzdkn2;
        zzdkm zzdkm2;
        zzago = ((zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp()).zzago();
        zzdkn2 = zzdkn;
        zzdkm2 = zzdkm;
        return zzdyi.zzg(this.f15705b.zza(zzdkm, zzdkn)).zzb(new C2265ow(this, zzdkm, new C2376rw(zzdkn2, zzdkm2, zzago.zzhio, zzago.zzhip, this.f15708e, zzago.zzhis, (zzdpq) null), zzdkn), this.f15708e);
    }
}
