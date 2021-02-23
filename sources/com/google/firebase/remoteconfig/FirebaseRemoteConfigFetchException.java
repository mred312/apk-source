package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public class FirebaseRemoteConfigFetchException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigFetchException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigFetchException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}
