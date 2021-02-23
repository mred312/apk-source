package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrc {

    /* renamed from: a */
    private final Object f15885a;

    /* renamed from: b */
    private final List<zzdyz<?>> f15886b;

    /* renamed from: c */
    private final /* synthetic */ zzdra f15887c;

    private zzdrc(zzdra zzdra, E e, List<zzdyz<?>> list) {
        this.f15887c = zzdra;
        this.f15885a = e;
        this.f15886b = list;
    }

    public final <O> zzdrg<O> zzb(Callable<O> callable) {
        zzdys<V> zzk = zzdyr.zzk(this.f15886b);
        zzdyz<C> zza = zzk.zza(C2568wz.f11740a, zzazj.zzegu);
        zzdra zzdra = this.f15887c;
        return new zzdrg(zzdra, this.f15885a, (String) null, zza, this.f15886b, zzk.zza(callable, zzdra.f15882a), (C2494uz) null);
    }
}
