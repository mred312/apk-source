package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;

/* renamed from: com.google.android.gms.internal.ads.sw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2417sw<R extends zzbre<AdT>, AdT extends zzboc> implements zzdqc<AdT> {

    /* renamed from: a */
    private final zzdkl<R, zzdpn<AdT>> f11114a;

    public C2417sw(zzdkl<R, zzdpn<AdT>> zzdkl) {
        this.f11114a = zzdkl;
    }

    public final zzdyz<zzdpn<AdT>> zza(zzdqb zzdqb) {
        C2376rw rwVar = (C2376rw) zzdqb;
        return this.f11114a.zza(rwVar.f10828b, rwVar.f10827a);
    }

    public final void zzb(Throwable th) {
    }

    public final void zza(zzdpn<AdT> zzdpn) {
        zzdpn.zzhmb = ((zzbre) this.f11114a.zzaty()).zzagh();
    }
}
