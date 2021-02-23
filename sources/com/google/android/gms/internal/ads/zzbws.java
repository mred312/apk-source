package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbws implements zzepf<Set<zzbxy<zzbsp>>> {
    private zzbws(zzbwp zzbwp) {
    }

    public static zzbws zzj(zzbwp zzbwp) {
        return new zzbws(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
