package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsv implements zzcqz<zzbyx> {

    /* renamed from: a */
    private final Context f14808a;

    /* renamed from: b */
    private final zzchp f14809b;

    /* renamed from: c */
    private final zzbzx f14810c;

    /* renamed from: d */
    private final zzdnn f14811d;

    /* renamed from: e */
    private final Executor f14812e;

    /* renamed from: f */
    private final zzazh f14813f;

    public zzcsv(Context context, zzazh zzazh, zzdnn zzdnn, Executor executor, zzbzx zzbzx, zzchp zzchp) {
        this.f14808a = context;
        this.f14811d = zzdnn;
        this.f14810c = zzbzx;
        this.f14812e = executor;
        this.f14813f = zzazh;
        this.f14809b = zzchp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16994a(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzbdv zza = this.f14809b.zza(this.f14811d.zzbpe, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        zzcif.zzc(this.f14808a, zza.getView());
        zzazq zzazq = new zzazq();
        zzbyz zza2 = this.f14810c.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new C1813cp(this.f14808a, this.f14813f, zzazq, zzdmu, zza), zza));
        zzazq.set(zza2);
        zza2.zzaft().zza(new C1776bp(zza), zzazj.zzegu);
        zza2.zzagr().zzb(zza, true);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu.zzerh) {
            zza2.zzagr();
            zzdnb zzdnb = zzdmu.zzhgx;
            zzdyz = zzchr.zza(zza, zzdnb.zzdrn, zzdnb.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new C2670zo(this, zza, zzdmu, zza2), this.f14812e);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbyx> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzbyx> zzb = zzdyr.zzb(zzdyr.zzag(null), new C2633yo(this, zzdmu, zzdnj, zzcif), this.f14812e);
        zzb.addListener(C2595xo.m7268a(zzcif), this.f14812e);
        return zzb;
    }
}
