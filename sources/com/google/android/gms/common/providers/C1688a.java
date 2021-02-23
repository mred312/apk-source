package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.common.providers.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1688a implements PooledExecutorsProvider.PooledExecutorFactory {
    C1688a() {
    }

    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return zze.zza().zza(1, zzj.zza);
    }
}
