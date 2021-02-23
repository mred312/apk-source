package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwz implements zzepf<Set<zzbxy<zzbtj>>> {

    /* renamed from: a */
    private final zzbwp f13830a;

    private zzbwz(zzbwp zzbwp) {
        this.f13830a = zzbwp;
    }

    public static zzbwz zzq(zzbwp zzbwp) {
        return new zzbwz(zzbwp);
    }

    public static Set<zzbxy<zzbtj>> zzr(zzbwp zzbwp) {
        return (Set) zzepl.zza(zzbwp.zzali(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzr(this.f13830a);
    }
}
