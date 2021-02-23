package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f6154a;

    /* renamed from: b */
    private int f6155b;

    /* renamed from: c */
    private int f6156c;

    /* renamed from: d */
    private int f6157d;

    /* renamed from: e */
    private int f6158e;

    /* renamed from: f */
    private final ArrayPool f6159f;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream$a */
    static class C1305a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        C1305a(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    /* renamed from: a */
    private int m4547a(InputStream inputStream, byte[] bArr) {
        int i;
        int i2 = this.f6157d;
        if (i2 == -1 || this.f6158e - i2 >= (i = this.f6156c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f6157d = -1;
                this.f6158e = 0;
                this.f6155b = read;
            }
            return read;
        }
        if (i2 == 0 && i > bArr.length && this.f6155b == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i) {
                i = length;
            }
            byte[] bArr2 = (byte[]) this.f6159f.get(i, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f6154a = bArr2;
            this.f6159f.put(bArr);
            bArr = bArr2;
        } else if (i2 > 0) {
            System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
        }
        int i3 = this.f6158e - this.f6157d;
        this.f6158e = i3;
        this.f6157d = 0;
        this.f6155b = 0;
        int read2 = inputStream.read(bArr, i3, bArr.length - i3);
        int i4 = this.f6158e;
        if (read2 > 0) {
            i4 += read2;
        }
        this.f6155b = i4;
        return read2;
    }

    /* renamed from: b */
    private static IOException m4548b() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f6154a == null || inputStream == null) {
            m4548b();
            throw null;
        }
        return (this.f6155b - this.f6158e) + inputStream.available();
    }

    public void close() {
        if (this.f6154a != null) {
            this.f6159f.put(this.f6154a);
            this.f6154a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.f6156c = this.f6154a.length;
    }

    public synchronized void mark(int i) {
        this.f6156c = Math.max(this.f6156c, i);
        this.f6157d = this.f6158e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0026=Splitter:B:19:0x0026, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x0039=Splitter:B:28:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f6154a     // Catch:{ all -> 0x003d }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x003d }
            r2 = 0
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            int r3 = r6.f6158e     // Catch:{ all -> 0x003d }
            int r4 = r6.f6155b     // Catch:{ all -> 0x003d }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r1 = r6.m4547a(r1, r0)     // Catch:{ all -> 0x003d }
            if (r1 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r1 = r6.f6154a     // Catch:{ all -> 0x003d }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r6.f6154a     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            m4548b()     // Catch:{ all -> 0x003d }
            throw r2
        L_0x0026:
            int r1 = r6.f6155b     // Catch:{ all -> 0x003d }
            int r2 = r6.f6158e     // Catch:{ all -> 0x003d }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0037
            int r1 = r2 + 1
            r6.f6158e = r1     // Catch:{ all -> 0x003d }
            byte r0 = r0[r2]     // Catch:{ all -> 0x003d }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r0
        L_0x0037:
            monitor-exit(r6)
            return r5
        L_0x0039:
            m4548b()     // Catch:{ all -> 0x003d }
            throw r2
        L_0x003d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read():int");
    }

    public synchronized void release() {
        if (this.f6154a != null) {
            this.f6159f.put(this.f6154a);
            this.f6154a = null;
        }
    }

    public synchronized void reset() {
        if (this.f6154a != null) {
            int i = this.f6157d;
            if (-1 != i) {
                this.f6158e = i;
            } else {
                throw new C1305a("Mark has been invalidated, pos: " + this.f6158e + " markLimit: " + this.f6156c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public synchronized long skip(long j) {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f6154a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i = this.f6155b;
                int i2 = this.f6158e;
                if (((long) (i - i2)) >= j) {
                    this.f6158e = (int) (((long) i2) + j);
                    return j;
                }
                long j2 = ((long) i) - ((long) i2);
                this.f6158e = i;
                if (this.f6157d == -1 || j > ((long) this.f6156c)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (m4547a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    int i3 = this.f6155b;
                    int i4 = this.f6158e;
                    if (((long) (i3 - i4)) >= j - j2) {
                        this.f6158e = (int) ((((long) i4) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) i3)) - ((long) i4);
                    this.f6158e = i3;
                    return j3;
                }
            } else {
                m4548b();
                throw null;
            }
        } else {
            m4548b();
            throw null;
        }
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i) {
        super(inputStream);
        this.f6157d = -1;
        this.f6159f = arrayPool;
        this.f6154a = (byte[]) arrayPool.get(i, byte[].class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0048, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0055, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(@androidx.annotation.NonNull byte[] r8, int r9, int r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            byte[] r0 = r7.f6154a     // Catch:{ all -> 0x008e }
            r1 = 0
            if (r0 == 0) goto L_0x008a
            if (r10 != 0) goto L_0x000b
            r8 = 0
            monitor-exit(r7)
            return r8
        L_0x000b:
            java.io.InputStream r2 = r7.in     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x0086
            int r3 = r7.f6158e     // Catch:{ all -> 0x008e }
            int r4 = r7.f6155b     // Catch:{ all -> 0x008e }
            if (r3 >= r4) goto L_0x0033
            int r5 = r4 - r3
            if (r5 < r10) goto L_0x001b
            r4 = r10
            goto L_0x001c
        L_0x001b:
            int r4 = r4 - r3
        L_0x001c:
            java.lang.System.arraycopy(r0, r3, r8, r9, r4)     // Catch:{ all -> 0x008e }
            int r3 = r7.f6158e     // Catch:{ all -> 0x008e }
            int r3 = r3 + r4
            r7.f6158e = r3     // Catch:{ all -> 0x008e }
            if (r4 == r10) goto L_0x0031
            int r3 = r2.available()     // Catch:{ all -> 0x008e }
            if (r3 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r9 = r9 + r4
            int r3 = r10 - r4
            goto L_0x0034
        L_0x0031:
            monitor-exit(r7)
            return r4
        L_0x0033:
            r3 = r10
        L_0x0034:
            int r4 = r7.f6157d     // Catch:{ all -> 0x008e }
            r5 = -1
            if (r4 != r5) goto L_0x0049
            int r4 = r0.length     // Catch:{ all -> 0x008e }
            if (r3 < r4) goto L_0x0049
            int r4 = r2.read(r8, r9, r3)     // Catch:{ all -> 0x008e }
            if (r4 != r5) goto L_0x0076
            if (r3 != r10) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            int r5 = r10 - r3
        L_0x0047:
            monitor-exit(r7)
            return r5
        L_0x0049:
            int r4 = r7.m4547a(r2, r0)     // Catch:{ all -> 0x008e }
            if (r4 != r5) goto L_0x0056
            if (r3 != r10) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            int r5 = r10 - r3
        L_0x0054:
            monitor-exit(r7)
            return r5
        L_0x0056:
            byte[] r4 = r7.f6154a     // Catch:{ all -> 0x008e }
            if (r0 == r4) goto L_0x0063
            byte[] r0 = r7.f6154a     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            m4548b()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x0063:
            int r4 = r7.f6155b     // Catch:{ all -> 0x008e }
            int r5 = r7.f6158e     // Catch:{ all -> 0x008e }
            int r6 = r4 - r5
            if (r6 < r3) goto L_0x006d
            r4 = r3
            goto L_0x006e
        L_0x006d:
            int r4 = r4 - r5
        L_0x006e:
            java.lang.System.arraycopy(r0, r5, r8, r9, r4)     // Catch:{ all -> 0x008e }
            int r5 = r7.f6158e     // Catch:{ all -> 0x008e }
            int r5 = r5 + r4
            r7.f6158e = r5     // Catch:{ all -> 0x008e }
        L_0x0076:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x007b
            monitor-exit(r7)
            return r10
        L_0x007b:
            int r5 = r2.available()     // Catch:{ all -> 0x008e }
            if (r5 != 0) goto L_0x0084
            int r10 = r10 - r3
            monitor-exit(r7)
            return r10
        L_0x0084:
            int r9 = r9 + r4
            goto L_0x0034
        L_0x0086:
            m4548b()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x008a:
            m4548b()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x008e:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0092
        L_0x0091:
            throw r8
        L_0x0092:
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }
}
