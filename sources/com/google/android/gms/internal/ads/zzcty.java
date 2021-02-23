package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcty implements zzcrh<zzcbt, zzapo, zzcst> {

    /* renamed from: a */
    private final Context f14850a;

    /* renamed from: b */
    private final zzcat f14851b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzaob f14852c;

    public zzcty(Context context, zzcat zzcat) {
        this.f14850a = context;
        this.f14851b = zzcat;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.f14850a), (zzapi) new C2258op(this, zzcrb), (zzano) zzcrb.zzgqp);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(6))) {
            zzcce zzb = zzcce.zzb(this.f14852c);
            if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(zzb.zzanc()))) {
                zzccf zza = this.f14851b.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzccq(zzb), new zzceb((zzanw) null, (zzanv) null, this.f14852c));
                ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
                return zza.zzafx();
            }
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        throw new zzcuq(zzdok.INVALID_REQUEST, "Unified must be used for RTB.");
    }
}
