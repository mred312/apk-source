package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbww implements zzepf<Set<zzbxy<zzva>>> {

    /* renamed from: a */
    private final zzbwp f13827a;

    private zzbww(zzbwp zzbwp) {
        this.f13827a = zzbwp;
    }

    public static zzbww zzn(zzbwp zzbwp) {
        return new zzbww(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13827a.zzaln(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
