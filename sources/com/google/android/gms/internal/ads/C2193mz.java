package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.mz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2193mz implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f10023a = new AtomicInteger(1);

    C2193mz() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f10023a.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
