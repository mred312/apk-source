package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class WorkInitializer {

    /* renamed from: a */
    private final Executor f7302a;

    /* renamed from: b */
    private final EventStore f7303b;

    /* renamed from: c */
    private final WorkScheduler f7304c;

    /* renamed from: d */
    private final SynchronizationGuard f7305d;

    @Inject
    WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f7302a = executor;
        this.f7303b = eventStore;
        this.f7304c = workScheduler;
        this.f7305d = synchronizationGuard;
    }

    /* renamed from: a */
    static /* synthetic */ Object m5104a(WorkInitializer workInitializer) {
        for (TransportContext schedule : workInitializer.f7303b.loadActiveContexts()) {
            workInitializer.f7304c.schedule(schedule, 1);
        }
        return null;
    }

    public void ensureContextsScheduled() {
        this.f7302a.execute(C1620j.m5118a(this));
    }
}
