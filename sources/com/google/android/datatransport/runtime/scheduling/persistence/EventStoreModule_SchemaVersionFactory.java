package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    /* renamed from: a */
    private static final EventStoreModule_SchemaVersionFactory f7339a = new EventStoreModule_SchemaVersionFactory();

    public static EventStoreModule_SchemaVersionFactory create() {
        return f7339a;
    }

    public static int schemaVersion() {
        return EventStoreModule.m5121b();
    }

    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
