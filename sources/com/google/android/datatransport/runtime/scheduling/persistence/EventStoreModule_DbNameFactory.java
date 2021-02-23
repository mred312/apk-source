package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class EventStoreModule_DbNameFactory implements Factory<String> {

    /* renamed from: a */
    private static final EventStoreModule_DbNameFactory f7338a = new EventStoreModule_DbNameFactory();

    public static EventStoreModule_DbNameFactory create() {
        return f7338a;
    }

    public static String dbName() {
        return (String) Preconditions.checkNotNull(EventStoreModule.m5120a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String get() {
        return dbName();
    }
}
