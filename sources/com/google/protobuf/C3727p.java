package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* renamed from: com.google.protobuf.p */
/* compiled from: IterableByteBufferInputStream */
class C3727p extends InputStream {

    /* renamed from: a */
    private Iterator<ByteBuffer> f20825a;

    /* renamed from: b */
    private ByteBuffer f20826b;

    /* renamed from: c */
    private int f20827c = 0;

    /* renamed from: d */
    private int f20828d;

    /* renamed from: e */
    private int f20829e;

    /* renamed from: f */
    private boolean f20830f;

    /* renamed from: g */
    private byte[] f20831g;

    /* renamed from: h */
    private int f20832h;

    /* renamed from: i */
    private long f20833i;

    C3727p(Iterable<ByteBuffer> iterable) {
        this.f20825a = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.f20827c++;
        }
        this.f20828d = -1;
        if (!m13581a()) {
            this.f20826b = Internal.EMPTY_BYTE_BUFFER;
            this.f20828d = 0;
            this.f20829e = 0;
            this.f20833i = 0;
        }
    }

    /* renamed from: a */
    private boolean m13581a() {
        this.f20828d++;
        if (!this.f20825a.hasNext()) {
            return false;
        }
        ByteBuffer next = this.f20825a.next();
        this.f20826b = next;
        this.f20829e = next.position();
        if (this.f20826b.hasArray()) {
            this.f20830f = true;
            this.f20831g = this.f20826b.array();
            this.f20832h = this.f20826b.arrayOffset();
        } else {
            this.f20830f = false;
            this.f20833i = C3752t0.m13744i(this.f20826b);
            this.f20831g = null;
        }
        return true;
    }

    /* renamed from: b */
    private void m13582b(int i) {
        int i2 = this.f20829e + i;
        this.f20829e = i2;
        if (i2 == this.f20826b.limit()) {
            m13581a();
        }
    }

    public int read() {
        if (this.f20828d == this.f20827c) {
            return -1;
        }
        if (this.f20830f) {
            byte b = this.f20831g[this.f20829e + this.f20832h] & 255;
            m13582b(1);
            return b;
        }
        byte v = C3752t0.m13757v(((long) this.f20829e) + this.f20833i) & 255;
        m13582b(1);
        return v;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f20828d == this.f20827c) {
            return -1;
        }
        int limit = this.f20826b.limit();
        int i3 = this.f20829e;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.f20830f) {
            System.arraycopy(this.f20831g, i3 + this.f20832h, bArr, i, i2);
            m13582b(i2);
        } else {
            int position = this.f20826b.position();
            this.f20826b.position(this.f20829e);
            this.f20826b.get(bArr, i, i2);
            this.f20826b.position(position);
            m13582b(i2);
        }
        return i2;
    }
}
