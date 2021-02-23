package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqc implements zzdru {

    /* renamed from: a */
    private final zzcpx f14703a;

    zzcqc(zzcpx zzcpx) {
        this.f14703a = zzcpx;
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl && this.f14703a.zzare() != 0) {
            this.f14703a.zzer(zzp.zzkx().elapsedRealtime() - this.f14703a.zzare());
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl) {
            this.f14703a.zzfe(zzp.zzkx().elapsedRealtime());
        }
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl && this.f14703a.zzare() != 0) {
            this.f14703a.zzer(zzp.zzkx().elapsedRealtime() - this.f14703a.zzare());
        }
    }
}
