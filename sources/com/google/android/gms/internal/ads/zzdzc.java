package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public interface zzdzc extends ExecutorService {
    <T> zzdyz<T> zze(Callable<T> callable);

    zzdyz<?> zzg(Runnable runnable);
}
