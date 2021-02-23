package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a */
    private int f6508a = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    private long m4763a(long j) {
        int i = this.f6508a;
        if (i == 0) {
            return -1;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : (long) i;
    }

    /* renamed from: b */
    private void m4764b(long j) {
        int i = this.f6508a;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f6508a = (int) (((long) i) - j);
        }
    }

    public int available() {
        int i = this.f6508a;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.f6508a = i;
    }

    public int read() {
        if (m4763a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m4764b(1);
        return read;
    }

    public synchronized void reset() {
        super.reset();
        this.f6508a = Integer.MIN_VALUE;
    }

    public long skip(long j) {
        long a = m4763a(j);
        if (a == -1) {
            return 0;
        }
        long skip = super.skip(a);
        m4764b(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i, int i2) {
        int a = (int) m4763a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        m4764b((long) read);
        return read;
    }
}
