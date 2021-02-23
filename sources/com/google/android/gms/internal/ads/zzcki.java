package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcki implements zzepf<zzbxy<zzbui>> {

    /* renamed from: a */
    private final zzeps<zzckg> f14497a;

    /* renamed from: b */
    private final zzeps<Executor> f14498b;

    private zzcki(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        this.f14497a = zzeps;
        this.f14498b = zzeps2;
    }

    public static zzcki zzal(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        return new zzcki(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14497a.get(), this.f14498b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
