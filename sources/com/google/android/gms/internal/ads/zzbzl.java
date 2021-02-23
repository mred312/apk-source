package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzl implements zzepf<Set<zzbxy<zzbru>>> {

    /* renamed from: a */
    private final zzbzc f13878a;

    /* renamed from: b */
    private final zzeps<zzbqu> f13879b;

    private zzbzl(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.f13878a = zzbzc;
        this.f13879b = zzeps;
    }

    public static zzbzl zze(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzl(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13878a.zzb(this.f13879b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
