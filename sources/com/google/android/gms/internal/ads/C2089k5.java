package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.k5 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2089k5 implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f9566a = new AtomicInteger(1);

    C2089k5(zzawx zzawx) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        int andIncrement = this.f9566a.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
