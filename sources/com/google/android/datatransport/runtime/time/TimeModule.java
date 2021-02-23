package com.google.android.datatransport.runtime.time;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class TimeModule {
    @WallTime
    @Provides
    /* renamed from: a */
    static Clock m5212a() {
        return new WallTimeClock();
    }

    @Monotonic
    @Provides
    /* renamed from: b */
    static Clock m5213b() {
        return new UptimeClock();
    }
}
