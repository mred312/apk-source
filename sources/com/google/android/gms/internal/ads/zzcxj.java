package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcxj extends zzwx {

    /* renamed from: a */
    private final zzcyh f15027a;

    public zzcxj(Context context, zzbgm zzbgm, zzdnp zzdnp, zzccl zzccl, zzwt zzwt) {
        zzcyj zzcyj = new zzcyj(zzccl);
        zzcyj.zzd(zzwt);
        this.f15027a = new zzcyh(new zzcyp(zzbgm, context, zzcyj, zzdnp), zzdnp.zzauq());
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.f15027a.getMediationAdapterClassName();
    }

    public final synchronized boolean isLoading() {
        return this.f15027a.isLoading();
    }

    public final synchronized void zza(zzvk zzvk, int i) {
        this.f15027a.zza(zzvk, i);
    }

    public final void zzb(zzvk zzvk) {
        this.f15027a.zza(zzvk, 1);
    }

    public final synchronized String zzkg() {
        return this.f15027a.zzkg();
    }
}
