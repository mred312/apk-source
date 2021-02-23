package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class PooledExecutorsProvider {

    /* renamed from: a */
    private static PooledExecutorFactory f7589a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public interface PooledExecutorFactory {
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (f7589a == null) {
                f7589a = new C1688a();
            }
            pooledExecutorFactory = f7589a;
        }
        return pooledExecutorFactory;
    }
}
