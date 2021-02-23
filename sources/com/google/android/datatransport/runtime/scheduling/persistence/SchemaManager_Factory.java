package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a */
    private final Provider<Context> f7360a;

    /* renamed from: b */
    private final Provider<String> f7361b;

    /* renamed from: c */
    private final Provider<Integer> f7362c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f7360a = provider;
        this.f7361b = provider2;
        this.f7362c = provider3;
    }

    public static SchemaManager_Factory create(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    public SchemaManager get() {
        return new SchemaManager(this.f7360a.get(), this.f7361b.get(), this.f7362c.get().intValue());
    }
}
