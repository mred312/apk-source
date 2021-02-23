package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwq implements zzepf<zzbrx> {

    /* renamed from: a */
    private final zzbwp f13822a;

    /* renamed from: b */
    private final zzeps<Set<zzbxy<zzbrz>>> f13823b;

    private zzbwq(zzbwp zzbwp, zzeps<Set<zzbxy<zzbrz>>> zzeps) {
        this.f13822a = zzbwp;
        this.f13823b = zzeps;
    }

    public static zzbwq zza(zzbwp zzbwp, zzeps<Set<zzbxy<zzbrz>>> zzeps) {
        return new zzbwq(zzbwp, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbrx) zzepl.zza(this.f13822a.zzc(this.f13823b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
