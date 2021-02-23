package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmq implements zzepf<zzbxy<zzbui>> {

    /* renamed from: a */
    private final zzeps<C2032im> f14605a;

    /* renamed from: b */
    private final zzeps<Executor> f14606b;

    private zzcmq(zzeps<C2032im> zzeps, zzeps<Executor> zzeps2) {
        this.f14605a = zzeps;
        this.f14606b = zzeps2;
    }

    public static zzcmq zzar(zzeps<C2032im> zzeps, zzeps<Executor> zzeps2) {
        return new zzcmq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14605a.get(), this.f14606b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
