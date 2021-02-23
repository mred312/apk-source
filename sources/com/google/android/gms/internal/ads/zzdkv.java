package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkv implements zzcyl<zzbyx> {

    /* renamed from: a */
    private final Context f15725a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f15726b;

    /* renamed from: c */
    private final zzbgm f15727c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzcxq f15728d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzdlf f15729e;
    @Nullable

    /* renamed from: f */
    private zzacb f15730f;
    @GuardedBy("this")

    /* renamed from: g */
    private final zzdnp f15731g;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: h */
    public zzdyz<zzbyx> f15732h;

    public zzdkv(Context context, Executor executor, zzbgm zzbgm, zzcxq zzcxq, zzdlf zzdlf, zzdnp zzdnp) {
        this.f15725a = context;
        this.f15726b = executor;
        this.f15727c = zzbgm;
        this.f15728d = zzcxq;
        this.f15731g = zzdnp;
        this.f15729e = zzdlf;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo17131c() {
        this.f15728d.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    public final boolean isLoading() {
        zzdyz<zzbyx> zzdyz = this.f15732h;
        return zzdyz != null && !zzdyz.isDone();
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzbyx> zzcyn) {
        zzvn zzvn;
        zzbzx zzbzx;
        if (str == null) {
            zzaza.zzey("Ad unit ID should not be null for interstitial ad.");
            this.f15726b.execute(new C1784bx(this));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            if (zzcyo instanceof zzdks) {
                zzvn = ((zzdks) zzcyo).zzead;
            } else {
                zzvn = new zzvn();
            }
            zzdnn zzaus = this.f15731g.zzgq(str).zzf(zzvn).zzh(zzvk).zzaus();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                zzbzx = this.f15727c.zzaev().zze(new zzbrg.zza().zzcg(this.f15725a).zza(zzaus).zzakx()).zze(new zzbwp.zza().zzalt()).zzb(new zzcwq(this.f15730f)).zzahf();
            } else {
                zzbwp.zza zza = new zzbwp.zza();
                zzdlf zzdlf = this.f15729e;
                if (zzdlf != null) {
                    zza.zza((zzbru) zzdlf, this.f15726b).zza((zzbtj) this.f15729e, this.f15726b).zza((zzbrz) this.f15729e, this.f15726b);
                }
                zzbzx = this.f15727c.zzaev().zze(new zzbrg.zza().zzcg(this.f15725a).zza(zzaus).zzakx()).zze(zza.zza((zzbru) this.f15728d, this.f15726b).zza((zzbtj) this.f15728d, this.f15726b).zza((zzbrz) this.f15728d, this.f15726b).zza((zzva) this.f15728d, this.f15726b).zza((AppEventListener) this.f15728d, this.f15726b).zza((zzbub) this.f15728d, this.f15726b).zzalt()).zzb(new zzcwq(this.f15730f)).zzahf();
            }
            zzdyz<zzbyx> zzakj = zzbzx.zzagh().zzakj();
            this.f15732h = zzakj;
            zzdyr.zza(zzakj, new C1858dx(this, zzcyn, zzbzx), this.f15726b);
            return true;
        }
    }

    public final void zza(zzacb zzacb) {
        this.f15730f = zzacb;
    }
}
