package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.google.protobuf.l0 */
/* compiled from: RopeByteString */
final class C3716l0 extends ByteString {

    /* renamed from: i */
    static final int[] f20795i = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;

    /* renamed from: d */
    private final int f20796d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ByteString f20797e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final ByteString f20798f;

    /* renamed from: g */
    private final int f20799g;

    /* renamed from: h */
    private final int f20800h;

    /* renamed from: com.google.protobuf.l0$a */
    /* compiled from: RopeByteString */
    class C3717a extends ByteString.C3602c {

        /* renamed from: a */
        final C3719c f20801a;

        /* renamed from: b */
        ByteString.ByteIterator f20802b = m13480b();

        C3717a() {
            this.f20801a = new C3719c(C3716l0.this, (C3717a) null);
        }

        /* renamed from: b */
        private ByteString.ByteIterator m13480b() {
            if (this.f20801a.hasNext()) {
                return this.f20801a.next().iterator();
            }
            return null;
        }

        public boolean hasNext() {
            return this.f20802b != null;
        }

        public byte nextByte() {
            ByteString.ByteIterator byteIterator = this.f20802b;
            if (byteIterator != null) {
                byte nextByte = byteIterator.nextByte();
                if (!this.f20802b.hasNext()) {
                    this.f20802b = m13480b();
                }
                return nextByte;
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: com.google.protobuf.l0$c */
    /* compiled from: RopeByteString */
    private static final class C3719c implements Iterator<ByteString.C3607h> {

        /* renamed from: a */
        private final ArrayDeque<C3716l0> f20805a;

        /* renamed from: b */
        private ByteString.C3607h f20806b;

        /* synthetic */ C3719c(ByteString byteString, C3717a aVar) {
            this(byteString);
        }

        /* renamed from: a */
        private ByteString.C3607h m13486a(ByteString byteString) {
            while (byteString instanceof C3716l0) {
                C3716l0 l0Var = (C3716l0) byteString;
                this.f20805a.push(l0Var);
                byteString = l0Var.f20797e;
            }
            return (ByteString.C3607h) byteString;
        }

        /* renamed from: b */
        private ByteString.C3607h m13487b() {
            ByteString.C3607h a;
            do {
                ArrayDeque<C3716l0> arrayDeque = this.f20805a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a = m13486a(this.f20805a.pop().f20798f);
            } while (a.isEmpty());
            return a;
        }

        /* renamed from: c */
        public ByteString.C3607h next() {
            ByteString.C3607h hVar = this.f20806b;
            if (hVar != null) {
                this.f20806b = m13487b();
                return hVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f20806b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private C3719c(ByteString byteString) {
            if (byteString instanceof C3716l0) {
                C3716l0 l0Var = (C3716l0) byteString;
                ArrayDeque<C3716l0> arrayDeque = new ArrayDeque<>(l0Var.getTreeDepth());
                this.f20805a = arrayDeque;
                arrayDeque.push(l0Var);
                this.f20806b = m13486a(l0Var.f20797e);
                return;
            }
            this.f20805a = null;
            this.f20806b = (ByteString.C3607h) byteString;
        }
    }

    /* synthetic */ C3716l0(ByteString byteString, ByteString byteString2, C3717a aVar) {
        this(byteString, byteString2);
    }

    /* renamed from: p */
    static ByteString m13474p(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return m13475q(byteString, byteString2);
        }
        if (byteString instanceof C3716l0) {
            C3716l0 l0Var = (C3716l0) byteString;
            if (l0Var.f20798f.size() + byteString2.size() < 128) {
                return new C3716l0(l0Var.f20797e, m13475q(l0Var.f20798f, byteString2));
            } else if (l0Var.f20797e.getTreeDepth() > l0Var.f20798f.getTreeDepth() && l0Var.getTreeDepth() > byteString2.getTreeDepth()) {
                return new C3716l0(l0Var.f20797e, new C3716l0(l0Var.f20798f, byteString2));
            }
        }
        if (size >= m13477s(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1)) {
            return new C3716l0(byteString, byteString2);
        }
        return new C3718b((C3717a) null).m13482b(byteString, byteString2);
    }

    /* renamed from: q */
    private static ByteString m13475q(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.m12412k(bArr);
    }

    /* renamed from: r */
    private boolean m13476r(ByteString byteString) {
        boolean z;
        C3719c cVar = new C3719c(this, (C3717a) null);
        ByteString.C3607h hVar = (ByteString.C3607h) cVar.next();
        C3719c cVar2 = new C3719c(byteString, (C3717a) null);
        ByteString.C3607h hVar2 = (ByteString.C3607h) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = hVar.size() - i;
            int size2 = hVar2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = hVar.mo22972n(hVar2, i2, min);
            } else {
                z = hVar2.mo22972n(hVar, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.f20796d;
            if (i3 < i4) {
                if (min == size) {
                    hVar = (ByteString.C3607h) cVar.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    hVar2 = (ByteString.C3607h) cVar2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    /* renamed from: s */
    static int m13477s(int i) {
        int[] iArr = f20795i;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        C3719c cVar = new C3719c(this, (C3717a) null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i) {
        ByteString.m12405c(i, this.f20796d);
        return mo22927e(i);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.f20797e.copyTo(byteBuffer);
        this.f20798f.copyTo(byteBuffer);
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f20799g;
        if (i4 <= i5) {
            this.f20797e.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.f20798f.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.f20797e.copyToInternal(bArr, i, i2, i6);
            this.f20798f.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte mo22927e(int i) {
        int i2 = this.f20799g;
        if (i < i2) {
            return this.f20797e.mo22927e(i);
        }
        return this.f20798f.mo22927e(i - i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f20796d != byteString.size()) {
            return false;
        }
        if (this.f20796d == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return m13476r(byteString);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int getTreeDepth() {
        return this.f20800h;
    }

    /* access modifiers changed from: protected */
    public boolean isBalanced() {
        return this.f20796d >= m13477s(this.f20800h);
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.f20797e.partialIsValidUtf8(0, 0, this.f20799g);
        ByteString byteString = this.f20798f;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo22936m(ByteOutput byteOutput) {
        this.f20797e.mo22936m(byteOutput);
        this.f20798f.mo22936m(byteOutput);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((InputStream) new C3720d());
    }

    public InputStream newInput() {
        return new C3720d();
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f20799g;
        if (i4 <= i5) {
            return this.f20797e.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f20798f.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f20798f.partialHash(this.f20797e.partialHash(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f20799g;
        if (i4 <= i5) {
            return this.f20797e.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f20798f.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f20798f.partialIsValidUtf8(this.f20797e.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    public int size() {
        return this.f20796d;
    }

    public ByteString substring(int i, int i2) {
        int d = ByteString.m12406d(i, i2, this.f20796d);
        if (d == 0) {
            return ByteString.EMPTY;
        }
        if (d == this.f20796d) {
            return this;
        }
        int i3 = this.f20799g;
        if (i2 <= i3) {
            return this.f20797e.substring(i, i2);
        }
        if (i >= i3) {
            return this.f20798f.substring(i - i3, i2 - i3);
        }
        return new C3716l0(this.f20797e.substring(i), this.f20798f.substring(0, i2 - this.f20799g));
    }

    /* access modifiers changed from: protected */
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return ByteString.m12412k(toByteArray());
    }

    public void writeTo(OutputStream outputStream) {
        this.f20797e.writeTo(outputStream);
        this.f20798f.writeTo(outputStream);
    }

    /* renamed from: com.google.protobuf.l0$b */
    /* compiled from: RopeByteString */
    private static class C3718b {

        /* renamed from: a */
        private final ArrayDeque<ByteString> f20804a;

        private C3718b() {
            this.f20804a = new ArrayDeque<>();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public ByteString m13482b(ByteString byteString, ByteString byteString2) {
            m13483c(byteString);
            m13483c(byteString2);
            ByteString pop = this.f20804a.pop();
            while (!this.f20804a.isEmpty()) {
                pop = new C3716l0(this.f20804a.pop(), pop, (C3717a) null);
            }
            return pop;
        }

        /* renamed from: c */
        private void m13483c(ByteString byteString) {
            if (byteString.isBalanced()) {
                m13485e(byteString);
            } else if (byteString instanceof C3716l0) {
                C3716l0 l0Var = (C3716l0) byteString;
                m13483c(l0Var.f20797e);
                m13483c(l0Var.f20798f);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        /* renamed from: d */
        private int m13484d(int i) {
            int binarySearch = Arrays.binarySearch(C3716l0.f20795i, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        /* renamed from: e */
        private void m13485e(ByteString byteString) {
            int d = m13484d(byteString.size());
            int s = C3716l0.m13477s(d + 1);
            if (this.f20804a.isEmpty() || this.f20804a.peek().size() >= s) {
                this.f20804a.push(byteString);
                return;
            }
            int s2 = C3716l0.m13477s(d);
            ByteString pop = this.f20804a.pop();
            while (!this.f20804a.isEmpty() && this.f20804a.peek().size() < s2) {
                pop = new C3716l0(this.f20804a.pop(), pop, (C3717a) null);
            }
            C3716l0 l0Var = new C3716l0(pop, byteString, (C3717a) null);
            while (!this.f20804a.isEmpty() && this.f20804a.peek().size() < C3716l0.m13477s(m13484d(l0Var.size()) + 1)) {
                l0Var = new C3716l0(this.f20804a.pop(), l0Var, (C3717a) null);
            }
            this.f20804a.push(l0Var);
        }

        /* synthetic */ C3718b(C3717a aVar) {
            this();
        }
    }

    private C3716l0(ByteString byteString, ByteString byteString2) {
        this.f20797e = byteString;
        this.f20798f = byteString2;
        int size = byteString.size();
        this.f20799g = size;
        this.f20796d = size + byteString2.size();
        this.f20800h = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public ByteString.ByteIterator iterator() {
        return new C3717a();
    }

    /* renamed from: com.google.protobuf.l0$d */
    /* compiled from: RopeByteString */
    private class C3720d extends InputStream {

        /* renamed from: a */
        private C3719c f20807a;

        /* renamed from: b */
        private ByteString.C3607h f20808b;

        /* renamed from: c */
        private int f20809c;

        /* renamed from: d */
        private int f20810d;

        /* renamed from: e */
        private int f20811e;

        /* renamed from: f */
        private int f20812f;

        public C3720d() {
            m13490b();
        }

        /* renamed from: a */
        private void m13489a() {
            int i;
            if (this.f20808b != null && this.f20810d == (i = this.f20809c)) {
                this.f20811e += i;
                this.f20810d = 0;
                if (this.f20807a.hasNext()) {
                    ByteString.C3607h c = this.f20807a.next();
                    this.f20808b = c;
                    this.f20809c = c.size();
                    return;
                }
                this.f20808b = null;
                this.f20809c = 0;
            }
        }

        /* renamed from: b */
        private void m13490b() {
            C3719c cVar = new C3719c(C3716l0.this, (C3717a) null);
            this.f20807a = cVar;
            ByteString.C3607h c = cVar.next();
            this.f20808b = c;
            this.f20809c = c.size();
            this.f20810d = 0;
            this.f20811e = 0;
        }

        /* renamed from: c */
        private int m13491c(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (i3 > 0) {
                m13489a();
                if (this.f20808b == null) {
                    break;
                }
                int min = Math.min(this.f20809c - this.f20810d, i3);
                if (bArr != null) {
                    this.f20808b.copyTo(bArr, this.f20810d, i, min);
                    i += min;
                }
                this.f20810d += min;
                i3 -= min;
            }
            return i2 - i3;
        }

        public int available() {
            return C3716l0.this.size() - (this.f20811e + this.f20810d);
        }

        public void mark(int i) {
            this.f20812f = this.f20811e + this.f20810d;
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            int c = m13491c(bArr, i, i2);
            if (c == 0) {
                return -1;
            }
            return c;
        }

        public synchronized void reset() {
            m13490b();
            m13491c((byte[]) null, 0, this.f20812f);
        }

        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return (long) m13491c((byte[]) null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read() {
            m13489a();
            ByteString.C3607h hVar = this.f20808b;
            if (hVar == null) {
                return -1;
            }
            int i = this.f20810d;
            this.f20810d = i + 1;
            return hVar.byteAt(i) & 255;
        }
    }
}
