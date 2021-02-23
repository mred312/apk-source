package com.google.firebase.crashlytics.internal.proto;

import com.bumptech.glide.load.Key;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStream implements Flushable {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;

    /* renamed from: a */
    private final byte[] f19477a;

    /* renamed from: b */
    private final int f19478b;

    /* renamed from: c */
    private int f19479c;

    /* renamed from: d */
    private final OutputStream f19480d;

    /* renamed from: com.google.firebase.crashlytics.internal.proto.CodedOutputStream$a */
    static class C3446a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        C3446a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(byte[] bArr, int i, int i2) {
        this.f19480d = null;
        this.f19477a = bArr;
        this.f19479c = i;
        this.f19478b = i + i2;
    }

    /* renamed from: a */
    private void m11650a() {
        OutputStream outputStream = this.f19480d;
        if (outputStream != null) {
            outputStream.write(this.f19477a, 0, this.f19479c);
            this.f19479c = 0;
            return;
        }
        throw new C3446a();
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeBytesSize(int i, C3447a aVar) {
        return computeTagSize(i) + computeBytesSizeNoTag(aVar);
    }

    public static int computeBytesSizeNoTag(C3447a aVar) {
        return computeRawVarint32Size(aVar.mo21479f()) + aVar.mo21479f();
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

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j) {
        return computeTagSize(i) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeRawMessageSetExtensionSize(int i, C3447a aVar) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, aVar);
    }

    public static int computeRawVarint32Size(int i) {
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

    public static int computeRawVarint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
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
        return computeRawVarint32Size(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size(C3448b.m11680a(i, 0));
    }

    public static int computeUInt32Size(int i, int i2) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i2);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeUInt64Size(int i, long j) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void flush() {
        if (this.f19480d != null) {
            m11650a();
        }
    }

    public int spaceLeft() {
        if (this.f19480d == null) {
            return this.f19478b - this.f19479c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void writeBool(int i, boolean z) {
        writeTag(i, 0);
        writeBoolNoTag(z);
    }

    public void writeBoolNoTag(boolean z) {
        writeRawByte(z ? 1 : 0);
    }

    public void writeBytes(int i, C3447a aVar) {
        writeTag(i, 2);
        writeBytesNoTag(aVar);
    }

    public void writeBytesNoTag(C3447a aVar) {
        writeRawVarint32(aVar.mo21479f());
        writeRawBytes(aVar);
    }

    public void writeDouble(int i, double d) {
        writeTag(i, 1);
        writeDoubleNoTag(d);
    }

    public void writeDoubleNoTag(double d) {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d));
    }

    public void writeEnum(int i, int i2) {
        writeTag(i, 0);
        writeEnumNoTag(i2);
    }

    public void writeEnumNoTag(int i) {
        writeInt32NoTag(i);
    }

    public void writeFixed32(int i, int i2) {
        writeTag(i, 5);
        writeFixed32NoTag(i2);
    }

    public void writeFixed32NoTag(int i) {
        writeRawLittleEndian32(i);
    }

    public void writeFixed64(int i, long j) {
        writeTag(i, 1);
        writeFixed64NoTag(j);
    }

    public void writeFixed64NoTag(long j) {
        writeRawLittleEndian64(j);
    }

    public void writeFloat(int i, float f) {
        writeTag(i, 5);
        writeFloatNoTag(f);
    }

    public void writeFloatNoTag(float f) {
        writeRawLittleEndian32(Float.floatToRawIntBits(f));
    }

    public void writeInt32(int i, int i2) {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public void writeInt32NoTag(int i) {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64((long) i);
        }
    }

    public void writeInt64(int i, long j) {
        writeTag(i, 0);
        writeInt64NoTag(j);
    }

    public void writeInt64NoTag(long j) {
        writeRawVarint64(j);
    }

    public void writeRawByte(byte b) {
        if (this.f19479c == this.f19478b) {
            m11650a();
        }
        byte[] bArr = this.f19477a;
        int i = this.f19479c;
        this.f19479c = i + 1;
        bArr[i] = b;
    }

    public void writeRawBytes(C3447a aVar) {
        writeRawBytes(aVar, 0, aVar.mo21479f());
    }

    public void writeRawLittleEndian32(int i) {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    public void writeRawMessageSetExtension(int i, C3447a aVar) {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeBytes(3, aVar);
        writeTag(1, 4);
    }

    public void writeRawVarint32(int i) {
        while ((i & -128) != 0) {
            writeRawByte((i & 127) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public void writeRawVarint64(long j) {
        while ((-128 & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeSFixed32(int i, int i2) {
        writeTag(i, 5);
        writeSFixed32NoTag(i2);
    }

    public void writeSFixed32NoTag(int i) {
        writeRawLittleEndian32(i);
    }

    public void writeSFixed64(int i, long j) {
        writeTag(i, 1);
        writeSFixed64NoTag(j);
    }

    public void writeSFixed64NoTag(long j) {
        writeRawLittleEndian64(j);
    }

    public void writeSInt32(int i, int i2) {
        writeTag(i, 0);
        writeSInt32NoTag(i2);
    }

    public void writeSInt32NoTag(int i) {
        writeRawVarint32(encodeZigZag32(i));
    }

    public void writeSInt64(int i, long j) {
        writeTag(i, 0);
        writeSInt64NoTag(j);
    }

    public void writeSInt64NoTag(long j) {
        writeRawVarint64(encodeZigZag64(j));
    }

    public void writeString(int i, String str) {
        writeTag(i, 2);
        writeStringNoTag(str);
    }

    public void writeStringNoTag(String str) {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i, int i2) {
        writeRawVarint32(C3448b.m11680a(i, i2));
    }

    public void writeUInt32(int i, int i2) {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public void writeUInt32NoTag(int i) {
        writeRawVarint32(i);
    }

    public void writeUInt64(int i, long j) {
        writeTag(i, 0);
        writeUInt64NoTag(j);
    }

    public void writeUInt64NoTag(long j) {
        writeRawVarint64(j);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void writeRawBytes(byte[] bArr) {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) {
        int i3 = this.f19478b;
        int i4 = this.f19479c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f19477a, i4, i2);
            this.f19479c += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f19477a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f19479c = this.f19478b;
        m11650a();
        if (i7 <= this.f19478b) {
            System.arraycopy(bArr, i6, this.f19477a, 0, i7);
            this.f19479c = i7;
            return;
        }
        this.f19480d.write(bArr, i6, i7);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i2) {
        return new CodedOutputStream(bArr, i, i2);
    }

    public void writeRawByte(int i) {
        writeRawByte((byte) i);
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f19480d = outputStream;
        this.f19477a = bArr;
        this.f19479c = 0;
        this.f19478b = bArr.length;
    }

    public void writeRawBytes(C3447a aVar, int i, int i2) {
        int i3 = this.f19478b;
        int i4 = this.f19479c;
        if (i3 - i4 >= i2) {
            aVar.mo21476d(this.f19477a, i, i4, i2);
            this.f19479c += i2;
            return;
        }
        int i5 = i3 - i4;
        aVar.mo21476d(this.f19477a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f19479c = this.f19478b;
        m11650a();
        if (i7 <= this.f19478b) {
            aVar.mo21476d(this.f19477a, i6, 0, i7);
            this.f19479c = i7;
            return;
        }
        InputStream e = aVar.mo21477e();
        long j = (long) i6;
        if (j == e.skip(j)) {
            while (i7 > 0) {
                int min = Math.min(i7, this.f19478b);
                int read = e.read(this.f19477a, 0, min);
                if (read == min) {
                    this.f19480d.write(this.f19477a, 0, read);
                    i7 -= read;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }
}
