package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new C3608i(Internal.EMPTY_BYTE_ARRAY);

    /* renamed from: b */
    private static final C3605f f20358b = (C3687b.m13156c() ? new C3609j((C3600a) null) : new C3603d((C3600a) null));

    /* renamed from: c */
    private static final Comparator<ByteString> f20359c = new C3601b();

    /* renamed from: a */
    private int f20360a = 0;

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* renamed from: com.google.protobuf.ByteString$a */
    class C3600a extends C3602c {

        /* renamed from: a */
        private int f20367a = 0;

        /* renamed from: b */
        private final int f20368b;

        C3600a() {
            this.f20368b = ByteString.this.size();
        }

        public boolean hasNext() {
            return this.f20367a < this.f20368b;
        }

        public byte nextByte() {
            int i = this.f20367a;
            if (i < this.f20368b) {
                this.f20367a = i + 1;
                return ByteString.this.mo22927e(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: com.google.protobuf.ByteString$b */
    static class C3601b implements Comparator<ByteString> {
        C3601b() {
        }

        /* renamed from: a */
        public int compare(ByteString byteString, ByteString byteString2) {
            ByteIterator it = byteString.iterator();
            ByteIterator it2 = byteString2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compare = Integer.compare(ByteString.m12409h(it.nextByte()), ByteString.m12409h(it2.nextByte()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    }

    /* renamed from: com.google.protobuf.ByteString$c */
    static abstract class C3602c implements ByteIterator {
        C3602c() {
        }

        /* renamed from: a */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.protobuf.ByteString$d */
    private static final class C3603d implements C3605f {
        private C3603d() {
        }

        /* renamed from: a */
        public byte[] mo22967a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        /* synthetic */ C3603d(C3600a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.ByteString$e */
    private static final class C3604e extends C3608i {
        private static final long serialVersionUID = 1;

        /* renamed from: e */
        private final int f20370e;

        /* renamed from: f */
        private final int f20371f;

        C3604e(byte[] bArr, int i, int i2) {
            super(bArr);
            ByteString.m12406d(i, i + i2, bArr.length);
            this.f20370e = i;
            this.f20371f = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public byte byteAt(int i) {
            ByteString.m12405c(i, size());
            return this.f20374d[this.f20370e + i];
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f20374d, mo22968o() + i, bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public byte mo22927e(int i) {
            return this.f20374d[this.f20370e + i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public int mo22968o() {
            return this.f20370e;
        }

        public int size() {
            return this.f20371f;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return ByteString.m12412k(toByteArray());
        }
    }

    /* renamed from: com.google.protobuf.ByteString$f */
    private interface C3605f {
        /* renamed from: a */
        byte[] mo22967a(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.google.protobuf.ByteString$g */
    static final class C3606g {

        /* renamed from: a */
        private final CodedOutputStream f20372a;

        /* renamed from: b */
        private final byte[] f20373b;

        /* synthetic */ C3606g(int i, C3600a aVar) {
            this(i);
        }

        /* renamed from: a */
        public ByteString mo22970a() {
            this.f20372a.checkNoSpaceLeft();
            return new C3608i(this.f20373b);
        }

        /* renamed from: b */
        public CodedOutputStream mo22971b() {
            return this.f20372a;
        }

        private C3606g(int i) {
            byte[] bArr = new byte[i];
            this.f20373b = bArr;
            this.f20372a = CodedOutputStream.newInstance(bArr);
        }
    }

    /* renamed from: com.google.protobuf.ByteString$h */
    static abstract class C3607h extends ByteString {
        C3607h() {
        }

        /* access modifiers changed from: protected */
        public final int getTreeDepth() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean isBalanced() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public abstract boolean mo22972n(ByteString byteString, int i, int i2);
    }

    /* renamed from: com.google.protobuf.ByteString$i */
    private static class C3608i extends C3607h {
        private static final long serialVersionUID = 1;

        /* renamed from: d */
        protected final byte[] f20374d;

        C3608i(byte[] bArr) {
            bArr.getClass();
            this.f20374d = bArr;
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.f20374d, mo22968o(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i) {
            return this.f20374d[i];
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.f20374d, mo22968o(), size());
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f20374d, i, bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public byte mo22927e(int i) {
            return this.f20374d[i];
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof C3608i)) {
                return obj.equals(this);
            }
            C3608i iVar = (C3608i) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = iVar.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return mo22972n(iVar, 0, size());
            }
            return false;
        }

        public final boolean isValidUtf8() {
            int o = mo22968o();
            return C3759u0.m13854u(this.f20374d, o, size() + o);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public final void mo22936m(ByteOutput byteOutput) {
            byteOutput.writeLazy(this.f20374d, mo22968o(), size());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public final boolean mo22972n(ByteString byteString, int i, int i2) {
            if (i2 <= byteString.size()) {
                int i3 = i + i2;
                if (i3 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + byteString.size());
                } else if (!(byteString instanceof C3608i)) {
                    return byteString.substring(i, i3).equals(substring(0, i2));
                } else {
                    C3608i iVar = (C3608i) byteString;
                    byte[] bArr = this.f20374d;
                    byte[] bArr2 = iVar.f20374d;
                    int o = mo22968o() + i2;
                    int o2 = mo22968o();
                    int o3 = iVar.mo22968o() + i;
                    while (o2 < o) {
                        if (bArr[o2] != bArr2[o3]) {
                            return false;
                        }
                        o2++;
                        o3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
        }

        public final CodedInputStream newCodedInput() {
            return CodedInputStream.m12441c(this.f20374d, mo22968o(), size(), true);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.f20374d, mo22968o(), size());
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public int mo22968o() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final int partialHash(int i, int i2, int i3) {
            return Internal.m12794e(i, this.f20374d, mo22968o() + i2, i3);
        }

        /* access modifiers changed from: protected */
        public final int partialIsValidUtf8(int i, int i2, int i3) {
            int o = mo22968o() + i2;
            return C3759u0.m13856w(i, this.f20374d, o, i3 + o);
        }

        public int size() {
            return this.f20374d.length;
        }

        public final ByteString substring(int i, int i2) {
            int d = ByteString.m12406d(i, i2, size());
            if (d == 0) {
                return ByteString.EMPTY;
            }
            return new C3604e(this.f20374d, mo22968o() + i, d);
        }

        /* access modifiers changed from: protected */
        public final String toStringInternal(Charset charset) {
            return new String(this.f20374d, mo22968o(), size(), charset);
        }

        public final void writeTo(OutputStream outputStream) {
            outputStream.write(toByteArray());
        }
    }

    /* renamed from: com.google.protobuf.ByteString$j */
    private static final class C3609j implements C3605f {
        private C3609j() {
        }

        /* renamed from: a */
        public byte[] mo22967a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        /* synthetic */ C3609j(C3600a aVar) {
            this();
        }
    }

    ByteString() {
    }

    /* renamed from: b */
    private static ByteString m12404b(Iterator<ByteString> it, int i) {
        if (i < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            return m12404b(it, i2).concat(m12404b(it, i - i2));
        }
    }

    /* renamed from: c */
    static void m12405c(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        m12406d(i, i + i2, bArr.length);
        return new C3608i(f20358b.mo22967a(bArr, i, i2));
    }

    public static ByteString copyFromUtf8(String str) {
        return new C3608i(str.getBytes(Internal.f20591a));
    }

    /* renamed from: d */
    static int m12406d(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    /* renamed from: f */
    static C3606g m12407f(int i) {
        return new C3606g(i, (C3600a) null);
    }

    /* renamed from: g */
    private static ByteString m12408g(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static int m12409h(byte b) {
        return b & 255;
    }

    /* renamed from: i */
    private String m12410i() {
        if (size() <= 50) {
            return C3742q0.m13627a(this);
        }
        return C3742q0.m13627a(substring(0, 47)) + "...";
    }

    /* renamed from: j */
    static ByteString m12411j(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new C3698e0(byteBuffer);
        }
        return m12413l(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    /* renamed from: k */
    static ByteString m12412k(byte[] bArr) {
        return new C3608i(bArr);
    }

    /* renamed from: l */
    static ByteString m12413l(byte[] bArr, int i, int i2) {
        return new C3604e(bArr, i, i2);
    }

    public static Output newOutput(int i) {
        return new Output(i);
    }

    public static ByteString readFrom(InputStream inputStream) {
        return readFrom(inputStream, 256, 8192);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return f20359c;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return C3716l0.m13474p(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i) {
        copyTo(bArr, 0, i, size());
    }

    /* access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract byte mo22927e(int i);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getTreeDepth();

    public final int hashCode() {
        int i = this.f20360a;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f20360a = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public abstract void mo22936m(ByteOutput byteOutput);

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    /* access modifiers changed from: protected */
    public abstract int partialHash(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.f20360a;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i) {
        return substring(i, size());
    }

    public abstract ByteString substring(int i, int i2);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e);
            throw unsupportedEncodingException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.f20591a);
    }

    public abstract void writeTo(OutputStream outputStream);

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i) {
        return readFrom(inputStream, i, i);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i, int i2, int i3) {
        m12406d(i, i + i3, size());
        m12406d(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            copyToInternal(bArr, i, i2, i3);
        }
    }

    public ByteIterator iterator() {
        return new C3600a();
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString g = m12408g(inputStream, i);
            if (g == null) {
                return copyFrom((Iterable<ByteString>) arrayList);
            }
            arrayList.add(g);
            i = Math.min(i * 2, i2);
        }
    }

    public static final class Output extends OutputStream {

        /* renamed from: f */
        private static final byte[] f20361f = new byte[0];

        /* renamed from: a */
        private final int f20362a;

        /* renamed from: b */
        private final ArrayList<ByteString> f20363b;

        /* renamed from: c */
        private int f20364c;

        /* renamed from: d */
        private byte[] f20365d;

        /* renamed from: e */
        private int f20366e;

        Output(int i) {
            if (i >= 0) {
                this.f20362a = i;
                this.f20363b = new ArrayList<>();
                this.f20365d = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        /* renamed from: a */
        private byte[] m12416a(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        /* renamed from: b */
        private void m12417b(int i) {
            this.f20363b.add(new C3608i(this.f20365d));
            int length = this.f20364c + this.f20365d.length;
            this.f20364c = length;
            this.f20365d = new byte[Math.max(this.f20362a, Math.max(i, length >>> 1))];
            this.f20366e = 0;
        }

        /* renamed from: c */
        private void m12418c() {
            int i = this.f20366e;
            byte[] bArr = this.f20365d;
            if (i >= bArr.length) {
                this.f20363b.add(new C3608i(this.f20365d));
                this.f20365d = f20361f;
            } else if (i > 0) {
                this.f20363b.add(new C3608i(m12416a(bArr, i)));
            }
            this.f20364c += this.f20366e;
            this.f20366e = 0;
        }

        public synchronized void reset() {
            this.f20363b.clear();
            this.f20364c = 0;
            this.f20366e = 0;
        }

        public synchronized int size() {
            return this.f20364c + this.f20366e;
        }

        public synchronized ByteString toByteString() {
            m12418c();
            return ByteString.copyFrom((Iterable<ByteString>) this.f20363b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        public synchronized void write(int i) {
            if (this.f20366e == this.f20365d.length) {
                m12417b(1);
            }
            byte[] bArr = this.f20365d;
            int i2 = this.f20366e;
            this.f20366e = i2 + 1;
            bArr[i2] = (byte) i;
        }

        public void writeTo(OutputStream outputStream) {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.f20363b;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.f20365d;
                i = this.f20366e;
            }
            for (ByteString writeTo : byteStringArr) {
                writeTo.writeTo(outputStream);
            }
            outputStream.write(m12416a(bArr, i));
        }

        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.f20365d;
            int length = bArr2.length;
            int i3 = this.f20366e;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.f20366e += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                m12417b(i4);
                System.arraycopy(bArr, i + length2, this.f20365d, 0, i4);
                this.f20366e = i4;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i) {
        m12406d(0, i, byteBuffer.remaining());
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new C3608i(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), m12410i()});
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) {
        return new C3608i(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new C3608i(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        if (i == 0) {
            return EMPTY;
        }
        return m12404b(iterable.iterator(), i);
    }
}
