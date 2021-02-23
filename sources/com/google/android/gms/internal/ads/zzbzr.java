package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzr implements zzepf<zzbxy<zzbvs>> {

    /* renamed from: a */
    private final zzbzc f13885a;

    /* renamed from: b */
    private final zzeps<Executor> f13886b;

    private zzbzr(zzbzc zzbzc, zzeps<Executor> zzeps) {
        this.f13885a = zzbzc;
        this.f13886b = zzeps;
    }

    public static zzbzr zzf(zzbzc zzbzc, zzeps<Executor> zzeps) {
        return new zzbzr(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(this.f13885a.zzb(this.f13886b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
