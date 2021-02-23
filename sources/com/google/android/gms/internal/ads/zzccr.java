package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccr implements zzepf<zzbxy<zzbub>> {

    /* renamed from: a */
    private final zzeps<zzcyb> f14090a;

    /* renamed from: b */
    private final zzeps<Executor> f14091b;

    private zzccr(zzeps<zzcyb> zzeps, zzeps<Executor> zzeps2) {
        this.f14090a = zzeps;
        this.f14091b = zzeps2;
    }

    public static zzccr zzy(zzeps<zzcyb> zzeps, zzeps<Executor> zzeps2) {
        return new zzccr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14090a.get(), this.f14091b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
