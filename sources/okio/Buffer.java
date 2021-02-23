package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.work.WorkRequest;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: c */
    private static final byte[] f20192c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: a */
    C3578d f20193a;

    /* renamed from: b */
    long f20194b;

    public static final class UnsafeCursor implements Closeable {

        /* renamed from: a */
        private C3578d f20195a;
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.f20195a = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            } else if (i <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j = buffer2.f20194b;
                    C3578d g = buffer2.mo22432g(i);
                    int i2 = 8192 - g.f20215c;
                    g.f20215c = 8192;
                    long j2 = (long) i2;
                    this.buffer.f20194b = j + j2;
                    this.f20195a = g;
                    this.offset = j;
                    this.data = g.f20213a;
                    this.start = 8192 - i2;
                    this.end = 8192;
                    return j2;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
        }

        public final int next() {
            long j = this.offset;
            if (j == this.buffer.f20194b) {
                throw new IllegalStateException();
            } else if (j == -1) {
                return seek(0);
            } else {
                return seek(j + ((long) (this.end - this.start)));
            }
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j2 = buffer2.f20194b;
                if (j <= j2) {
                    if (j >= 0) {
                        long j3 = j2 - j;
                        while (true) {
                            if (j3 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            C3578d dVar = buffer3.f20193a.f20219g;
                            int i = dVar.f20215c;
                            long j4 = (long) (i - dVar.f20214b);
                            if (j4 > j3) {
                                dVar.f20215c = (int) (((long) i) - j3);
                                break;
                            }
                            buffer3.f20193a = dVar.mo22596b();
                            C3579e.m12094a(dVar);
                            j3 -= j4;
                        }
                        this.f20195a = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j);
                    }
                } else if (j > j2) {
                    long j5 = j - j2;
                    boolean z = true;
                    while (j5 > 0) {
                        C3578d g = this.buffer.mo22432g(1);
                        int min = (int) Math.min(j5, (long) (8192 - g.f20215c));
                        int i2 = g.f20215c + min;
                        g.f20215c = i2;
                        j5 -= (long) min;
                        if (z) {
                            this.f20195a = g;
                            this.offset = j2;
                            this.data = g.f20213a;
                            this.start = i2 - min;
                            this.end = i2;
                            z = false;
                        }
                    }
                }
                this.buffer.f20194b = j;
                return j2;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j) {
            if (j >= -1) {
                Buffer buffer2 = this.buffer;
                long j2 = buffer2.f20194b;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f20195a = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j3 = 0;
                    C3578d dVar = buffer2.f20193a;
                    C3578d dVar2 = this.f20195a;
                    if (dVar2 != null) {
                        long j4 = this.offset - ((long) (this.start - dVar2.f20214b));
                        if (j4 > j) {
                            j2 = j4;
                            C3578d dVar3 = dVar2;
                            dVar2 = dVar;
                            dVar = dVar3;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        dVar2 = dVar;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = dVar2.f20215c;
                            int i2 = dVar2.f20214b;
                            if (j < ((long) (i - i2)) + j3) {
                                break;
                            }
                            j3 += (long) (i - i2);
                            dVar2 = dVar2.f20218f;
                        }
                    } else {
                        while (j2 > j) {
                            dVar = dVar.f20219g;
                            j2 -= (long) (dVar.f20215c - dVar.f20214b);
                        }
                        dVar2 = dVar;
                        j3 = j2;
                    }
                    if (this.readWrite && dVar2.f20216d) {
                        C3578d f = dVar2.mo22600f();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.f20193a == dVar2) {
                            buffer3.f20193a = f;
                        }
                        dVar2.mo22597c(f);
                        f.f20219g.mo22596b();
                        dVar2 = f;
                    }
                    this.f20195a = dVar2;
                    this.offset = j;
                    this.data = dVar2.f20213a;
                    int i3 = dVar2.f20214b + ((int) (j - j3));
                    this.start = i3;
                    int i4 = dVar2.f20215c;
                    this.end = i4;
                    return i4 - i3;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.buffer.f20194b)}));
        }
    }

    /* renamed from: okio.Buffer$a */
    class C3572a extends OutputStream {
        C3572a() {
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        public void write(int i) {
            Buffer.this.writeByte((int) (byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    /* renamed from: okio.Buffer$b */
    class C3573b extends InputStream {
        C3573b() {
        }

        public int available() {
            return (int) Math.min(Buffer.this.f20194b, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.f20194b > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }
    }

    /* renamed from: a */
    private ByteString m12071a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            C3578d dVar = this.f20193a;
            if (dVar != null) {
                byte[] bArr = dVar.f20213a;
                int i = dVar.f20214b;
                instance.update(bArr, i, dVar.f20215c - i);
                C3578d dVar2 = this.f20193a;
                while (true) {
                    dVar2 = dVar2.f20218f;
                    if (dVar2 == this.f20193a) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f20213a;
                    int i2 = dVar2.f20214b;
                    instance.update(bArr2, i2, dVar2.f20215c - i2);
                }
            }
            return ByteString.m12083of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private ByteString m12072b(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            C3578d dVar = this.f20193a;
            if (dVar != null) {
                byte[] bArr = dVar.f20213a;
                int i = dVar.f20214b;
                instance.update(bArr, i, dVar.f20215c - i);
                C3578d dVar2 = this.f20193a;
                while (true) {
                    dVar2 = dVar2.f20218f;
                    if (dVar2 == this.f20193a) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f20213a;
                    int i2 = dVar2.f20214b;
                    instance.update(bArr2, i2, dVar2.f20215c - i2);
                }
            }
            return ByteString.m12083of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: c */
    private boolean m12073c(C3578d dVar, int i, ByteString byteString, int i2, int i3) {
        int i4 = dVar.f20215c;
        byte[] bArr = dVar.f20213a;
        while (i2 < i3) {
            if (i == i4) {
                dVar = dVar.f20218f;
                byte[] bArr2 = dVar.f20213a;
                int i5 = dVar.f20214b;
                bArr = bArr2;
                i = i5;
                i4 = dVar.f20215c;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* renamed from: d */
    private void m12074d(InputStream inputStream, long j, boolean z) {
        if (inputStream != null) {
            while (true) {
                if (j > 0 || z) {
                    C3578d g = mo22432g(1);
                    int read = inputStream.read(g.f20213a, g.f20215c, (int) Math.min(j, (long) (8192 - g.f20215c)));
                    if (read != -1) {
                        g.f20215c += read;
                        long j2 = (long) read;
                        this.f20194b += j2;
                        j -= j2;
                    } else if (!z) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.f20194b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.f20194b;
        if (j == 0) {
            return 0;
        }
        C3578d dVar = this.f20193a.f20219g;
        int i = dVar.f20215c;
        return (i >= 8192 || !dVar.f20217e) ? j : j - ((long) (i - dVar.f20214b));
    }

    public final Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0, this.f20194b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo22426e(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1);
        return readUtf82;
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.f20194b;
        if (j != buffer.f20194b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        C3578d dVar = this.f20193a;
        C3578d dVar2 = buffer.f20193a;
        int i = dVar.f20214b;
        int i2 = dVar2.f20214b;
        while (j2 < this.f20194b) {
            long min = (long) Math.min(dVar.f20215c - i, dVar2.f20215c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (dVar.f20213a[i] != dVar2.f20213a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == dVar.f20215c) {
                dVar = dVar.f20218f;
                i = dVar.f20214b;
            }
            if (i2 == dVar2.f20215c) {
                dVar2 = dVar2.f20218f;
                i2 = dVar2.f20214b;
            }
            j2 += min;
        }
        return true;
    }

    public boolean exhausted() {
        return this.f20194b == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo22431f(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        C3578d dVar;
        int i4;
        Options options2 = options;
        C3578d dVar2 = this.f20193a;
        int i5 = -2;
        if (dVar2 != null) {
            byte[] bArr = dVar2.f20213a;
            int i6 = dVar2.f20214b;
            int i7 = dVar2.f20215c;
            int[] iArr = options2.f21375b;
            C3578d dVar3 = dVar2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (dVar3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != iArr[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            C3578d dVar4 = dVar3.f20218f;
                            i4 = dVar4.f20214b;
                            byte[] bArr2 = dVar4.f20213a;
                            i3 = dVar4.f20215c;
                            if (dVar4 != dVar2) {
                                byte[] bArr3 = bArr2;
                                dVar = dVar4;
                                bArr = bArr3;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                dVar = null;
                            }
                        } else {
                            C3578d dVar5 = dVar3;
                            i3 = i7;
                            i4 = i15;
                            dVar = dVar5;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            dVar3 = dVar;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        dVar3 = dVar;
                    }
                } else {
                    int i17 = i6 + 1;
                    byte b = bArr[i6] & 255;
                    int i18 = i12 + i11;
                    while (i12 != i18) {
                        if (b == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                dVar3 = dVar3.f20218f;
                                i2 = dVar3.f20214b;
                                bArr = dVar3.f20213a;
                                i7 = dVar3.f20215c;
                                if (dVar3 == dVar2) {
                                    dVar3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            return z ? i5 : i9;
        } else if (z) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public void flush() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C3578d mo22432g(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        C3578d dVar = this.f20193a;
        if (dVar == null) {
            C3578d b = C3579e.m12095b();
            this.f20193a = b;
            b.f20219g = b;
            b.f20218f = b;
            return b;
        }
        C3578d dVar2 = dVar.f20219g;
        if (dVar2.f20215c + i <= 8192 && dVar2.f20217e) {
            return dVar2;
        }
        C3578d b2 = C3579e.m12095b();
        dVar2.mo22597c(b2);
        return b2;
    }

    public final byte getByte(long j) {
        int i;
        C3972g.m14445b(this.f20194b, j, 1);
        long j2 = this.f20194b;
        if (j2 - j > j) {
            C3578d dVar = this.f20193a;
            while (true) {
                int i2 = dVar.f20215c;
                int i3 = dVar.f20214b;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return dVar.f20213a[i3 + ((int) j)];
                }
                j -= j3;
                dVar = dVar.f20218f;
            }
        } else {
            long j4 = j - j2;
            C3578d dVar2 = this.f20193a;
            do {
                dVar2 = dVar2.f20219g;
                int i4 = dVar2.f20215c;
                i = dVar2.f20214b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return dVar2.f20213a[i + ((int) j4)];
        }
    }

    public int hashCode() {
        C3578d dVar = this.f20193a;
        if (dVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = dVar.f20215c;
            for (int i3 = dVar.f20214b; i3 < i2; i3++) {
                i = (i * 31) + dVar.f20213a[i3];
            }
            dVar = dVar.f20218f;
        } while (dVar != this.f20193a);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return m12072b("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return m12072b("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return m12072b("HmacSHA512", byteString);
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new C3573b();
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return m12071a("MD5");
    }

    public OutputStream outputStream() {
        return new C3572a();
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) {
        long j = this.f20194b;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public byte readByte() {
        long j = this.f20194b;
        if (j != 0) {
            C3578d dVar = this.f20193a;
            int i = dVar.f20214b;
            int i2 = dVar.f20215c;
            int i3 = i + 1;
            byte b = dVar.f20213a[i];
            this.f20194b = j - 1;
            if (i3 == i2) {
                this.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            } else {
                dVar.f20214b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.f20194b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        if (r8 == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return -r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f20194b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c6
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0014:
            okio.d r10 = r0.f20193a
            byte[] r11 = r10.f20213a
            int r12 = r10.f20214b
            int r13 = r10.f20215c
        L_0x001c:
            if (r12 >= r13) goto L_0x009f
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006c
            r14 = 57
            if (r15 > r14) goto L_0x006c
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0038
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0076
        L_0x003f:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r3)
            okio.Buffer r1 = r1.writeByte((int) r15)
            if (r8 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r1 = 45
            if (r15 != r1) goto L_0x0080
            if (r7 != 0) goto L_0x0080
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L_0x001c
        L_0x0080:
            if (r7 == 0) goto L_0x0084
            r9 = 1
            goto L_0x009f
        L_0x0084:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009f:
            if (r12 != r13) goto L_0x00ab
            okio.d r1 = r10.mo22596b()
            r0.f20193a = r1
            okio.C3579e.m12094a(r10)
            goto L_0x00ad
        L_0x00ab:
            r10.f20214b = r12
        L_0x00ad:
            if (r9 != 0) goto L_0x00bb
            okio.d r1 = r0.f20193a
            if (r1 != 0) goto L_0x00b4
            goto L_0x00bb
        L_0x00b4:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L_0x0014
        L_0x00bb:
            long r1 = r0.f20194b
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.f20194b = r1
            if (r8 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            long r3 = -r3
        L_0x00c5:
            return r3
        L_0x00c6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00cf
        L_0x00ce:
            throw r1
        L_0x00cf:
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) {
        m12074d(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(Buffer buffer, long j) {
        long j2 = this.f20194b;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.f20193a = r6.mo22596b();
        okio.C3579e.m12094a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f20214b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.f20194b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.d r6 = r15.f20193a
            byte[] r7 = r6.f20213a
            int r8 = r6.f20214b
            int r9 = r6.f20215c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            okio.d r7 = r6.mo22596b()
            r15.f20193a = r7
            okio.C3579e.m12094a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f20214b = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            okio.d r6 = r15.f20193a
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r15.f20194b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f20194b = r1
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j = this.f20194b;
        if (j >= 4) {
            C3578d dVar = this.f20193a;
            int i = dVar.f20214b;
            int i2 = dVar.f20215c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = dVar.f20213a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f20194b = j - 4;
            if (i6 == i2) {
                this.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            } else {
                dVar.f20214b = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.f20194b);
    }

    public int readIntLe() {
        return C3972g.m14446c(readInt());
    }

    public long readLong() {
        long j = this.f20194b;
        if (j >= 8) {
            C3578d dVar = this.f20193a;
            int i = dVar.f20214b;
            int i2 = dVar.f20215c;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = dVar.f20213a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (((long) bArr[i3]) & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            this.f20194b = j - 8;
            if (i10 == i2) {
                this.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            } else {
                dVar.f20214b = i10;
            }
            return j3;
        }
        throw new IllegalStateException("size < 8: " + this.f20194b);
    }

    public long readLongLe() {
        return C3972g.m14447d(readLong());
    }

    public short readShort() {
        long j = this.f20194b;
        if (j >= 2) {
            C3578d dVar = this.f20193a;
            int i = dVar.f20214b;
            int i2 = dVar.f20215c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = dVar.f20213a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f20194b = j - 2;
            if (i4 == i2) {
                this.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            } else {
                dVar.f20214b = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.f20194b);
    }

    public short readShortLe() {
        return C3972g.m14448e(readShort());
    }

    public String readString(Charset charset) {
        try {
            return readString(this.f20194b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public String readUtf8() {
        try {
            return readString(this.f20194b, C3972g.f21394a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int readUtf8CodePoint() {
        byte b;
        int i;
        byte b2;
        if (this.f20194b != 0) {
            byte b3 = getByte(0);
            int i2 = 1;
            if ((b3 & 128) == 0) {
                b2 = b3 & Byte.MAX_VALUE;
                i = 1;
                b = 0;
            } else if ((b3 & 224) == 192) {
                b2 = b3 & 31;
                i = 2;
                b = 128;
            } else if ((b3 & 240) == 224) {
                b2 = b3 & 15;
                i = 3;
                b = 2048;
            } else if ((b3 & 248) == 240) {
                b2 = b3 & 7;
                i = 4;
                b = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j = (long) i;
            if (this.f20194b >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b4 = getByte(j2);
                    if ((b4 & 192) == 128) {
                        b2 = (b2 << 6) | (b4 & 63);
                        i2++;
                    } else {
                        skip(j2);
                        return 65533;
                    }
                }
                skip(j);
                if (b2 > 1114111) {
                    return 65533;
                }
                if ((b2 < 55296 || b2 > 57343) && b2 >= b) {
                    return b2;
                }
                return 65533;
            }
            throw new EOFException("size < " + i + ": " + this.f20194b + " (to read code point prefixed 0x" + Integer.toHexString(b3) + ")");
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return mo22426e(indexOf);
        }
        long j = this.f20194b;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j) {
        return this.f20194b >= j;
    }

    public void require(long j) {
        if (this.f20194b < j) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        int f = mo22431f(options, false);
        if (f == -1) {
            return -1;
        }
        try {
            skip((long) options.f21374a[f].size());
            return f;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString sha1() {
        return m12071a("SHA-1");
    }

    public final ByteString sha256() {
        return m12071a("SHA-256");
    }

    public final ByteString sha512() {
        return m12071a("SHA-512");
    }

    public final long size() {
        return this.f20194b;
    }

    public void skip(long j) {
        while (j > 0) {
            C3578d dVar = this.f20193a;
            if (dVar != null) {
                int min = (int) Math.min(j, (long) (dVar.f20215c - dVar.f20214b));
                long j2 = (long) min;
                this.f20194b -= j2;
                j -= j2;
                C3578d dVar2 = this.f20193a;
                int i = dVar2.f20214b + min;
                dVar2.f20214b = i;
                if (i == dVar2.f20215c) {
                    this.f20193a = dVar2.mo22596b();
                    C3579e.m12094a(dVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.f20194b;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f20194b);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.f20194b);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f20194b == 0) {
            return buffer;
        }
        C3578d d = this.f20193a.mo22598d();
        buffer.f20193a = d;
        d.f20219g = d;
        d.f20218f = d;
        C3578d dVar = this.f20193a;
        while (true) {
            dVar = dVar.f20218f;
            if (dVar != this.f20193a) {
                buffer.f20193a.f20219g.mo22597c(dVar.mo22598d());
            } else {
                buffer.f20194b = this.f20194b;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) {
        if (outputStream != null) {
            C3972g.m14445b(this.f20194b, j, j2);
            if (j2 == 0) {
                return this;
            }
            C3578d dVar = this.f20193a;
            while (true) {
                int i = dVar.f20215c;
                int i2 = dVar.f20214b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                dVar = dVar.f20218f;
            }
            while (j2 > 0) {
                int i3 = (int) (((long) dVar.f20214b) + j);
                int min = (int) Math.min((long) (dVar.f20215c - i3), j2);
                outputStream.write(dVar.f20213a, i3, min);
                j2 -= (long) min;
                dVar = dVar.f20218f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            C3578d dVar = this.f20193a;
            if (dVar == null) {
                return -1;
            }
            long j3 = this.f20194b;
            if (j3 - j < j) {
                while (j3 > j) {
                    dVar = dVar.f20219g;
                    j3 -= (long) (dVar.f20215c - dVar.f20214b);
                }
            } else {
                while (true) {
                    long j4 = ((long) (dVar.f20215c - dVar.f20214b)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    dVar = dVar.f20218f;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.size() == 2) {
                byte b = byteString.getByte(0);
                byte b2 = byteString.getByte(1);
                while (j3 < this.f20194b) {
                    byte[] bArr = dVar.f20213a;
                    i = (int) ((((long) dVar.f20214b) + j) - j3);
                    int i3 = dVar.f20215c;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (b3 == b || b3 == b2) {
                            i2 = dVar.f20214b;
                        } else {
                            i++;
                        }
                    }
                    j3 += (long) (dVar.f20215c - dVar.f20214b);
                    dVar = dVar.f20218f;
                    j = j3;
                }
                return -1;
            }
            byte[] e = byteString.mo22537e();
            while (j3 < this.f20194b) {
                byte[] bArr2 = dVar.f20213a;
                int i4 = (int) ((((long) dVar.f20214b) + j) - j3);
                int i5 = dVar.f20215c;
                while (i < i5) {
                    byte b4 = bArr2[i];
                    int length = e.length;
                    int i6 = 0;
                    while (i6 < length) {
                        if (b4 == e[i6]) {
                            i2 = dVar.f20214b;
                        } else {
                            i6++;
                        }
                    }
                    i4 = i + 1;
                }
                j3 += (long) (dVar.f20215c - dVar.f20214b);
                dVar = dVar.f20218f;
                j = j3;
            }
            return -1;
            return ((long) (i - i2)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f20194b - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr, int i, int i2) {
        C3972g.m14445b((long) bArr.length, (long) i, (long) i2);
        C3578d dVar = this.f20193a;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(i2, dVar.f20215c - dVar.f20214b);
        System.arraycopy(dVar.f20213a, dVar.f20214b, bArr, i, min);
        int i3 = dVar.f20214b + min;
        dVar.f20214b = i3;
        this.f20194b -= (long) min;
        if (i3 == dVar.f20215c) {
            this.f20193a = dVar.mo22596b();
            C3579e.m12094a(dVar);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    public final Buffer readFrom(InputStream inputStream, long j) {
        if (j >= 0) {
            m12074d(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8LineStrict(long j) {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return mo22426e(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return mo22426e(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public Buffer writeByte(int i) {
        C3578d g = mo22432g(1);
        byte[] bArr = g.f20213a;
        int i2 = g.f20215c;
        g.f20215c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f20194b++;
        return this;
    }

    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        C3578d g = mo22432g(i);
        byte[] bArr = g.f20213a;
        int i2 = g.f20215c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f20192c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        g.f20215c += i;
        this.f20194b += (long) i;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C3578d g = mo22432g(numberOfTrailingZeros);
        byte[] bArr = g.f20213a;
        int i = g.f20215c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f20192c[(int) (15 & j)];
            j >>>= 4;
        }
        g.f20215c += numberOfTrailingZeros;
        this.f20194b += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i) {
        C3578d g = mo22432g(4);
        byte[] bArr = g.f20213a;
        int i2 = g.f20215c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        g.f20215c = i5 + 1;
        this.f20194b += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(C3972g.m14446c(i));
    }

    public Buffer writeLong(long j) {
        C3578d g = mo22432g(8);
        byte[] bArr = g.f20213a;
        int i = g.f20215c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        g.f20215c = i8 + 1;
        this.f20194b += 8;
        return this;
    }

    public Buffer writeLongLe(long j) {
        return writeLong(C3972g.m14447d(j));
    }

    public Buffer writeShort(int i) {
        C3578d g = mo22432g(2);
        byte[] bArr = g.f20213a;
        int i2 = g.f20215c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        g.f20215c = i3 + 1;
        this.f20194b += 2;
        return this;
    }

    public Buffer writeShortLe(int i) {
        return writeShort((int) C3972g.m14448e((short) i));
    }

    public final Buffer writeTo(OutputStream outputStream, long j) {
        if (outputStream != null) {
            C3972g.m14445b(this.f20194b, 0, j);
            C3578d dVar = this.f20193a;
            while (j > 0) {
                int min = (int) Math.min(j, (long) (dVar.f20215c - dVar.f20214b));
                outputStream.write(dVar.f20213a, dVar.f20214b, min);
                int i = dVar.f20214b + min;
                dVar.f20214b = i;
                long j2 = (long) min;
                this.f20194b -= j2;
                j -= j2;
                if (i == dVar.f20215c) {
                    C3578d b = dVar.mo22596b();
                    this.f20193a = b;
                    C3579e.m12094a(dVar);
                    dVar = b;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public long indexOf(byte b, long j, long j2) {
        C3578d dVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f20194b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f20194b;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (dVar = this.f20193a) == null) {
            return -1;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                dVar = dVar.f20219g;
                j4 -= (long) (dVar.f20215c - dVar.f20214b);
            }
        } else {
            while (true) {
                long j6 = ((long) (dVar.f20215c - dVar.f20214b)) + j3;
                if (j6 >= j) {
                    break;
                }
                dVar = dVar.f20218f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = dVar.f20213a;
            int min = (int) Math.min((long) dVar.f20215c, (((long) dVar.f20214b) + j5) - j4);
            for (int i = (int) ((((long) dVar.f20214b) + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - dVar.f20214b)) + j4;
                }
            }
            byte b2 = b;
            j4 += (long) (dVar.f20215c - dVar.f20214b);
            dVar = dVar.f20218f;
            j7 = j4;
        }
        return -1;
    }

    public byte[] readByteArray(long j) {
        C3972g.m14445b(this.f20194b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public String readString(long j, Charset charset) {
        C3972g.m14445b(this.f20194b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C3578d dVar = this.f20193a;
            if (((long) dVar.f20214b) + j > ((long) dVar.f20215c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(dVar.f20213a, dVar.f20214b, (int) j, charset);
            int i = (int) (((long) dVar.f20214b) + j);
            dVar.f20214b = i;
            this.f20194b -= j;
            if (i == dVar.f20215c) {
                this.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            }
            return str;
        }
    }

    public String readUtf8(long j) {
        return readString(j, C3972g.f21394a);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new C3971f(this, i);
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.mo22541f(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C3972g.f21394a)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeUtf8(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    C3578d g = mo22432g(1);
                    byte[] bArr = g.f20213a;
                    int i3 = g.f20215c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = g.f20215c;
                    int i6 = (i3 + i4) - i5;
                    g.f20215c = i5 + i6;
                    this.f20194b += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C3972g.m14445b((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C3578d g = mo22432g(1);
                int min = Math.min(i3 - i, 8192 - g.f20215c);
                System.arraycopy(bArr, i, g.f20213a, g.f20215c, min);
                i += min;
                g.f20215c += min;
            }
            this.f20194b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            C3972g.m14445b(this.f20194b, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.f20194b += j2;
            C3578d dVar = this.f20193a;
            while (true) {
                int i = dVar.f20215c;
                int i2 = dVar.f20214b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                dVar = dVar.f20218f;
            }
            while (j2 > 0) {
                C3578d d = dVar.mo22598d();
                int i3 = (int) (((long) d.f20214b) + j);
                d.f20214b = i3;
                d.f20215c = Math.min(i3 + ((int) j2), d.f20215c);
                C3578d dVar2 = buffer.f20193a;
                if (dVar2 == null) {
                    d.f20219g = d;
                    d.f20218f = d;
                    buffer.f20193a = d;
                } else {
                    dVar2.f20219g.mo22597c(d);
                }
                j2 -= (long) (d.f20215c - d.f20214b);
                dVar = dVar.f20218f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int read(ByteBuffer byteBuffer) {
        C3578d dVar = this.f20193a;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), dVar.f20215c - dVar.f20214b);
        byteBuffer.put(dVar.f20213a, dVar.f20214b, min);
        int i = dVar.f20214b + min;
        dVar.f20214b = i;
        this.f20194b -= (long) min;
        if (i == dVar.f20215c) {
            this.f20193a = dVar.mo22596b();
            C3579e.m12094a(dVar);
        }
        return min;
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C3578d g = mo22432g(1);
                int min = Math.min(i, 8192 - g.f20215c);
                byteBuffer.get(g.f20213a, g.f20215c, min);
                i -= min;
                g.f20215c += min;
            }
            this.f20194b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                C3578d dVar = this.f20193a;
                long j3 = -1;
                if (dVar == null) {
                    return -1;
                }
                long j4 = this.f20194b;
                if (j4 - j < j) {
                    while (j4 > j) {
                        dVar = dVar.f20219g;
                        j4 -= (long) (dVar.f20215c - dVar.f20214b);
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (dVar.f20215c - dVar.f20214b)) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        dVar = dVar.f20218f;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b = byteString.getByte(0);
                int size = byteString.size();
                long j6 = 1 + (this.f20194b - ((long) size));
                long j7 = j;
                C3578d dVar2 = dVar;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = dVar2.f20213a;
                    int min = (int) Math.min((long) dVar2.f20215c, (((long) dVar2.f20214b) + j6) - j8);
                    int i = (int) ((((long) dVar2.f20214b) + j7) - j8);
                    while (i < min) {
                        if (bArr2[i] == b) {
                            bArr = bArr2;
                            if (m12073c(dVar2, i + 1, byteString, 1, size)) {
                                return ((long) (i - dVar2.f20214b)) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i++;
                        bArr2 = bArr;
                    }
                    j8 += (long) (dVar2.f20215c - dVar2.f20214b);
                    dVar2 = dVar2.f20218f;
                    j7 = j8;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f20194b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j) {
        int i;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            C3972g.m14445b(buffer.f20194b, 0, j);
            while (j > 0) {
                C3578d dVar = buffer.f20193a;
                if (j < ((long) (dVar.f20215c - dVar.f20214b))) {
                    C3578d dVar2 = this.f20193a;
                    C3578d dVar3 = dVar2 != null ? dVar2.f20219g : null;
                    if (dVar3 != null && dVar3.f20217e) {
                        long j2 = ((long) dVar3.f20215c) + j;
                        if (dVar3.f20216d) {
                            i = 0;
                        } else {
                            i = dVar3.f20214b;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            dVar.mo22601g(dVar3, (int) j);
                            buffer.f20194b -= j;
                            this.f20194b += j;
                            return;
                        }
                    }
                    buffer.f20193a = dVar.mo22599e((int) j);
                }
                C3578d dVar4 = buffer.f20193a;
                long j3 = (long) (dVar4.f20215c - dVar4.f20214b);
                buffer.f20193a = dVar4.mo22596b();
                C3578d dVar5 = this.f20193a;
                if (dVar5 == null) {
                    this.f20193a = dVar4;
                    dVar4.f20219g = dVar4;
                    dVar4.f20218f = dVar4;
                } else {
                    dVar5.f20219g.mo22597c(dVar4);
                    dVar4.mo22595a();
                }
                buffer.f20194b -= j3;
                this.f20194b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
