package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzctw implements zzcrh<zzcbt, zzdoe, zzcst> {

    /* renamed from: a */
    private final Context f14847a;

    /* renamed from: b */
    private final zzcat f14848b;

    /* renamed from: c */
    private final Executor f14849c;

    public zzctw(Context context, zzcat zzcat, Executor executor) {
        this.f14847a = context;
        this.f14848b = zzcat;
        this.f14849c = executor;
    }

    /* renamed from: a */
    private static boolean m8270a(zzdnj zzdnj, int i) {
        return zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(i));
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        zzdnn zzdnn = zzdnj.zzhij.zzfvl;
        ((zzdoe) zzcrb.zzdmo).zza(this.f14847a, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp, zzdnn.zzdnh, zzdnn.zzhiq);
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzcce zzcce;
        zzanv zzue = ((zzdoe) zzcrb.zzdmo).zzue();
        zzanw zzuf = ((zzdoe) zzcrb.zzdmo).zzuf();
        zzaob zzuk = ((zzdoe) zzcrb.zzdmo).zzuk();
        if (zzuk != null && m8270a(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzuk);
        } else if (zzue != null && m8270a(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzue);
        } else if (zzue != null && m8270a(zzdnj, 2)) {
            zzcce = zzcce.zza(zzue);
        } else if (zzuf != null && m8270a(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzuf);
        } else if (zzuf == null || !m8270a(zzdnj, 1)) {
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No native ad mappers");
        } else {
            zzcce = zzcce.zza(zzuf);
        }
        if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(zzcce.zzanc()))) {
            zzccf zza = this.f14848b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzccq(zzcce), new zzceb(zzuf, zzue, zzuk));
            ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
            zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.f14849c);
            return zza.zzafx();
        }
        throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
    }
}
