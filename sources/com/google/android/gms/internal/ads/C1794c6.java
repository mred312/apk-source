package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.c6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1794c6 implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f7967a = new AtomicInteger(1);

    /* renamed from: b */
    private final /* synthetic */ String f7968b;

    C1794c6(String str) {
        this.f7968b = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.f7968b;
        int andIncrement = this.f7967a.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
