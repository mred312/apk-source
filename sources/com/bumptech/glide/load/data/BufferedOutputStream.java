package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    @NonNull

    /* renamed from: a */
    private final OutputStream f5616a;

    /* renamed from: b */
    private byte[] f5617b;

    /* renamed from: c */
    private ArrayPool f5618c;

    /* renamed from: d */
    private int f5619d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    /* renamed from: a */
    private void m4189a() {
        int i = this.f5619d;
        if (i > 0) {
            this.f5616a.write(this.f5617b, 0, i);
            this.f5619d = 0;
        }
    }

    /* renamed from: b */
    private void m4190b() {
        if (this.f5619d == this.f5617b.length) {
            m4189a();
        }
    }

    /* renamed from: c */
    private void m4191c() {
        byte[] bArr = this.f5617b;
        if (bArr != null) {
            this.f5618c.put(bArr);
            this.f5617b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        try {
            flush();
            this.f5616a.close();
            m4191c();
        } catch (Throwable th) {
            this.f5616a.close();
            throw th;
        }
    }

    public void flush() {
        m4189a();
        this.f5616a.flush();
    }

    public void write(int i) {
        byte[] bArr = this.f5617b;
        int i2 = this.f5619d;
        this.f5619d = i2 + 1;
        bArr[i2] = (byte) i;
        m4190b();
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.f5616a = outputStream;
        this.f5618c = arrayPool;
        this.f5617b = (byte[]) arrayPool.get(i, byte[].class);
    }

    public void write(@NonNull byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f5619d;
            if (i6 != 0 || i4 < this.f5617b.length) {
                int min = Math.min(i4, this.f5617b.length - i6);
                System.arraycopy(bArr, i5, this.f5617b, this.f5619d, min);
                this.f5619d += min;
                i3 += min;
                m4190b();
            } else {
                this.f5616a.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
