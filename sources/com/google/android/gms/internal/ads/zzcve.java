package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcve implements zzcqz<zzchc> {

    /* renamed from: a */
    private final Context f14935a;

    /* renamed from: b */
    private final zzchp f14936b;

    /* renamed from: c */
    private final zzchf f14937c;

    /* renamed from: d */
    private final zzdnn f14938d;

    /* renamed from: e */
    private final Executor f14939e;

    /* renamed from: f */
    private final zzazh f14940f;

    public zzcve(Context context, zzazh zzazh, zzdnn zzdnn, Executor executor, zzchf zzchf, zzchp zzchp) {
        this.f14935a = context;
        this.f14938d = zzdnn;
        this.f14937c = zzchf;
        this.f14939e = executor;
        this.f14940f = zzazh;
        this.f14936b = zzchp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17009a(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzdmu zzdmu2 = zzdmu;
        zzdnj zzdnj2 = zzdnj;
        zzbdv zza = this.f14936b.zza(this.f14938d.zzbpe, zzdmu2, zzdnj2.zzhik.zzerj, zzdmu2.zzerh);
        zza.zzaw(zzdmu2.zzdvo);
        zzcif.zzc(this.f14935a, zza.getView());
        zzazq zzazq = new zzazq();
        zzchf zzchf = this.f14937c;
        zzbos zzbos = new zzbos(zzdnj2, zzdmu2, (String) null);
        C1740aq aqVar = r1;
        C1740aq aqVar2 = new C1740aq(this.f14935a, this.f14936b, this.f14938d, this.f14940f, zzdmu, zzazq, zza);
        zzche zza2 = zzchf.zza(zzbos, new zzchd(aqVar, zza));
        zzazq.set(zza2);
        zzaig.zza(zza, (zzaij) zza2.zzahr());
        zza2.zzaft().zza(new C2521vp(zza), zzazj.zzegu);
        zza2.zzagr().zzb(zza, true);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu2.zzerh) {
            zza2.zzagr();
            zzdnb zzdnb = zzdmu2.zzhgx;
            zzdyz = zzchr.zza(zza, zzdnb.zzdrn, zzdnb.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new C2634yp(this, zza, zzdmu2, zza2), this.f14939e);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzchc> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzchc> zzb = zzdyr.zzb(zzdyr.zzag(null), new C2484up(this, zzdmu, zzdnj, zzcif), this.f14939e);
        zzb.addListener(C2558wp.m7137a(zzcif), this.f14939e);
        return zzb;
    }
}
