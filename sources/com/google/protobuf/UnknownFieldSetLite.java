package com.google.protobuf;

import com.google.protobuf.Writer;
import java.util.Arrays;

public final class UnknownFieldSetLite {

    /* renamed from: f */
    private static final UnknownFieldSetLite f20710f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a */
    private int f20711a;

    /* renamed from: b */
    private int[] f20712b;

    /* renamed from: c */
    private Object[] f20713c;

    /* renamed from: d */
    private int f20714d;

    /* renamed from: e */
    private boolean f20715e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    /* renamed from: b */
    private void m13035b() {
        int i = this.f20711a;
        int[] iArr = this.f20712b;
        if (i == iArr.length) {
            int i2 = i + (i < 4 ? 8 : i >> 1);
            this.f20712b = Arrays.copyOf(iArr, i2);
            this.f20713c = Arrays.copyOf(this.f20713c, i2);
        }
    }

    /* renamed from: c */
    private static boolean m13036c(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m13037d(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static int m13038e(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    /* renamed from: f */
    private static int m13039f(Object[] objArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
        }
        return i2;
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return f20710f;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: h */
    private com.google.protobuf.UnknownFieldSetLite m13040h(com.google.protobuf.CodedInputStream r2) {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mo23690g(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnknownFieldSetLite.m13040h(com.google.protobuf.CodedInputStream):com.google.protobuf.UnknownFieldSetLite");
    }

    /* renamed from: k */
    static UnknownFieldSetLite m13041k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.f20711a + unknownFieldSetLite2.f20711a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f20712b, i);
        System.arraycopy(unknownFieldSetLite2.f20712b, 0, copyOf, unknownFieldSetLite.f20711a, unknownFieldSetLite2.f20711a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f20713c, i);
        System.arraycopy(unknownFieldSetLite2.f20713c, 0, copyOf2, unknownFieldSetLite.f20711a, unknownFieldSetLite2.f20711a);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    /* renamed from: l */
    static UnknownFieldSetLite m13042l() {
        return new UnknownFieldSetLite();
    }

    /* renamed from: p */
    private static void m13043p(int i, Object obj, Writer writer) {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            writer.mo23790q(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 1) {
            writer.mo23784k(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 2) {
            writer.mo23795v(tagFieldNumber, (ByteString) obj);
        } else if (tagWireType != 3) {
            if (tagWireType == 5) {
                writer.mo23779f(tagFieldNumber, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.m12802d());
        } else if (writer.mo23785l() == Writer.FieldOrder.ASCENDING) {
            writer.mo23794u(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.mo23766H(tagFieldNumber);
        } else {
            writer.mo23766H(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.mo23794u(tagFieldNumber);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23688a() {
        if (!this.f20715e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.f20711a;
        return i == unknownFieldSetLite.f20711a && m13036c(this.f20712b, unknownFieldSetLite.f20712b, i) && m13037d(this.f20713c, unknownFieldSetLite.f20713c, this.f20711a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo23690g(int i, CodedInputStream codedInputStream) {
        mo23688a();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            mo23698n(i, Long.valueOf(codedInputStream.readInt64()));
            return true;
        } else if (tagWireType == 1) {
            mo23698n(i, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        } else if (tagWireType == 2) {
            mo23698n(i, codedInputStream.readBytes());
            return true;
        } else if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.m13040h(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.m13092a(tagFieldNumber, 4));
            mo23698n(i, unknownFieldSetLite);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                mo23698n(i, Integer.valueOf(codedInputStream.readFixed32()));
                return true;
            }
            throw InvalidProtocolBufferException.m12802d();
        }
    }

    public int getSerializedSize() {
        int i;
        int i2 = this.f20714d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f20711a; i4++) {
            int i5 = this.f20712b[i4];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                i = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.f20713c[i4]).longValue());
            } else if (tagWireType == 1) {
                i = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.f20713c[i4]).longValue());
            } else if (tagWireType == 2) {
                i = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.f20713c[i4]);
            } else if (tagWireType == 3) {
                i = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.f20713c[i4]).getSerializedSize();
            } else if (tagWireType == 5) {
                i = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.f20713c[i4]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.m12802d());
            }
            i3 += i;
        }
        this.f20714d = i3;
        return i3;
    }

    public int getSerializedSizeAsMessageSet() {
        int i = this.f20714d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f20711a; i3++) {
            i2 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.f20712b[i3]), (ByteString) this.f20713c[i3]);
        }
        this.f20714d = i2;
        return i2;
    }

    public int hashCode() {
        int i = this.f20711a;
        return ((((527 + i) * 31) + m13038e(this.f20712b, i)) * 31) + m13039f(this.f20713c, this.f20711a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public UnknownFieldSetLite mo23694i(int i, ByteString byteString) {
        mo23688a();
        if (i != 0) {
            mo23698n(WireFormat.m13092a(i, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public UnknownFieldSetLite mo23695j(int i, int i2) {
        mo23688a();
        if (i != 0) {
            mo23698n(WireFormat.m13092a(i, 0), Long.valueOf((long) i2));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo23696m(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f20711a; i2++) {
            C3768y.m13920c(sb, i, String.valueOf(WireFormat.getTagFieldNumber(this.f20712b[i2])), this.f20713c[i2]);
        }
    }

    public void makeImmutable() {
        this.f20715e = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo23698n(int i, Object obj) {
        mo23688a();
        m13035b();
        int[] iArr = this.f20712b;
        int i2 = this.f20711a;
        iArr[i2] = i;
        this.f20713c[i2] = obj;
        this.f20711a = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo23699o(Writer writer) {
        if (writer.mo23785l() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.f20711a - 1; i >= 0; i--) {
                writer.mo23778e(WireFormat.getTagFieldNumber(this.f20712b[i]), this.f20713c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f20711a; i2++) {
            writer.mo23778e(WireFormat.getTagFieldNumber(this.f20712b[i2]), this.f20713c[i2]);
        }
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.f20711a; i++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.f20712b[i]), (ByteString) this.f20713c[i]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.f20711a; i++) {
            int i2 = this.f20712b[i];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.f20713c[i]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.f20713c[i]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.f20713c[i]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.f20713c[i]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.f20713c[i]).intValue());
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    private UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f20714d = -1;
        this.f20711a = i;
        this.f20712b = iArr;
        this.f20713c = objArr;
        this.f20715e = z;
    }

    public void writeTo(Writer writer) {
        if (this.f20711a != 0) {
            if (writer.mo23785l() == Writer.FieldOrder.ASCENDING) {
                for (int i = 0; i < this.f20711a; i++) {
                    m13043p(this.f20712b[i], this.f20713c[i], writer);
                }
                return;
            }
            for (int i2 = this.f20711a - 1; i2 >= 0; i2--) {
                m13043p(this.f20712b[i2], this.f20713c[i2], writer);
            }
        }
    }
}
