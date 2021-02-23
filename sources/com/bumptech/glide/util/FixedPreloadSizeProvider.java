package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    /* renamed from: a */
    private final int[] f6502a;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.f6502a = new int[]{i, i2};
    }

    @Nullable
    public int[] getPreloadSize(@NonNull T t, int i, int i2) {
        return this.f6502a;
    }
}
