package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.f */
/* compiled from: Uploader */
final /* synthetic */ class C1616f implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final Uploader f7325a;

    /* renamed from: b */
    private final TransportContext f7326b;

    private C1616f(Uploader uploader, TransportContext transportContext) {
        this.f7325a = uploader;
        this.f7326b = transportContext;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5114a(Uploader uploader, TransportContext transportContext) {
        return new C1616f(uploader, transportContext);
    }

    public Object execute() {
        return this.f7325a.f7290c.loadBatch(this.f7326b);
    }
}
