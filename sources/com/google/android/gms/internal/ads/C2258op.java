package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.op */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2258op extends zzapl {

    /* renamed from: a */
    private zzcrb<zzapo, zzcst> f10397a;

    /* renamed from: b */
    private final /* synthetic */ zzcty f10398b;

    private C2258op(zzcty zzcty, zzcrb<zzapo, zzcst> zzcrb) {
        this.f10398b = zzcty;
        this.f10397a = zzcrb;
    }

    public final void zza(zzaob zzaob) {
        zzaob unused = this.f10398b.f14852c = zzaob;
        ((zzcst) this.f10397a.zzgqp).onAdLoaded();
    }

    public final void zzdm(String str) {
        ((zzcst) this.f10397a.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.f10397a.zzgqp).zzc(zzve);
    }
}
