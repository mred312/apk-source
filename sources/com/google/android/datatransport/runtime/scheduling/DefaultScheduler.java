package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

public class DefaultScheduler implements Scheduler {

    /* renamed from: f */
    private static final Logger f7254f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a */
    private final WorkScheduler f7255a;

    /* renamed from: b */
    private final Executor f7256b;

    /* renamed from: c */
    private final BackendRegistry f7257c;

    /* renamed from: d */
    private final EventStore f7258d;

    /* renamed from: e */
    private final SynchronizationGuard f7259e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f7256b = executor;
        this.f7257c = backendRegistry;
        this.f7255a = workScheduler;
        this.f7258d = eventStore;
        this.f7259e = synchronizationGuard;
    }

    /* renamed from: a */
    static /* synthetic */ Object m5078a(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        defaultScheduler.f7258d.persist(transportContext, eventInternal);
        defaultScheduler.f7255a.schedule(transportContext, 1);
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ void m5079b(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = defaultScheduler.f7257c.get(transportContext.getBackendName());
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{transportContext.getBackendName()});
                f7254f.warning(format);
                transportScheduleCallback.onSchedule(new IllegalArgumentException(format));
                return;
            }
            defaultScheduler.f7259e.runCriticalSection(C1608b.m5083a(defaultScheduler, transportContext, transportBackend.decorate(eventInternal)));
            transportScheduleCallback.onSchedule((Exception) null);
        } catch (Exception e) {
            Logger logger = f7254f;
            logger.warning("Error scheduling event " + e.getMessage());
            transportScheduleCallback.onSchedule(e);
        }
    }

    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f7256b.execute(C1607a.m5082a(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
