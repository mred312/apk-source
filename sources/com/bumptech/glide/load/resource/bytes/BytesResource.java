package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {

    /* renamed from: a */
    private final byte[] f6189a;

    public BytesResource(byte[] bArr) {
        this.f6189a = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    public int getSize() {
        return this.f6189a.length;
    }

    public void recycle() {
    }

    @NonNull
    public byte[] get() {
        return this.f6189a;
    }
}
