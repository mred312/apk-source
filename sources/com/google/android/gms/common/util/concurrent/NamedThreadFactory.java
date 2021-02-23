package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f7638a;

    /* renamed from: b */
    private final ThreadFactory f7639b;

    @KeepForSdk
    public NamedThreadFactory(String str) {
        this(str, 0);
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f7639b.newThread(new C1690a(runnable, 0));
        newThread.setName(this.f7638a);
        return newThread;
    }

    private NamedThreadFactory(String str, int i) {
        this.f7639b = Executors.defaultThreadFactory();
        this.f7638a = (String) Preconditions.checkNotNull(str, "Name must not be null");
    }
}
