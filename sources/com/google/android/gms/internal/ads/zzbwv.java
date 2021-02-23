package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwv implements zzepf<Set<zzbxy<zzbrz>>> {

    /* renamed from: a */
    private final zzbwp f13826a;

    private zzbwv(zzbwp zzbwp) {
        this.f13826a = zzbwp;
    }

    public static zzbwv zzm(zzbwp zzbwp) {
        return new zzbwv(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.f13826a.zzalj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
