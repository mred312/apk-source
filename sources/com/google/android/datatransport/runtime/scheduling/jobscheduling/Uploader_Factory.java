package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a */
    private final Provider<Context> f7295a;

    /* renamed from: b */
    private final Provider<BackendRegistry> f7296b;

    /* renamed from: c */
    private final Provider<EventStore> f7297c;

    /* renamed from: d */
    private final Provider<WorkScheduler> f7298d;

    /* renamed from: e */
    private final Provider<Executor> f7299e;

    /* renamed from: f */
    private final Provider<SynchronizationGuard> f7300f;

    /* renamed from: g */
    private final Provider<Clock> f7301g;

    public Uploader_Factory(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        this.f7295a = provider;
        this.f7296b = provider2;
        this.f7297c = provider3;
        this.f7298d = provider4;
        this.f7299e = provider5;
        this.f7300f = provider6;
        this.f7301g = provider7;
    }

    public static Uploader_Factory create(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock);
    }

    public Uploader get() {
        return new Uploader(this.f7295a.get(), this.f7296b.get(), this.f7297c.get(), this.f7298d.get(), this.f7299e.get(), this.f7300f.get(), this.f7301g.get());
    }
}
