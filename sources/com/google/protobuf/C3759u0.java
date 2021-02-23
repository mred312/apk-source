package com.google.protobuf;

import java.nio.ByteBuffer;

/* renamed from: com.google.protobuf.u0 */
/* compiled from: Utf8 */
final class C3759u0 {

    /* renamed from: a */
    private static final C3761b f20877a = ((!C3764e.m13898p() || C3687b.m13156c()) ? new C3762c() : new C3764e());

    /* renamed from: com.google.protobuf.u0$a */
    /* compiled from: Utf8 */
    private static class C3760a {
        /* access modifiers changed from: private */
        /* renamed from: h */
        public static void m13864h(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
            if (m13869m(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m13869m(b3) || m13869m(b4)) {
                throw InvalidProtocolBufferException.m12801c();
            }
            int r = ((b & 7) << 18) | (m13874r(b2) << 12) | (m13874r(b3) << 6) | m13874r(b4);
            cArr[i] = m13868l(r);
            cArr[i + 1] = m13873q(r);
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public static void m13865i(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public static void m13866j(byte b, byte b2, byte b3, char[] cArr, int i) {
            if (m13869m(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m13869m(b3)))) {
                throw InvalidProtocolBufferException.m12801c();
            }
            cArr[i] = (char) (((b & 15) << 12) | (m13874r(b2) << 6) | m13874r(b3));
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public static void m13867k(byte b, byte b2, char[] cArr, int i) {
            if (b < -62 || m13869m(b2)) {
                throw InvalidProtocolBufferException.m12801c();
            }
            cArr[i] = (char) (((b & 31) << 6) | m13874r(b2));
        }

        /* renamed from: l */
        private static char m13868l(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        /* renamed from: m */
        private static boolean m13869m(byte b) {
            return b > -65;
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public static boolean m13870n(byte b) {
            return b >= 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public static boolean m13871o(byte b) {
            return b < -16;
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public static boolean m13872p(byte b) {
            return b < -32;
        }

        /* renamed from: q */
        private static char m13873q(int i) {
            return (char) ((i & 1023) + 56320);
        }

        /* renamed from: r */
        private static int m13874r(byte b) {
            return b & 63;
        }
    }

    /* renamed from: com.google.protobuf.u0$b */
    /* compiled from: Utf8 */
    static abstract class C3761b {
        C3761b() {
        }

        /* renamed from: m */
        private static int m13875m(ByteBuffer byteBuffer, int i, int i2) {
            int e = i + C3759u0.m13846m(byteBuffer, i, i2);
            while (e < i2) {
                int i3 = e + 1;
                byte b = byteBuffer.get(e);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        i3++;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return C3759u0.m13850q(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 > -65 || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || byteBuffer.get(i4) > -65))) {
                            return -1;
                        }
                        e = i4 + 1;
                    } else if (i3 >= i2 - 2) {
                        return C3759u0.m13850q(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (byteBuffer.get(i5) <= -65) {
                                i3 = i6 + 1;
                                if (byteBuffer.get(i6) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                e = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final String mo24063a(ByteBuffer byteBuffer, int i, int i2) {
            if (byteBuffer.hasArray()) {
                return mo24064b(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            } else if (byteBuffer.isDirect()) {
                return mo24066d(byteBuffer, i, i2);
            } else {
                return mo24065c(byteBuffer, i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract String mo24064b(byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final String mo24065c(ByteBuffer byteBuffer, int i, int i2) {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte b = byteBuffer.get(r13);
                    if (!C3760a.m13870n(b)) {
                        break;
                    }
                    i = r13 + 1;
                    C3760a.m13865i(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte b2 = byteBuffer.get(r13);
                    if (C3760a.m13870n(b2)) {
                        int i7 = i5 + 1;
                        C3760a.m13865i(b2, cArr, i5);
                        while (i6 < i3) {
                            byte b3 = byteBuffer.get(i6);
                            if (!C3760a.m13870n(b3)) {
                                break;
                            }
                            i6++;
                            C3760a.m13865i(b3, cArr, i7);
                            i7++;
                        }
                        r13 = i6;
                        i5 = i7;
                    } else if (C3760a.m13872p(b2)) {
                        if (i6 < i3) {
                            C3760a.m13867k(b2, byteBuffer.get(i6), cArr, i5);
                            r13 = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (C3760a.m13871o(b2)) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            C3760a.m13866j(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                            r13 = i8 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        byte b4 = byteBuffer.get(i6);
                        int i10 = i9 + 1;
                        C3760a.m13864h(b2, b4, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                        r13 = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.m12801c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract String mo24066d(ByteBuffer byteBuffer, int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract int mo24067e(CharSequence charSequence, byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public final void mo24068f(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(C3759u0.m13842i(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                mo24070h(charSequence, byteBuffer);
            } else {
                mo24069g(charSequence, byteBuffer);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public final void mo24069g(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i2 = 0;
            while (i2 < length) {
                try {
                    char charAt = charSequence.charAt(i2);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i2, (byte) charAt);
                    i2++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i2 == length) {
                byteBuffer.position(position + i2);
                return;
            }
            position += i2;
            while (i2 < length) {
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    i = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i, (byte) ((charAt2 & '?') | 128));
                        position = i;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                    }
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    i = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                    position = i + 1;
                    byteBuffer.put(i, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i3 = i2 + 1;
                    if (i3 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i4 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    position = i4 + 1;
                                    byteBuffer.put(i4, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i4 = position + 1;
                                    byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i4, (byte) ((codePoint & 63) | 128));
                                    position = i4;
                                    i2 = i3;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i4;
                                    i2 = i3;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i2 = i3;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                            i2 = i3;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1)));
                        }
                    }
                    throw new C3763d(i2, length);
                }
                i2++;
                position++;
            }
            byteBuffer.position(position);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public abstract void mo24070h(CharSequence charSequence, ByteBuffer byteBuffer);

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public final boolean mo24071i(ByteBuffer byteBuffer, int i, int i2) {
            return mo24073k(0, byteBuffer, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public final boolean mo24072j(byte[] bArr, int i, int i2) {
            return mo24074l(0, bArr, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public final int mo24073k(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return mo24074l(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return mo24076o(i, byteBuffer, i2, i3);
            } else {
                return mo24075n(i, byteBuffer, i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public abstract int mo24074l(int i, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008b, code lost:
            if (r8.get(r9) > -65) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* renamed from: n */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int mo24075n(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x008e
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x008e
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = com.google.protobuf.C3759u0.m13848o(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x0065
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0063
                int r7 = com.google.protobuf.C3759u0.m13848o(r0, r1)
                return r7
            L_0x0063:
                r9 = r7
                goto L_0x0068
            L_0x0065:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0068:
                if (r4 != 0) goto L_0x0078
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L_0x0077
                int r7 = com.google.protobuf.C3759u0.m13849p(r0, r1, r4)
                return r7
            L_0x0077:
                r9 = r7
            L_0x0078:
                if (r1 > r3) goto L_0x008d
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x008d
                if (r4 > r3) goto L_0x008d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x008d:
                return r2
            L_0x008e:
                int r7 = m13875m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3761b.mo24075n(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public abstract int mo24076o(int i, ByteBuffer byteBuffer, int i2, int i3);
    }

    /* renamed from: com.google.protobuf.u0$c */
    /* compiled from: Utf8 */
    static final class C3762c extends C3761b {
        C3762c() {
        }

        /* renamed from: p */
        private static int m13890p(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return m13891q(bArr, i, i2);
        }

        /* renamed from: q */
        private static int m13891q(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return C3759u0.m13851r(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return C3759u0.m13851r(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo24064b(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte b = bArr[r13];
                    if (!C3760a.m13870n(b)) {
                        break;
                    }
                    i = r13 + 1;
                    C3760a.m13865i(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte b2 = bArr[r13];
                    if (C3760a.m13870n(b2)) {
                        int i7 = i5 + 1;
                        C3760a.m13865i(b2, cArr, i5);
                        while (i6 < i3) {
                            byte b3 = bArr[i6];
                            if (!C3760a.m13870n(b3)) {
                                break;
                            }
                            i6++;
                            C3760a.m13865i(b3, cArr, i7);
                            i7++;
                        }
                        r13 = i6;
                        i5 = i7;
                    } else if (C3760a.m13872p(b2)) {
                        if (i6 < i3) {
                            C3760a.m13867k(b2, bArr[i6], cArr, i5);
                            r13 = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (C3760a.m13871o(b2)) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            C3760a.m13866j(b2, bArr[i6], bArr[i8], cArr, i5);
                            r13 = i8 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        C3760a.m13864h(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        r13 = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.m12801c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public String mo24066d(ByteBuffer byteBuffer, int i, int i2) {
            return mo24065c(byteBuffer, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo24067e(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new C3763d(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new C3763d(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo24070h(CharSequence charSequence, ByteBuffer byteBuffer) {
            mo24069g(charSequence, byteBuffer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
            if (r8[r9] > -65) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* renamed from: l */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo24074l(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0082
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0082
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = com.google.protobuf.C3759u0.m13848o(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x005d
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005b
                int r7 = com.google.protobuf.C3759u0.m13848o(r0, r1)
                return r7
            L_0x005b:
                r9 = r7
                goto L_0x0060
            L_0x005d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0060:
                if (r4 != 0) goto L_0x006e
                int r7 = r9 + 1
                byte r4 = r8[r9]
                if (r7 < r10) goto L_0x006d
                int r7 = com.google.protobuf.C3759u0.m13849p(r0, r1, r4)
                return r7
            L_0x006d:
                r9 = r7
            L_0x006e:
                if (r1 > r3) goto L_0x0081
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x0081
                if (r4 > r3) goto L_0x0081
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0081:
                return r2
            L_0x0082:
                int r7 = m13890p(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3762c.mo24074l(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public int mo24076o(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return mo24075n(i, byteBuffer, i2, i3);
        }
    }

    /* renamed from: com.google.protobuf.u0$d */
    /* compiled from: Utf8 */
    static class C3763d extends IllegalArgumentException {
        C3763d(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* renamed from: com.google.protobuf.u0$e */
    /* compiled from: Utf8 */
    static final class C3764e extends C3761b {
        C3764e() {
        }

        /* renamed from: p */
        static boolean m13898p() {
            return C3752t0.m13719H() && C3752t0.m13720I();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* renamed from: q */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m13899q(long r8, int r10) {
            /*
                int r0 = m13901s(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r10 <= 0) goto L_0x001a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r8)
                if (r1 < 0) goto L_0x0019
                int r10 = r10 + -1
                r8 = r4
                goto L_0x0009
            L_0x0019:
                r8 = r4
            L_0x001a:
                if (r10 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r10 = r10 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r10 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r10 = r10 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.C3752t0.m13757v(r8)
                if (r8 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r8 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r10 >= r6) goto L_0x0046
                int r8 = m13903u(r8, r1, r10)
                return r8
            L_0x0046:
                int r10 = r10 + -2
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.C3752t0.m13757v(r8)
                if (r8 > r4) goto L_0x0063
                r9 = -96
                if (r1 != r0) goto L_0x0056
                if (r8 < r9) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r8 >= r9) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r8 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r10 >= r0) goto L_0x006c
                int r8 = m13903u(r8, r1, r10)
                return r8
            L_0x006c:
                int r10 = r10 + -3
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.C3752t0.m13757v(r8)
                if (r8 > r4) goto L_0x008e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L_0x008e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.C3752t0.m13757v(r8)
                if (r8 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.m13899q(long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* renamed from: r */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m13900r(byte[] r8, long r9, int r11) {
            /*
                int r0 = m13902t(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.C3752t0.m13758w(r8, r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C3752t0.m13758w(r8, r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = m13904v(r8, r1, r9, r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C3752t0.m13758w(r8, r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.C3752t0.m13758w(r8, r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = m13904v(r8, r1, r9, r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C3752t0.m13758w(r8, r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.C3752t0.m13758w(r8, r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C3752t0.m13758w(r8, r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.m13900r(byte[], long, int):int");
        }

        /* renamed from: s */
        private static int m13901s(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = 8 - (((int) j) & 7);
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (C3752t0.m13757v(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (C3752t0.m13714C(j) & -9187201950435737472L) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* renamed from: t */
        private static int m13902t(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                long j2 = 1 + j;
                if (C3752t0.m13758w(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            return i;
        }

        /* renamed from: u */
        private static int m13903u(long j, int i, int i2) {
            if (i2 == 0) {
                return C3759u0.m13847n(i);
            }
            if (i2 == 1) {
                return C3759u0.m13848o(i, C3752t0.m13757v(j));
            }
            if (i2 == 2) {
                return C3759u0.m13849p(i, C3752t0.m13757v(j), C3752t0.m13757v(j + 1));
            }
            throw new AssertionError();
        }

        /* renamed from: v */
        private static int m13904v(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return C3759u0.m13847n(i);
            }
            if (i2 == 1) {
                return C3759u0.m13848o(i, C3752t0.m13758w(bArr, j));
            }
            if (i2 == 2) {
                return C3759u0.m13849p(i, C3752t0.m13758w(bArr, j), C3752t0.m13758w(bArr, j + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo24064b(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte w = C3752t0.m13758w(bArr, (long) r13);
                    if (!C3760a.m13870n(w)) {
                        break;
                    }
                    i = r13 + 1;
                    C3760a.m13865i(w, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte w2 = C3752t0.m13758w(bArr, (long) r13);
                    if (C3760a.m13870n(w2)) {
                        int i7 = i5 + 1;
                        C3760a.m13865i(w2, cArr, i5);
                        while (i6 < i3) {
                            byte w3 = C3752t0.m13758w(bArr, (long) i6);
                            if (!C3760a.m13870n(w3)) {
                                break;
                            }
                            i6++;
                            C3760a.m13865i(w3, cArr, i7);
                            i7++;
                        }
                        r13 = i6;
                        i5 = i7;
                    } else if (C3760a.m13872p(w2)) {
                        if (i6 < i3) {
                            int i8 = i6 + 1;
                            C3760a.m13867k(w2, C3752t0.m13758w(bArr, (long) i6), cArr, i5);
                            r13 = i8;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (C3760a.m13871o(w2)) {
                        if (i6 < i3 - 1) {
                            int i9 = i6 + 1;
                            int i10 = i9 + 1;
                            C3760a.m13866j(w2, C3752t0.m13758w(bArr, (long) i6), C3752t0.m13758w(bArr, (long) i9), cArr, i5);
                            r13 = i10;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    } else if (i6 < i3 - 2) {
                        int i11 = i6 + 1;
                        byte w4 = C3752t0.m13758w(bArr, (long) i6);
                        int i12 = i11 + 1;
                        C3760a.m13864h(w2, w4, C3752t0.m13758w(bArr, (long) i11), C3752t0.m13758w(bArr, (long) i12), cArr, i5);
                        r13 = i12 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.m12801c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public String mo24066d(ByteBuffer byteBuffer, int i, int i2) {
            long j;
            int i3 = i;
            int i4 = i2;
            if ((i3 | i4 | ((byteBuffer.limit() - i3) - i4)) >= 0) {
                long i5 = C3752t0.m13744i(byteBuffer) + ((long) i3);
                long j2 = ((long) i4) + i5;
                char[] cArr = new char[i4];
                int i6 = 0;
                while (i5 < j2) {
                    byte v = C3752t0.m13757v(i5);
                    if (!C3760a.m13870n(v)) {
                        break;
                    }
                    i5++;
                    C3760a.m13865i(v, cArr, i6);
                    i6++;
                }
                while (true) {
                    int i7 = i6;
                    while (j < j2) {
                        long j3 = j + 1;
                        byte v2 = C3752t0.m13757v(j);
                        if (C3760a.m13870n(v2)) {
                            int i8 = i7 + 1;
                            C3760a.m13865i(v2, cArr, i7);
                            while (j3 < j2) {
                                byte v3 = C3752t0.m13757v(j3);
                                if (!C3760a.m13870n(v3)) {
                                    break;
                                }
                                j3++;
                                C3760a.m13865i(v3, cArr, i8);
                                i8++;
                            }
                            i7 = i8;
                            j = j3;
                        } else if (C3760a.m13872p(v2)) {
                            if (j3 < j2) {
                                j = j3 + 1;
                                C3760a.m13867k(v2, C3752t0.m13757v(j3), cArr, i7);
                                i7++;
                            } else {
                                throw InvalidProtocolBufferException.m12801c();
                            }
                        } else if (C3760a.m13871o(v2)) {
                            if (j3 < j2 - 1) {
                                long j4 = j3 + 1;
                                C3760a.m13866j(v2, C3752t0.m13757v(j3), C3752t0.m13757v(j4), cArr, i7);
                                i7++;
                                j = j4 + 1;
                            } else {
                                throw InvalidProtocolBufferException.m12801c();
                            }
                        } else if (j3 < j2 - 2) {
                            long j5 = j3 + 1;
                            byte v4 = C3752t0.m13757v(j3);
                            long j6 = j5 + 1;
                            byte v5 = C3752t0.m13757v(j5);
                            i5 = j6 + 1;
                            C3760a.m13864h(v2, v4, v5, C3752t0.m13757v(j6), cArr, i7);
                            i6 = i7 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.m12801c();
                        }
                    }
                    return new String(cArr, 0, i7);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo24067e(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
            /*
                r22 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r3 = r26
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r23.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0144
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0144
                r2 = 0
            L_0x001a:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.google.protobuf.C3752t0.m13726O(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0142
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004b
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004b
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.google.protobuf.C3752t0.m13726O(r1, r4, r13)
                r4 = r11
                r12 = r14
            L_0x0047:
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fb
            L_0x004b:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0075
                r14 = 2
                long r14 = r6 - r14
                int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r16 > 0) goto L_0x0075
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.C3752t0.m13726O(r1, r4, r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13726O(r1, r14, r5)
                r20 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r20
                goto L_0x00fb
            L_0x0075:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007f
                if (r3 >= r13) goto L_0x00ae
            L_0x007f:
                r15 = 3
                long r15 = r6 - r15
                int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r17 > 0) goto L_0x00ae
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.C3752t0.m13726O(r1, r4, r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13726O(r1, r14, r5)
                r14 = 1
                long r18 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13726O(r1, r3, r5)
                r12 = r18
                r4 = 1
                goto L_0x0047
            L_0x00ae:
                r11 = 4
                long r11 = r6 - r11
                int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                com.google.protobuf.C3752t0.m13726O(r1, r4, r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                com.google.protobuf.C3752t0.m13726O(r1, r13, r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                com.google.protobuf.C3752t0.m13726O(r1, r4, r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                com.google.protobuf.C3752t0.m13726O(r1, r14, r2)
                r2 = r3
            L_0x00fb:
                int r2 = r2 + 1
                r3 = 128(0x80, float:1.794E-43)
                r20 = r4
                r4 = r12
                r11 = r20
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                com.google.protobuf.u0$d r0 = new com.google.protobuf.u0$d
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                com.google.protobuf.u0$d r0 = new com.google.protobuf.u0$d
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0142:
                int r0 = (int) r4
                return r0
            L_0x0144:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                goto L_0x0168
            L_0x0167:
                throw r1
            L_0x0168:
                goto L_0x0167
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.mo24067e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[LOOP:1: B:11:0x0041->B:36:0x0100, LOOP_START, PHI: r2 r4 r9 r10 
          PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x0039, B:36:0x0100] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:8:0x0039, B:36:0x0100] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v3 int) = (r9v2 int), (r9v5 int) binds: [B:8:0x0039, B:36:0x0100] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 char) = (r10v0 char), (r10v2 char) binds: [B:8:0x0039, B:36:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
        /* renamed from: h */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo24070h(java.lang.CharSequence r22, java.nio.ByteBuffer r23) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                long r2 = com.google.protobuf.C3752t0.m13744i(r23)
                int r4 = r23.position()
                long r4 = (long) r4
                long r4 = r4 + r2
                int r6 = r23.limit()
                long r6 = (long) r6
                long r6 = r6 + r2
                int r8 = r22.length()
                long r9 = (long) r8
                long r11 = r6 - r4
                java.lang.String r13 = " at index "
                java.lang.String r14 = "Failed writing "
                int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x0151
                r9 = 0
            L_0x0024:
                r10 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r9 >= r8) goto L_0x0039
                char r15 = r0.charAt(r9)
                if (r15 >= r10) goto L_0x0039
                long r11 = r11 + r4
                byte r10 = (byte) r15
                com.google.protobuf.C3752t0.m13725N(r4, r10)
                int r9 = r9 + 1
                r4 = r11
                goto L_0x0024
            L_0x0039:
                if (r9 != r8) goto L_0x0041
                long r4 = r4 - r2
                int r0 = (int) r4
                r1.position(r0)
                return
            L_0x0041:
                if (r9 >= r8) goto L_0x0146
                char r15 = r0.charAt(r9)
                if (r15 >= r10) goto L_0x005b
                int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r16 >= 0) goto L_0x005b
                long r16 = r4 + r11
                byte r15 = (byte) r15
                com.google.protobuf.C3752t0.m13725N(r4, r15)
                r4 = r16
                r15 = 128(0x80, float:1.794E-43)
                r17 = r2
                goto L_0x0100
            L_0x005b:
                r10 = 2048(0x800, float:2.87E-42)
                if (r15 >= r10) goto L_0x0083
                r17 = 2
                long r17 = r6 - r17
                int r10 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r10 > 0) goto L_0x0083
                r17 = r2
                long r1 = r4 + r11
                int r3 = r15 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.C3752t0.m13725N(r4, r3)
                long r3 = r1 + r11
                r5 = r15 & 63
                r10 = 128(0x80, float:1.794E-43)
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13725N(r1, r5)
                r4 = r3
            L_0x007f:
                r15 = 128(0x80, float:1.794E-43)
                goto L_0x0100
            L_0x0083:
                r17 = r2
                r1 = 57343(0xdfff, float:8.0355E-41)
                r2 = 55296(0xd800, float:7.7486E-41)
                if (r15 < r2) goto L_0x008f
                if (r1 >= r15) goto L_0x00b9
            L_0x008f:
                r19 = 3
                long r19 = r6 - r19
                int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r3 > 0) goto L_0x00b9
                long r1 = r4 + r11
                int r3 = r15 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.C3752t0.m13725N(r4, r3)
                long r3 = r1 + r11
                int r5 = r15 >>> 6
                r5 = r5 & 63
                r10 = 128(0x80, float:1.794E-43)
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13725N(r1, r5)
                long r1 = r3 + r11
                r5 = r15 & 63
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13725N(r3, r5)
                r4 = r1
                goto L_0x007f
            L_0x00b9:
                r19 = 4
                long r19 = r6 - r19
                int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r3 > 0) goto L_0x0113
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x010b
                char r2 = r0.charAt(r1)
                boolean r3 = java.lang.Character.isSurrogatePair(r15, r2)
                if (r3 == 0) goto L_0x010a
                int r2 = java.lang.Character.toCodePoint(r15, r2)
                long r9 = r4 + r11
                int r3 = r2 >>> 18
                r3 = r3 | 240(0xf0, float:3.36E-43)
                byte r3 = (byte) r3
                com.google.protobuf.C3752t0.m13725N(r4, r3)
                long r3 = r9 + r11
                int r5 = r2 >>> 12
                r5 = r5 & 63
                r15 = 128(0x80, float:1.794E-43)
                r5 = r5 | r15
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13725N(r9, r5)
                long r9 = r3 + r11
                int r5 = r2 >>> 6
                r5 = r5 & 63
                r5 = r5 | r15
                byte r5 = (byte) r5
                com.google.protobuf.C3752t0.m13725N(r3, r5)
                long r3 = r9 + r11
                r2 = r2 & 63
                r2 = r2 | r15
                byte r2 = (byte) r2
                com.google.protobuf.C3752t0.m13725N(r9, r2)
                r9 = r1
                r4 = r3
            L_0x0100:
                int r9 = r9 + 1
                r1 = r23
                r2 = r17
                r10 = 128(0x80, float:1.794E-43)
                goto L_0x0041
            L_0x010a:
                r9 = r1
            L_0x010b:
                com.google.protobuf.u0$d r0 = new com.google.protobuf.u0$d
                int r9 = r9 + -1
                r0.<init>(r9, r8)
                throw r0
            L_0x0113:
                if (r2 > r15) goto L_0x012b
                if (r15 > r1) goto L_0x012b
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x0125
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r15, r0)
                if (r0 != 0) goto L_0x012b
            L_0x0125:
                com.google.protobuf.u0$d r0 = new com.google.protobuf.u0$d
                r0.<init>(r9, r8)
                throw r0
            L_0x012b:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r14)
                r1.append(r15)
                r1.append(r13)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0146:
                r17 = r2
                long r4 = r4 - r17
                int r0 = (int) r4
                r1 = r23
                r1.position(r0)
                return
            L_0x0151:
                java.lang.ArrayIndexOutOfBoundsException r2 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r3.append(r0)
                r3.append(r13)
                int r0 = r23.limit()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                goto L_0x0177
            L_0x0176:
                throw r2
            L_0x0177:
                goto L_0x0176
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.mo24070h(java.lang.CharSequence, java.nio.ByteBuffer):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (com.google.protobuf.C3752t0.m13758w(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (com.google.protobuf.C3752t0.m13758w(r13, r2) > -65) goto L_0x00a0;
         */
        /* renamed from: l */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo24074l(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a8
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x002b
                r12 = -62
                if (r0 < r12) goto L_0x002a
                long r7 = r7 + r2
                byte r12 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r2 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r0 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                r12 = r12 ^ r5
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r2 + r7
                byte r12 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0044
                int r12 = com.google.protobuf.C3759u0.m13848o(r0, r12)
                return r12
            L_0x0044:
                r2 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r1 = -96
                if (r0 != r4) goto L_0x004d
                if (r12 < r1) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r0 != r4) goto L_0x0053
                if (r12 >= r1) goto L_0x005e
            L_0x0053:
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r2 = r0
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                r4 = r4 ^ r5
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r2 + r7
                byte r4 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = com.google.protobuf.C3759u0.m13848o(r0, r4)
                return r12
            L_0x0074:
                r2 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0079:
                if (r1 != 0) goto L_0x008b
                long r9 = r2 + r7
                byte r1 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = com.google.protobuf.C3759u0.m13849p(r0, r4, r1)
                return r12
            L_0x008a:
                r2 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r1 > r6) goto L_0x00a0
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.C3752t0.m13758w(r13, r2)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r2
                int r12 = (int) r14
                int r12 = m13900r(r13, r2, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                goto L_0x00cd
            L_0x00cc:
                throw r12
            L_0x00cd:
                goto L_0x00cc
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.mo24074l(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.C3752t0.m13757v(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.C3752t0.m13757v(r2) > -65) goto L_0x00aa;
         */
        /* renamed from: o */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo24076o(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = com.google.protobuf.C3752t0.m13744i(r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00ab
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r2
                byte r11 = com.google.protobuf.C3752t0.m13757v(r2)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r6
                goto L_0x00ab
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0069
                int r11 = r11 >> 8
                r11 = r11 ^ r4
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r2 + r6
                byte r11 = com.google.protobuf.C3752t0.m13757v(r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r11 = com.google.protobuf.C3759u0.m13848o(r14, r11)
                return r11
            L_0x004e:
                r2 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0068
                r1 = -96
                if (r14 != r0) goto L_0x0057
                if (r11 < r1) goto L_0x0068
            L_0x0057:
                r0 = -19
                if (r14 != r0) goto L_0x005d
                if (r11 >= r1) goto L_0x0068
            L_0x005d:
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.C3752t0.m13757v(r2)
                if (r11 <= r5) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r0
                goto L_0x00ab
            L_0x0068:
                return r4
            L_0x0069:
                int r0 = r11 >> 8
                r0 = r0 ^ r4
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0080
                long r8 = r2 + r6
                byte r0 = com.google.protobuf.C3752t0.m13757v(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007e
                int r11 = com.google.protobuf.C3759u0.m13848o(r14, r0)
                return r11
            L_0x007e:
                r2 = r8
                goto L_0x0083
            L_0x0080:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r8 = r2 + r6
                byte r1 = com.google.protobuf.C3752t0.m13757v(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0094
                int r11 = com.google.protobuf.C3759u0.m13849p(r14, r0, r1)
                return r11
            L_0x0094:
                r2 = r8
            L_0x0095:
                if (r0 > r5) goto L_0x00aa
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00aa
                if (r1 > r5) goto L_0x00aa
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.C3752t0.m13757v(r2)
                if (r11 <= r5) goto L_0x0066
            L_0x00aa:
                return r4
            L_0x00ab:
                long r12 = r12 - r2
                int r11 = (int) r12
                int r11 = m13899q(r2, r11)
                return r11
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                r0[r1] = r12
                r12 = 1
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r12] = r13
                r12 = 2
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                r0[r12] = r13
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                goto L_0x00da
            L_0x00d9:
                throw r11
            L_0x00da:
                goto L_0x00d9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3759u0.C3764e.mo24076o(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    /* renamed from: g */
    static String m13840g(ByteBuffer byteBuffer, int i, int i2) {
        return f20877a.mo24063a(byteBuffer, i, i2);
    }

    /* renamed from: h */
    static String m13841h(byte[] bArr, int i, int i2) {
        return f20877a.mo24064b(bArr, i, i2);
    }

    /* renamed from: i */
    static int m13842i(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f20877a.mo24067e(charSequence, bArr, i, i2);
    }

    /* renamed from: j */
    static void m13843j(CharSequence charSequence, ByteBuffer byteBuffer) {
        f20877a.mo24068f(charSequence, byteBuffer);
    }

    /* renamed from: k */
    static int m13844k(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += m13845l(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    /* renamed from: l */
    private static int m13845l(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new C3763d(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static int m13846m(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i2 - 7;
        int i4 = i;
        while (i4 < i3 && (byteBuffer.getLong(i4) & -9187201950435737472L) == 0) {
            i4 += 8;
        }
        return i4 - i;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static int m13847n(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public static int m13848o(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public static int m13849p(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public static int m13850q(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 == 0) {
            return m13847n(i);
        }
        if (i3 == 1) {
            return m13848o(i, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return m13849p(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public static int m13851r(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m13847n(b);
        }
        if (i3 == 1) {
            return m13848o(b, bArr[i]);
        }
        if (i3 == 2) {
            return m13849p(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    static boolean m13852s(ByteBuffer byteBuffer) {
        return f20877a.mo24071i(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* renamed from: t */
    public static boolean m13853t(byte[] bArr) {
        return f20877a.mo24072j(bArr, 0, bArr.length);
    }

    /* renamed from: u */
    public static boolean m13854u(byte[] bArr, int i, int i2) {
        return f20877a.mo24072j(bArr, i, i2);
    }

    /* renamed from: v */
    static int m13855v(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return f20877a.mo24073k(i, byteBuffer, i2, i3);
    }

    /* renamed from: w */
    public static int m13856w(int i, byte[] bArr, int i2, int i3) {
        return f20877a.mo24074l(i, bArr, i2, i3);
    }
}
