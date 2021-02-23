package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrp implements zzcqz<zzbll> {

    /* renamed from: a */
    private final zzblg f14749a;

    /* renamed from: b */
    private final Context f14750b;

    /* renamed from: c */
    private final zzchp f14751c;

    /* renamed from: d */
    private final Executor f14752d;

    public zzcrp(zzblg zzblg, Context context, Executor executor, zzchp zzchp) {
        this.f14750b = context;
        this.f14749a = zzblg;
        this.f14752d = executor;
        this.f14751c = zzchp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16986a(zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        zzvn zzb = zzdns.zzb(this.f14750b, zzdmu.zzhgz);
        zzbdv zza = this.f14751c.zza(zzb, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zzbky zza2 = this.f14749a.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbkx(zza.getView(), zza, zzdns.zzg(zzb), zzdmu.zzfsa, zzdmu.zzfsb, zzdmu.zzfsc));
        zza2.zzagr().zzb(zza, false);
        zzbsl zzaft = zza2.zzaft();
        C1923fo foVar = new C1923fo(zza);
        zzdzc zzdzc = zzazj.zzegu;
        zzaft.zza(foVar, zzdzc);
        zza2.zzagr();
        zzdnb zzdnb = zzdmu.zzhgx;
        return zzdyr.zzb(zzchr.zza(zza, zzdnb.zzdrn, zzdnb.zzdrp), new C1997ho(zza2), (Executor) zzdzc);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbll> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzag(null), new C1960go(this, zzdnj, zzdmu), this.f14752d);
    }
}
