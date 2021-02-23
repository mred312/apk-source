package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.b */
/* compiled from: DefaultScheduler */
final /* synthetic */ class C1608b implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final DefaultScheduler f7274a;

    /* renamed from: b */
    private final TransportContext f7275b;

    /* renamed from: c */
    private final EventInternal f7276c;

    private C1608b(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f7274a = defaultScheduler;
        this.f7275b = transportContext;
        this.f7276c = eventInternal;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5083a(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        return new C1608b(defaultScheduler, transportContext, eventInternal);
    }

    public Object execute() {
        return DefaultScheduler.m5078a(this.f7274a, this.f7275b, this.f7276c);
    }
}
