package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdqu implements zzepf<ScheduledExecutorService> {

    /* renamed from: a */
    private final zzeps<ThreadFactory> f15877a;

    public zzdqu(zzeps<ThreadFactory> zzeps) {
        this.f15877a = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzepl.zza(zzduo.zzayg().zzb(1, this.f15877a.get(), zzdut.zzhsl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
