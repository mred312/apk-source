package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcf implements zzepf<zzdbw<zzdfp>> {

    /* renamed from: a */
    private final zzeps<C2300pu> f15412a;

    /* renamed from: b */
    private final zzeps<Clock> f15413b;

    public zzdcf(zzeps<C2300pu> zzeps, zzeps<Clock> zzeps2) {
        this.f15412a = zzeps;
        this.f15413b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzdbw) zzepl.zza(new zzdbw(this.f15412a.get(), zzact.zzdbo.get().longValue(), this.f15413b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
