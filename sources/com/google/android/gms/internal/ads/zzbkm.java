package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkm implements zzepf<zzbjz> {

    /* renamed from: a */
    private final zzeps<zzqr> f13419a;

    /* renamed from: b */
    private final zzeps<zzamq> f13420b;

    /* renamed from: c */
    private final zzeps<Executor> f13421c;

    private zzbkm(zzeps<zzqr> zzeps, zzeps<zzamq> zzeps2, zzeps<Executor> zzeps3) {
        this.f13419a = zzeps;
        this.f13420b = zzeps2;
        this.f13421c = zzeps3;
    }

    public static zzbkm zzb(zzeps<zzqr> zzeps, zzeps<zzamq> zzeps2, zzeps<Executor> zzeps3) {
        return new zzbkm(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzbjz) zzepl.zza(new zzbjz(this.f13419a.get().getUniqueId(), this.f13420b.get(), this.f13421c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
