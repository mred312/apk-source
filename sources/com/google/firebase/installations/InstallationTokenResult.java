package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.C3475a;

@AutoValue
/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
public abstract class InstallationTokenResult {

    @AutoValue.Builder
    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    public static abstract class Builder {
        @NonNull
        public abstract InstallationTokenResult build();

        @NonNull
        public abstract Builder setToken(@NonNull String str);

        @NonNull
        public abstract Builder setTokenCreationTimestamp(long j);

        @NonNull
        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    @NonNull
    public static Builder builder() {
        return new C3475a.C3477b();
    }

    @NonNull
    public abstract String getToken();

    @NonNull
    public abstract long getTokenCreationTimestamp();

    @NonNull
    public abstract long getTokenExpirationTimestamp();

    @NonNull
    public abstract Builder toBuilder();
}
