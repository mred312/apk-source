package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: okio.f */
/* compiled from: SegmentedByteString */
final class C3971f extends ByteString {

    /* renamed from: e */
    final transient byte[][] f21392e;

    /* renamed from: f */
    final transient int[] f21393f;

    C3971f(Buffer buffer, int i) {
        super((byte[]) null);
        C3972g.m14445b(buffer.f20194b, 0, (long) i);
        C3578d dVar = buffer.f20193a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = dVar.f20215c;
            int i6 = dVar.f20214b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                dVar = dVar.f20218f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f21392e = new byte[i4][];
        this.f21393f = new int[(i4 * 2)];
        C3578d dVar2 = buffer.f20193a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f21392e;
            bArr[i7] = dVar2.f20213a;
            int i8 = dVar2.f20215c;
            int i9 = dVar2.f20214b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f21393f;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            dVar2.f20216d = true;
            i7++;
            dVar2 = dVar2.f20218f;
        }
    }

    /* renamed from: g */
    private int m14440g(int i) {
        int binarySearch = Arrays.binarySearch(this.f21393f, 0, this.f21392e.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    /* renamed from: h */
    private ByteString m14441h() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return m14441h();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return m14441h().base64();
    }

    public String base64Url() {
        return m14441h().base64Url();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte[] mo22537e() {
        return toByteArray();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() != size() || !rangeEquals(0, byteString, 0, size())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo22541f(Buffer buffer) {
        int length = this.f21392e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f21393f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C3578d dVar = new C3578d(this.f21392e[i], i3, (i3 + i4) - i2, true, false);
            C3578d dVar2 = buffer.f20193a;
            if (dVar2 == null) {
                dVar.f20219g = dVar;
                dVar.f20218f = dVar;
                buffer.f20193a = dVar;
            } else {
                dVar2.f20219g.mo22597c(dVar);
            }
            i++;
            i2 = i4;
        }
        buffer.f20194b += (long) i2;
    }

    public byte getByte(int i) {
        int i2;
        C3972g.m14445b((long) this.f21393f[this.f21392e.length - 1], (long) i, 1);
        int g = m14440g(i);
        if (g == 0) {
            i2 = 0;
        } else {
            i2 = this.f21393f[g - 1];
        }
        int[] iArr = this.f21393f;
        byte[][] bArr = this.f21392e;
        return bArr[g][(i - i2) + iArr[bArr.length + g]];
    }

    public int hashCode() {
        int i = this.f20200b;
        if (i != 0) {
            return i;
        }
        int length = this.f21392e.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f21392e[i2];
            int[] iArr = this.f21393f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f20200b = i4;
        return i4;
    }

    public String hex() {
        return m14441h().hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return m14441h().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return m14441h().hmacSha256(byteString);
    }

    public int indexOf(byte[] bArr, int i) {
        return m14441h().indexOf(bArr, i);
    }

    public int lastIndexOf(byte[] bArr, int i) {
        return m14441h().lastIndexOf(bArr, i);
    }

    public ByteString md5() {
        return m14441h().md5();
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int g = m14440g(i);
        while (i3 > 0) {
            if (g == 0) {
                i4 = 0;
            } else {
                i4 = this.f21393f[g - 1];
            }
            int min = Math.min(i3, ((this.f21393f[g] - i4) + i4) - i);
            int[] iArr = this.f21393f;
            byte[][] bArr = this.f21392e;
            if (!byteString.rangeEquals(i2, bArr[g], (i - i4) + iArr[bArr.length + g], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            g++;
        }
        return true;
    }

    public ByteString sha1() {
        return m14441h().sha1();
    }

    public ByteString sha256() {
        return m14441h().sha256();
    }

    public int size() {
        return this.f21393f[this.f21392e.length - 1];
    }

    public String string(Charset charset) {
        return m14441h().string(charset);
    }

    public ByteString substring(int i) {
        return m14441h().substring(i);
    }

    public ByteString toAsciiLowercase() {
        return m14441h().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return m14441h().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.f21393f;
        byte[][] bArr = this.f21392e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f21393f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f21392e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public String toString() {
        return m14441h().toString();
    }

    public String utf8() {
        return m14441h().utf8();
    }

    public void write(OutputStream outputStream) {
        if (outputStream != null) {
            int length = this.f21392e.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.f21393f;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.f21392e[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public ByteString substring(int i, int i2) {
        return m14441h().substring(i, i2);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int g = m14440g(i);
        while (i3 > 0) {
            if (g == 0) {
                i4 = 0;
            } else {
                i4 = this.f21393f[g - 1];
            }
            int min = Math.min(i3, ((this.f21393f[g] - i4) + i4) - i);
            int[] iArr = this.f21393f;
            byte[][] bArr2 = this.f21392e;
            if (!C3972g.m14444a(bArr2[g], (i - i4) + iArr[bArr2.length + g], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            g++;
        }
        return true;
    }
}
