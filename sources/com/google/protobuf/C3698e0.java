package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.e0 */
/* compiled from: NioByteString */
final class C3698e0 extends ByteString.C3607h {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ByteBuffer f20768d;

    C3698e0(ByteBuffer byteBuffer) {
        Internal.m12791b(byteBuffer, "buffer");
        this.f20768d = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    /* renamed from: p */
    private ByteBuffer m13277p(int i, int i2) {
        if (i < this.f20768d.position() || i2 > this.f20768d.limit() || i > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        ByteBuffer slice = this.f20768d.slice();
        slice.position(i - this.f20768d.position());
        slice.limit(i2 - this.f20768d.position());
        return slice;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.f20768d.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.f20768d.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i) {
        try {
            return this.f20768d.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f20768d.slice());
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer slice = this.f20768d.slice();
        slice.position(i);
        slice.get(bArr, i2, i3);
    }

    /* renamed from: e */
    public byte mo22927e(int i) {
        return byteAt(i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof C3698e0) {
            return this.f20768d.equals(((C3698e0) obj).f20768d);
        }
        if (obj instanceof C3716l0) {
            return obj.equals(this);
        }
        return this.f20768d.equals(byteString.asReadOnlyByteBuffer());
    }

    public boolean isValidUtf8() {
        return C3759u0.m13852s(this.f20768d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo22936m(ByteOutput byteOutput) {
        byteOutput.writeLazy(this.f20768d.slice());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo22972n(ByteString byteString, int i, int i2) {
        return substring(0, i2).equals(byteString.substring(i, i2 + i));
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.m12440b(this.f20768d, true);
    }

    public InputStream newInput() {
        return new C3699a();
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + this.f20768d.get(i4);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i, int i2, int i3) {
        return C3759u0.m13855v(i, this.f20768d, i2, i3 + i2);
    }

    public int size() {
        return this.f20768d.remaining();
    }

    public ByteString substring(int i, int i2) {
        try {
            return new C3698e0(m13277p(i, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String toStringInternal(Charset charset) {
        int i;
        int i2;
        byte[] bArr;
        if (this.f20768d.hasArray()) {
            bArr = this.f20768d.array();
            i2 = this.f20768d.arrayOffset() + this.f20768d.position();
            i = this.f20768d.remaining();
        } else {
            bArr = toByteArray();
            i2 = 0;
            i = bArr.length;
        }
        return new String(bArr, i2, i, charset);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(toByteArray());
    }

    /* renamed from: com.google.protobuf.e0$a */
    /* compiled from: NioByteString */
    class C3699a extends InputStream {

        /* renamed from: a */
        private final ByteBuffer f20769a;

        C3699a() {
            this.f20769a = C3698e0.this.f20768d.slice();
        }

        public int available() {
            return this.f20769a.remaining();
        }

        public void mark(int i) {
            this.f20769a.mark();
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!this.f20769a.hasRemaining()) {
                return -1;
            }
            return this.f20769a.get() & 255;
        }

        public void reset() {
            try {
                this.f20769a.reset();
            } catch (InvalidMarkException e) {
                throw new IOException(e);
            }
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.f20769a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.f20769a.remaining());
            this.f20769a.get(bArr, i, min);
            return min;
        }
    }
}
