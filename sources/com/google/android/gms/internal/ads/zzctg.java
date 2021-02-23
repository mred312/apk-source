package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzctg implements zzcrh<zzbyx, zzdoe, zzcst> {

    /* renamed from: a */
    private final Context f14823a;

    /* renamed from: b */
    private final zzbzx f14824b;

    /* renamed from: c */
    private final zzazh f14825c;

    /* renamed from: d */
    private final Executor f14826d;

    public zzctg(Context context, zzazh zzazh, zzbzx zzbzx, Executor executor) {
        this.f14823a = context;
        this.f14825c = zzazh;
        this.f14824b = zzbzx;
        this.f14826d = executor;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        if (this.f14825c.zzegm < 4100000) {
            ((zzdoe) zzcrb.zzdmo).zza(this.f14823a, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
        } else {
            ((zzdoe) zzcrb.zzdmo).zza(this.f14823a, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbyz zza = this.f14824b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbzc(new C1924fp(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.f14826d);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
        return zza.zzahh();
    }
}
