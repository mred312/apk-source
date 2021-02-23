package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse fatalError() {
        return new C1587b(Status.FATAL_ERROR, -1);
    }

    /* renamed from: ok */
    public static BackendResponse m5052ok(long j) {
        return new C1587b(Status.OK, j);
    }

    public static BackendResponse transientError() {
        return new C1587b(Status.TRANSIENT_ERROR, -1);
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();
}
