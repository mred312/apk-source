package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxb implements zzepf<Set<zzbxy<zzbto>>> {

    /* renamed from: a */
    private final zzbwp f13832a;

    private zzbxb(zzbwp zzbwp) {
        this.f13832a = zzbwp;
    }

    public static zzbxb zzt(zzbwp zzbwp) {
        return new zzbxb(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13832a.zzalp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
