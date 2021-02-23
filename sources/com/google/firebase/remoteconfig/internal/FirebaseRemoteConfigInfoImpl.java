package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {

    /* renamed from: a */
    private final long f20268a;

    /* renamed from: b */
    private final int f20269b;

    /* renamed from: c */
    private final FirebaseRemoteConfigSettings f20270c;

    public static class Builder {

        /* renamed from: a */
        private long f20271a;

        /* renamed from: b */
        private int f20272b;

        /* renamed from: c */
        private FirebaseRemoteConfigSettings f20273c;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Builder mo22657a(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.f20273c = firebaseRemoteConfigSettings;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Builder mo22658b(int i) {
            this.f20272b = i;
            return this;
        }

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.f20271a, this.f20272b, this.f20273c);
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j) {
            this.f20271a = j;
            return this;
        }

        private Builder() {
        }
    }

    /* renamed from: a */
    static Builder m12154a() {
        return new Builder();
    }

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.f20270c;
    }

    public long getFetchTimeMillis() {
        return this.f20268a;
    }

    public int getLastFetchStatus() {
        return this.f20269b;
    }

    private FirebaseRemoteConfigInfoImpl(long j, int i, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f20268a = j;
        this.f20269b = i;
        this.f20270c = firebaseRemoteConfigSettings;
    }
}
