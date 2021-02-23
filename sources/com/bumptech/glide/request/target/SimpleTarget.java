package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;

@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: b */
    private final int f6444b;

    /* renamed from: c */
    private final int f6445c;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.f6444b, this.f6445c)) {
            sizeReadyCallback.onSizeReady(this.f6444b, this.f6445c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f6444b + " and height: " + this.f6445c + ", either provide dimensions in the constructor or call override()");
    }

    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i, int i2) {
        this.f6444b = i;
        this.f6445c = i2;
    }
}
