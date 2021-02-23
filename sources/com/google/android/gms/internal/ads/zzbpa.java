package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpa implements zzepf<zzbxy<zzbto>> {

    /* renamed from: a */
    private final zzeps<zzbtw> f13615a;

    /* renamed from: b */
    private final zzeps<Executor> f13616b;

    private zzbpa(zzeps<zzbtw> zzeps, zzeps<Executor> zzeps2) {
        this.f13615a = zzeps;
        this.f13616b = zzeps2;
    }

    public static zzbpa zzc(zzeps<zzbtw> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpa(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13615a.get(), this.f13616b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
