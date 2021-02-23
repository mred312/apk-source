package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxe implements zzepf<Set<zzbxy<zzbub>>> {

    /* renamed from: a */
    private final zzbwp f13835a;

    private zzbxe(zzbwp zzbwp) {
        this.f13835a = zzbwp;
    }

    public static zzbxe zzw(zzbwp zzbwp) {
        return new zzbxe(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13835a.zzalq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
