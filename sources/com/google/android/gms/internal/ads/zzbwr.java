package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwr implements zzepf<Set<zzbxy<zzbtj>>> {

    /* renamed from: a */
    private final zzbwp f13824a;

    private zzbwr(zzbwp zzbwp) {
        this.f13824a = zzbwp;
    }

    public static zzbwr zzh(zzbwp zzbwp) {
        return new zzbwr(zzbwp);
    }

    public static Set<zzbxy<zzbtj>> zzi(zzbwp zzbwp) {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzi(this.f13824a);
    }
}
