package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmm implements zzepf<zzbte> {

    /* renamed from: a */
    private final zzbmh f13503a;

    /* renamed from: b */
    private final zzeps<Set<zzbxy<zzbtj>>> f13504b;

    public zzbmm(zzbmh zzbmh, zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        this.f13503a = zzbmh;
        this.f13504b = zzeps;
    }

    public static zzbte zza(zzbmh zzbmh, Set<zzbxy<zzbtj>> set) {
        return (zzbte) zzepl.zza(zzbmh.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13503a, this.f13504b.get());
    }
}
