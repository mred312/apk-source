package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdpr {

    /* renamed from: a */
    private HashMap<zzdpj, zzdpu<? extends zzboc>> f15866a = new HashMap<>();

    public final <AdT extends zzboc> zzdpu<AdT> zza(zzdpj zzdpj, Context context, zzdpa zzdpa, zzdqc<AdT> zzdqc) {
        zzdpu<AdT> zzdpu = this.f15866a.get(zzdpj);
        if (zzdpu != null) {
            return zzdpu;
        }
        C1860dz dzVar = new C1860dz(zzdpk.zza(zzdpj, context));
        zzdpu<AdT> zzdpu2 = new zzdpu<>(dzVar, new zzdpv(dzVar, zzdpa, zzdqc));
        this.f15866a.put(zzdpj, zzdpu2);
        return zzdpu2;
    }
}
