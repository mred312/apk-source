package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpr implements zzepf<zzbxy<zzbsi>> {

    /* renamed from: a */
    private final zzeps<zzbjv> f13632a;

    /* renamed from: b */
    private final zzeps<Executor> f13633b;

    private zzbpr(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.f13632a = zzeps;
        this.f13633b = zzeps2;
    }

    public static zzbpr zzg(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13632a.get(), this.f13633b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
