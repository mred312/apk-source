package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class xc0 implements ThreadFactory {

    /* renamed from: a */
    private final ThreadFactory f11883a = Executors.defaultThreadFactory();

    /* renamed from: b */
    private final AtomicInteger f11884b = new AtomicInteger(1);

    xc0() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f11883a.newThread(runnable);
        int andIncrement = this.f11884b.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
