package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.measurement.l */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2803l implements ThreadFactory {

    /* renamed from: a */
    private ThreadFactory f17363a = Executors.defaultThreadFactory();

    C2803l(zzag zzag) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f17363a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
