package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {

    /* renamed from: a */
    int f20379a;

    /* renamed from: b */
    int f20380b;

    /* renamed from: c */
    int f20381c;

    /* renamed from: d */
    C3700f f20382d;

    /* renamed from: com.google.protobuf.CodedInputStream$b */
    private static final class C3612b extends CodedInputStream {

        /* renamed from: e */
        private final byte[] f20383e;

        /* renamed from: f */
        private final boolean f20384f;

        /* renamed from: g */
        private int f20385g;

        /* renamed from: h */
        private int f20386h;

        /* renamed from: i */
        private int f20387i;

        /* renamed from: j */
        private int f20388j;

        /* renamed from: k */
        private int f20389k;

        /* renamed from: l */
        private boolean f20390l;

        /* renamed from: m */
        private int f20391m;

        /* renamed from: e */
        private void m12442e() {
            int i = this.f20385g + this.f20386h;
            this.f20385g = i;
            int i2 = i - this.f20388j;
            int i3 = this.f20391m;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.f20386h = i4;
                this.f20385g = i - i4;
                return;
            }
            this.f20386h = 0;
        }

        /* renamed from: f */
        private void m12443f() {
            if (this.f20385g - this.f20387i >= 10) {
                m12444g();
            } else {
                m12445h();
            }
        }

        /* renamed from: g */
        private void m12444g() {
            int i = 0;
            while (i < 10) {
                byte[] bArr = this.f20383e;
                int i2 = this.f20387i;
                this.f20387i = i2 + 1;
                if (bArr[i2] < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: h */
        private void m12445h() {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        public void checkLastTagWas(int i) {
            if (this.f20389k != i) {
                throw InvalidProtocolBufferException.m12799a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public long mo23023d() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        public void enableAliasing(boolean z) {
            this.f20390l = z;
        }

        public int getBytesUntilLimit() {
            int i = this.f20391m;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.f20389k;
        }

        public int getTotalBytesRead() {
            return this.f20387i - this.f20388j;
        }

        public boolean isAtEnd() {
            return this.f20387i == this.f20385g;
        }

        public void popLimit(int i) {
            this.f20391m = i;
            m12442e();
        }

        public int pushLimit(int i) {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i2 = this.f20391m;
                if (totalBytesRead <= i2) {
                    this.f20391m = totalBytesRead;
                    m12442e();
                    return i2;
                }
                throw InvalidProtocolBufferException.m12808j();
            }
            throw InvalidProtocolBufferException.m12804f();
        }

        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() {
            ByteBuffer byteBuffer;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f20385g;
                int i2 = this.f20387i;
                if (readRawVarint32 <= i - i2) {
                    if (this.f20384f || !this.f20390l) {
                        byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.f20383e, i2, i2 + readRawVarint32));
                    } else {
                        byteBuffer = ByteBuffer.wrap(this.f20383e, i2, readRawVarint32).slice();
                    }
                    this.f20387i += readRawVarint32;
                    return byteBuffer;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.m12804f();
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public ByteString readBytes() {
            ByteString byteString;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f20385g;
                int i2 = this.f20387i;
                if (readRawVarint32 <= i - i2) {
                    if (!this.f20384f || !this.f20390l) {
                        byteString = ByteString.copyFrom(this.f20383e, i2, readRawVarint32);
                    } else {
                        byteString = ByteString.m12413l(this.f20383e, i2, readRawVarint32);
                    }
                    this.f20387i += readRawVarint32;
                    return byteString;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.m12412k(readRawBytes(readRawVarint32));
        }

        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() {
            return readRawVarint32();
        }

        public int readFixed32() {
            return readRawLittleEndian32();
        }

        public long readFixed64() {
            return readRawLittleEndian64();
        }

        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public int readInt32() {
            return readRawVarint32();
        }

        public long readInt64() {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public byte readRawByte() {
            int i = this.f20387i;
            if (i != this.f20385g) {
                byte[] bArr = this.f20383e;
                this.f20387i = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public byte[] readRawBytes(int i) {
            if (i > 0) {
                int i2 = this.f20385g;
                int i3 = this.f20387i;
                if (i <= i2 - i3) {
                    int i4 = i + i3;
                    this.f20387i = i4;
                    return Arrays.copyOfRange(this.f20383e, i3, i4);
                }
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.m12808j();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.m12804f();
            }
        }

        public int readRawLittleEndian32() {
            int i = this.f20387i;
            if (this.f20385g - i >= 4) {
                byte[] bArr = this.f20383e;
                this.f20387i = i + 4;
                return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public long readRawLittleEndian64() {
            int i = this.f20387i;
            if (this.f20385g - i >= 8) {
                byte[] bArr = this.f20383e;
                this.f20387i = i + 8;
                return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() {
            /*
                r5 = this;
                int r0 = r5.f20387i
                int r1 = r5.f20385g
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f20383e
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f20387i = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.mo23023d()
                int r1 = (int) r0
                return r1
            L_0x0070:
                r5.f20387i = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3612b.readRawVarint32():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() {
            /*
                r11 = this;
                int r0 = r11.f20387i
                int r1 = r11.f20385g
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f20383e
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f20387i = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r1 = r1 ^ r3
                r2 = r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r3 = r3 ^ r5
            L_0x0072:
                r2 = r3
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0072
            L_0x00b6:
                long r0 = r11.mo23023d()
                return r0
            L_0x00bb:
                r1 = r0
                goto L_0x0072
            L_0x00bd:
                r11.f20387i = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3612b.readRawVarint64():long");
        }

        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= this.f20385g - this.f20387i) {
                String str = new String(this.f20383e, this.f20387i, readRawVarint32, Internal.f20591a);
                this.f20387i += readRawVarint32;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f20385g;
                int i2 = this.f20387i;
                if (readRawVarint32 <= i - i2) {
                    String h = C3759u0.m13841h(this.f20383e, i2, readRawVarint32);
                    this.f20387i += readRawVarint32;
                    return h;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.m12804f();
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public int readTag() {
            if (isAtEnd()) {
                this.f20389k = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f20389k = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f20389k;
            }
            throw InvalidProtocolBufferException.m12800b();
        }

        public int readUInt32() {
            return readRawVarint32();
        }

        public long readUInt64() {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.f20388j = this.f20387i;
        }

        public boolean skipField(int i) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                m12443f();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3612b.skipMessage():void");
        }

        public void skipRawBytes(int i) {
            if (i >= 0) {
                int i2 = this.f20385g;
                int i3 = this.f20387i;
                if (i <= i2 - i3) {
                    this.f20387i = i3 + i;
                    return;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.m12804f();
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        private C3612b(byte[] bArr, int i, int i2, boolean z) {
            super();
            this.f20391m = Integer.MAX_VALUE;
            this.f20383e = bArr;
            this.f20385g = i2 + i;
            this.f20387i = i;
            this.f20388j = i;
            this.f20384f = z;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3612b.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public boolean skipField(int i, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int a = WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(a);
                codedOutputStream.writeRawVarint32(a);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedInputStream$c */
    private static final class C3613c extends CodedInputStream {

        /* renamed from: e */
        private Iterable<ByteBuffer> f20392e;

        /* renamed from: f */
        private Iterator<ByteBuffer> f20393f;

        /* renamed from: g */
        private ByteBuffer f20394g;

        /* renamed from: h */
        private boolean f20395h;

        /* renamed from: i */
        private boolean f20396i;

        /* renamed from: j */
        private int f20397j;

        /* renamed from: k */
        private int f20398k;

        /* renamed from: l */
        private int f20399l;

        /* renamed from: m */
        private int f20400m;

        /* renamed from: n */
        private int f20401n;

        /* renamed from: o */
        private int f20402o;

        /* renamed from: p */
        private long f20403p;

        /* renamed from: q */
        private long f20404q;

        /* renamed from: r */
        private long f20405r;

        /* renamed from: s */
        private long f20406s;

        /* renamed from: d */
        private long m12447d() {
            return this.f20406s - this.f20403p;
        }

        /* renamed from: e */
        private void m12448e() {
            if (this.f20393f.hasNext()) {
                m12454l();
                return;
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        /* renamed from: f */
        private void m12449f(byte[] bArr, int i, int i2) {
            if (i2 >= 0 && i2 <= m12451i()) {
                int i3 = i2;
                while (i3 > 0) {
                    if (m12447d() == 0) {
                        m12448e();
                    }
                    int min = Math.min(i3, (int) m12447d());
                    long j = (long) min;
                    C3752t0.m13749n(this.f20403p, bArr, (long) ((i2 - i3) + i), j);
                    i3 -= min;
                    this.f20403p += j;
                }
            } else if (i2 > 0) {
                throw InvalidProtocolBufferException.m12808j();
            } else if (i2 != 0) {
                throw InvalidProtocolBufferException.m12804f();
            }
        }

        /* renamed from: h */
        private void m12450h() {
            int i = this.f20397j + this.f20398k;
            this.f20397j = i;
            int i2 = i - this.f20402o;
            int i3 = this.f20399l;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.f20398k = i4;
                this.f20397j = i - i4;
                return;
            }
            this.f20398k = 0;
        }

        /* renamed from: i */
        private int m12451i() {
            return (int) ((((long) (this.f20397j - this.f20401n)) - this.f20403p) + this.f20404q);
        }

        /* renamed from: j */
        private void m12452j() {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.m12808j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r3.f20394g.position(r0);
            r3.f20394g.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer m12453k(int r4, int r5) {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f20394g
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f20394g
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f20394g     // Catch:{ IllegalArgumentException -> 0x0029 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.f20394g     // Catch:{ IllegalArgumentException -> 0x0029 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.f20394g     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r5 = r3.f20394g
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f20394g
                r5.limit(r1)
                return r4
            L_0x0027:
                r4 = move-exception
                goto L_0x002e
            L_0x0029:
                com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.m12808j()     // Catch:{ all -> 0x0027 }
                throw r4     // Catch:{ all -> 0x0027 }
            L_0x002e:
                java.nio.ByteBuffer r5 = r3.f20394g
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f20394g
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3613c.m12453k(int, int):java.nio.ByteBuffer");
        }

        /* renamed from: l */
        private void m12454l() {
            ByteBuffer next = this.f20393f.next();
            this.f20394g = next;
            this.f20401n += (int) (this.f20403p - this.f20404q);
            long position = (long) next.position();
            this.f20403p = position;
            this.f20404q = position;
            this.f20406s = (long) this.f20394g.limit();
            long i = C3752t0.m13744i(this.f20394g);
            this.f20405r = i;
            this.f20403p += i;
            this.f20404q += i;
            this.f20406s += i;
        }

        public void checkLastTagWas(int i) {
            if (this.f20400m != i) {
                throw InvalidProtocolBufferException.m12799a();
            }
        }

        public void enableAliasing(boolean z) {
            this.f20396i = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public long mo23024g() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        public int getBytesUntilLimit() {
            int i = this.f20399l;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.f20400m;
        }

        public int getTotalBytesRead() {
            return (int) ((((long) (this.f20401n - this.f20402o)) + this.f20403p) - this.f20404q);
        }

        public boolean isAtEnd() {
            return (((long) this.f20401n) + this.f20403p) - this.f20404q == ((long) this.f20397j);
        }

        public void popLimit(int i) {
            this.f20399l = i;
            m12450h();
        }

        public int pushLimit(int i) {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i2 = this.f20399l;
                if (totalBytesRead <= i2) {
                    this.f20399l = totalBytesRead;
                    m12450h();
                    return i2;
                }
                throw InvalidProtocolBufferException.m12808j();
            }
            throw InvalidProtocolBufferException.m12804f();
        }

        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                if (j <= m12447d()) {
                    if (this.f20395h || !this.f20396i) {
                        byte[] bArr = new byte[readRawVarint32];
                        C3752t0.m13749n(this.f20403p, bArr, 0, j);
                        this.f20403p += j;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j2 = this.f20403p + j;
                    this.f20403p = j2;
                    long j3 = this.f20405r;
                    return m12453k((int) ((j2 - j3) - j), (int) (j2 - j3));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= m12451i()) {
                byte[] bArr2 = new byte[readRawVarint32];
                m12449f(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.f20406s;
                long j3 = this.f20403p;
                if (j <= j2 - j3) {
                    if (!this.f20395h || !this.f20396i) {
                        byte[] bArr = new byte[readRawVarint32];
                        C3752t0.m13749n(j3, bArr, 0, j);
                        this.f20403p += j;
                        return ByteString.m12412k(bArr);
                    }
                    int i = (int) (j3 - this.f20405r);
                    ByteString j4 = ByteString.m12411j(m12453k(i, readRawVarint32 + i));
                    this.f20403p += j;
                    return j4;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= m12451i()) {
                byte[] bArr2 = new byte[readRawVarint32];
                m12449f(bArr2, 0, readRawVarint32);
                return ByteString.m12412k(bArr2);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() {
            return readRawVarint32();
        }

        public int readFixed32() {
            return readRawLittleEndian32();
        }

        public long readFixed64() {
            return readRawLittleEndian64();
        }

        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public int readInt32() {
            return readRawVarint32();
        }

        public long readInt64() {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public byte readRawByte() {
            if (m12447d() == 0) {
                m12448e();
            }
            long j = this.f20403p;
            this.f20403p = 1 + j;
            return C3752t0.m13757v(j);
        }

        public byte[] readRawBytes(int i) {
            if (i >= 0) {
                long j = (long) i;
                if (j <= m12447d()) {
                    byte[] bArr = new byte[i];
                    C3752t0.m13749n(this.f20403p, bArr, 0, j);
                    this.f20403p += j;
                    return bArr;
                }
            }
            if (i >= 0 && i <= m12451i()) {
                byte[] bArr2 = new byte[i];
                m12449f(bArr2, 0, i);
                return bArr2;
            } else if (i > 0) {
                throw InvalidProtocolBufferException.m12808j();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.m12804f();
            }
        }

        public int readRawLittleEndian32() {
            if (m12447d() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long j = this.f20403p;
            this.f20403p = 4 + j;
            return ((C3752t0.m13757v(j + 3) & 255) << 24) | (C3752t0.m13757v(j) & 255) | ((C3752t0.m13757v(1 + j) & 255) << 8) | ((C3752t0.m13757v(2 + j) & 255) << 16);
        }

        public long readRawLittleEndian64() {
            if (m12447d() < 8) {
                return (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48) | ((((long) readRawByte()) & 255) << 56);
            }
            long j = this.f20403p;
            this.f20403p = 8 + j;
            long v = ((((long) C3752t0.m13757v(4 + j)) & 255) << 32) | ((((long) C3752t0.m13757v(2 + j)) & 255) << 16) | (((long) C3752t0.m13757v(j)) & 255) | ((((long) C3752t0.m13757v(1 + j)) & 255) << 8) | ((((long) C3752t0.m13757v(3 + j)) & 255) << 24) | ((((long) C3752t0.m13757v(5 + j)) & 255) << 40);
            return ((((long) C3752t0.m13757v(j + 7)) & 255) << 56) | ((((long) C3752t0.m13757v(6 + j)) & 255) << 48) | v;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
            if (com.google.protobuf.C3752t0.m13757v(r4) < 0) goto L_0x008a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() {
            /*
                r10 = this;
                long r0 = r10.f20403p
                long r2 = r10.f20406s
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto L_0x000a
                goto L_0x008a
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.C3752t0.m13757v(r0)
                if (r0 < 0) goto L_0x001a
                long r4 = r10.f20403p
                long r4 = r4 + r2
                r10.f20403p = r4
                return r0
            L_0x001a:
                long r6 = r10.f20406s
                long r8 = r10.f20403p
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0026
                goto L_0x008a
            L_0x0026:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0034
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0090
            L_0x0034:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0043
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x0041:
                r6 = r4
                goto L_0x0090
            L_0x0043:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0053
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x0090
            L_0x0053:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x0090
            L_0x008a:
                long r0 = r10.mo23024g()
                int r1 = (int) r0
                return r1
            L_0x0090:
                r10.f20403p = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3613c.readRawVarint32():int");
        }

        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            byte b;
            long j4 = this.f20403p;
            if (this.f20406s != j4) {
                long j5 = j4 + 1;
                byte v = C3752t0.m13757v(j4);
                if (v >= 0) {
                    this.f20403p++;
                    return (long) v;
                } else if (this.f20406s - this.f20403p >= 10) {
                    long j6 = j5 + 1;
                    byte v2 = v ^ (C3752t0.m13757v(j5) << 7);
                    if (v2 < 0) {
                        b = v2 ^ Byte.MIN_VALUE;
                    } else {
                        long j7 = j6 + 1;
                        byte v3 = v2 ^ (C3752t0.m13757v(j6) << 14);
                        if (v3 >= 0) {
                            j = (long) (v3 ^ 16256);
                        } else {
                            j6 = j7 + 1;
                            byte v4 = v3 ^ (C3752t0.m13757v(j7) << 21);
                            if (v4 < 0) {
                                b = v4 ^ -2080896;
                            } else {
                                j7 = j6 + 1;
                                long v5 = ((long) v4) ^ (((long) C3752t0.m13757v(j6)) << 28);
                                if (v5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j8 = j7 + 1;
                                    long v6 = v5 ^ (((long) C3752t0.m13757v(j7)) << 35);
                                    if (v6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j7 = j8 + 1;
                                        v5 = v6 ^ (((long) C3752t0.m13757v(j8)) << 42);
                                        if (v5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j8 = j7 + 1;
                                            v6 = v5 ^ (((long) C3752t0.m13757v(j7)) << 49);
                                            if (v6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                j7 = j8 + 1;
                                                j = (v6 ^ (((long) C3752t0.m13757v(j8)) << 56)) ^ 71499008037633920L;
                                                if (j < 0) {
                                                    long j9 = 1 + j7;
                                                    if (((long) C3752t0.m13757v(j7)) >= 0) {
                                                        j6 = j9;
                                                        this.f20403p = j6;
                                                        return j;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = v6 ^ j2;
                                    j6 = j8;
                                    this.f20403p = j6;
                                    return j;
                                }
                                j = v5 ^ j3;
                            }
                        }
                        j6 = j7;
                        this.f20403p = j6;
                        return j;
                    }
                    j = (long) b;
                    this.f20403p = j6;
                    return j;
                }
            }
            return mo23024g();
        }

        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.f20406s;
                long j3 = this.f20403p;
                if (j <= j2 - j3) {
                    byte[] bArr = new byte[readRawVarint32];
                    C3752t0.m13749n(j3, bArr, 0, j);
                    String str = new String(bArr, Internal.f20591a);
                    this.f20403p += j;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= m12451i()) {
                byte[] bArr2 = new byte[readRawVarint32];
                m12449f(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.f20591a);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.f20406s;
                long j3 = this.f20403p;
                if (j <= j2 - j3) {
                    String g = C3759u0.m13840g(this.f20394g, (int) (j3 - this.f20404q), readRawVarint32);
                    this.f20403p += j;
                    return g;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= m12451i()) {
                byte[] bArr = new byte[readRawVarint32];
                m12449f(bArr, 0, readRawVarint32);
                return C3759u0.m13841h(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public int readTag() {
            if (isAtEnd()) {
                this.f20400m = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f20400m = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f20400m;
            }
            throw InvalidProtocolBufferException.m12800b();
        }

        public int readUInt32() {
            return readRawVarint32();
        }

        public long readUInt64() {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.f20402o = (int) ((((long) this.f20401n) + this.f20403p) - this.f20404q);
        }

        public boolean skipField(int i) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                m12452j();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3613c.skipMessage():void");
        }

        public void skipRawBytes(int i) {
            if (i >= 0 && ((long) i) <= (((long) (this.f20397j - this.f20401n)) - this.f20403p) + this.f20404q) {
                while (i > 0) {
                    if (m12447d() == 0) {
                        m12448e();
                    }
                    int min = Math.min(i, (int) m12447d());
                    i -= min;
                    this.f20403p += (long) min;
                }
            } else if (i < 0) {
                throw InvalidProtocolBufferException.m12804f();
            } else {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        private C3613c(Iterable<ByteBuffer> iterable, int i, boolean z) {
            super();
            this.f20399l = Integer.MAX_VALUE;
            this.f20397j = i;
            this.f20392e = iterable;
            this.f20393f = iterable.iterator();
            this.f20395h = z;
            this.f20401n = 0;
            this.f20402o = 0;
            if (i == 0) {
                this.f20394g = Internal.EMPTY_BYTE_BUFFER;
                this.f20403p = 0;
                this.f20404q = 0;
                this.f20406s = 0;
                this.f20405r = 0;
                return;
            }
            m12454l();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3613c.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public boolean skipField(int i, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int a = WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(a);
                codedOutputStream.writeRawVarint32(a);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedInputStream$d */
    private static final class C3614d extends CodedInputStream {

        /* renamed from: e */
        private final InputStream f20407e;

        /* renamed from: f */
        private final byte[] f20408f;

        /* renamed from: g */
        private int f20409g;

        /* renamed from: h */
        private int f20410h;

        /* renamed from: i */
        private int f20411i;

        /* renamed from: j */
        private int f20412j;

        /* renamed from: k */
        private int f20413k;

        /* renamed from: l */
        private int f20414l;

        /* renamed from: m */
        private C3615a f20415m;

        /* renamed from: com.google.protobuf.CodedInputStream$d$a */
        private interface C3615a {
            /* renamed from: a */
            void mo23026a();
        }

        /* renamed from: d */
        private ByteString m12456d(int i) {
            byte[] f = m12458f(i);
            if (f != null) {
                return ByteString.copyFrom(f);
            }
            int i2 = this.f20411i;
            int i3 = this.f20409g;
            int i4 = i3 - i2;
            this.f20413k += i3;
            this.f20411i = 0;
            this.f20409g = 0;
            List<byte[]> g = m12459g(i - i4);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f20408f, i2, bArr, 0, i4);
            for (byte[] next : g) {
                System.arraycopy(next, 0, bArr, i4, next.length);
                i4 += next.length;
            }
            return ByteString.m12412k(bArr);
        }

        /* renamed from: e */
        private byte[] m12457e(int i, boolean z) {
            byte[] f = m12458f(i);
            if (f != null) {
                return z ? (byte[]) f.clone() : f;
            }
            int i2 = this.f20411i;
            int i3 = this.f20409g;
            int i4 = i3 - i2;
            this.f20413k += i3;
            this.f20411i = 0;
            this.f20409g = 0;
            List<byte[]> g = m12459g(i - i4);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f20408f, i2, bArr, 0, i4);
            for (byte[] next : g) {
                System.arraycopy(next, 0, bArr, i4, next.length);
                i4 += next.length;
            }
            return bArr;
        }

        /* renamed from: f */
        private byte[] m12458f(int i) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i >= 0) {
                int i2 = this.f20413k;
                int i3 = this.f20411i;
                int i4 = i2 + i3 + i;
                if (i4 - this.f20381c <= 0) {
                    int i5 = this.f20414l;
                    if (i4 <= i5) {
                        int i6 = this.f20409g - i3;
                        int i7 = i - i6;
                        if (i7 >= 4096 && i7 > this.f20407e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i];
                        System.arraycopy(this.f20408f, this.f20411i, bArr, 0, i6);
                        this.f20413k += this.f20409g;
                        this.f20411i = 0;
                        this.f20409g = 0;
                        while (i6 < i) {
                            int read = this.f20407e.read(bArr, i6, i - i6);
                            if (read != -1) {
                                this.f20413k += read;
                                i6 += read;
                            } else {
                                throw InvalidProtocolBufferException.m12808j();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i5 - i2) - i3);
                    throw InvalidProtocolBufferException.m12808j();
                }
                throw InvalidProtocolBufferException.m12807i();
            }
            throw InvalidProtocolBufferException.m12804f();
        }

        /* renamed from: g */
        private List<byte[]> m12459g(int i) {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int min = Math.min(i, 4096);
                byte[] bArr = new byte[min];
                int i2 = 0;
                while (i2 < min) {
                    int read = this.f20407e.read(bArr, i2, min - i2);
                    if (read != -1) {
                        this.f20413k += read;
                        i2 += read;
                    } else {
                        throw InvalidProtocolBufferException.m12808j();
                    }
                }
                i -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        /* renamed from: i */
        private void m12460i() {
            int i = this.f20409g + this.f20410h;
            this.f20409g = i;
            int i2 = this.f20413k + i;
            int i3 = this.f20414l;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.f20410h = i4;
                this.f20409g = i - i4;
                return;
            }
            this.f20410h = 0;
        }

        /* renamed from: j */
        private void m12461j(int i) {
            if (m12466o(i)) {
                return;
            }
            if (i > (this.f20381c - this.f20413k) - this.f20411i) {
                throw InvalidProtocolBufferException.m12807i();
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
            throw new java.lang.IllegalStateException(r8.f20407e.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m12462k(int r9) {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0099
                int r0 = r8.f20413k
                int r1 = r8.f20411i
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.f20414l
                if (r2 > r3) goto L_0x008f
                com.google.protobuf.CodedInputStream$d$a r2 = r8.f20415m
                r3 = 0
                if (r2 != 0) goto L_0x0071
                int r0 = r0 + r1
                r8.f20413k = r0
                int r0 = r8.f20409g
                int r0 = r0 - r1
                r8.f20409g = r3
                r8.f20411i = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0069
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f20407e     // Catch:{ all -> 0x005f }
                long r4 = (long) r0     // Catch:{ all -> 0x005f }
                long r0 = r1.skip(r4)     // Catch:{ all -> 0x005f }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x003a
                int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x003a
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 != 0) goto L_0x0037
                goto L_0x0069
            L_0x0037:
                int r1 = (int) r0     // Catch:{ all -> 0x005f }
                int r3 = r3 + r1
                goto L_0x001d
            L_0x003a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
                r2.<init>()     // Catch:{ all -> 0x005f }
                java.io.InputStream r4 = r8.f20407e     // Catch:{ all -> 0x005f }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005f }
                r2.append(r4)     // Catch:{ all -> 0x005f }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005f }
                r2.append(r0)     // Catch:{ all -> 0x005f }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005f }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005f }
                r9.<init>(r0)     // Catch:{ all -> 0x005f }
                throw r9     // Catch:{ all -> 0x005f }
            L_0x005f:
                r9 = move-exception
                int r0 = r8.f20413k
                int r0 = r0 + r3
                r8.f20413k = r0
                r8.m12460i()
                throw r9
            L_0x0069:
                int r0 = r8.f20413k
                int r0 = r0 + r3
                r8.f20413k = r0
                r8.m12460i()
            L_0x0071:
                if (r3 >= r9) goto L_0x008e
                int r0 = r8.f20409g
                int r1 = r8.f20411i
                int r1 = r0 - r1
                r8.f20411i = r0
                r0 = 1
                r8.m12461j(r0)
            L_0x007f:
                int r2 = r9 - r1
                int r3 = r8.f20409g
                if (r2 <= r3) goto L_0x008c
                int r1 = r1 + r3
                r8.f20411i = r3
                r8.m12461j(r0)
                goto L_0x007f
            L_0x008c:
                r8.f20411i = r2
            L_0x008e:
                return
            L_0x008f:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.skipRawBytes(r3)
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.m12808j()
                throw r9
            L_0x0099:
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.m12804f()
                goto L_0x009f
            L_0x009e:
                throw r9
            L_0x009f:
                goto L_0x009e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3614d.m12462k(int):void");
        }

        /* renamed from: l */
        private void m12463l() {
            if (this.f20409g - this.f20411i >= 10) {
                m12464m();
            } else {
                m12465n();
            }
        }

        /* renamed from: m */
        private void m12464m() {
            int i = 0;
            while (i < 10) {
                byte[] bArr = this.f20408f;
                int i2 = this.f20411i;
                this.f20411i = i2 + 1;
                if (bArr[i2] < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: n */
        private void m12465n() {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: o */
        private boolean m12466o(int i) {
            int i2 = this.f20411i;
            if (i2 + i > this.f20409g) {
                int i3 = this.f20381c;
                int i4 = this.f20413k;
                if (i > (i3 - i4) - i2 || i4 + i2 + i > this.f20414l) {
                    return false;
                }
                C3615a aVar = this.f20415m;
                if (aVar != null) {
                    aVar.mo23026a();
                }
                int i5 = this.f20411i;
                if (i5 > 0) {
                    int i6 = this.f20409g;
                    if (i6 > i5) {
                        byte[] bArr = this.f20408f;
                        System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                    }
                    this.f20413k += i5;
                    this.f20409g -= i5;
                    this.f20411i = 0;
                }
                InputStream inputStream = this.f20407e;
                byte[] bArr2 = this.f20408f;
                int i7 = this.f20409g;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.f20381c - this.f20413k) - i7));
                if (read == 0 || read < -1 || read > this.f20408f.length) {
                    throw new IllegalStateException(this.f20407e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f20409g += read;
                    m12460i();
                    if (this.f20409g >= i) {
                        return true;
                    }
                    return m12466o(i);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
            }
        }

        public void checkLastTagWas(int i) {
            if (this.f20412j != i) {
                throw InvalidProtocolBufferException.m12799a();
            }
        }

        public void enableAliasing(boolean z) {
        }

        public int getBytesUntilLimit() {
            int i = this.f20414l;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.f20413k + this.f20411i);
        }

        public int getLastTag() {
            return this.f20412j;
        }

        public int getTotalBytesRead() {
            return this.f20413k + this.f20411i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public long mo23025h() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        public boolean isAtEnd() {
            return this.f20411i == this.f20409g && !m12466o(1);
        }

        public void popLimit(int i) {
            this.f20414l = i;
            m12460i();
        }

        public int pushLimit(int i) {
            if (i >= 0) {
                int i2 = i + this.f20413k + this.f20411i;
                int i3 = this.f20414l;
                if (i2 <= i3) {
                    this.f20414l = i2;
                    m12460i();
                    return i3;
                }
                throw InvalidProtocolBufferException.m12808j();
            }
            throw InvalidProtocolBufferException.m12804f();
        }

        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() {
            int readRawVarint32 = readRawVarint32();
            int i = this.f20409g;
            int i2 = this.f20411i;
            if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
                return m12457e(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.f20408f, i2, i2 + readRawVarint32);
            this.f20411i += readRawVarint32;
            return copyOfRange;
        }

        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            int i = this.f20409g;
            int i2 = this.f20411i;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f20408f, i2, i2 + readRawVarint32));
                this.f20411i += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(m12457e(readRawVarint32, true));
            }
        }

        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            int i = this.f20409g;
            int i2 = this.f20411i;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f20408f, i2, readRawVarint32);
                this.f20411i += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return m12456d(readRawVarint32);
            }
        }

        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() {
            return readRawVarint32();
        }

        public int readFixed32() {
            return readRawLittleEndian32();
        }

        public long readFixed64() {
            return readRawLittleEndian64();
        }

        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public int readInt32() {
            return readRawVarint32();
        }

        public long readInt64() {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public byte readRawByte() {
            if (this.f20411i == this.f20409g) {
                m12461j(1);
            }
            byte[] bArr = this.f20408f;
            int i = this.f20411i;
            this.f20411i = i + 1;
            return bArr[i];
        }

        public byte[] readRawBytes(int i) {
            int i2 = this.f20411i;
            if (i > this.f20409g - i2 || i <= 0) {
                return m12457e(i, false);
            }
            int i3 = i + i2;
            this.f20411i = i3;
            return Arrays.copyOfRange(this.f20408f, i2, i3);
        }

        public int readRawLittleEndian32() {
            int i = this.f20411i;
            if (this.f20409g - i < 4) {
                m12461j(4);
                i = this.f20411i;
            }
            byte[] bArr = this.f20408f;
            this.f20411i = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() {
            int i = this.f20411i;
            if (this.f20409g - i < 8) {
                m12461j(8);
                i = this.f20411i;
            }
            byte[] bArr = this.f20408f;
            this.f20411i = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() {
            /*
                r5 = this;
                int r0 = r5.f20411i
                int r1 = r5.f20409g
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f20408f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f20411i = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.mo23025h()
                int r1 = (int) r0
                return r1
            L_0x0070:
                r5.f20411i = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3614d.readRawVarint32():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() {
            /*
                r11 = this;
                int r0 = r11.f20411i
                int r1 = r11.f20409g
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f20408f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f20411i = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r1 = r1 ^ r3
                r2 = r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r3 = r3 ^ r5
            L_0x0072:
                r2 = r3
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0072
            L_0x00b6:
                long r0 = r11.mo23025h()
                return r0
            L_0x00bb:
                r1 = r0
                goto L_0x0072
            L_0x00bd:
                r11.f20411i = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3614d.readRawVarint64():long");
        }

        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= this.f20409g - this.f20411i) {
                String str = new String(this.f20408f, this.f20411i, readRawVarint32, Internal.f20591a);
                this.f20411i += readRawVarint32;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 > this.f20409g) {
                    return new String(m12457e(readRawVarint32, false), Internal.f20591a);
                }
                m12461j(readRawVarint32);
                String str2 = new String(this.f20408f, this.f20411i, readRawVarint32, Internal.f20591a);
                this.f20411i += readRawVarint32;
                return str2;
            }
        }

        public String readStringRequireUtf8() {
            byte[] bArr;
            int readRawVarint32 = readRawVarint32();
            int i = this.f20411i;
            int i2 = this.f20409g;
            if (readRawVarint32 <= i2 - i && readRawVarint32 > 0) {
                bArr = this.f20408f;
                this.f20411i = i + readRawVarint32;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= i2) {
                    m12461j(readRawVarint32);
                    bArr = this.f20408f;
                    this.f20411i = readRawVarint32 + 0;
                } else {
                    bArr = m12457e(readRawVarint32, false);
                }
                i = 0;
            }
            return C3759u0.m13841h(bArr, i, readRawVarint32);
        }

        public int readTag() {
            if (isAtEnd()) {
                this.f20412j = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f20412j = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f20412j;
            }
            throw InvalidProtocolBufferException.m12800b();
        }

        public int readUInt32() {
            return readRawVarint32();
        }

        public long readUInt64() {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.f20413k = -this.f20411i;
        }

        public boolean skipField(int i) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                m12463l();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3614d.skipMessage():void");
        }

        public void skipRawBytes(int i) {
            int i2 = this.f20409g;
            int i3 = this.f20411i;
            if (i > i2 - i3 || i < 0) {
                m12462k(i);
            } else {
                this.f20411i = i3 + i;
            }
        }

        private C3614d(InputStream inputStream, int i) {
            super();
            this.f20414l = Integer.MAX_VALUE;
            this.f20415m = null;
            Internal.m12791b(inputStream, "input");
            this.f20407e = inputStream;
            this.f20408f = new byte[i];
            this.f20409g = 0;
            this.f20411i = 0;
            this.f20413k = 0;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3614d.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public boolean skipField(int i, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int a = WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(a);
                codedOutputStream.writeRawVarint32(a);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: com.google.protobuf.CodedInputStream$e */
    private static final class C3616e extends CodedInputStream {

        /* renamed from: e */
        private final ByteBuffer f20416e;

        /* renamed from: f */
        private final boolean f20417f;

        /* renamed from: g */
        private final long f20418g;

        /* renamed from: h */
        private long f20419h;

        /* renamed from: i */
        private long f20420i;

        /* renamed from: j */
        private long f20421j;

        /* renamed from: k */
        private int f20422k;

        /* renamed from: l */
        private int f20423l;

        /* renamed from: m */
        private boolean f20424m;

        /* renamed from: n */
        private int f20425n;

        /* renamed from: d */
        private int m12469d(long j) {
            return (int) (j - this.f20418g);
        }

        /* renamed from: e */
        static boolean m12470e() {
            return C3752t0.m13720I();
        }

        /* renamed from: g */
        private void m12471g() {
            long j = this.f20419h + ((long) this.f20422k);
            this.f20419h = j;
            int i = (int) (j - this.f20421j);
            int i2 = this.f20425n;
            if (i > i2) {
                int i3 = i - i2;
                this.f20422k = i3;
                this.f20419h = j - ((long) i3);
                return;
            }
            this.f20422k = 0;
        }

        /* renamed from: h */
        private int m12472h() {
            return (int) (this.f20419h - this.f20420i);
        }

        /* renamed from: i */
        private void m12473i() {
            if (m12472h() >= 10) {
                m12474j();
            } else {
                m12475k();
            }
        }

        /* renamed from: j */
        private void m12474j() {
            int i = 0;
            while (i < 10) {
                long j = this.f20420i;
                this.f20420i = 1 + j;
                if (C3752t0.m13757v(j) < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* renamed from: k */
        private void m12475k() {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.m12808j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.f20416e.position(r0);
            r3.f20416e.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* renamed from: l */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer m12476l(long r4, long r6) {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f20416e
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f20416e
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f20416e     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r4 = r3.m12469d(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f20416e     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r5 = r3.m12469d(r6)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f20416e     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r5 = r3.f20416e
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f20416e
                r5.limit(r1)
                return r4
            L_0x002f:
                r4 = move-exception
                goto L_0x0036
            L_0x0031:
                com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.m12808j()     // Catch:{ all -> 0x002f }
                throw r4     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r5 = r3.f20416e
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f20416e
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3616e.m12476l(long, long):java.nio.ByteBuffer");
        }

        public void checkLastTagWas(int i) {
            if (this.f20423l != i) {
                throw InvalidProtocolBufferException.m12799a();
            }
        }

        public void enableAliasing(boolean z) {
            this.f20424m = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public long mo23027f() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.m12803e();
        }

        public int getBytesUntilLimit() {
            int i = this.f20425n;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.f20423l;
        }

        public int getTotalBytesRead() {
            return (int) (this.f20420i - this.f20421j);
        }

        public boolean isAtEnd() {
            return this.f20420i == this.f20419h;
        }

        public void popLimit(int i) {
            this.f20425n = i;
            m12471g();
        }

        public int pushLimit(int i) {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i2 = this.f20425n;
                if (totalBytesRead <= i2) {
                    this.f20425n = totalBytesRead;
                    m12471g();
                    return i2;
                }
                throw InvalidProtocolBufferException.m12808j();
            }
            throw InvalidProtocolBufferException.m12804f();
        }

        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > m12472h()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            } else if (this.f20417f || !this.f20424m) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                C3752t0.m13749n(this.f20420i, bArr, 0, j);
                this.f20420i += j;
                return ByteBuffer.wrap(bArr);
            } else {
                long j2 = this.f20420i;
                long j3 = (long) readRawVarint32;
                ByteBuffer l = m12476l(j2, j2 + j3);
                this.f20420i += j3;
                return l;
            }
        }

        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > m12472h()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            } else if (!this.f20417f || !this.f20424m) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                C3752t0.m13749n(this.f20420i, bArr, 0, j);
                this.f20420i += j;
                return ByteString.m12412k(bArr);
            } else {
                long j2 = this.f20420i;
                long j3 = (long) readRawVarint32;
                ByteBuffer l = m12476l(j2, j2 + j3);
                this.f20420i += j3;
                return ByteString.m12411j(l);
            }
        }

        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() {
            return readRawVarint32();
        }

        public int readFixed32() {
            return readRawLittleEndian32();
        }

        public long readFixed64() {
            return readRawLittleEndian64();
        }

        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public int readInt32() {
            return readRawVarint32();
        }

        public long readInt64() {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public byte readRawByte() {
            long j = this.f20420i;
            if (j != this.f20419h) {
                this.f20420i = 1 + j;
                return C3752t0.m13757v(j);
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public byte[] readRawBytes(int i) {
            if (i >= 0 && i <= m12472h()) {
                byte[] bArr = new byte[i];
                long j = this.f20420i;
                long j2 = (long) i;
                m12476l(j, j + j2).get(bArr);
                this.f20420i += j2;
                return bArr;
            } else if (i > 0) {
                throw InvalidProtocolBufferException.m12808j();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.m12804f();
            }
        }

        public int readRawLittleEndian32() {
            long j = this.f20420i;
            if (this.f20419h - j >= 4) {
                this.f20420i = 4 + j;
                return ((C3752t0.m13757v(j + 3) & 255) << 24) | (C3752t0.m13757v(j) & 255) | ((C3752t0.m13757v(1 + j) & 255) << 8) | ((C3752t0.m13757v(2 + j) & 255) << 16);
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        public long readRawLittleEndian64() {
            long j = this.f20420i;
            if (this.f20419h - j >= 8) {
                this.f20420i = 8 + j;
                return ((((long) C3752t0.m13757v(j + 7)) & 255) << 56) | (((long) C3752t0.m13757v(j)) & 255) | ((((long) C3752t0.m13757v(1 + j)) & 255) << 8) | ((((long) C3752t0.m13757v(2 + j)) & 255) << 16) | ((((long) C3752t0.m13757v(3 + j)) & 255) << 24) | ((((long) C3752t0.m13757v(4 + j)) & 255) << 32) | ((((long) C3752t0.m13757v(5 + j)) & 255) << 40) | ((((long) C3752t0.m13757v(6 + j)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.m12808j();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (com.google.protobuf.C3752t0.m13757v(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() {
            /*
                r10 = this;
                long r0 = r10.f20420i
                long r2 = r10.f20419h
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto L_0x000a
                goto L_0x0085
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.C3752t0.m13757v(r0)
                if (r0 < 0) goto L_0x0017
                r10.f20420i = r4
                return r0
            L_0x0017:
                long r6 = r10.f20419h
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0021
                goto L_0x0085
            L_0x0021:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002f
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x008b
            L_0x002f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003c:
                r6 = r4
                goto L_0x008b
            L_0x003e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x008b
            L_0x004e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.C3752t0.m13757v(r4)
                if (r1 >= 0) goto L_0x008b
            L_0x0085:
                long r0 = r10.mo23027f()
                int r1 = (int) r0
                return r1
            L_0x008b:
                r10.f20420i = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3616e.readRawVarint32():int");
        }

        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            byte b;
            long j4 = this.f20420i;
            if (this.f20419h != j4) {
                long j5 = j4 + 1;
                byte v = C3752t0.m13757v(j4);
                if (v >= 0) {
                    this.f20420i = j5;
                    return (long) v;
                } else if (this.f20419h - j5 >= 9) {
                    long j6 = j5 + 1;
                    byte v2 = v ^ (C3752t0.m13757v(j5) << 7);
                    if (v2 < 0) {
                        b = v2 ^ Byte.MIN_VALUE;
                    } else {
                        long j7 = j6 + 1;
                        byte v3 = v2 ^ (C3752t0.m13757v(j6) << 14);
                        if (v3 >= 0) {
                            j = (long) (v3 ^ 16256);
                        } else {
                            j6 = j7 + 1;
                            byte v4 = v3 ^ (C3752t0.m13757v(j7) << 21);
                            if (v4 < 0) {
                                b = v4 ^ -2080896;
                            } else {
                                j7 = j6 + 1;
                                long v5 = ((long) v4) ^ (((long) C3752t0.m13757v(j6)) << 28);
                                if (v5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j8 = j7 + 1;
                                    long v6 = v5 ^ (((long) C3752t0.m13757v(j7)) << 35);
                                    if (v6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j7 = j8 + 1;
                                        v5 = v6 ^ (((long) C3752t0.m13757v(j8)) << 42);
                                        if (v5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j8 = j7 + 1;
                                            v6 = v5 ^ (((long) C3752t0.m13757v(j7)) << 49);
                                            if (v6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                j7 = j8 + 1;
                                                j = (v6 ^ (((long) C3752t0.m13757v(j8)) << 56)) ^ 71499008037633920L;
                                                if (j < 0) {
                                                    long j9 = 1 + j7;
                                                    if (((long) C3752t0.m13757v(j7)) >= 0) {
                                                        j6 = j9;
                                                        this.f20420i = j6;
                                                        return j;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = v6 ^ j2;
                                    j6 = j8;
                                    this.f20420i = j6;
                                    return j;
                                }
                                j = v5 ^ j3;
                            }
                        }
                        j6 = j7;
                        this.f20420i = j6;
                        return j;
                    }
                    j = (long) b;
                    this.f20420i = j6;
                    return j;
                }
            }
            return mo23027f();
        }

        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= m12472h()) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                C3752t0.m13749n(this.f20420i, bArr, 0, j);
                String str = new String(bArr, Internal.f20591a);
                this.f20420i += j;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= m12472h()) {
                String g = C3759u0.m13840g(this.f20416e, m12469d(this.f20420i), readRawVarint32);
                this.f20420i += (long) readRawVarint32;
                return g;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.m12804f();
                }
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        public int readTag() {
            if (isAtEnd()) {
                this.f20423l = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f20423l = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f20423l;
            }
            throw InvalidProtocolBufferException.m12800b();
        }

        public int readUInt32() {
            return readRawVarint32();
        }

        public long readUInt64() {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.f20421j = this.f20420i;
        }

        public boolean skipField(int i) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                m12473i();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3616e.skipMessage():void");
        }

        public void skipRawBytes(int i) {
            if (i >= 0 && i <= m12472h()) {
                this.f20420i += (long) i;
            } else if (i < 0) {
                throw InvalidProtocolBufferException.m12804f();
            } else {
                throw InvalidProtocolBufferException.m12808j();
            }
        }

        private C3616e(ByteBuffer byteBuffer, boolean z) {
            super();
            this.f20425n = Integer.MAX_VALUE;
            this.f20416e = byteBuffer;
            long i = C3752t0.m13744i(byteBuffer);
            this.f20418g = i;
            this.f20419h = ((long) byteBuffer.limit()) + i;
            long position = i + ((long) byteBuffer.position());
            this.f20420i = position;
            this.f20421j = position;
            this.f20417f = z;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.C3616e.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int i2 = this.f20379a;
            if (i2 < this.f20380b) {
                this.f20379a = i2 + 1;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(WireFormat.m13092a(i, 4));
                this.f20379a--;
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            if (this.f20379a < this.f20380b) {
                int pushLimit = pushLimit(readRawVarint32);
                this.f20379a++;
                T t = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
                checkLastTagWas(0);
                this.f20379a--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.m12806h();
        }

        public boolean skipField(int i, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int a = WireFormat.m13092a(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(a);
                codedOutputStream.writeRawVarint32(a);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: a */
    static CodedInputStream m12439a(Iterable<ByteBuffer> iterable, boolean z) {
        boolean z2 = false;
        int i = 0;
        for (ByteBuffer next : iterable) {
            i += next.remaining();
            if (next.hasArray()) {
                z2 |= true;
            } else {
                z2 = next.isDirect() ? z2 | true : z2 | true;
            }
        }
        if (z2) {
            return new C3613c(iterable, i, z);
        }
        return newInstance((InputStream) new C3727p(iterable));
    }

    /* renamed from: b */
    static CodedInputStream m12440b(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return m12441c(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && C3616e.m12470e()) {
            return new C3616e(byteBuffer, z);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return m12441c(bArr, 0, remaining, true);
    }

    /* renamed from: c */
    static CodedInputStream m12441c(byte[] bArr, int i, int i2, boolean z) {
        C3612b bVar = new C3612b(bArr, i, i2, z);
        try {
            bVar.pushLimit(i2);
            return bVar;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i, InputStream inputStream) {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & 127) << i3;
                if ((read & 128) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw InvalidProtocolBufferException.m12808j();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.m12808j();
            } else if ((read2 & 128) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw InvalidProtocolBufferException.m12803e();
    }

    public abstract void checkLastTagWas(int i);

    public abstract void enableAliasing(boolean z);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int i);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.Builder builder);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i) {
        if (i >= 0) {
            int i2 = this.f20380b;
            this.f20380b = i;
            return i2;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
    }

    public final int setSizeLimit(int i) {
        if (i >= 0) {
            int i2 = this.f20381c;
            this.f20381c = i;
            return i2;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public abstract boolean skipField(int i);

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream);

    public abstract void skipMessage();

    public abstract void skipMessage(CodedOutputStream codedOutputStream);

    public abstract void skipRawBytes(int i);

    private CodedInputStream() {
        this.f20380b = 100;
        this.f20381c = Integer.MAX_VALUE;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        } else {
            return new C3614d(inputStream, i);
        }
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!C3616e.m12470e()) {
            return newInstance((InputStream) new C3727p(iterable));
        }
        return m12439a(iterable, false);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        return m12441c(bArr, i, i2, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return m12440b(byteBuffer, false);
    }
}
