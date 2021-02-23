package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzm;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.analytics.b */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
final class C3223b extends ThreadPoolExecutor {
    C3223b(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }

    public final void execute(Runnable runnable) {
        super.execute(zzm.zza().zza(runnable));
    }
}
