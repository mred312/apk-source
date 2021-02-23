package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmb implements zzepf<zzbua> {

    /* renamed from: a */
    private final zzeps<ScheduledExecutorService> f13485a;

    /* renamed from: b */
    private final zzeps<Clock> f13486b;

    public zzbmb(zzeps<ScheduledExecutorService> zzeps, zzeps<Clock> zzeps2) {
        this.f13485a = zzeps;
        this.f13486b = zzeps2;
    }

    public static zzbua zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbua) zzepl.zza(new zzbua(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13485a.get(), this.f13486b.get());
    }
}
