package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkq implements zzepf<zzdkl<zzchf, zzchc>> {

    /* renamed from: a */
    private final zzeps<Context> f15719a;

    /* renamed from: b */
    private final zzeps<zzdpa> f15720b;

    /* renamed from: c */
    private final zzeps<zzdpr> f15721c;

    public zzdkq(zzeps<Context> zzeps, zzeps<zzdpa> zzeps2, zzeps<zzdpr> zzeps3) {
        this.f15719a = zzeps;
        this.f15720b = zzeps2;
        this.f15721c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.f15719a.get();
        zzdpa zzdpa = this.f15720b.get();
        zzdpr zzdpr = this.f15721c.get();
        if (((Integer) zzwq.zzqe().zzd(zzabf.zzcxb)).intValue() > 0) {
            zzdpu zza = zzdpr.zza(zzdpj.Rewarded, context, zzdpa, new C2417sw(new zzdjk()));
            zzdkc zzdkc = new zzdkc(new zzdkd());
            zzdpd zzdpd = zza.zzhez;
            zzdzc zzdzc = zzazj.zzegp;
            obj = new zzdjp(zzdkc, new zzdju(zzdpd, zzdzc), zza.zzhmg, zzdzc);
        } else {
            obj = new zzdkd();
        }
        return (zzdkl) zzepl.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
