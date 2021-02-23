package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class EventStoreModule_StoreConfigFactory implements Factory<C1630c> {

    /* renamed from: a */
    private static final EventStoreModule_StoreConfigFactory f7340a = new EventStoreModule_StoreConfigFactory();

    public static EventStoreModule_StoreConfigFactory create() {
        return f7340a;
    }

    public static C1630c storeConfig() {
        return (C1630c) Preconditions.checkNotNull(EventStoreModule.m5122c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public C1630c get() {
        return storeConfig();
    }
}
