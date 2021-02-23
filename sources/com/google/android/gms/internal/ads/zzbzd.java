package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzd implements zzepf<Set<zzbxy<zzbsi>>> {

    /* renamed from: a */
    private final zzeps<zzbqu> f13869a;

    private zzbzd(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.f13869a = zzeps;
    }

    public static zzbzd zza(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzd(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.f13869a.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
