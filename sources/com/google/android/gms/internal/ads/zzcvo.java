package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcvo implements zzcrh<zzchc, zzdoe, zzcsw> {

    /* renamed from: a */
    private final Context f14947a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f14948b;

    /* renamed from: c */
    private final zzchf f14949c;

    public zzcvo(Context context, Executor executor, zzchf zzchf) {
        this.f14947a = context;
        this.f14948b = executor;
        this.f14949c = zzchf;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m8284c(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcsw> zzcrb) {
        try {
            ((zzdoe) zzcrb.zzdmo).zza(zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrb.zzchy);
            zzaza.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcsw> zzcrb) {
        if (!((zzdoe) zzcrb.zzdmo).isInitialized()) {
            ((zzcsw) zzcrb.zzgqp).zza((zzbyl) new C1888eq(this, zzdnj, zzdmu, zzcrb));
            ((zzdoe) zzcrb.zzdmo).zza(this.f14947a, zzdnj.zzhij.zzfvl.zzhio, (String) null, (zzauw) zzcrb.zzgqp, zzdmu.zzhha.toString());
            return;
        }
        m8284c(zzdnj, zzdmu, zzcrb);
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzche zza = this.f14949c.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(new C1814cq(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.f14948b);
        zzbsu zzafr = zza.zzafr();
        zzbrt zzafs = zza.zzafs();
        ((zzcsw) zzcrb.zzgqp).zza((zzauw) new C1925fq(this, zza.zzahi(), zzafs, zzafr, zza.zzahr()));
        return zza.zzahq();
    }
}
