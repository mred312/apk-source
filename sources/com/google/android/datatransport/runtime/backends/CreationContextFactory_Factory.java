package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CreationContextFactory_Factory implements Factory<C1589d> {

    /* renamed from: a */
    private final Provider<Context> f7201a;

    /* renamed from: b */
    private final Provider<Clock> f7202b;

    /* renamed from: c */
    private final Provider<Clock> f7203c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f7201a = provider;
        this.f7202b = provider2;
        this.f7203c = provider3;
    }

    public static CreationContextFactory_Factory create(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static C1589d newInstance(Context context, Clock clock, Clock clock2) {
        return new C1589d(context, clock, clock2);
    }

    public C1589d get() {
        return new C1589d(this.f7201a.get(), this.f7202b.get(), this.f7203c.get());
    }
}
