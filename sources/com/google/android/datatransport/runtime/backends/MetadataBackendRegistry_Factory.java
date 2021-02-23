package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MetadataBackendRegistry_Factory implements Factory<C1590e> {

    /* renamed from: a */
    private final Provider<Context> f7204a;

    /* renamed from: b */
    private final Provider<C1589d> f7205b;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<C1589d> provider2) {
        this.f7204a = provider;
        this.f7205b = provider2;
    }

    public static MetadataBackendRegistry_Factory create(Provider<Context> provider, Provider<C1589d> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static C1590e newInstance(Context context, Object obj) {
        return new C1590e(context, (C1589d) obj);
    }

    public C1590e get() {
        return new C1590e(this.f7204a.get(), this.f7205b.get());
    }
}
