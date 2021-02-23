package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.ads.a6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1720a6 extends ScheduledThreadPoolExecutor {
    C1720a6(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }

    public final void execute(Runnable runnable) {
        super.execute(zzdus.zzayi().zzf(runnable));
    }
}
