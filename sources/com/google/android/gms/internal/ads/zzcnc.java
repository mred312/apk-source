package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzcnc implements zzdyb<zzatl, zzdnj> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbuh f14622a;

    public zzcnc(zzbuh zzbuh) {
        this.f14622a = zzbuh;
    }

    /* access modifiers changed from: protected */
    public abstract zzdyz<zzdnj> zzb(zzatl zzatl);

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzatl zzatl = (zzatl) obj;
        this.f14622a.zzd(zzatl);
        zzdyz<zzdnj> zzb = zzb(zzatl);
        zzdyr.zza(zzb, new C2443tl(this), zzazj.zzegu);
        return zzb;
    }
}
