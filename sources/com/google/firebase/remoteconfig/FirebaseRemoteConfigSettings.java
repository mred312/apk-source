package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

public class FirebaseRemoteConfigSettings {

    /* renamed from: a */
    private final boolean f19682a;

    /* renamed from: b */
    private final long f19683b;

    /* renamed from: c */
    private final long f19684c;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f19685a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f19686b = 60;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public long f19687c = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;

        @NonNull
        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings(this);
        }

        public long getFetchTimeoutInSeconds() {
            return this.f19686b;
        }

        public long getMinimumFetchIntervalInSeconds() {
            return this.f19687c;
        }

        @NonNull
        @Deprecated
        public Builder setDeveloperModeEnabled(boolean z) {
            this.f19685a = z;
            return this;
        }

        @NonNull
        public Builder setFetchTimeoutInSeconds(long j) {
            if (j >= 0) {
                this.f19686b = j;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", new Object[]{Long.valueOf(j)}));
        }

        @NonNull
        public Builder setMinimumFetchIntervalInSeconds(long j) {
            if (j >= 0) {
                this.f19687c = j;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.f19683b;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.f19684c;
    }

    @Deprecated
    public boolean isDeveloperModeEnabled() {
        return this.f19682a;
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setDeveloperModeEnabled(isDeveloperModeEnabled());
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f19682a = builder.f19685a;
        this.f19683b = builder.f19686b;
        this.f19684c = builder.f19687c;
    }
}
