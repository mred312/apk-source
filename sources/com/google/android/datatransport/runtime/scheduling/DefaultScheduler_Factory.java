package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a */
    private final Provider<Executor> f7260a;

    /* renamed from: b */
    private final Provider<BackendRegistry> f7261b;

    /* renamed from: c */
    private final Provider<WorkScheduler> f7262c;

    /* renamed from: d */
    private final Provider<EventStore> f7263d;

    /* renamed from: e */
    private final Provider<SynchronizationGuard> f7264e;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f7260a = provider;
        this.f7261b = provider2;
        this.f7262c = provider3;
        this.f7263d = provider4;
        this.f7264e = provider5;
    }

    public static DefaultScheduler_Factory create(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    public DefaultScheduler get() {
        return new DefaultScheduler(this.f7260a.get(), this.f7261b.get(), this.f7262c.get(), this.f7263d.get(), this.f7264e.get());
    }
}
