package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqh implements zzepf<zzbxy<zzbvz>> {

    /* renamed from: a */
    private final zzeps<zzcke> f13664a;

    /* renamed from: b */
    private final zzeps<Executor> f13665b;

    private zzbqh(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.f13664a = zzeps;
        this.f13665b = zzeps2;
    }

    public static zzbqh zzr(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqh(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13664a.get(), this.f13665b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
