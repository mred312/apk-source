package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzf implements zzepf<Set<zzbxy<zzbvz>>> {

    /* renamed from: a */
    private final zzeps<zzbqu> f13870a;

    private zzbzf(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.f13870a = zzeps;
    }

    public static zzbzf zzb(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzf(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.f13870a.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
