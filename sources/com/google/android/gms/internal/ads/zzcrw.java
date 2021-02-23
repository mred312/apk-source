package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzag;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrw implements zzcqz<zzbme> {

    /* renamed from: a */
    private final zzbna f14757a;

    /* renamed from: b */
    private final Context f14758b;

    /* renamed from: c */
    private final zzchp f14759c;

    /* renamed from: d */
    private final zzdnn f14760d;

    /* renamed from: e */
    private final Executor f14761e;

    /* renamed from: f */
    private final zzdvm<zzdmu, zzag> f14762f;

    public zzcrw(zzbna zzbna, Context context, Executor executor, zzchp zzchp, zzdnn zzdnn, zzdvm<zzdmu, zzag> zzdvm) {
        this.f14758b = context;
        this.f14757a = zzbna;
        this.f14761e = executor;
        this.f14759c = zzchp;
        this.f14760d = zzdnn;
        this.f14762f = zzdvm;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16987a(zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        View view;
        zzvn zzb = zzdns.zzb(this.f14758b, zzdmu.zzhgz);
        zzbdv zza = this.f14759c.zza(zzb, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcye)).booleanValue() || !zzdmu.zzhho) {
            view = new zzcig(this.f14758b, zza.getView(), this.f14762f.apply(zzdmu));
        } else {
            view = zzbns.zza(this.f14758b, zza.getView(), zzdmu);
        }
        zzbna zzbna = this.f14757a;
        zzbos zzbos = new zzbos(zzdnj, zzdmu, (String) null);
        zza.getClass();
        zzbmd zza2 = zzbna.zza(zzbos, new zzbmh(view, zza, C2108ko.m6431a(zza), zzdns.zzg(zzb)));
        zza2.zzagr().zzb(zza, false);
        zzbsl zzaft = zza2.zzaft();
        C2071jo joVar = new C2071jo(zza);
        zzdzc zzdzc = zzazj.zzegu;
        zzaft.zza(joVar, zzdzc);
        zza2.zzagr();
        zzdnb zzdnb = zzdmu.zzhgx;
        zzdyz<?> zza3 = zzchr.zza(zza, zzdnb.zzdrn, zzdnb.zzdrp);
        if (zzdmu.zzdxi) {
            zza.getClass();
            zza3.addListener(C2182mo.m6513a(zza), this.f14761e);
        }
        zza3.addListener(new C2145lo(this, zza), this.f14761e);
        return zzdyr.zzb(zza3, new C2219no(zza2), (Executor) zzdzc);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16988b(zzbdv zzbdv) {
        zzbdv.zzacm();
        zzbep zzaah = zzbdv.zzaah();
        zzaak zzaak = this.f14760d.zzhin;
        if (zzaak != null && zzaah != null) {
            zzaah.zzb(zzaak);
        }
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzag(null), new C2034io(this, zzdnj, zzdmu), this.f14761e);
    }
}
