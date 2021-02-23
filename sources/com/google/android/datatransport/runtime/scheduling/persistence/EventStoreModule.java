package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public abstract class EventStoreModule {
    @Provides
    @Named("SQLITE_DB_NAME")
    /* renamed from: a */
    static String m5120a() {
        return "com.google.android.datatransport.events";
    }

    @Provides
    @Named("SCHEMA_VERSION")
    /* renamed from: b */
    static int m5121b() {
        return SchemaManager.f7352c;
    }

    @Provides
    /* renamed from: c */
    static C1630c m5122c() {
        return C1630c.f7376a;
    }
}
