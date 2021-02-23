package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.vq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2522vq implements zzdyo<zzbme> {

    /* renamed from: a */
    private final /* synthetic */ zzbna f11637a;

    /* renamed from: b */
    final /* synthetic */ zzcxm f11638b;

    C2522vq(zzcxm zzcxm, zzbna zzbna) {
        this.f11638b = zzcxm;
        this.f11637a = zzbna;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbme zzbme = (zzbme) obj;
        synchronized (this.f11638b) {
            zzdyz unused = this.f11638b.f15043k = null;
            if (this.f11638b.f15042j != null) {
                this.f11638b.f15042j.destroy();
            }
            zzbme unused2 = this.f11638b.f15042j = zzbme;
            this.f11638b.f15035c.removeAllViews();
            if (zzbme.zzaiz() != null) {
                ViewParent parent = zzbme.zzaiz().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.f11638b.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzaza.zzfa(sb.toString());
                    ((ViewGroup) parent).removeView(zzbme.zzaiz());
                }
            }
            zzaaq zzaaq = zzabf.zzcyp;
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                zzbme.zzakb().zza(this.f11638b.f15036d).zza(this.f11638b.f15037e);
            }
            this.f11638b.f15035c.addView(zzbme.zzaiz());
            zzbme.zzajj();
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                Executor zzaek = this.f11638b.f15033a.zzaek();
                zzcxq g = this.f11638b.f15036d;
                g.getClass();
                zzaek.execute(C2597xq.m7269a(g));
            }
            this.f11638b.f15038f.zzdx(zzbme.zzaji());
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.f11637a.zzagh().zze(th);
        synchronized (this.f11638b) {
            zzdyz unused = this.f11638b.f15043k = null;
            this.f11637a.zzagi().zzk(zze);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
                this.f11638b.f15033a.zzaek().execute(new C2559wq(this, zze));
            }
            this.f11638b.f15038f.zzdx(60);
            zzdob.zza(zze.errorCode, th, "BannerAdManagerShim.onFailure");
        }
    }
}
