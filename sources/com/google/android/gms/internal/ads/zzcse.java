package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcse implements zzcrh<zzbme, zzdoe, zzcst> {

    /* renamed from: a */
    private final Context f14775a;

    /* renamed from: b */
    private final zzazh f14776b;

    /* renamed from: c */
    private final zzbna f14777c;

    /* renamed from: d */
    private final Executor f14778d;

    public zzcse(Context context, zzazh zzazh, zzbna zzbna, Executor executor) {
        this.f14775a = context;
        this.f14776b = zzazh;
        this.f14777c = zzbna;
        this.f14778d = executor;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        zzvn zzvn;
        zzvn zzvn2 = zzdnj.zzhij.zzfvl.zzbpe;
        if (zzvn2.zzchw) {
            zzvn = new zzvn(this.f14775a, zzb.zza(zzvn2.width, zzvn2.height));
        } else {
            zzvn = zzdns.zzb(this.f14775a, zzdmu.zzhgz);
        }
        zzvn zzvn3 = zzvn;
        if (this.f14776b.zzegm < 4100000) {
            ((zzdoe) zzcrb.zzdmo).zza(this.f14775a, zzvn3, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
        } else {
            ((zzdoe) zzcrb.zzdmo).zza(this.f14775a, zzvn3, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbna zzbna = this.f14777c;
        zzbos zzbos = new zzbos(zzdnj, zzdmu, zzcrb.zzchy);
        View view = ((zzdoe) zzcrb.zzdmo).getView();
        zzdoe zzdoe = (zzdoe) zzcrb.zzdmo;
        zzdoe.getClass();
        zzbmd zza = zzbna.zza(zzbos, new zzbmh(view, (zzbdv) null, C2257oo.m6595a(zzdoe), zzdmu.zzhgz.get(0)));
        zza.zzahd().zzv(((zzdoe) zzcrb.zzdmo).getView());
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.f14778d);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
        return zza.zzahc();
    }
}
