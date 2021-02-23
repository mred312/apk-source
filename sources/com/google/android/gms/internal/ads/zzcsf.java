package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsf implements zzcrh<zzbme, zzapo, zzcst> {

    /* renamed from: a */
    private final Context f14779a;

    /* renamed from: b */
    private final zzbna f14780b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f14781c;

    public zzcsf(Context context, zzbna zzbna) {
        this.f14779a = context;
        this.f14780b = zzbna;
    }

    /* renamed from: b */
    static final /* synthetic */ zzys m8257b(zzcrb zzcrb) {
        try {
            return ((zzapo) zzcrb.zzdmo).getVideoController();
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.f14779a), new C2368ro(this, zzcrb), (zzano) zzcrb.zzgqp, zzdnj.zzhij.zzfvl.zzbpe);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbmd zza = this.f14780b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbmh(this.f14781c, (zzbdv) null, new C2331qo(zzcrb), zzdmu.zzhgz.get(0)));
        zza.zzahd().zzv(this.f14781c);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
        return zza.zzahc();
    }
}
