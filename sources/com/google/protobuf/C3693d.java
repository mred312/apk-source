package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.google.protobuf.d */
/* compiled from: BinaryReader */
abstract class C3693d implements C3714k0 {

    /* renamed from: com.google.protobuf.d$a */
    /* compiled from: BinaryReader */
    static /* synthetic */ class C3694a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20756a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20756a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20756a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3693d.C3694a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.d$b */
    /* compiled from: BinaryReader */
    private static final class C3695b extends C3693d {

        /* renamed from: a */
        private final boolean f20757a;

        /* renamed from: b */
        private final byte[] f20758b;

        /* renamed from: c */
        private int f20759c;

        /* renamed from: d */
        private int f20760d;

        /* renamed from: e */
        private int f20761e;

        /* renamed from: f */
        private int f20762f;

        public C3695b(ByteBuffer byteBuffer, boolean z) {
            super((C3694a) null);
            this.f20757a = z;
            this.f20758b = byteBuffer.array();
            this.f20759c = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f20760d = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        /* renamed from: Q */
        private boolean m13200Q() {
            return this.f20759c == this.f20760d;
        }

        /* renamed from: R */
        private byte m13201R() {
            int i = this.f20759c;
            if (i != this.f20760d) {
                byte[] bArr = this.f20758b;
                this.f20759c = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        /* renamed from: S */
        private Object m13202S(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (C3694a.f20756a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(mo23843l());
                case 2:
                    return mo23818F();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(mo23855v());
                case 5:
                    return Integer.valueOf(mo23842k());
                case 6:
                    return Long.valueOf(mo23832c());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(mo23820H());
                case 9:
                    return Long.valueOf(mo23825M());
                case 10:
                    return mo23841j(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(mo23822J());
                case 12:
                    return Long.valueOf(mo23845n());
                case 13:
                    return Integer.valueOf(mo23857x());
                case 14:
                    return Long.valueOf(mo23858y());
                case 15:
                    return mo23826N();
                case 16:
                    return Integer.valueOf(mo23848q());
                case 17:
                    return Long.valueOf(mo23831b());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        /* renamed from: T */
        private <T> T m13203T(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            int i = this.f20762f;
            this.f20762f = WireFormat.m13092a(WireFormat.getTagFieldNumber(this.f20761e), 4);
            try {
                T c = m0Var.mo23804c();
                m0Var.mo23809h(c, this, extensionRegistryLite);
                m0Var.mo23807f(c);
                if (this.f20761e == this.f20762f) {
                    return c;
                }
                throw InvalidProtocolBufferException.m12805g();
            } finally {
                this.f20762f = i;
            }
        }

        /* renamed from: U */
        private int m13204U() {
            m13211e0(4);
            return m13205V();
        }

        /* renamed from: V */
        private int m13205V() {
            int i = this.f20759c;
            byte[] bArr = this.f20758b;
            this.f20759c = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        /* renamed from: W */
        private long m13206W() {
            m13211e0(8);
            return m13207X();
        }

        /* renamed from: X */
        private long m13207X() {
            int i = this.f20759c;
            byte[] bArr = this.f20758b;
            this.f20759c = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        /* renamed from: Y */
        private <T> T m13208Y(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            int b0 = m13209b0();
            m13211e0(b0);
            int i = this.f20760d;
            int i2 = this.f20759c + b0;
            this.f20760d = i2;
            try {
                T c = m0Var.mo23804c();
                m0Var.mo23809h(c, this, extensionRegistryLite);
                m0Var.mo23807f(c);
                if (this.f20759c == i2) {
                    return c;
                }
                throw InvalidProtocolBufferException.m12805g();
            } finally {
                this.f20760d = i;
            }
        }

        /* renamed from: b0 */
        private int m13209b0() {
            byte b;
            int i = this.f20759c;
            int i2 = this.f20760d;
            if (i2 != i) {
                byte[] bArr = this.f20758b;
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.f20759c = i3;
                    return b2;
                } else if (i2 - i3 < 9) {
                    return (int) m13210d0();
                } else {
                    int i4 = i3 + 1;
                    byte b3 = b2 ^ (bArr[i3] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i5 = i4 + 1;
                        byte b4 = b3 ^ (bArr[i4] << 14);
                        if (b4 >= 0) {
                            b = b4 ^ 16256;
                        } else {
                            i4 = i5 + 1;
                            byte b5 = b4 ^ (bArr[i5] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                i5 = i4 + 1;
                                byte b6 = bArr[i4];
                                b = (b5 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    i4 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i4 + 1;
                                        if (bArr[i4] < 0) {
                                            i4 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i4 + 1;
                                                if (bArr[i4] < 0) {
                                                    i4 = i5 + 1;
                                                    if (bArr[i5] < 0) {
                                                        throw InvalidProtocolBufferException.m12803e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = i5;
                    }
                    this.f20759c = i4;
                    return b;
                }
            } else {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        /* renamed from: d0 */
        private long m13210d0() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte R = m13201R();
                j |= ((long) (R & Byte.MAX_VALUE)) << i;
                if ((R & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: e0 */
        private void m13211e0(int i) {
            if (i < 0 || i > this.f20760d - this.f20759c) {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        /* renamed from: f0 */
        private void m13212f0(int i) {
            if (this.f20759c != i) {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        /* renamed from: g0 */
        private void m13213g0(int i) {
            if (WireFormat.getTagWireType(this.f20761e) != i) {
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /* renamed from: h0 */
        private void m13214h0(int i) {
            m13211e0(i);
            this.f20759c += i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* renamed from: i0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m13215i0() {
            /*
                r3 = this;
                int r0 = r3.f20762f
                int r1 = r3.f20761e
                int r1 = com.google.protobuf.WireFormat.getTagFieldNumber(r1)
                r2 = 4
                int r1 = com.google.protobuf.WireFormat.m13092a(r1, r2)
                r3.f20762f = r1
            L_0x000f:
                int r1 = r3.mo23814B()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.mo23821I()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f20761e
                int r2 = r3.f20762f
                if (r1 != r2) goto L_0x0027
                r3.f20762f = r0
                return
            L_0x0027:
                com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
                goto L_0x002d
            L_0x002c:
                throw r0
            L_0x002d:
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3693d.C3695b.m13215i0():void");
        }

        /* renamed from: j0 */
        private void m13216j0() {
            int i = this.f20760d;
            int i2 = this.f20759c;
            if (i - i2 >= 10) {
                byte[] bArr = this.f20758b;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.f20759c = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            m13217k0();
        }

        /* renamed from: k0 */
        private void m13217k0() {
            int i = 0;
            while (i < 10) {
                if (m13201R() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: l0 */
        private void m13218l0(int i) {
            m13211e0(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.m12805g();
            }
        }

        /* renamed from: m0 */
        private void m13219m0(int i) {
            m13211e0(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.m12805g();
            }
        }

        /* renamed from: A */
        public <T> T mo23813A(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            m13213g0(3);
            return m13203T(C3707h0.m13389a().mo23886d(cls), extensionRegistryLite);
        }

        /* renamed from: B */
        public int mo23814B() {
            if (m13200Q()) {
                return Integer.MAX_VALUE;
            }
            int b0 = m13209b0();
            this.f20761e = b0;
            if (b0 == this.f20762f) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(b0);
        }

        /* renamed from: C */
        public <T> T mo23815C(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            m13213g0(2);
            return m13208Y(m0Var, extensionRegistryLite);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(2:22|35)(3:30|23|24)) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (mo23821I() != false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
            throw new com.google.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* renamed from: D */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void mo23816D(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.C3657b<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) {
            /*
                r7 = this;
                r0 = 2
                r7.m13213g0(r0)
                int r1 = r7.m13209b0()
                r7.m13211e0(r1)
                int r2 = r7.f20760d
                int r3 = r7.f20759c
                int r3 = r3 + r1
                r7.f20760d = r3
                K r1 = r9.f20629b     // Catch:{ all -> 0x005b }
                V r3 = r9.f20631d     // Catch:{ all -> 0x005b }
            L_0x0016:
                int r4 = r7.mo23814B()     // Catch:{ all -> 0x005b }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0025
                r8.put(r1, r3)     // Catch:{ all -> 0x005b }
                r7.f20760d = r2
                return
            L_0x0025:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0046
                if (r4 == r0) goto L_0x0039
                boolean r4 = r7.mo23821I()     // Catch:{ InvalidWireTypeException -> 0x004e }
                if (r4 == 0) goto L_0x0033
                goto L_0x0016
            L_0x0033:
                com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004e }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004e }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x004e }
            L_0x0039:
                com.google.protobuf.WireFormat$FieldType r4 = r9.f20630c     // Catch:{ InvalidWireTypeException -> 0x004e }
                V r5 = r9.f20631d     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Object r3 = r7.m13202S(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x0046:
                com.google.protobuf.WireFormat$FieldType r4 = r9.f20628a     // Catch:{ InvalidWireTypeException -> 0x004e }
                r5 = 0
                java.lang.Object r1 = r7.m13202S(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x004e:
                boolean r4 = r7.mo23821I()     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x0055
                goto L_0x0016
            L_0x0055:
                com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x005b }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x005b }
                throw r8     // Catch:{ all -> 0x005b }
            L_0x005b:
                r8 = move-exception
                r7.f20760d = r2
                goto L_0x0060
            L_0x005f:
                throw r8
            L_0x0060:
                goto L_0x005f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3693d.C3695b.mo23816D(java.util.Map, com.google.protobuf.MapEntryLite$b, com.google.protobuf.ExtensionRegistryLite):void");
        }

        /* renamed from: E */
        public void mo23817E(List<String> list) {
            mo23830a0(list, true);
        }

        /* renamed from: F */
        public ByteString mo23818F() {
            ByteString byteString;
            m13213g0(2);
            int b0 = m13209b0();
            if (b0 == 0) {
                return ByteString.EMPTY;
            }
            m13211e0(b0);
            if (this.f20757a) {
                byteString = ByteString.m12413l(this.f20758b, this.f20759c, b0);
            } else {
                byteString = ByteString.copyFrom(this.f20758b, this.f20759c, b0);
            }
            this.f20759c += b0;
            return byteString;
        }

        /* renamed from: G */
        public void mo23819G(List<Float> list) {
            int i;
            int i2;
            if (list instanceof C3721m) {
                C3721m mVar = (C3721m) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13218l0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        mVar.addFloat(Float.intBitsToFloat(m13205V()));
                    }
                } else if (tagWireType == 5) {
                    do {
                        mVar.addFloat(readFloat());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13218l0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Float.valueOf(Float.intBitsToFloat(m13205V())));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: H */
        public int mo23820H() {
            m13213g0(0);
            return m13209b0();
        }

        /* renamed from: I */
        public boolean mo23821I() {
            int i;
            if (m13200Q() || (i = this.f20761e) == this.f20762f) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                m13216j0();
                return true;
            } else if (tagWireType == 1) {
                m13214h0(8);
                return true;
            } else if (tagWireType == 2) {
                m13214h0(m13209b0());
                return true;
            } else if (tagWireType == 3) {
                m13215i0();
                return true;
            } else if (tagWireType == 5) {
                m13214h0(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /* renamed from: J */
        public int mo23822J() {
            m13213g0(5);
            return m13204U();
        }

        /* renamed from: K */
        public void mo23823K(List<ByteString> list) {
            int i;
            if (WireFormat.getTagWireType(this.f20761e) == 2) {
                do {
                    list.add(mo23818F());
                    if (!m13200Q()) {
                        i = this.f20759c;
                    } else {
                        return;
                    }
                } while (m13209b0() == this.f20761e);
                this.f20759c = i;
                return;
            }
            throw InvalidProtocolBufferException.m12802d();
        }

        /* renamed from: L */
        public void mo23824L(List<Double> list) {
            int i;
            int i2;
            if (list instanceof C3706h) {
                C3706h hVar = (C3706h) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 1) {
                    do {
                        hVar.addDouble(readDouble());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13219m0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        hVar.addDouble(Double.longBitsToDouble(m13207X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13219m0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Double.valueOf(Double.longBitsToDouble(m13207X())));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: M */
        public long mo23825M() {
            m13213g0(0);
            return mo23833c0();
        }

        /* renamed from: N */
        public String mo23826N() {
            return mo23828Z(true);
        }

        /* renamed from: O */
        public void mo23827O(List<Long> list) {
            int i;
            int i2;
            if (list instanceof C3745r) {
                C3745r rVar = (C3745r) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 1) {
                    do {
                        rVar.addLong(mo23832c());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13219m0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        rVar.addLong(m13207X());
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(mo23832c()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13219m0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Long.valueOf(m13207X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: Z */
        public String mo23828Z(boolean z) {
            m13213g0(2);
            int b0 = m13209b0();
            if (b0 == 0) {
                return "";
            }
            m13211e0(b0);
            if (z) {
                byte[] bArr = this.f20758b;
                int i = this.f20759c;
                if (!C3759u0.m13854u(bArr, i, i + b0)) {
                    throw InvalidProtocolBufferException.m12801c();
                }
            }
            String str = new String(this.f20758b, this.f20759c, b0, Internal.f20591a);
            this.f20759c += b0;
            return str;
        }

        /* renamed from: a */
        public void mo23829a(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        oVar.addInt(mo23857x());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        oVar.addInt(CodedInputStream.decodeZigZag32(m13209b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(mo23857x()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(m13209b0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: a0 */
        public void mo23830a0(List<String> list, boolean z) {
            int i;
            int i2;
            if (WireFormat.getTagWireType(this.f20761e) != 2) {
                throw InvalidProtocolBufferException.m12802d();
            } else if (!(list instanceof LazyStringList) || z) {
                do {
                    list.add(mo23828Z(z));
                    if (!m13200Q()) {
                        i = this.f20759c;
                    } else {
                        return;
                    }
                } while (m13209b0() == this.f20761e);
                this.f20759c = i;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(mo23818F());
                    if (!m13200Q()) {
                        i2 = this.f20759c;
                    } else {
                        return;
                    }
                } while (m13209b0() == this.f20761e);
                this.f20759c = i2;
            }
        }

        /* renamed from: b */
        public long mo23831b() {
            m13213g0(0);
            return mo23833c0();
        }

        /* renamed from: c */
        public long mo23832c() {
            m13213g0(1);
            return m13206W();
        }

        /* renamed from: c0 */
        public long mo23833c0() {
            long j;
            int i;
            long j2;
            long j3;
            long j4;
            byte b;
            int i2 = this.f20759c;
            int i3 = this.f20760d;
            if (i3 != i2) {
                byte[] bArr = this.f20758b;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f20759c = i4;
                    return (long) b2;
                } else if (i3 - i4 < 9) {
                    return m13210d0();
                } else {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << 14);
                        if (b4 >= 0) {
                            i = i6;
                            j = (long) (b4 ^ 16256);
                        } else {
                            i5 = i6 + 1;
                            byte b5 = b4 ^ (bArr[i6] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                long j5 = (long) b5;
                                int i7 = i5 + 1;
                                long j6 = j5 ^ (((long) bArr[i5]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i = i7 + 1;
                                    long j7 = j6 ^ (((long) bArr[i7]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i7 = i + 1;
                                        j6 = j7 ^ (((long) bArr[i]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i = i7 + 1;
                                            j7 = j6 ^ (((long) bArr[i7]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i8 = i + 1;
                                                j2 = (j7 ^ (((long) bArr[i]) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    i = i8 + 1;
                                                    if (((long) bArr[i8]) < 0) {
                                                        throw InvalidProtocolBufferException.m12803e();
                                                    }
                                                } else {
                                                    i = i8;
                                                }
                                                j = j2;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    j = j2;
                                }
                                j = j4 ^ j6;
                                i = i7;
                            }
                        }
                        this.f20759c = i;
                        return j;
                    }
                    j = (long) b;
                    this.f20759c = i;
                    return j;
                }
            } else {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        /* renamed from: d */
        public void mo23834d(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13218l0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        oVar.addInt(m13205V());
                    }
                } else if (tagWireType == 5) {
                    do {
                        oVar.addInt(mo23822J());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13218l0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Integer.valueOf(m13205V()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(mo23822J()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: e */
        public String mo23835e() {
            return mo23828Z(false);
        }

        /* renamed from: f */
        public void mo23836f(List<String> list) {
            mo23830a0(list, false);
        }

        /* renamed from: g */
        public void mo23837g(List<Long> list) {
            int i;
            int i2;
            if (list instanceof C3745r) {
                C3745r rVar = (C3745r) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        rVar.addLong(mo23858y());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        rVar.addLong(CodedInputStream.decodeZigZag64(mo23833c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(mo23858y()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(mo23833c0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        public int getTag() {
            return this.f20761e;
        }

        /* renamed from: h */
        public <T> void mo23839h(List<T> list, C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            int i;
            if (WireFormat.getTagWireType(this.f20761e) == 3) {
                int i2 = this.f20761e;
                do {
                    list.add(m13203T(m0Var, extensionRegistryLite));
                    if (!m13200Q()) {
                        i = this.f20759c;
                    } else {
                        return;
                    }
                } while (m13209b0() == i2);
                this.f20759c = i;
                return;
            }
            throw InvalidProtocolBufferException.m12802d();
        }

        /* renamed from: i */
        public void mo23840i(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        oVar.addInt(mo23848q());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        oVar.addInt(m13209b0());
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(mo23848q()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Integer.valueOf(m13209b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: j */
        public <T> T mo23841j(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            m13213g0(2);
            return m13208Y(C3707h0.m13389a().mo23886d(cls), extensionRegistryLite);
        }

        /* renamed from: k */
        public int mo23842k() {
            m13213g0(5);
            return m13204U();
        }

        /* renamed from: l */
        public boolean mo23843l() {
            m13213g0(0);
            if (m13209b0() != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: m */
        public <T> void mo23844m(List<T> list, C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            int i;
            if (WireFormat.getTagWireType(this.f20761e) == 2) {
                int i2 = this.f20761e;
                do {
                    list.add(m13208Y(m0Var, extensionRegistryLite));
                    if (!m13200Q()) {
                        i = this.f20759c;
                    } else {
                        return;
                    }
                } while (m13209b0() == i2);
                this.f20759c = i;
                return;
            }
            throw InvalidProtocolBufferException.m12802d();
        }

        /* renamed from: n */
        public long mo23845n() {
            m13213g0(1);
            return m13206W();
        }

        /* renamed from: o */
        public void mo23846o(List<Long> list) {
            int i;
            int i2;
            if (list instanceof C3745r) {
                C3745r rVar = (C3745r) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        rVar.addLong(mo23831b());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        rVar.addLong(mo23833c0());
                    }
                    m13212f0(b0);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(mo23831b()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Long.valueOf(mo23833c0()));
                    }
                    m13212f0(b02);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: p */
        public <T> T mo23847p(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
            m13213g0(3);
            return m13203T(m0Var, extensionRegistryLite);
        }

        /* renamed from: q */
        public int mo23848q() {
            m13213g0(0);
            return m13209b0();
        }

        /* renamed from: r */
        public void mo23849r(List<Long> list) {
            int i;
            int i2;
            if (list instanceof C3745r) {
                C3745r rVar = (C3745r) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        rVar.addLong(mo23825M());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        rVar.addLong(mo23833c0());
                    }
                    m13212f0(b0);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(mo23825M()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Long.valueOf(mo23833c0()));
                    }
                    m13212f0(b02);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        public double readDouble() {
            m13213g0(1);
            return Double.longBitsToDouble(m13206W());
        }

        public float readFloat() {
            m13213g0(5);
            return Float.intBitsToFloat(m13204U());
        }

        /* renamed from: s */
        public void mo23852s(List<Long> list) {
            int i;
            int i2;
            if (list instanceof C3745r) {
                C3745r rVar = (C3745r) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 1) {
                    do {
                        rVar.addLong(mo23845n());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13219m0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        rVar.addLong(m13207X());
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(mo23845n()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13219m0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Long.valueOf(m13207X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: t */
        public void mo23853t(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        oVar.addInt(mo23820H());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        oVar.addInt(m13209b0());
                    }
                    m13212f0(b0);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(mo23820H()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Integer.valueOf(m13209b0()));
                    }
                    m13212f0(b02);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: u */
        public void mo23854u(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        oVar.addInt(mo23855v());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        oVar.addInt(m13209b0());
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(mo23855v()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Integer.valueOf(m13209b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: v */
        public int mo23855v() {
            m13213g0(0);
            return m13209b0();
        }

        /* renamed from: w */
        public void mo23856w(List<Integer> list) {
            int i;
            int i2;
            if (list instanceof C3725o) {
                C3725o oVar = (C3725o) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 2) {
                    int b0 = m13209b0();
                    m13218l0(b0);
                    int i3 = this.f20759c + b0;
                    while (this.f20759c < i3) {
                        oVar.addInt(m13205V());
                    }
                } else if (tagWireType == 5) {
                    do {
                        oVar.addInt(mo23842k());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 2) {
                    int b02 = m13209b0();
                    m13218l0(b02);
                    int i4 = this.f20759c + b02;
                    while (this.f20759c < i4) {
                        list.add(Integer.valueOf(m13205V()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(mo23842k()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }

        /* renamed from: x */
        public int mo23857x() {
            m13213g0(0);
            return CodedInputStream.decodeZigZag32(m13209b0());
        }

        /* renamed from: y */
        public long mo23858y() {
            m13213g0(0);
            return CodedInputStream.decodeZigZag64(mo23833c0());
        }

        /* renamed from: z */
        public void mo23859z(List<Boolean> list) {
            int i;
            int i2;
            if (list instanceof C3697e) {
                C3697e eVar = (C3697e) list;
                int tagWireType = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType == 0) {
                    do {
                        eVar.addBoolean(mo23843l());
                        if (!m13200Q()) {
                            i2 = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i2;
                } else if (tagWireType == 2) {
                    int b0 = this.f20759c + m13209b0();
                    while (this.f20759c < b0) {
                        eVar.addBoolean(m13209b0() != 0);
                    }
                    m13212f0(b0);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.f20761e);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Boolean.valueOf(mo23843l()));
                        if (!m13200Q()) {
                            i = this.f20759c;
                        } else {
                            return;
                        }
                    } while (m13209b0() == this.f20761e);
                    this.f20759c = i;
                } else if (tagWireType2 == 2) {
                    int b02 = this.f20759c + m13209b0();
                    while (this.f20759c < b02) {
                        list.add(Boolean.valueOf(m13209b0() != 0));
                    }
                    m13212f0(b02);
                } else {
                    throw InvalidProtocolBufferException.m12802d();
                }
            }
        }
    }

    /* synthetic */ C3693d(C3694a aVar) {
        this();
    }

    /* renamed from: P */
    public static C3693d m13199P(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new C3695b(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private C3693d() {
    }
}
