package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* renamed from: okio.c */
/* compiled from: RealBufferedSource */
final class C3576c implements BufferedSource {

    /* renamed from: a */
    public final Buffer f20209a = new Buffer();

    /* renamed from: b */
    public final Source f20210b;

    /* renamed from: c */
    boolean f20211c;

    C3576c(Source source) {
        if (source != null) {
            this.f20210b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public Buffer buffer() {
        return this.f20209a;
    }

    public void close() {
        if (!this.f20211c) {
            this.f20211c = true;
            this.f20210b.close();
            this.f20209a.clear();
        }
    }

    public boolean exhausted() {
        if (!this.f20211c) {
            return this.f20209a.exhausted() && this.f20210b.read(this.f20209a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new C3577a();
    }

    public boolean isOpen() {
        return !this.f20211c;
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f20211c) {
            Buffer buffer2 = this.f20209a;
            if (buffer2.f20194b == 0 && this.f20210b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.f20209a.read(buffer, Math.min(j, this.f20209a.f20194b));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long readAll(Sink sink) {
        if (sink != null) {
            long j = 0;
            while (this.f20210b.read(this.f20209a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                long completeSegmentByteCount = this.f20209a.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j += completeSegmentByteCount;
                    sink.write(this.f20209a, completeSegmentByteCount);
                }
            }
            if (this.f20209a.size() <= 0) {
                return j;
            }
            long size = j + this.f20209a.size();
            Buffer buffer = this.f20209a;
            sink.write(buffer, buffer.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public byte readByte() {
        require(1);
        return this.f20209a.readByte();
    }

    public byte[] readByteArray() {
        this.f20209a.writeAll(this.f20210b);
        return this.f20209a.readByteArray();
    }

    public ByteString readByteString() {
        this.f20209a.writeAll(this.f20210b);
        return this.f20209a.readByteString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L_0x0040
            okio.Buffer r3 = r6.f20209a
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            okio.Buffer r0 = r6.f20209a
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.C3576c.readDecimalLong():long");
    }

    public void readFully(byte[] bArr) {
        try {
            require((long) bArr.length);
            this.f20209a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.f20209a;
                long j = buffer.f20194b;
                if (j > 0) {
                    int read = buffer.read(bArr, i, (int) j);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b = this.f20209a.getByte((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f20209a.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.f20209a.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.f20209a.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.f20209a.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.f20209a.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.f20209a.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.f20209a.readShortLe();
    }

    public String readString(Charset charset) {
        if (charset != null) {
            this.f20209a.writeAll(this.f20210b);
            return this.f20209a.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8() {
        this.f20209a.writeAll(this.f20210b);
        return this.f20209a.readUtf8();
    }

    public int readUtf8CodePoint() {
        require(1);
        byte b = this.f20209a.getByte(0);
        if ((b & 224) == 192) {
            require(2);
        } else if ((b & 240) == 224) {
            require(3);
        } else if ((b & 248) == 240) {
            require(4);
        }
        return this.f20209a.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.f20209a.mo22426e(indexOf);
        }
        long j = this.f20209a.f20194b;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j) {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f20211c) {
            do {
                buffer = this.f20209a;
                if (buffer.f20194b >= j) {
                    return true;
                }
            } while (this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        if (!this.f20211c) {
            do {
                int f = this.f20209a.mo22431f(options, true);
                if (f == -1) {
                    return -1;
                }
                if (f != -2) {
                    this.f20209a.skip((long) options.f21374a[f].size());
                    return f;
                }
            } while (this.f20210b.read(this.f20209a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public void skip(long j) {
        if (!this.f20211c) {
            while (j > 0) {
                Buffer buffer = this.f20209a;
                if (buffer.f20194b == 0 && this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f20209a.size());
                this.f20209a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.f20210b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f20210b + ")";
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j) {
        if (!this.f20211c) {
            while (true) {
                long indexOfElement = this.f20209a.indexOfElement(byteString, j);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer = this.f20209a;
                long j2 = buffer.f20194b;
                if (this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (this.f20211c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!request(1 + j2) || this.f20209a.getByte(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String readUtf8LineStrict(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return this.f20209a.mo22426e(indexOf);
            }
            if (j2 < Long.MAX_VALUE && request(j2) && this.f20209a.getByte(j2 - 1) == 13 && request(1 + j2) && this.f20209a.getByte(j2) == 10) {
                return this.f20209a.mo22426e(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f20209a;
            buffer2.copyTo(buffer, 0, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f20209a.size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public long indexOf(byte b, long j, long j2) {
        if (this.f20211c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long indexOf = this.f20209a.indexOf(b, j, j2);
                if (indexOf == -1) {
                    Buffer buffer = this.f20209a;
                    long j3 = buffer.f20194b;
                    if (j3 >= j2 || this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public byte[] readByteArray(long j) {
        require(j);
        return this.f20209a.readByteArray(j);
    }

    public ByteString readByteString(long j) {
        require(j);
        return this.f20209a.readByteString(j);
    }

    public String readUtf8(long j) {
        require(j);
        return this.f20209a.readUtf8(j);
    }

    public String readString(long j, Charset charset) {
        require(j);
        if (charset != null) {
            return this.f20209a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: okio.c$a */
    /* compiled from: RealBufferedSource */
    class C3577a extends InputStream {
        C3577a() {
        }

        public int available() {
            C3576c cVar = C3576c.this;
            if (!cVar.f20211c) {
                return (int) Math.min(cVar.f20209a.f20194b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            C3576c.this.close();
        }

        public int read() {
            C3576c cVar = C3576c.this;
            if (!cVar.f20211c) {
                Buffer buffer = cVar.f20209a;
                if (buffer.f20194b == 0 && cVar.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return C3576c.this.f20209a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return C3576c.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!C3576c.this.f20211c) {
                C3972g.m14445b((long) bArr.length, (long) i, (long) i2);
                C3576c cVar = C3576c.this;
                Buffer buffer = cVar.f20209a;
                if (buffer.f20194b == 0 && cVar.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return C3576c.this.f20209a.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    public void readFully(Buffer buffer, long j) {
        try {
            require(j);
            this.f20209a.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.f20209a);
            throw e;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = (long) i2;
        C3972g.m14445b((long) bArr.length, (long) i, j);
        Buffer buffer = this.f20209a;
        if (buffer.f20194b == 0 && this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f20209a.read(bArr, i, (int) Math.min(j, this.f20209a.f20194b));
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        if (!this.f20211c) {
            while (true) {
                long indexOf = this.f20209a.indexOf(byteString, j);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer = this.f20209a;
                long j2 = buffer.f20194b;
                if (this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, (j2 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public int read(ByteBuffer byteBuffer) {
        Buffer buffer = this.f20209a;
        if (buffer.f20194b == 0 && this.f20210b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f20209a.read(byteBuffer);
    }
}
