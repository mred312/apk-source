package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcth implements zzcrh<zzbyx, zzapo, zzcst> {

    /* renamed from: a */
    private final Context f14827a;

    /* renamed from: b */
    private final zzbzx f14828b;

    public zzcth(Context context, zzbzx zzbzx) {
        this.f14827a = context;
        this.f14828b = zzbzx;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.f14827a), (zzaph) new C1961gp(this, zzcrb), (zzano) zzcrb.zzgqp);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        C1887ep epVar = new C1887ep(zzdmu, (zzapo) zzcrb.zzdmo, false);
        zzbyz zza = this.f14828b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbzc(epVar));
        epVar.mo13915a(zza.zzaft());
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
        return zza.zzahh();
    }
}
