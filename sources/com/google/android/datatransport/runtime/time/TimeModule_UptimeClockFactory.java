package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    /* renamed from: a */
    private static final TimeModule_UptimeClockFactory f7409a = new TimeModule_UptimeClockFactory();

    public static TimeModule_UptimeClockFactory create() {
        return f7409a;
    }

    public static Clock uptimeClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.m5213b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return uptimeClock();
    }
}
