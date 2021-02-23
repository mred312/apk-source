package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcav implements zzepf<Set<String>> {

    /* renamed from: a */
    private final zzeps<zzccl> f13933a;

    public zzcav(zzeps<zzccl> zzeps) {
        this.f13933a = zzeps;
    }

    public static Set<String> zza(zzccl zzccl) {
        Set set;
        if (zzccl.zzanu() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13933a.get());
    }
}
