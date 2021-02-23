package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a */
    private final Provider<Executor> f7306a;

    /* renamed from: b */
    private final Provider<EventStore> f7307b;

    /* renamed from: c */
    private final Provider<WorkScheduler> f7308c;

    /* renamed from: d */
    private final Provider<SynchronizationGuard> f7309d;

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f7306a = provider;
        this.f7307b = provider2;
        this.f7308c = provider3;
        this.f7309d = provider4;
    }

    public static WorkInitializer_Factory create(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    public WorkInitializer get() {
        return new WorkInitializer(this.f7306a.get(), this.f7307b.get(), this.f7308c.get(), this.f7309d.get());
    }
}
