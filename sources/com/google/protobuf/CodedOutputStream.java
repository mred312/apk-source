package com.google.protobuf;

import com.google.protobuf.C3759u0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;

    /* renamed from: c */
    private static final Logger f20426c = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final boolean f20427d = C3752t0.m13719H();

    /* renamed from: a */
    C3703g f20428a;

    /* renamed from: b */
    private boolean f20429b;

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$b */
    private static abstract class C3618b extends CodedOutputStream {

        /* renamed from: e */
        final byte[] f20430e;

        /* renamed from: f */
        final int f20431f;

        /* renamed from: g */
        int f20432g;

        /* renamed from: h */
        int f20433h;

        C3618b(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.f20430e = bArr;
                this.f20431f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int getTotalBytesWritten() {
            return this.f20433h;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public final void mo23092p(byte b) {
            byte[] bArr = this.f20430e;
            int i = this.f20432g;
            this.f20432g = i + 1;
            bArr[i] = b;
            this.f20433h++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public final void mo23093q(int i) {
            byte[] bArr = this.f20430e;
            int i2 = this.f20432g;
            int i3 = i2 + 1;
            this.f20432g = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.f20432g = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.f20432g = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f20432g = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.f20433h += 4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public final void mo23094r(long j) {
            byte[] bArr = this.f20430e;
            int i = this.f20432g;
            int i2 = i + 1;
            this.f20432g = i2;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            this.f20432g = i3;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            this.f20432g = i4;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            this.f20432g = i5;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            this.f20432g = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f20432g = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f20432g = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f20432g = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.f20433h += 8;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public final void mo23095s(int i) {
            if (i >= 0) {
                mo23097u(i);
            } else {
                mo23098v((long) i);
            }
        }

        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public final void mo23096t(int i, int i2) {
            mo23097u(WireFormat.m13092a(i, i2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public final void mo23097u(int i) {
            if (CodedOutputStream.f20427d) {
                long j = (long) this.f20432g;
                while ((i & -128) != 0) {
                    byte[] bArr = this.f20430e;
                    int i2 = this.f20432g;
                    this.f20432g = i2 + 1;
                    C3752t0.m13726O(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f20430e;
                int i3 = this.f20432g;
                this.f20432g = i3 + 1;
                C3752t0.m13726O(bArr2, (long) i3, (byte) i);
                this.f20433h += (int) (((long) this.f20432g) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.f20430e;
                int i4 = this.f20432g;
                this.f20432g = i4 + 1;
                bArr3[i4] = (byte) ((i & 127) | 128);
                this.f20433h++;
                i >>>= 7;
            }
            byte[] bArr4 = this.f20430e;
            int i5 = this.f20432g;
            this.f20432g = i5 + 1;
            bArr4[i5] = (byte) i;
            this.f20433h++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public final void mo23098v(long j) {
            if (CodedOutputStream.f20427d) {
                long j2 = (long) this.f20432g;
                while ((j & -128) != 0) {
                    byte[] bArr = this.f20430e;
                    int i = this.f20432g;
                    this.f20432g = i + 1;
                    C3752t0.m13726O(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f20430e;
                int i2 = this.f20432g;
                this.f20432g = i2 + 1;
                C3752t0.m13726O(bArr2, (long) i2, (byte) ((int) j));
                this.f20433h += (int) (((long) this.f20432g) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.f20430e;
                int i3 = this.f20432g;
                this.f20432g = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                this.f20433h++;
                j >>>= 7;
            }
            byte[] bArr4 = this.f20430e;
            int i4 = this.f20432g;
            this.f20432g = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.f20433h++;
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$c */
    private static class C3619c extends CodedOutputStream {

        /* renamed from: e */
        private final byte[] f20434e;

        /* renamed from: f */
        private final int f20435f;

        /* renamed from: g */
        private final int f20436g;

        /* renamed from: h */
        private int f20437h;

        C3619c(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f20434e = bArr;
                    this.f20435f = i;
                    this.f20437h = i;
                    this.f20436g = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final int getTotalBytesWritten() {
            return this.f20437h - this.f20435f;
        }

        /* renamed from: l */
        public final void mo23033l(byte[] bArr, int i, int i2) {
            writeUInt32NoTag(i2);
            write(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public final void mo23036o(int i, MessageLite messageLite, C3722m0 m0Var) {
            writeTag(i, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).mo22788b(m0Var));
            m0Var.mo23806e(messageLite, this.f20428a);
        }

        public final int spaceLeft() {
            return this.f20436g - this.f20437h;
        }

        public final void write(byte b) {
            try {
                byte[] bArr = this.f20434e;
                int i = this.f20437h;
                this.f20437h = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), 1}), e);
            }
        }

        public final void writeBool(int i, boolean z) {
            writeTag(i, 0);
            write(z ? (byte) 1 : 0);
        }

        public final void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        public final void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public final void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.mo22936m(this);
        }

        public final void writeFixed32(int i, int i2) {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        public final void writeFixed32NoTag(int i) {
            try {
                byte[] bArr = this.f20434e;
                int i2 = this.f20437h;
                int i3 = i2 + 1;
                this.f20437h = i3;
                bArr[i2] = (byte) (i & 255);
                int i4 = i3 + 1;
                this.f20437h = i4;
                bArr[i3] = (byte) ((i >> 8) & 255);
                int i5 = i4 + 1;
                this.f20437h = i5;
                bArr[i4] = (byte) ((i >> 16) & 255);
                this.f20437h = i5 + 1;
                bArr[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), 1}), e);
            }
        }

        public final void writeFixed64(int i, long j) {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        public final void writeFixed64NoTag(long j) {
            try {
                byte[] bArr = this.f20434e;
                int i = this.f20437h;
                int i2 = i + 1;
                this.f20437h = i2;
                bArr[i] = (byte) (((int) j) & 255);
                int i3 = i2 + 1;
                this.f20437h = i3;
                bArr[i2] = (byte) (((int) (j >> 8)) & 255);
                int i4 = i3 + 1;
                this.f20437h = i4;
                bArr[i3] = (byte) (((int) (j >> 16)) & 255);
                int i5 = i4 + 1;
                this.f20437h = i5;
                bArr[i4] = (byte) (((int) (j >> 24)) & 255);
                int i6 = i5 + 1;
                this.f20437h = i6;
                bArr[i5] = (byte) (((int) (j >> 32)) & 255);
                int i7 = i6 + 1;
                this.f20437h = i7;
                bArr[i6] = (byte) (((int) (j >> 40)) & 255);
                int i8 = i7 + 1;
                this.f20437h = i8;
                bArr[i7] = (byte) (((int) (j >> 48)) & 255);
                this.f20437h = i8 + 1;
                bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), 1}), e);
            }
        }

        public final void writeInt32(int i, int i2) {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        public final void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag((long) i);
            }
        }

        public final void writeLazy(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        public final void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public final void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public final void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public final void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public final void writeString(int i, String str) {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) {
            int i = this.f20437h;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i2 = i + computeUInt32SizeNoTag2;
                    this.f20437h = i2;
                    int i3 = C3759u0.m13842i(str, this.f20434e, i2, spaceLeft());
                    this.f20437h = i;
                    writeUInt32NoTag((i3 - i) - computeUInt32SizeNoTag2);
                    this.f20437h = i3;
                    return;
                }
                writeUInt32NoTag(C3759u0.m13844k(str));
                this.f20437h = C3759u0.m13842i(str, this.f20434e, this.f20437h, spaceLeft());
            } catch (C3759u0.C3763d e) {
                this.f20437h = i;
                mo23031h(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public final void writeTag(int i, int i2) {
            writeUInt32NoTag(WireFormat.m13092a(i, i2));
        }

        public final void writeUInt32(int i, int i2) {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        public final void writeUInt32NoTag(int i) {
            if (!CodedOutputStream.f20427d || C3687b.m13156c() || spaceLeft() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f20434e;
                    int i2 = this.f20437h;
                    this.f20437h = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20434e;
                    int i3 = this.f20437h;
                    this.f20437h = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f20434e;
                int i4 = this.f20437h;
                this.f20437h = i4 + 1;
                C3752t0.m13726O(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f20434e;
                int i5 = this.f20437h;
                this.f20437h = i5 + 1;
                C3752t0.m13726O(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f20434e;
                    int i7 = this.f20437h;
                    this.f20437h = i7 + 1;
                    C3752t0.m13726O(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f20434e;
                int i8 = this.f20437h;
                this.f20437h = i8 + 1;
                C3752t0.m13726O(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f20434e;
                    int i10 = this.f20437h;
                    this.f20437h = i10 + 1;
                    C3752t0.m13726O(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f20434e;
                int i11 = this.f20437h;
                this.f20437h = i11 + 1;
                C3752t0.m13726O(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f20434e;
                    int i13 = this.f20437h;
                    this.f20437h = i13 + 1;
                    C3752t0.m13726O(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f20434e;
                int i14 = this.f20437h;
                this.f20437h = i14 + 1;
                C3752t0.m13726O(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.f20434e;
                int i15 = this.f20437h;
                this.f20437h = i15 + 1;
                C3752t0.m13726O(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void writeUInt64(int i, long j) {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        public final void writeUInt64NoTag(long j) {
            if (!CodedOutputStream.f20427d || spaceLeft() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f20434e;
                    int i = this.f20437h;
                    this.f20437h = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20434e;
                    int i2 = this.f20437h;
                    this.f20437h = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f20434e;
                    int i3 = this.f20437h;
                    this.f20437h = i3 + 1;
                    C3752t0.m13726O(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f20434e;
                int i4 = this.f20437h;
                this.f20437h = i4 + 1;
                C3752t0.m13726O(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void writeByteArray(int i, byte[] bArr, int i2, int i3) {
            writeTag(i, 2);
            mo23033l(bArr, i2, i3);
        }

        public final void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        public final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f20434e, this.f20437h, i2);
                this.f20437h += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), Integer.valueOf(i2)}), e);
            }
        }

        public final void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f20434e, this.f20437h, remaining);
                this.f20437h += remaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20437h), Integer.valueOf(this.f20436g), Integer.valueOf(remaining)}), e);
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$d */
    private static final class C3620d extends C3619c {

        /* renamed from: i */
        private final ByteBuffer f20438i;

        /* renamed from: j */
        private int f20439j;

        C3620d(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f20438i = byteBuffer;
            this.f20439j = byteBuffer.position();
        }

        public void flush() {
            this.f20438i.position(this.f20439j + getTotalBytesWritten());
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$e */
    private static final class C3621e extends C3618b {

        /* renamed from: i */
        private final OutputStream f20440i;

        C3621e(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.f20440i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        /* renamed from: w */
        private void m12502w() {
            this.f20440i.write(this.f20430e, 0, this.f20432g);
            this.f20432g = 0;
        }

        /* renamed from: x */
        private void m12503x(int i) {
            if (this.f20431f - this.f20432g < i) {
                m12502w();
            }
        }

        public void flush() {
            if (this.f20432g > 0) {
                m12502w();
            }
        }

        /* renamed from: l */
        public void mo23033l(byte[] bArr, int i, int i2) {
            writeUInt32NoTag(i2);
            write(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public void mo23036o(int i, MessageLite messageLite, C3722m0 m0Var) {
            writeTag(i, 2);
            mo23099y(messageLite, m0Var);
        }

        public void write(byte b) {
            if (this.f20432g == this.f20431f) {
                m12502w();
            }
            mo23092p(b);
        }

        public void writeBool(int i, boolean z) {
            m12503x(11);
            mo23096t(i, 0);
            mo23092p(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        public void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.mo22936m(this);
        }

        public void writeFixed32(int i, int i2) {
            m12503x(14);
            mo23096t(i, 5);
            mo23093q(i2);
        }

        public void writeFixed32NoTag(int i) {
            m12503x(4);
            mo23093q(i);
        }

        public void writeFixed64(int i, long j) {
            m12503x(18);
            mo23096t(i, 1);
            mo23094r(j);
        }

        public void writeFixed64NoTag(long j) {
            m12503x(8);
            mo23094r(j);
        }

        public void writeInt32(int i, int i2) {
            m12503x(20);
            mo23096t(i, 0);
            mo23095s(i2);
        }

        public void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag((long) i);
            }
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i, String str) {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i3 = computeUInt32SizeNoTag + length;
                int i4 = this.f20431f;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int i5 = C3759u0.m13842i(str, bArr, 0, length);
                    writeUInt32NoTag(i5);
                    writeLazy(bArr, 0, i5);
                    return;
                }
                if (i3 > i4 - this.f20432g) {
                    m12502w();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                i = this.f20432g;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i6 = i + computeUInt32SizeNoTag2;
                    this.f20432g = i6;
                    int i7 = C3759u0.m13842i(str, this.f20430e, i6, this.f20431f - i6);
                    this.f20432g = i;
                    i2 = (i7 - i) - computeUInt32SizeNoTag2;
                    mo23097u(i2);
                    this.f20432g = i7;
                } else {
                    i2 = C3759u0.m13844k(str);
                    mo23097u(i2);
                    this.f20432g = C3759u0.m13842i(str, this.f20430e, this.f20432g, i2);
                }
                this.f20433h += i2;
            } catch (C3759u0.C3763d e) {
                this.f20433h -= this.f20432g - i;
                this.f20432g = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (C3759u0.C3763d e3) {
                mo23031h(str, e3);
            }
        }

        public void writeTag(int i, int i2) {
            writeUInt32NoTag(WireFormat.m13092a(i, i2));
        }

        public void writeUInt32(int i, int i2) {
            m12503x(20);
            mo23096t(i, 0);
            mo23097u(i2);
        }

        public void writeUInt32NoTag(int i) {
            m12503x(5);
            mo23097u(i);
        }

        public void writeUInt64(int i, long j) {
            m12503x(20);
            mo23096t(i, 0);
            mo23098v(j);
        }

        public void writeUInt64NoTag(long j) {
            m12503x(10);
            mo23098v(j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo23099y(MessageLite messageLite, C3722m0 m0Var) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).mo22788b(m0Var));
            m0Var.mo23806e(messageLite, this.f20428a);
        }

        public void writeByteArray(int i, byte[] bArr, int i2, int i3) {
            writeTag(i, 2);
            mo23033l(bArr, i2, i3);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i, int i2) {
            int i3 = this.f20431f;
            int i4 = this.f20432g;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f20430e, i4, i2);
                this.f20432g += i2;
                this.f20433h += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f20430e, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f20432g = this.f20431f;
            this.f20433h += i5;
            m12502w();
            if (i7 <= this.f20431f) {
                System.arraycopy(bArr, i6, this.f20430e, 0, i7);
                this.f20432g = i7;
            } else {
                this.f20440i.write(bArr, i6, i7);
            }
            this.f20433h += i7;
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i = this.f20431f;
            int i2 = this.f20432g;
            if (i - i2 >= remaining) {
                byteBuffer.get(this.f20430e, i2, remaining);
                this.f20432g += remaining;
                this.f20433h += remaining;
                return;
            }
            int i3 = i - i2;
            byteBuffer.get(this.f20430e, i2, i3);
            int i4 = remaining - i3;
            this.f20432g = this.f20431f;
            this.f20433h += i3;
            m12502w();
            while (true) {
                int i5 = this.f20431f;
                if (i4 > i5) {
                    byteBuffer.get(this.f20430e, 0, i5);
                    this.f20440i.write(this.f20430e, 0, this.f20431f);
                    int i6 = this.f20431f;
                    i4 -= i6;
                    this.f20433h += i6;
                } else {
                    byteBuffer.get(this.f20430e, 0, i4);
                    this.f20432g = i4;
                    this.f20433h += i4;
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$f */
    private static final class C3622f extends CodedOutputStream {

        /* renamed from: e */
        private final ByteBuffer f20441e;

        /* renamed from: f */
        private final ByteBuffer f20442f;

        /* renamed from: g */
        private final int f20443g;

        C3622f(ByteBuffer byteBuffer) {
            super();
            this.f20441e = byteBuffer;
            this.f20442f = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f20443g = byteBuffer.position();
        }

        /* renamed from: p */
        private void m12507p(String str) {
            try {
                C3759u0.m13843j(str, this.f20442f);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void flush() {
            this.f20441e.position(this.f20442f.position());
        }

        public int getTotalBytesWritten() {
            return this.f20442f.position() - this.f20443g;
        }

        /* renamed from: l */
        public void mo23033l(byte[] bArr, int i, int i2) {
            writeUInt32NoTag(i2);
            write(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public void mo23036o(int i, MessageLite messageLite, C3722m0 m0Var) {
            writeTag(i, 2);
            mo23100q(messageLite, m0Var);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo23100q(MessageLite messageLite, C3722m0 m0Var) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).mo22788b(m0Var));
            m0Var.mo23806e(messageLite, this.f20428a);
        }

        public int spaceLeft() {
            return this.f20442f.remaining();
        }

        public void write(byte b) {
            try {
                this.f20442f.put(b);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeBool(int i, boolean z) {
            writeTag(i, 0);
            write(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        public void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.mo22936m(this);
        }

        public void writeFixed32(int i, int i2) {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        public void writeFixed32NoTag(int i) {
            try {
                this.f20442f.putInt(i);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeFixed64(int i, long j) {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) {
            try {
                this.f20442f.putLong(j);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeInt32(int i, int i2) {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        public void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag((long) i);
            }
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i, String str) {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) {
            int position = this.f20442f.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.f20442f.position() + computeUInt32SizeNoTag2;
                    this.f20442f.position(position2);
                    m12507p(str);
                    int position3 = this.f20442f.position();
                    this.f20442f.position(position);
                    writeUInt32NoTag(position3 - position2);
                    this.f20442f.position(position3);
                    return;
                }
                writeUInt32NoTag(C3759u0.m13844k(str));
                m12507p(str);
            } catch (C3759u0.C3763d e) {
                this.f20442f.position(position);
                mo23031h(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void writeTag(int i, int i2) {
            writeUInt32NoTag(WireFormat.m13092a(i, i2));
        }

        public void writeUInt32(int i, int i2) {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        public void writeUInt32NoTag(int i) {
            while ((i & -128) != 0) {
                this.f20442f.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.f20442f.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeUInt64(int i, long j) {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) {
            while ((-128 & j) != 0) {
                this.f20442f.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.f20442f.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeByteArray(int i, byte[] bArr, int i2, int i3) {
            writeTag(i, 2);
            mo23033l(bArr, i2, i3);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i, int i2) {
            try {
                this.f20442f.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void write(ByteBuffer byteBuffer) {
            try {
                this.f20442f.put(byteBuffer);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStream$g */
    private static final class C3623g extends CodedOutputStream {

        /* renamed from: e */
        private final ByteBuffer f20444e;

        /* renamed from: f */
        private final ByteBuffer f20445f;

        /* renamed from: g */
        private final long f20446g;

        /* renamed from: h */
        private final long f20447h;

        /* renamed from: i */
        private final long f20448i;

        /* renamed from: j */
        private final long f20449j;

        /* renamed from: k */
        private long f20450k;

        C3623g(ByteBuffer byteBuffer) {
            super();
            this.f20444e = byteBuffer;
            this.f20445f = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long i = C3752t0.m13744i(byteBuffer);
            this.f20446g = i;
            long position = ((long) byteBuffer.position()) + i;
            this.f20447h = position;
            long limit = i + ((long) byteBuffer.limit());
            this.f20448i = limit;
            this.f20449j = limit - 10;
            this.f20450k = position;
        }

        /* renamed from: p */
        private int m12511p(long j) {
            return (int) (j - this.f20446g);
        }

        /* renamed from: q */
        static boolean m12512q() {
            return C3752t0.m13720I();
        }

        /* renamed from: r */
        private void m12513r(long j) {
            this.f20445f.position(m12511p(j));
        }

        public void flush() {
            this.f20444e.position(m12511p(this.f20450k));
        }

        public int getTotalBytesWritten() {
            return (int) (this.f20450k - this.f20447h);
        }

        /* renamed from: l */
        public void mo23033l(byte[] bArr, int i, int i2) {
            writeUInt32NoTag(i2);
            write(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public void mo23036o(int i, MessageLite messageLite, C3722m0 m0Var) {
            writeTag(i, 2);
            mo23101s(messageLite, m0Var);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public void mo23101s(MessageLite messageLite, C3722m0 m0Var) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).mo22788b(m0Var));
            m0Var.mo23806e(messageLite, this.f20428a);
        }

        public int spaceLeft() {
            return (int) (this.f20448i - this.f20450k);
        }

        public void write(byte b) {
            long j = this.f20450k;
            if (j < this.f20448i) {
                this.f20450k = 1 + j;
                C3752t0.m13725N(j, b);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f20450k), Long.valueOf(this.f20448i), 1}));
        }

        public void writeBool(int i, boolean z) {
            writeTag(i, 0);
            write(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        public void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.mo22936m(this);
        }

        public void writeFixed32(int i, int i2) {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        public void writeFixed32NoTag(int i) {
            this.f20445f.putInt(m12511p(this.f20450k), i);
            this.f20450k += 4;
        }

        public void writeFixed64(int i, long j) {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) {
            this.f20445f.putLong(m12511p(this.f20450k), j);
            this.f20450k += 8;
        }

        public void writeInt32(int i, int i2) {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        public void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag((long) i);
            }
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i, String str) {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) {
            long j = this.f20450k;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int p = m12511p(this.f20450k) + computeUInt32SizeNoTag2;
                    this.f20445f.position(p);
                    C3759u0.m13843j(str, this.f20445f);
                    int position = this.f20445f.position() - p;
                    writeUInt32NoTag(position);
                    this.f20450k += (long) position;
                    return;
                }
                int k = C3759u0.m13844k(str);
                writeUInt32NoTag(k);
                m12513r(this.f20450k);
                C3759u0.m13843j(str, this.f20445f);
                this.f20450k += (long) k;
            } catch (C3759u0.C3763d e) {
                this.f20450k = j;
                m12513r(j);
                mo23031h(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void writeTag(int i, int i2) {
            writeUInt32NoTag(WireFormat.m13092a(i, i2));
        }

        public void writeUInt32(int i, int i2) {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        public void writeUInt32NoTag(int i) {
            if (this.f20450k <= this.f20449j) {
                while ((i & -128) != 0) {
                    long j = this.f20450k;
                    this.f20450k = j + 1;
                    C3752t0.m13725N(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.f20450k;
                this.f20450k = 1 + j2;
                C3752t0.m13725N(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.f20450k;
                if (j3 >= this.f20448i) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f20450k), Long.valueOf(this.f20448i), 1}));
                } else if ((i & -128) == 0) {
                    this.f20450k = 1 + j3;
                    C3752t0.m13725N(j3, (byte) i);
                    return;
                } else {
                    this.f20450k = j3 + 1;
                    C3752t0.m13725N(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        public void writeUInt64(int i, long j) {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) {
            if (this.f20450k <= this.f20449j) {
                while ((j & -128) != 0) {
                    long j2 = this.f20450k;
                    this.f20450k = j2 + 1;
                    C3752t0.m13725N(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.f20450k;
                this.f20450k = 1 + j3;
                C3752t0.m13725N(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.f20450k;
                if (j4 >= this.f20448i) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f20450k), Long.valueOf(this.f20448i), 1}));
                } else if ((j & -128) == 0) {
                    this.f20450k = 1 + j4;
                    C3752t0.m13725N(j4, (byte) ((int) j));
                    return;
                } else {
                    this.f20450k = j4 + 1;
                    C3752t0.m13725N(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        public void writeByteArray(int i, byte[] bArr, int i2, int i3) {
            writeTag(i, 2);
            mo23033l(bArr, i2, i3);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.f20450k;
                if (this.f20448i - j >= j2) {
                    C3752t0.m13750o(bArr, (long) i, j2, j);
                    this.f20450k += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f20450k), Long.valueOf(this.f20448i), Integer.valueOf(i2)}));
        }

        public void write(ByteBuffer byteBuffer) {
            try {
                int remaining = byteBuffer.remaining();
                m12513r(this.f20450k);
                this.f20445f.put(byteBuffer);
                this.f20450k += (long) remaining;
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }
    }

    @Deprecated
    /* renamed from: b */
    static int m12479b(int i, MessageLite messageLite, C3722m0 m0Var) {
        return (computeTagSize(i) * 2) + m12480c(messageLite, m0Var);
    }

    @Deprecated
    /* renamed from: c */
    static int m12480c(MessageLite messageLite, C3722m0 m0Var) {
        return ((AbstractMessageLite) messageLite).mo22788b(m0Var);
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeByteArraySize(int i, byte[] bArr) {
        return computeTagSize(i) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return m12481d(bArr.length);
    }

    public static int computeByteBufferSize(int i, ByteBuffer byteBuffer) {
        return computeTagSize(i) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return m12481d(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeTagSize(i) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return m12481d(byteString.size());
    }

    public static int computeDoubleSize(int i, double d) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d);
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeEnumSizeNoTag(i2);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeFixed32SizeNoTag(i2);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j) {
        return computeTagSize(i) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeTagSize(i) + computeFloatSizeNoTag(f);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite) {
        return (computeTagSize(i) * 2) + computeGroupSizeNoTag(messageLite);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeUInt32SizeNoTag(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j) {
        return computeTagSize(i) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return m12481d(lazyFieldLite.getSerializedSize());
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return m12481d(messageLite.getSerializedSize());
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, byteString);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i) {
        return computeUInt32SizeNoTag(i);
    }

    @Deprecated
    public static int computeRawVarint64Size(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeSFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j) {
        return computeTagSize(i) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i2) {
        return computeTagSize(i) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int i;
        try {
            i = C3759u0.m13844k(str);
        } catch (C3759u0.C3763d unused) {
            i = str.getBytes(Internal.f20591a).length;
        }
        return m12481d(i);
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.m13092a(i, 0));
    }

    public static int computeUInt32Size(int i, int i2) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i2);
    }

    public static int computeUInt32SizeNoTag(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i, long j) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    /* renamed from: d */
    static int m12481d(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    /* renamed from: e */
    static int m12482e(int i, MessageLite messageLite, C3722m0 m0Var) {
        return computeTagSize(i) + m12483f(messageLite, m0Var);
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: f */
    static int m12483f(MessageLite messageLite, C3722m0 m0Var) {
        return m12481d(((AbstractMessageLite) messageLite).mo22788b(m0Var));
    }

    /* renamed from: g */
    static int m12484g(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    /* renamed from: j */
    static CodedOutputStream m12485j(ByteBuffer byteBuffer) {
        return new C3622f(byteBuffer);
    }

    /* renamed from: k */
    static CodedOutputStream m12486k(ByteBuffer byteBuffer) {
        return new C3623g(byteBuffer);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo23031h(String str, C3759u0.C3763d dVar) {
        f20426c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(Internal.f20591a);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException((Throwable) e);
        } catch (OutOfSpaceException e2) {
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo23032i() {
        return this.f20429b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public abstract void mo23033l(byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: m */
    public final void mo23034m(int i, MessageLite messageLite, C3722m0 m0Var) {
        writeTag(i, 3);
        mo23035n(messageLite, m0Var);
        writeTag(i, 4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: n */
    public final void mo23035n(MessageLite messageLite, C3722m0 m0Var) {
        m0Var.mo23806e(messageLite, this.f20428a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public abstract void mo23036o(int i, MessageLite messageLite, C3722m0 m0Var);

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.f20429b = true;
    }

    public abstract void write(byte b);

    public abstract void write(ByteBuffer byteBuffer);

    public abstract void write(byte[] bArr, int i, int i2);

    public abstract void writeBool(int i, boolean z);

    public final void writeBoolNoTag(boolean z) {
        write(z ? (byte) 1 : 0);
    }

    public abstract void writeByteArray(int i, byte[] bArr);

    public abstract void writeByteArray(int i, byte[] bArr, int i2, int i3);

    public final void writeByteArrayNoTag(byte[] bArr) {
        mo23033l(bArr, 0, bArr.length);
    }

    public abstract void writeByteBuffer(int i, ByteBuffer byteBuffer);

    public abstract void writeBytes(int i, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i, double d) {
        writeFixed64(i, Double.doubleToRawLongBits(d));
    }

    public final void writeDoubleNoTag(double d) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d));
    }

    public final void writeEnum(int i, int i2) {
        writeInt32(i, i2);
    }

    public final void writeEnumNoTag(int i) {
        writeInt32NoTag(i);
    }

    public abstract void writeFixed32(int i, int i2);

    public abstract void writeFixed32NoTag(int i);

    public abstract void writeFixed64(int i, long j);

    public abstract void writeFixed64NoTag(long j);

    public final void writeFloat(int i, float f) {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public final void writeFloatNoTag(float f) {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite) {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i, int i2);

    public abstract void writeInt32NoTag(int i);

    public final void writeInt64(int i, long j) {
        writeUInt64(i, j);
    }

    public final void writeInt64NoTag(long j) {
        writeUInt64NoTag(j);
    }

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i, int i2);

    public abstract void writeMessage(int i, MessageLite messageLite);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    public abstract void writeMessageSetExtension(int i, MessageLite messageLite);

    public final void writeRawByte(byte b) {
        write(b);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer);

    public final void writeRawBytes(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int i) {
        writeFixed32NoTag(i);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long j) {
        writeFixed64NoTag(j);
    }

    public abstract void writeRawMessageSetExtension(int i, ByteString byteString);

    @Deprecated
    public final void writeRawVarint32(int i) {
        writeUInt32NoTag(i);
    }

    @Deprecated
    public final void writeRawVarint64(long j) {
        writeUInt64NoTag(j);
    }

    public final void writeSFixed32(int i, int i2) {
        writeFixed32(i, i2);
    }

    public final void writeSFixed32NoTag(int i) {
        writeFixed32NoTag(i);
    }

    public final void writeSFixed64(int i, long j) {
        writeFixed64(i, j);
    }

    public final void writeSFixed64NoTag(long j) {
        writeFixed64NoTag(j);
    }

    public final void writeSInt32(int i, int i2) {
        writeUInt32(i, encodeZigZag32(i2));
    }

    public final void writeSInt32NoTag(int i) {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j) {
        writeUInt64(i, encodeZigZag64(j));
    }

    public final void writeSInt64NoTag(long j) {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    public abstract void writeString(int i, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i, int i2);

    public abstract void writeUInt32(int i, int i2);

    public abstract void writeUInt32NoTag(int i);

    public abstract void writeUInt64(int i, long j);

    public abstract void writeUInt64NoTag(long j);

    private CodedOutputStream() {
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new C3621e(outputStream, i);
    }

    public final void writeRawByte(int i) {
        write((byte) i);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i2) {
        write(bArr, i, i2);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.mo22936m(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i2) {
        return new C3619c(bArr, i, i2);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new C3620d(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (C3623g.m12512q()) {
            return m12486k(byteBuffer);
        } else {
            return m12485j(byteBuffer);
        }
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i) {
        return newInstance(byteBuffer);
    }
}
