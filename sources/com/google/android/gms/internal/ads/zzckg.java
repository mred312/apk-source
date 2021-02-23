package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckg implements zzbrz, zzbtj, zzbui {

    /* renamed from: a */
    private final zzcko f14493a;

    /* renamed from: b */
    private final zzckv f14494b;

    public zzckg(zzcko zzcko, zzckv zzckv) {
        this.f14493a = zzcko;
        this.f14494b = zzckv;
    }

    public final void onAdLoaded() {
        this.f14493a.zzrx().put("action", "loaded");
        this.f14494b.zzo(this.f14493a.zzrx());
    }

    public final void zzb(zzdnj zzdnj) {
        this.f14493a.zzc(zzdnj);
    }

    public final void zzd(zzatl zzatl) {
        this.f14493a.zzi(zzatl.zzdvx);
    }

    public final void zzk(zzve zzve) {
        this.f14493a.zzrx().put("action", "ftl");
        this.f14493a.zzrx().put("ftl", String.valueOf(zzve.errorCode));
        this.f14493a.zzrx().put("ed", zzve.zzcgt);
        this.f14494b.zzo(this.f14493a.zzrx());
    }
}
