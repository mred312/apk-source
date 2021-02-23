package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = m12083of(new byte[0]);

    /* renamed from: d */
    static final char[] f20198d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    final byte[] f20199a;

    /* renamed from: b */
    transient int f20200b;

    /* renamed from: c */
    transient String f20201c;

    ByteString(byte[] bArr) {
        this.f20199a = bArr;
    }

    /* renamed from: a */
    static int m12078a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    /* renamed from: b */
    private static int m12079b(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: c */
    private ByteString m12080c(String str) {
        try {
            return m12083of(MessageDigest.getInstance(str).digest(this.f20199a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    private ByteString m12081d(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return m12083of(instance.doFinal(this.f20199a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] a = C3968a.m14436a(str);
            if (a != null) {
                return new ByteString(a);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m12079b(str.charAt(i2)) << 4) + m12079b(str.charAt(i2 + 1)));
            }
            return m12083of(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(C3972g.f21394a));
            byteString.f20201c = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: of */
    public static ByteString m12083of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString read(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new ByteString(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, read.f20199a);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f20199a.length);
        objectOutputStream.write(this.f20199a);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.f20199a).asReadOnlyBuffer();
    }

    public String base64() {
        return C3968a.m14437b(this.f20199a);
    }

    public String base64Url() {
        return C3968a.m14439d(this.f20199a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte[] mo22537e() {
        return this.f20199a;
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.f20199a;
            if (size != bArr.length || !byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo22541f(Buffer buffer) {
        byte[] bArr = this.f20199a;
        buffer.write(bArr, 0, bArr.length);
    }

    public byte getByte(int i) {
        return this.f20199a[i];
    }

    public int hashCode() {
        int i = this.f20200b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f20199a);
        this.f20200b = hashCode;
        return hashCode;
    }

    public String hex() {
        byte[] bArr = this.f20199a;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f20198d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return m12081d("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return m12081d("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return m12081d("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.mo22537e(), 0);
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.mo22537e(), size());
    }

    public ByteString md5() {
        return m12080c("MD5");
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.f20199a, i, i3);
    }

    public ByteString sha1() {
        return m12080c("SHA-1");
    }

    public ByteString sha256() {
        return m12080c("SHA-256");
    }

    public ByteString sha512() {
        return m12080c("SHA-512");
    }

    public int size() {
        return this.f20199a.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.f20199a, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i) {
        return substring(i, this.f20199a.length);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20199a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20199a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 97 || b > 122) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        bArr2[i2] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.f20199a.clone();
    }

    public String toString() {
        if (this.f20199a.length == 0) {
            return "[size=0]";
        }
        String utf8 = utf8();
        int a = m12078a(utf8, 64);
        if (a != -1) {
            String replace = utf8.substring(0, a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a < utf8.length()) {
                return "[size=" + this.f20199a.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.f20199a.length <= 64) {
            return "[hex=" + hex() + "]";
        } else {
            return "[size=" + this.f20199a.length + " hex=" + substring(0, 64).hex() + "…]";
        }
    }

    public String utf8() {
        String str = this.f20201c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f20199a, C3972g.f21394a);
        this.f20201c = str2;
        return str2;
    }

    public void write(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.write(this.f20199a);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            byte b = getByte(i) & 255;
            byte b2 = byteString.getByte(i) & 255;
            if (b == b2) {
                i++;
            } else if (b < b2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i) {
        return indexOf(byteString.mo22537e(), i);
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        return lastIndexOf(byteString.mo22537e(), i);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f20199a;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C3972g.m14444a(bArr2, i, bArr, i2, i3);
        }
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public ByteString substring(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f20199a;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    return new ByteString(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f20199a.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: of */
    public static ByteString m12084of(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            C3972g.m14445b((long) bArr.length, (long) i, (long) i2);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.f20199a.length - bArr.length;
        for (int max = Math.max(i, 0); max <= length; max++) {
            if (C3972g.m14444a(this.f20199a, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (int min = Math.min(i, this.f20199a.length - bArr.length); min >= 0; min--) {
            if (C3972g.m14444a(this.f20199a, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    /* renamed from: of */
    public static ByteString m12082of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }
}
