package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbrd;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzdil<AppOpenAd extends zzboc, AppOpenRequestComponent extends zzblm<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbrd<AppOpenRequestComponent>> implements zzcyl<AppOpenAd> {

    /* renamed from: a */
    private final Context f15668a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f15669b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzdir f15670c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzdkl<AppOpenRequestComponent, AppOpenAd> f15671d;

    /* renamed from: e */
    private final ViewGroup f15672e;
    @GuardedBy("this")

    /* renamed from: f */
    private final zzdnp f15673f;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: g */
    public zzdyz<AppOpenAd> f15674g;
    protected final zzbgm zzgxj;

    protected zzdil(Context context, Executor executor, zzbgm zzbgm, zzdkl<AppOpenRequestComponent, AppOpenAd> zzdkl, zzdir zzdir, zzdnp zzdnp) {
        this.f15668a = context;
        this.f15669b = executor;
        this.zzgxj = zzbgm;
        this.f15671d = zzdkl;
        this.f15670c = zzdir;
        this.f15673f = zzdnp;
        this.f15672e = new FrameLayout(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final synchronized AppOpenRequestComponentBuilder mo17113f(zzdkk zzdkk) {
        C2490uv uvVar = (C2490uv) zzdkk;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
            return zza(new zzblz(this.f15672e), new zzbrg.zza().zzcg(this.f15668a).zza(uvVar.f11445a).zzakx(), new zzbwp.zza().zzalt());
        }
        zzdir zzb = zzdir.zzb(this.f15670c);
        zzbwp.zza zza = new zzbwp.zza();
        zza.zza((zzbrz) zzb, this.f15669b);
        zza.zza((zzbto) zzb, this.f15669b);
        zza.zza((zzp) zzb, this.f15669b);
        zza.zza(zzb);
        return zza(new zzblz(this.f15672e), new zzbrg.zza().zzcg(this.f15668a).zza(uvVar.f11445a).zzakx(), zza.zzalt());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo17112e() {
        this.f15670c.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    public final boolean isLoading() {
        zzdyz<AppOpenAd> zzdyz = this.f15674g;
        return zzdyz != null && !zzdyz.isDone();
    }

    /* access modifiers changed from: protected */
    public abstract AppOpenRequestComponentBuilder zza(zzblz zzblz, zzbrg zzbrg, zzbwp zzbwp);

    public final synchronized boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super AppOpenAd> zzcyn) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzaza.zzey("Ad unit ID should not be null for app open ad.");
            this.f15669b.execute(new C2375rv(this));
            return false;
        } else if (this.f15674g != null) {
            return false;
        } else {
            zzdob.zze(this.f15668a, zzvk.zzchb);
            zzdnn zzaus = this.f15673f.zzgq(str).zzf(zzvn.zzpq()).zzh(zzvk).zzaus();
            C2490uv uvVar = new C2490uv((C2416sv) null);
            uvVar.f11445a = zzaus;
            zzdyz<AppOpenAd> zza = this.f15671d.zza(new zzdkm(uvVar), new C2453tv(this));
            this.f15674g = zza;
            zzdyr.zza(zza, new C2416sv(this, zzcyn, uvVar), this.f15669b);
            return true;
        }
    }

    public final void zza(zzvw zzvw) {
        this.f15673f.zzb(zzvw);
    }
}
