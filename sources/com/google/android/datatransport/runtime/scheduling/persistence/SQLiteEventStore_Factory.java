package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a */
    private final Provider<Clock> f7348a;

    /* renamed from: b */
    private final Provider<Clock> f7349b;

    /* renamed from: c */
    private final Provider<C1630c> f7350c;

    /* renamed from: d */
    private final Provider<SchemaManager> f7351d;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<C1630c> provider3, Provider<SchemaManager> provider4) {
        this.f7348a = provider;
        this.f7349b = provider2;
        this.f7350c = provider3;
        this.f7351d = provider4;
    }

    public static SQLiteEventStore_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<C1630c> provider3, Provider<SchemaManager> provider4) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2) {
        return new SQLiteEventStore(clock, clock2, (C1630c) obj, (SchemaManager) obj2);
    }

    public SQLiteEventStore get() {
        return new SQLiteEventStore(this.f7348a.get(), this.f7349b.get(), this.f7350c.get(), this.f7351d.get());
    }
}
