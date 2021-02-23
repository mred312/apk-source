package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqj implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzcke> f13668a;

    /* renamed from: b */
    private final zzeps<Executor> f13669b;

    private zzbqj(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.f13668a = zzeps;
        this.f13669b = zzeps2;
    }

    public static zzbqj zzt(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqj(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13668a.get(), this.f13669b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
