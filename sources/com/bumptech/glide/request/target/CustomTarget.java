package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: a */
    private final int f6411a;

    /* renamed from: b */
    private final int f6412b;
    @Nullable

    /* renamed from: c */
    private Request f6413c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Nullable
    public final Request getRequest() {
        return this.f6413c;
    }

    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f6411a, this.f6412b);
    }

    public void onDestroy() {
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void setRequest(@Nullable Request request) {
        this.f6413c = request;
    }

    public CustomTarget(int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            this.f6411a = i;
            this.f6412b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
