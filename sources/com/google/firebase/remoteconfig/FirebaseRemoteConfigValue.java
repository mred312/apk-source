package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

public interface FirebaseRemoteConfigValue {
    boolean asBoolean();

    @NonNull
    byte[] asByteArray();

    double asDouble();

    long asLong();

    @NonNull
    String asString();

    int getSource();
}
