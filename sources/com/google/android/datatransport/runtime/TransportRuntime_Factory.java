package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a */
    private final Provider<Clock> f7172a;

    /* renamed from: b */
    private final Provider<Clock> f7173b;

    /* renamed from: c */
    private final Provider<Scheduler> f7174c;

    /* renamed from: d */
    private final Provider<Uploader> f7175d;

    /* renamed from: e */
    private final Provider<WorkInitializer> f7176e;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.f7172a = provider;
        this.f7173b = provider2;
        this.f7174c = provider3;
        this.f7175d = provider4;
        this.f7176e = provider5;
    }

    public static TransportRuntime_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    public TransportRuntime get() {
        return new TransportRuntime(this.f7172a.get(), this.f7173b.get(), this.f7174c.get(), this.f7175d.get(), this.f7176e.get());
    }
}
