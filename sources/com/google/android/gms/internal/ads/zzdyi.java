package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzdyi<V> extends n30<V> {
    zzdyi() {
    }

    public static <V> zzdyi<V> zzg(zzdyz<V> zzdyz) {
        if (zzdyz instanceof zzdyi) {
            return (zzdyi) zzdyz;
        }
        return new i30(zzdyz);
    }

    public final <X extends Throwable> zzdyi<V> zza(Class<X> cls, zzdvm<? super X, ? extends V> zzdvm, Executor executor) {
        s20 s20 = new s20(this, cls, zzdvm);
        addListener(s20, zzdzb.m8610a(executor, s20));
        return s20;
    }

    public final <T> zzdyi<T> zzb(zzdyb<? super V, T> zzdyb, Executor executor) {
        zzdvv.checkNotNull(executor);
        v20 v20 = new v20(this, zzdyb);
        addListener(v20, zzdzb.m8610a(executor, v20));
        return v20;
    }

    public final <X extends Throwable> zzdyi<V> zza(Class<X> cls, zzdyb<? super X, ? extends V> zzdyb, Executor executor) {
        q20 q20 = new q20(this, cls, zzdyb);
        addListener(q20, zzdzb.m8610a(executor, q20));
        return q20;
    }

    public final zzdyi<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdyi) zzdyr.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdyi<T> zza(zzdvm<? super V, T> zzdvm, Executor executor) {
        zzdvv.checkNotNull(zzdvm);
        u20 u20 = new u20(this, zzdvm);
        addListener(u20, zzdzb.m8610a(executor, u20));
        return u20;
    }
}
