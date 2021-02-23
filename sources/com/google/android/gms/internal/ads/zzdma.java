package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdma implements zzcyl<zzchc> {

    /* renamed from: a */
    private final Context f15749a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f15750b;

    /* renamed from: c */
    private final zzbgm f15751c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzdlf f15752d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzdkl<zzchf, zzchc> f15753e;

    /* renamed from: f */
    private final zzdni f15754f;
    @GuardedBy("this")

    /* renamed from: g */
    private final zzdnp f15755g;
    @GuardedBy("this")

    /* renamed from: h */
    private zzdyz<zzchc> f15756h;

    public zzdma(Context context, Executor executor, zzbgm zzbgm, zzdkl<zzchf, zzchc> zzdkl, zzdlf zzdlf, zzdnp zzdnp, zzdni zzdni) {
        this.f15749a = context;
        this.f15750b = executor;
        this.f15751c = zzbgm;
        this.f15753e = zzdkl;
        this.f15752d = zzdlf;
        this.f15755g = zzdnp;
        this.f15754f = zzdni;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final zzchi mo17141g(zzdkk zzdkk) {
        C2007hy hyVar = (C2007hy) zzdkk;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
            return this.f15751c.zzaey().zzf(new zzbrg.zza().zzcg(this.f15749a).zza(hyVar.f9242a).zzfu(hyVar.f9243b).zza(this.f15754f).zzakx()).zzf(new zzbwp.zza().zzalt());
        }
        zzdlf zzb = zzdlf.zzb(this.f15752d);
        return this.f15751c.zzaey().zzf(new zzbrg.zza().zzcg(this.f15749a).zza(hyVar.f9242a).zzfu(hyVar.f9243b).zza(this.f15754f).zzakx()).zzf(new zzbwp.zza().zza((zzbru) zzb, this.f15750b).zza((zzbtj) zzb, this.f15750b).zza((zzbrz) zzb, this.f15750b).zza((AdMetadataListener) zzb, this.f15750b).zza((zzbsi) zzb, this.f15750b).zza((zzbub) zzb, this.f15750b).zza(zzb).zzalt());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo17140c() {
        this.f15752d.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo17142h(int i) {
        this.f15755g.zzaur().zzed(i);
    }

    public final boolean isLoading() {
        zzdyz<zzchc> zzdyz = this.f15756h;
        return zzdyz != null && !zzdyz.isDone();
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzchc> zzcyn) {
        zzauv zzauv = new zzauv(zzvk, str);
        String str2 = zzcyo instanceof zzdmb ? ((zzdmb) zzcyo).zzhgb : null;
        if (zzauv.zzbum == null) {
            zzaza.zzey("Ad unit ID should not be null for rewarded video ad.");
            this.f15750b.execute(new C1896ey(this));
            return false;
        }
        zzdyz<zzchc> zzdyz = this.f15756h;
        if (zzdyz != null && !zzdyz.isDone()) {
            return false;
        }
        zzdob.zze(this.f15749a, zzauv.zzdsr.zzchb);
        zzdnn zzaus = this.f15755g.zzgq(zzauv.zzbum).zzf(zzvn.zzpp()).zzh(zzauv.zzdsr).zzaus();
        C2007hy hyVar = new C2007hy((C1970gy) null);
        hyVar.f9242a = zzaus;
        hyVar.f9243b = str2;
        zzdyz<zzchc> zza = this.f15753e.zza(new zzdkm(hyVar), new C1859dy(this));
        this.f15756h = zza;
        zzdyr.zza(zza, new C1970gy(this, zzcyn, hyVar), this.f15750b);
        return true;
    }
}
