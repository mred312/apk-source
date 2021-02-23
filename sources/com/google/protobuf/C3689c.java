package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;

/* renamed from: com.google.protobuf.c */
/* compiled from: ArrayDecoders */
final class C3689c {

    /* renamed from: com.google.protobuf.c$a */
    /* compiled from: ArrayDecoders */
    static /* synthetic */ class C3690a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20751a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20751a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f20751a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.C3690a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.c$b */
    /* compiled from: ArrayDecoders */
    static final class C3691b {

        /* renamed from: a */
        public int f20752a;

        /* renamed from: b */
        public long f20753b;

        /* renamed from: c */
        public Object f20754c;

        /* renamed from: d */
        public final ExtensionRegistryLite f20755d;

        C3691b(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f20755d = extensionRegistryLite;
        }
    }

    /* renamed from: A */
    static int m13158A(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        int I = m13166I(bArr, i2, bVar);
        oVar.addInt(CodedInputStream.decodeZigZag32(bVar.f20752a));
        while (I < i3) {
            int I2 = m13166I(bArr, I, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            I = m13166I(bArr, I2, bVar);
            oVar.addInt(CodedInputStream.decodeZigZag32(bVar.f20752a));
        }
        return I;
    }

    /* renamed from: B */
    static int m13159B(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        int L = m13169L(bArr, i2, bVar);
        rVar.addLong(CodedInputStream.decodeZigZag64(bVar.f20753b));
        while (L < i3) {
            int I = m13166I(bArr, L, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            L = m13169L(bArr, I, bVar);
            rVar.addLong(CodedInputStream.decodeZigZag64(bVar.f20753b));
        }
        return L;
    }

    /* renamed from: C */
    static int m13160C(byte[] bArr, int i, C3691b bVar) {
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.m12804f();
        } else if (i2 == 0) {
            bVar.f20754c = "";
            return I;
        } else {
            bVar.f20754c = new String(bArr, I, i2, Internal.f20591a);
            return I + i2;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* renamed from: D */
    static int m13161D(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.C3689c.C3691b r9) {
        /*
            int r6 = m13166I(r5, r6, r9)
            int r0 = r9.f20752a
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f20591a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = m13166I(r5, r6, r9)
            int r2 = r9.f20752a
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = m13166I(r5, r0, r9)
            int r0 = r9.f20752a
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f20591a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            goto L_0x004b
        L_0x004a:
            throw r4
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.m13161D(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.c$b):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (com.google.protobuf.C3759u0.m13854u(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.protobuf.Internal.f20591a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw com.google.protobuf.InvalidProtocolBufferException.m12801c();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* renamed from: E */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m13162E(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.C3689c.C3691b r10) {
        /*
            int r7 = m13166I(r6, r7, r10)
            int r0 = r10.f20752a
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.C3759u0.m13854u(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f20591a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = m13166I(r6, r7, r10)
            int r2 = r10.f20752a
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = m13166I(r6, r0, r10)
            int r0 = r10.f20752a
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.C3759u0.m13854u(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f20591a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.m12801c()
            throw r5
        L_0x0054:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.m12801c()
            throw r5
        L_0x005f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            goto L_0x0065
        L_0x0064:
            throw r5
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.m13162E(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.c$b):int");
    }

    /* renamed from: F */
    static int m13163F(byte[] bArr, int i, C3691b bVar) {
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.m12804f();
        } else if (i2 == 0) {
            bVar.f20754c = "";
            return I;
        } else {
            bVar.f20754c = C3759u0.m13841h(bArr, I, i2);
            return I + i2;
        }
    }

    /* renamed from: G */
    static int m13164G(int i, byte[] bArr, int i2, int i3, UnknownFieldSetLite unknownFieldSetLite, C3691b bVar) {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                int L = m13169L(bArr, i2, bVar);
                unknownFieldSetLite.mo23698n(i, Long.valueOf(bVar.f20753b));
                return L;
            } else if (tagWireType == 1) {
                unknownFieldSetLite.mo23698n(i, Long.valueOf(m13181j(bArr, i2)));
                return i2 + 8;
            } else if (tagWireType == 2) {
                int I = m13166I(bArr, i2, bVar);
                int i4 = bVar.f20752a;
                if (i4 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                } else if (i4 <= bArr.length - I) {
                    if (i4 == 0) {
                        unknownFieldSetLite.mo23698n(i, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.mo23698n(i, ByteString.copyFrom(bArr, I, i4));
                    }
                    return I + i4;
                } else {
                    throw InvalidProtocolBufferException.m12808j();
                }
            } else if (tagWireType == 3) {
                UnknownFieldSetLite l = UnknownFieldSetLite.m13042l();
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int I2 = m13166I(bArr, i2, bVar);
                    int i7 = bVar.f20752a;
                    if (i7 == i5) {
                        i6 = i7;
                        i2 = I2;
                        break;
                    }
                    i6 = i7;
                    i2 = m13164G(i7, bArr, I2, i3, l, bVar);
                }
                if (i2 > i3 || i6 != i5) {
                    throw InvalidProtocolBufferException.m12805g();
                }
                unknownFieldSetLite.mo23698n(i, l);
                return i2;
            } else if (tagWireType == 5) {
                unknownFieldSetLite.mo23698n(i, Integer.valueOf(m13179h(bArr, i2)));
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.m12800b();
            }
        } else {
            throw InvalidProtocolBufferException.m12800b();
        }
    }

    /* renamed from: H */
    static int m13165H(int i, byte[] bArr, int i2, C3691b bVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            bVar.f20752a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            bVar.f20752a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            bVar.f20752a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            bVar.f20752a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                bVar.f20752a = i11;
                return i12;
            }
        }
    }

