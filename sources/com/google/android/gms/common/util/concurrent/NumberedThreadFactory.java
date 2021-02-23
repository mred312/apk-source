package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f7640a;

    /* renamed from: b */
    private final AtomicInteger f7641b;

    /* renamed from: c */
    private final ThreadFactory f7642c;

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f7642c.newThread(new C1690a(runnable, 0));
        String str = this.f7640a;
        int andIncrement = this.f7641b.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }

    private NumberedThreadFactory(String str, int i) {
        this.f7641b = new AtomicInteger();
        this.f7642c = Executors.defaultThreadFactory();
        this.f7640a = (String) Preconditions.checkNotNull(str, "Name must not be null");
    }
}
