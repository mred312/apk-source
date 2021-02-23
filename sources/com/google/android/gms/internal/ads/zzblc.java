package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzblc implements zzepf<Set<zzbxy<zzqu>>> {

    /* renamed from: a */
    private final zzeps<zzbnt> f13460a;

    public zzblc(zzbkx zzbkx, zzeps<zzbnt> zzeps) {
        this.f13460a = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(new zzbxy(this.f13460a.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
