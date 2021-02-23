package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {

    /* renamed from: a */
    private final int f19681a;

    public FirebaseRemoteConfigServerException(int i, @NonNull String str) {
        super(str);
        this.f19681a = i;
    }

    public int getHttpStatusCode() {
        return this.f19681a;
    }

    public FirebaseRemoteConfigServerException(int i, @NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.f19681a = i;
    }
}
