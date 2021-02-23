package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: c */
    private static final byte[] f5623c;

    /* renamed from: d */
    private static final int f5624d;

    /* renamed from: e */
    private static final int f5625e;

    /* renamed from: a */
    private final byte f5626a;

    /* renamed from: b */
    private int f5627b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f5623c = bArr;
        int length = bArr.length;
        f5624d = length;
        f5625e = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.f5626a = (byte) i;
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int i;
        int i2;
        int i3 = this.f5627b;
        if (i3 < 2 || i3 > (i2 = f5625e)) {
            i = super.read();
        } else if (i3 == i2) {
            i = this.f5626a;
        } else {
            i = f5623c[i3 - 2] & 255;
        }
        if (i != -1) {
            this.f5627b++;
        }
        return i;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f5627b = (int) (((long) this.f5627b) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f5627b;
        int i5 = f5625e;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f5626a;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f5623c, this.f5627b - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f5627b += i3;
        }
        return i3;
    }
}
