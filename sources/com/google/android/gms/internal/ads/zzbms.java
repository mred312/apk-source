package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbms implements zzepf<Set<zzbxy<zzbtj>>> {

    /* renamed from: a */
    private final zzbmh f13515a;

    /* renamed from: b */
    private final zzeps<zzbnt> f13516b;

    public zzbms(zzbmh zzbmh, zzeps<zzbnt> zzeps) {
        this.f13515a = zzbmh;
        this.f13516b = zzeps;
    }

    public static Set<zzbxy<zzbtj>> zza(zzbmh zzbmh, zzbnt zzbnt) {
        return (Set) zzepl.zza(Collections.singleton(new zzbxy(zzbnt, zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13515a, this.f13516b.get());
    }
}
