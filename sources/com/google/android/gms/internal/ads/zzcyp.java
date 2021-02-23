package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyp implements zzcyl<zzboc> {
    @GuardedBy("this")

    /* renamed from: a */
    private final zzdnp f15070a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzbgm f15071b;

    /* renamed from: c */
    private final Context f15072c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzcyj f15073d;
    @GuardedBy("this")
    @Nullable

    /* renamed from: e */
    private zzboj f15074e;

    public zzcyp(zzbgm zzbgm, Context context, zzcyj zzcyj, zzdnp zzdnp) {
        this.f15071b = zzbgm;
        this.f15072c = context;
        this.f15073d = zzcyj;
        this.f15070a = zzdnp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo17058b() {
        this.f15073d.zzasd().zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo17059c() {
        this.f15073d.zzasd().zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
    }

    public final boolean isLoading() {
        zzboj zzboj = this.f15074e;
        return zzboj != null && zzboj.isLoading();
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzboc> zzcyn) {
        zzcat zzcat;
        zzp.zzkq();
        if (zzm.zzbb(this.f15072c) && zzvk.zzchn == null) {
            zzaza.zzey("Failed to load the ad because app ID is missing.");
            this.f15071b.zzaek().execute(new C2260or(this));
            return false;
        } else if (str == null) {
            zzaza.zzey("Ad unit ID should not be null for NativeAdLoader.");
            this.f15071b.zzaek().execute(new C2222nr(this));
            return false;
        } else {
            zzdob.zze(this.f15072c, zzvk.zzchb);
            zzdnn zzaus = this.f15070a.zzh(zzvk).zzee(zzcyo instanceof zzcyq ? ((zzcyq) zzcyo).zzgwz : 1).zzaus();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
                zzcat = this.f15071b.zzaex().zza(new zzbrg.zza().zzcg(this.f15072c).zza(zzaus).zzakx()).zza(new zzbwp.zza().zzalt()).zza(this.f15073d.zzarz()).zza(new zzblz((ViewGroup) null)).zzafo();
            } else {
                zzcat = this.f15071b.zzaex().zza(new zzbrg.zza().zzcg(this.f15072c).zza(zzaus).zzakx()).zza(new zzbwp.zza().zza(this.f15073d.zzasc(), this.f15071b.zzaek()).zza(this.f15073d.zzasd(), this.f15071b.zzaek()).zza(this.f15073d.zzase(), this.f15071b.zzaek()).zza(this.f15073d.zzasf(), this.f15071b.zzaek()).zza(this.f15073d.zzasb(), this.f15071b.zzaek()).zza(zzaus.zzhiu, this.f15071b.zzaek()).zzalt()).zza(this.f15073d.zzarz()).zza(new zzblz((ViewGroup) null)).zzafo();
            }
            this.f15071b.zzafd().ensureSize(1);
            zzboj zzboj = new zzboj(this.f15071b.zzaem(), this.f15071b.zzael(), zzcat.zzagh().zzakj());
            this.f15074e = zzboj;
            zzboj.zza(new C2334qr(this, zzcyn, zzcat));
            return true;
        }
    }
}