    /* renamed from: I */
    static int m13166I(byte[] bArr, int i, C3691b bVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m13165H(b, bArr, i2, bVar);
        }
        bVar.f20752a = b;
        return i2;
    }

    /* renamed from: J */
    static int m13167J(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        int I = m13166I(bArr, i2, bVar);
        oVar.addInt(bVar.f20752a);
        while (I < i3) {
            int I2 = m13166I(bArr, I, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            I = m13166I(bArr, I2, bVar);
            oVar.addInt(bVar.f20752a);
        }
        return I;
    }

    /* renamed from: K */
    static int m13168K(long j, byte[] bArr, int i, C3691b bVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i3 = 7;
        while (b < 0) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            i3 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i3;
            byte b3 = b2;
            i2 = i4;
            b = b3;
        }
        bVar.f20753b = j2;
        return i2;
    }

    /* renamed from: L */
    static int m13169L(byte[] bArr, int i, C3691b bVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            return m13168K(j, bArr, i2, bVar);
        }
        bVar.f20753b = j;
        return i2;
    }

    /* renamed from: M */
    static int m13170M(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        int L = m13169L(bArr, i2, bVar);
        rVar.addLong(bVar.f20753b);
        while (L < i3) {
            int I = m13166I(bArr, L, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            L = m13169L(bArr, I, bVar);
            rVar.addLong(bVar.f20753b);
        }
        return L;
    }

    /* renamed from: N */
    static int m13171N(int i, byte[] bArr, int i2, int i3, C3691b bVar) {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                return m13169L(bArr, i2, bVar);
            }
            if (tagWireType == 1) {
                return i2 + 8;
            }
            if (tagWireType == 2) {
                return m13166I(bArr, i2, bVar) + bVar.f20752a;
            }
            if (tagWireType == 3) {
                int i4 = (i & -8) | 4;
                int i5 = 0;
                while (i2 < i3) {
                    i2 = m13166I(bArr, i2, bVar);
                    i5 = bVar.f20752a;
                    if (i5 == i4) {
                        break;
                    }
                    i2 = m13171N(i5, bArr, i2, i3, bVar);
                }
                if (i2 <= i3 && i5 == i4) {
                    return i2;
                }
                throw InvalidProtocolBufferException.m12805g();
            } else if (tagWireType == 5) {
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.m12800b();
            }
        } else {
            throw InvalidProtocolBufferException.m12800b();
        }
    }

    /* renamed from: a */
    static int m13172a(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3697e eVar = (C3697e) protobufList;
        int L = m13169L(bArr, i2, bVar);
        eVar.addBoolean(bVar.f20753b != 0);
        while (L < i3) {
            int I = m13166I(bArr, L, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            L = m13169L(bArr, I, bVar);
            eVar.addBoolean(bVar.f20753b != 0);
        }
        return L;
    }

    /* renamed from: b */
    static int m13173b(byte[] bArr, int i, C3691b bVar) {
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.m12804f();
        } else if (i2 > bArr.length - I) {
            throw InvalidProtocolBufferException.m12808j();
        } else if (i2 == 0) {
            bVar.f20754c = ByteString.EMPTY;
            return I;
        } else {
            bVar.f20754c = ByteString.copyFrom(bArr, I, i2);
            return I + i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m13174c(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.C3689c.C3691b r7) {
        /*
            int r4 = m13166I(r3, r4, r7)
            int r0 = r7.f20752a
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = m13166I(r3, r4, r7)
            int r1 = r7.f20752a
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = m13166I(r3, r0, r7)
            int r0 = r7.f20752a
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m12808j()
            throw r2
        L_0x0048:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m12808j()
            throw r2
        L_0x0053:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
            goto L_0x0059
        L_0x0058:
            throw r2
        L_0x0059:
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.m13174c(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.c$b):int");
    }

    /* renamed from: d */
    static double m13175d(byte[] bArr, int i) {
        return Double.longBitsToDouble(m13181j(bArr, i));
    }

    /* renamed from: e */
    static int m13176e(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3706h hVar = (C3706h) protobufList;
        hVar.addDouble(m13175d(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = m13166I(bArr, i4, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            hVar.addDouble(m13175d(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ff, code lost:
        r9 = r9 + 8;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m13177f(int r7, byte[] r8, int r9, int r10, com.google.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r12, com.google.protobuf.C3746r0<com.google.protobuf.UnknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite> r13, com.google.protobuf.C3689c.C3691b r14) {
        /*
            com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$b> r0 = r11.extensions
            int r7 = r7 >>> 3
            com.google.protobuf.GeneratedMessageLite$b r1 = r12.f20572d
            boolean r1 = r1.isRepeated()
            r2 = 0
            if (r1 == 0) goto L_0x00fb
            com.google.protobuf.GeneratedMessageLite$b r1 = r12.f20572d
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L_0x00fb
            int[] r10 = com.google.protobuf.C3689c.C3690a.f20751a
            com.google.protobuf.WireFormat$FieldType r1 = r12.getLiteType()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00ab;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x008b;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            com.google.protobuf.o r10 = new com.google.protobuf.o
            r10.<init>()
            int r8 = m13196y(r8, r9, r10, r14)
            com.google.protobuf.UnknownFieldSetLite r9 = r11.unknownFields
            com.google.protobuf.UnknownFieldSetLite r14 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            com.google.protobuf.Internal$EnumLiteMap r9 = r9.getEnumType()
            java.lang.Object r7 = com.google.protobuf.C3726o0.m13580z(r7, r10, r9, r2, r13)
            com.google.protobuf.UnknownFieldSetLite r7 = (com.google.protobuf.UnknownFieldSetLite) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            com.google.protobuf.GeneratedMessageLite$b r7 = r12.f20572d
            r0.mo23278C(r7, r10)
            goto L_0x0234
        L_0x006b:
            com.google.protobuf.r r7 = new com.google.protobuf.r
            r7.<init>()
            int r8 = m13195x(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x007b:
            com.google.protobuf.o r7 = new com.google.protobuf.o
            r7.<init>()
            int r8 = m13194w(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x008b:
            com.google.protobuf.e r7 = new com.google.protobuf.e
            r7.<init>()
            int r8 = m13189r(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x009b:
            com.google.protobuf.o r7 = new com.google.protobuf.o
            r7.<init>()
            int r8 = m13191t(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00ab:
            com.google.protobuf.r r7 = new com.google.protobuf.r
            r7.<init>()
            int r8 = m13192u(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00bb:
            com.google.protobuf.o r7 = new com.google.protobuf.o
            r7.<init>()
            int r8 = m13196y(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00cb:
            com.google.protobuf.r r7 = new com.google.protobuf.r
            r7.<init>()
            int r8 = m13197z(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00db:
            com.google.protobuf.m r7 = new com.google.protobuf.m
            r7.<init>()
            int r8 = m13193v(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00eb:
            com.google.protobuf.h r7 = new com.google.protobuf.h
            r7.<init>()
            int r8 = m13190s(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$b r9 = r12.f20572d
            r0.mo23278C(r9, r7)
            goto L_0x0234
        L_0x00fb:
            com.google.protobuf.WireFormat$FieldType r1 = r12.getLiteType()
            com.google.protobuf.WireFormat$FieldType r3 = com.google.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0131
            int r9 = m13166I(r8, r9, r14)
            com.google.protobuf.GeneratedMessageLite$b r8 = r12.f20572d
            com.google.protobuf.Internal$EnumLiteMap r8 = r8.getEnumType()
            int r10 = r14.f20752a
            com.google.protobuf.Internal$EnumLite r8 = r8.findValueByNumber(r10)
            if (r8 != 0) goto L_0x0129
            com.google.protobuf.UnknownFieldSetLite r8 = r11.unknownFields
            com.google.protobuf.UnknownFieldSetLite r10 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r8 != r10) goto L_0x0123
            com.google.protobuf.UnknownFieldSetLite r8 = com.google.protobuf.UnknownFieldSetLite.m13042l()
            r11.unknownFields = r8
        L_0x0123:
            int r10 = r14.f20752a
            com.google.protobuf.C3726o0.m13535L(r7, r10, r8, r13)
            return r9
        L_0x0129:
            int r7 = r14.f20752a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x0131:
            int[] r11 = com.google.protobuf.C3689c.C3690a.f20751a
            com.google.protobuf.WireFormat$FieldType r13 = r12.getLiteType()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ec;
                case 3: goto L_0x01e1;
                case 4: goto L_0x01e1;
                case 5: goto L_0x01d6;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01cd;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01c4;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a1;
                case 13: goto L_0x0192;
                case 14: goto L_0x018a;
                case 15: goto L_0x0182;
                case 16: goto L_0x017a;
                case 17: goto L_0x015a;
                case 18: goto L_0x0142;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0201
        L_0x0142:
            com.google.protobuf.h0 r7 = com.google.protobuf.C3707h0.m13389a()
            com.google.protobuf.MessageLite r11 = r12.getMessageDefaultInstance()
            java.lang.Class r11 = r11.getClass()
            com.google.protobuf.m0 r7 = r7.mo23886d(r11)
            int r9 = m13187p(r7, r8, r9, r10, r14)
            java.lang.Object r2 = r14.f20754c
            goto L_0x0201
        L_0x015a:
            int r7 = r7 << 3
            r5 = r7 | 4
            com.google.protobuf.h0 r7 = com.google.protobuf.C3707h0.m13389a()
            com.google.protobuf.MessageLite r11 = r12.getMessageDefaultInstance()
            java.lang.Class r11 = r11.getClass()
            com.google.protobuf.m0 r1 = r7.mo23886d(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = m13185n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r14.f20754c
            goto L_0x0201
        L_0x017a:
            int r9 = m13160C(r8, r9, r14)
            java.lang.Object r2 = r14.f20754c
            goto L_0x0201
        L_0x0182:
            int r9 = m13173b(r8, r9, r14)
            java.lang.Object r2 = r14.f20754c
            goto L_0x0201
        L_0x018a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0192:
            int r9 = m13169L(r8, r9, r14)
            long r7 = r14.f20753b
            long r7 = com.google.protobuf.CodedInputStream.decodeZigZag64(r7)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01a1:
            int r9 = m13166I(r8, r9, r14)
            int r7 = r14.f20752a
            int r7 = com.google.protobuf.CodedInputStream.decodeZigZag32(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01b0:
            int r9 = m13169L(r8, r9, r14)
            long r7 = r14.f20753b
            r10 = 0
            int r13 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x01be
            r7 = 1
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x0201
        L_0x01c4:
            int r7 = m13179h(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x01f4
        L_0x01cd:
            long r7 = m13181j(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x01ff
        L_0x01d6:
            int r9 = m13166I(r8, r9, r14)
            int r7 = r14.f20752a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01e1:
            int r9 = m13169L(r8, r9, r14)
            long r7 = r14.f20753b
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01ec:
            float r7 = m13183l(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
        L_0x01f4:
            int r9 = r9 + 4
            goto L_0x0201
        L_0x01f7:
            double r7 = m13175d(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
        L_0x01ff:
            int r9 = r9 + 8
        L_0x0201:
            boolean r7 = r12.isRepeated()
            if (r7 == 0) goto L_0x020d
            com.google.protobuf.GeneratedMessageLite$b r7 = r12.f20572d
            r0.mo23280a(r7, r2)
            goto L_0x0233
        L_0x020d:
            int[] r7 = com.google.protobuf.C3689c.C3690a.f20751a
            com.google.protobuf.WireFormat$FieldType r8 = r12.getLiteType()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x0222
            r8 = 18
            if (r7 == r8) goto L_0x0222
            goto L_0x022e
        L_0x0222:
            com.google.protobuf.GeneratedMessageLite$b r7 = r12.f20572d
            java.lang.Object r7 = r0.mo23287j(r7)
            if (r7 == 0) goto L_0x022e
            java.lang.Object r2 = com.google.protobuf.Internal.m12793d(r7, r2)
        L_0x022e:
            com.google.protobuf.GeneratedMessageLite$b r7 = r12.f20572d
            r0.mo23278C(r7, r2)
        L_0x0233:
            r8 = r9
        L_0x0234:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.m13177f(int, byte[], int, int, com.google.protobuf.GeneratedMessageLite$ExtendableMessage, com.google.protobuf.GeneratedMessageLite$GeneratedExtension, com.google.protobuf.r0, com.google.protobuf.c$b):int");
    }

    /* renamed from: g */
    static int m13178g(int i, byte[] bArr, int i2, int i3, Object obj, MessageLite messageLite, C3746r0<UnknownFieldSetLite, UnknownFieldSetLite> r0Var, C3691b bVar) {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = bVar.f20755d.findLiteExtensionByNumber(messageLite, i >>> 3);
        if (findLiteExtensionByNumber == null) {
            return m13164G(i, bArr, i2, i3, C3769z.m13982w(obj), bVar);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.mo23362r();
        return m13177f(i, bArr, i2, i3, extendableMessage, findLiteExtensionByNumber, r0Var, bVar);
    }

    /* renamed from: h */
    static int m13179h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: i */
    static int m13180i(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        oVar.addInt(m13179h(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = m13166I(bArr, i4, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            oVar.addInt(m13179h(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    /* renamed from: j */
    static long m13181j(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* renamed from: k */
    static int m13182k(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        rVar.addLong(m13181j(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = m13166I(bArr, i4, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            rVar.addLong(m13181j(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* renamed from: l */
    static float m13183l(byte[] bArr, int i) {
        return Float.intBitsToFloat(m13179h(bArr, i));
    }

    /* renamed from: m */
    static int m13184m(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3721m mVar = (C3721m) protobufList;
        mVar.addFloat(m13183l(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = m13166I(bArr, i4, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            mVar.addFloat(m13183l(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    /* renamed from: n */
    static int m13185n(C3722m0 m0Var, byte[] bArr, int i, int i2, int i3, C3691b bVar) {
        C3769z zVar = (C3769z) m0Var;
        Object c = zVar.mo23804c();
        int d0 = zVar.mo24077d0(c, bArr, i, i2, i3, bVar);
        zVar.mo23807f(c);
        bVar.f20754c = c;
        return d0;
    }

    /* renamed from: o */
    static int m13186o(C3722m0 m0Var, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        int i4 = (i & -8) | 4;
        int n = m13185n(m0Var, bArr, i2, i3, i4, bVar);
        protobufList.add(bVar.f20754c);
        while (n < i3) {
            int I = m13166I(bArr, n, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            n = m13185n(m0Var, bArr, I, i3, i4, bVar);
            protobufList.add(bVar.f20754c);
        }
        return n;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m13187p(com.google.protobuf.C3722m0 r6, byte[] r7, int r8, int r9, com.google.protobuf.C3689c.C3691b r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = m13165H(r8, r7, r0, r10)
            int r8 = r10.f20752a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.mo23804c()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.mo23810i(r1, r2, r3, r4, r5)
            r6.mo23807f(r9)
            r10.f20754c = r9
            return r8
        L_0x0025:
            com.google.protobuf.InvalidProtocolBufferException r6 = com.google.protobuf.InvalidProtocolBufferException.m12808j()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3689c.m13187p(com.google.protobuf.m0, byte[], int, int, com.google.protobuf.c$b):int");
    }

    /* renamed from: q */
    static int m13188q(C3722m0<?> m0Var, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        int p = m13187p(m0Var, bArr, i2, i3, bVar);
        protobufList.add(bVar.f20754c);
        while (p < i3) {
            int I = m13166I(bArr, p, bVar);
            if (i != bVar.f20752a) {
                break;
            }
            p = m13187p(m0Var, bArr, I, i3, bVar);
            protobufList.add(bVar.f20754c);
        }
        return p;
    }

    /* renamed from: r */
    static int m13189r(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3697e eVar = (C3697e) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            I = m13169L(bArr, I, bVar);
            eVar.addBoolean(bVar.f20753b != 0);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: s */
    static int m13190s(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3706h hVar = (C3706h) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            hVar.addDouble(m13175d(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: t */
    static int m13191t(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            oVar.addInt(m13179h(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: u */
    static int m13192u(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            rVar.addLong(m13181j(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: v */
    static int m13193v(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3721m mVar = (C3721m) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            mVar.addFloat(m13183l(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: w */
    static int m13194w(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            I = m13166I(bArr, I, bVar);
            oVar.addInt(CodedInputStream.decodeZigZag32(bVar.f20752a));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: x */
    static int m13195x(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            I = m13169L(bArr, I, bVar);
            rVar.addLong(CodedInputStream.decodeZigZag64(bVar.f20753b));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: y */
    static int m13196y(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3725o oVar = (C3725o) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            I = m13166I(bArr, I, bVar);
            oVar.addInt(bVar.f20752a);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }

    /* renamed from: z */
    static int m13197z(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, C3691b bVar) {
        C3745r rVar = (C3745r) protobufList;
        int I = m13166I(bArr, i, bVar);
        int i2 = bVar.f20752a + I;
        while (I < i2) {
            I = m13169L(bArr, I, bVar);
            rVar.addLong(bVar.f20753b);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.m12808j();
    }
}
