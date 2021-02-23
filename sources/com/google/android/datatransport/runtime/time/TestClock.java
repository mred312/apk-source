package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock implements Clock {

    /* renamed from: a */
    private final AtomicLong f7407a;

    public TestClock(long j) {
        this.f7407a = new AtomicLong(j);
    }

    public void advance(long j) {
        if (j >= 0) {
            this.f7407a.addAndGet(j);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    public long getTime() {
        return this.f7407a.get();
    }

    public void tick() {
        advance(1);
    }
}
