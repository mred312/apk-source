package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.k */
/* compiled from: WorkInitializer */
final /* synthetic */ class C1621k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final WorkInitializer f7337a;

    private C1621k(WorkInitializer workInitializer) {
        this.f7337a = workInitializer;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5119a(WorkInitializer workInitializer) {
        return new C1621k(workInitializer);
    }

    public Object execute() {
        return WorkInitializer.m5104a(this.f7337a);
    }
}
