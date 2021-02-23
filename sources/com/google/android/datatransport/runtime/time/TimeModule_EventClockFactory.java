package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TimeModule_EventClockFactory implements Factory<Clock> {

    /* renamed from: a */
    private static final TimeModule_EventClockFactory f7408a = new TimeModule_EventClockFactory();

    public static TimeModule_EventClockFactory create() {
        return f7408a;
    }

    public static Clock eventClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.m5212a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return eventClock();
    }
}
