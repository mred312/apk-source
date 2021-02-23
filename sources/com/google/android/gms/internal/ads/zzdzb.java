package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdzb {
    /* renamed from: a */
    static Executor m8610a(Executor executor, zzdxo<?> zzdxo) {
        zzdvv.checkNotNull(executor);
        zzdvv.checkNotNull(zzdxo);
        if (executor == g30.INSTANCE) {
            return executor;
        }
        return new u30(executor, zzdxo);
    }

    public static zzdzc zza(ExecutorService executorService) {
        if (executorService instanceof zzdzc) {
            return (zzdzc) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new w30((ScheduledExecutorService) executorService);
        }
        return new t30(executorService);
    }

    public static Executor zzazo() {
        return g30.INSTANCE;
    }
}
