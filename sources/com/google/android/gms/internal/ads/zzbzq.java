package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzq implements zzepf<zzbxy<zzbru>> {

    /* renamed from: a */
    private final zzeps<zzcal> f13883a;

    /* renamed from: b */
    private final zzeps<Executor> f13884b;

    private zzbzq(zzbzc zzbzc, zzeps<zzcal> zzeps, zzeps<Executor> zzeps2) {
        this.f13883a = zzeps;
        this.f13884b = zzeps2;
    }

    public static zzbzq zzb(zzbzc zzbzc, zzeps<zzcal> zzeps, zzeps<Executor> zzeps2) {
        return new zzbzq(zzbzc, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13883a.get(), this.f13884b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
