package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxa implements zzepf<Set<zzbxy<zzbru>>> {

    /* renamed from: a */
    private final zzbwp f13831a;

    private zzbxa(zzbwp zzbwp) {
        this.f13831a = zzbwp;
    }

    public static zzbxa zzs(zzbwp zzbwp) {
        return new zzbxa(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13831a.zzalh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
