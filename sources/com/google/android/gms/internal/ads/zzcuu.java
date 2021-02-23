package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcuu implements zzcrh<zzchc, zzdoe, zzcst> {

    /* renamed from: a */
    private final Context f14912a;

    /* renamed from: b */
    private final Executor f14913b;

    /* renamed from: c */
    private final zzchf f14914c;

    public zzcuu(Context context, Executor executor, zzchf zzchf) {
        this.f14912a = context;
        this.f14913b = executor;
        this.f14914c = zzchf;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        try {
            zzdnn zzdnn = zzdnj.zzhij.zzfvl;
            if (zzdnn.zzhiv.zzhia == zzdnf.zzhie) {
                ((zzdoe) zzcrb.zzdmo).zzc(this.f14912a, zzdnn.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
            } else {
                ((zzdoe) zzcrb.zzdmo).zzb(this.f14912a, zzdnn.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrb.zzchy);
            zzaza.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzche zza = this.f14914c.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(new C2369rp(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.f14913b);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzahs());
        return zza.zzahq();
    }
}
