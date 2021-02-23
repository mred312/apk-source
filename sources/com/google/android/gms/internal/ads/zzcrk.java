package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrk implements zzcqz<zzblv> {

    /* renamed from: a */
    private final zzblp f14737a;

    /* renamed from: b */
    private final Context f14738b;

    /* renamed from: c */
    private final zzchp f14739c;

    /* renamed from: d */
    private final zzdnn f14740d;

    /* renamed from: e */
    private final Executor f14741e;

    /* renamed from: f */
    private final zzazh f14742f;

    public zzcrk(zzblp zzblp, Context context, Executor executor, zzchp zzchp, zzdnn zzdnn, zzazh zzazh) {
        this.f14738b = context;
        this.f14737a = zzblp;
        this.f14741e = executor;
        this.f14739c = zzchp;
        this.f14740d = zzdnn;
        this.f14742f = zzazh;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16985a(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzbdv zza = this.f14739c.zza(this.f14740d.zzbpe, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        zzcif.zzc(this.f14738b, zza.getView());
        zzazq zzazq = new zzazq();
        zzbln zza2 = this.f14737a.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new C1886eo(this.f14738b, this.f14742f, zzazq, zzdmu, zza, this.f14740d), zza), new zzblq(zzdmu.zzfsa));
        zza2.zzagr().zzb(zza, false);
        zzazq.set(zza2);
        zza2.zzaft().zza(new C1775bo(zza), zzazj.zzegu);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu.zzerh) {
            zza2.zzagr();
            zzdnb zzdnb = zzdmu.zzhgx;
            zzdyz = zzchr.zza(zza, zzdnb.zzdrn, zzdnb.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new C1849do(this, zza, zzdmu, zza2), this.f14741e);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzblv> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzblv> zzb = zzdyr.zzb(zzdyr.zzag(null), new C1738ao(this, zzdmu, zzdnj, zzcif), this.f14741e);
        zzb.addListener(C1812co.m5918a(zzcif), this.f14741e);
        return zzb;
    }
}
