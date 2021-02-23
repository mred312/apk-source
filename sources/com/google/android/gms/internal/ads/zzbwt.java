package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwt implements zzepf<Set<zzbxy<zzbvs>>> {
    private zzbwt(zzbwp zzbwp) {
    }

    public static zzbwt zzk(zzbwp zzbwp) {
        return new zzbwt(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
