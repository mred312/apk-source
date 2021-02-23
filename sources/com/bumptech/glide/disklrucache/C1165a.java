package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.disklrucache.a */
/* compiled from: StrictLineReader */
class C1165a implements Closeable {

    /* renamed from: a */
    private final InputStream f5542a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f5543b;

    /* renamed from: c */
    private byte[] f5544c;

    /* renamed from: d */
    private int f5545d;

    /* renamed from: e */
    private int f5546e;

    /* renamed from: com.bumptech.glide.disklrucache.a$a */
    /* compiled from: StrictLineReader */
    class C1166a extends ByteArrayOutputStream {
        C1166a(int i) {
            super(i);
        }

        public String toString() {
            int i = this.count;
            if (i > 0 && this.buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(this.buf, 0, i, C1165a.this.f5543b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public C1165a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m4156b() {
        InputStream inputStream = this.f5542a;
        byte[] bArr = this.f5544c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f5545d = 0;
            this.f5546e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: c */
    public boolean mo9329c() {
        return this.f5546e == -1;
    }

    public void close() {
        synchronized (this.f5542a) {
            if (this.f5544c != null) {
                this.f5544c = null;
                this.f5542a.close();
            }
        }
    }

    /* renamed from: d */
    public String mo9331d() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f5542a) {
            if (this.f5544c != null) {
                if (this.f5545d >= this.f5546e) {
                    m4156b();
                }
                for (int i3 = this.f5545d; i3 != this.f5546e; i3++) {
                    byte[] bArr2 = this.f5544c;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.f5545d) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.f5544c;
                                int i4 = this.f5545d;
                                String str = new String(bArr3, i4, i2 - i4, this.f5543b.name());
                                this.f5545d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr32 = this.f5544c;
                        int i42 = this.f5545d;
                        String str2 = new String(bArr32, i42, i2 - i42, this.f5543b.name());
                        this.f5545d = i3 + 1;
                        return str2;
                    }
                }
                C1166a aVar = new C1166a((this.f5546e - this.f5545d) + 80);
                loop1:
                while (true) {
                    byte[] bArr4 = this.f5544c;
                    int i5 = this.f5545d;
                    aVar.write(bArr4, i5, this.f5546e - i5);
                    this.f5546e = -1;
                    m4156b();
                    i = this.f5545d;
                    while (true) {
                        if (i != this.f5546e) {
                            bArr = this.f5544c;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                int i6 = this.f5545d;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.f5545d = i + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public C1165a(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C1167b.f5548a)) {
            this.f5542a = inputStream;
            this.f5543b = charset;
            this.f5544c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
