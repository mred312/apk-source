package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull String str, double d);

    @NonNull
    ObjectEncoderContext add(@NonNull String str, int i);

    @NonNull
    ObjectEncoderContext add(@NonNull String str, long j);

    @NonNull
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj);

    @NonNull
    ObjectEncoderContext add(@NonNull String str, boolean z);

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj);

    @NonNull
    ObjectEncoderContext nested(@NonNull String str);
}
