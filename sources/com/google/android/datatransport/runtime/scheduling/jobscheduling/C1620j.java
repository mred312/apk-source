package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.j */
/* compiled from: WorkInitializer */
final /* synthetic */ class C1620j implements Runnable {

    /* renamed from: a */
    private final WorkInitializer f7336a;

    private C1620j(WorkInitializer workInitializer) {
        this.f7336a = workInitializer;
    }

    /* renamed from: a */
    public static Runnable m5118a(WorkInitializer workInitializer) {
        return new C1620j(workInitializer);
    }

    public void run() {
        this.f7336a.f7305d.runCriticalSection(C1621k.m5119a(this.f7336a));
    }
}
