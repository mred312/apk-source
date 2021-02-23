package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwx implements zzepf<Set<zzbxy<zzbsm>>> {

    /* renamed from: a */
    private final zzbwp f13828a;

    private zzbwx(zzbwp zzbwp) {
        this.f13828a = zzbwp;
    }

    public static zzbwx zzo(zzbwp zzbwp) {
        return new zzbwx(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13828a.zzalo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
