package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwy implements zzepf<Set<zzbxy<zzbsi>>> {

    /* renamed from: a */
    private final zzbwp f13829a;

    private zzbwy(zzbwp zzbwp) {
        this.f13829a = zzbwp;
    }

    public static zzbwy zzp(zzbwp zzbwp) {
        return new zzbwy(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13829a.zzalk(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
