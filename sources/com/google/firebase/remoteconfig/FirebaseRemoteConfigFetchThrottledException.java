package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {

    /* renamed from: a */
    private final long f19680a;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    public long getThrottleEndTimeMillis() {
        return this.f19680a;
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
        this.f19680a = j;
    }
}
