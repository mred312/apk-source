package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqb implements zzepf<zzbxy<zzbsi>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13653a;

    /* renamed from: b */
    private final zzeps<Executor> f13654b;

    private zzbqb(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13653a = zzeps;
        this.f13654b = zzeps2;
    }

    public static zzbqb zzm(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqb(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13653a.get(), this.f13654b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
