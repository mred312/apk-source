package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzs implements zzepf<Set<zzbxy<zzbxr>>> {

    /* renamed from: a */
    private final zzeps<zzcaj> f13887a;

    private zzbzs(zzeps<zzcaj> zzeps) {
        this.f13887a = zzeps;
    }

    public static zzbzs zzw(zzeps<zzcaj> zzeps) {
        return new zzbzs(zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.f13887a.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
