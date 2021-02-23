package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckh implements zzepf<zzbxy<zzbrz>> {

    /* renamed from: a */
    private final zzeps<zzckg> f14495a;

    /* renamed from: b */
    private final zzeps<Executor> f14496b;

    private zzckh(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        this.f14495a = zzeps;
        this.f14496b = zzeps2;
    }

    public static zzckh zzak(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        return new zzckh(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14495a.get(), this.f14496b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
