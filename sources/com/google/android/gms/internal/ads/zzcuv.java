package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcuv implements zzcrh<zzchc, zzapo, zzcst> {

    /* renamed from: a */
    private final Context f14915a;

    /* renamed from: b */
    private final zzchf f14916b;

    public zzcuv(Context context, zzchf zzchf) {
        this.f14915a = context;
        this.f14916b = zzchf;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            if (zzdnj.zzhij.zzfvl.zzhiv.zzhia == zzdnf.zzhie) {
                ((zzapo) zzcrb.zzdmo).zzb(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.f14915a), new C2410sp(this, zzcrb), (zzano) zzcrb.zzgqp);
            } else {
                ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.f14915a), (zzapn) new C2410sp(this, zzcrb), (zzano) zzcrb.zzgqp);
            }
        } catch (RemoteException e) {
            zzd.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        C1887ep epVar = new C1887ep(zzdmu, (zzapo) zzcrb.zzdmo, true);
        zzche zza = this.f14916b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(epVar));
        epVar.mo13915a(zza.zzaft());
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzaht());
        return zza.zzahq();
    }
}
