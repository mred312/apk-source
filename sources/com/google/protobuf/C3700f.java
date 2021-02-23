package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.util.List;

/* renamed from: com.google.protobuf.f */
/* compiled from: CodedInputStreamReader */
final class C3700f implements C3714k0 {

    /* renamed from: a */
    private final CodedInputStream f20771a;

    /* renamed from: b */
    private int f20772b;

    /* renamed from: c */
    private int f20773c;

    /* renamed from: d */
    private int f20774d = 0;

    /* renamed from: com.google.protobuf.f$a */
    /* compiled from: CodedInputStreamReader */
    static /* synthetic */ class C3701a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20775a;

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
                f20775a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20775a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3700f.C3701a.<clinit>():void");
        }
    }

    private C3700f(CodedInputStream codedInputStream) {
        Internal.m12791b(codedInputStream, "input");
        CodedInputStream codedInputStream2 = codedInputStream;
        this.f20771a = codedInputStream2;
        codedInputStream2.f20382d = this;
    }

    /* renamed from: P */
    public static C3700f m13281P(CodedInputStream codedInputStream) {
        C3700f fVar = codedInputStream.f20382d;
        if (fVar != null) {
            return fVar;
        }
        return new C3700f(codedInputStream);
    }

    /* renamed from: Q */
    private Object m13282Q(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (C3701a.f20775a[fieldType.ordinal()]) {
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

    /* renamed from: R */
    private <T> T m13283R(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        int i = this.f20773c;
        this.f20773c = WireFormat.m13092a(WireFormat.getTagFieldNumber(this.f20772b), 4);
        try {
            T c = m0Var.mo23804c();
            m0Var.mo23809h(c, this, extensionRegistryLite);
            m0Var.mo23807f(c);
            if (this.f20772b == this.f20773c) {
                return c;
            }
            throw InvalidProtocolBufferException.m12805g();
        } finally {
            this.f20773c = i;
        }
    }

    /* renamed from: S */
    private <T> T m13284S(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        int readUInt32 = this.f20771a.readUInt32();
        CodedInputStream codedInputStream = this.f20771a;
        if (codedInputStream.f20379a < codedInputStream.f20380b) {
            int pushLimit = codedInputStream.pushLimit(readUInt32);
            T c = m0Var.mo23804c();
            this.f20771a.f20379a++;
            m0Var.mo23809h(c, this, extensionRegistryLite);
            m0Var.mo23807f(c);
            this.f20771a.checkLastTagWas(0);
            CodedInputStream codedInputStream2 = this.f20771a;
            codedInputStream2.f20379a--;
            codedInputStream2.popLimit(pushLimit);
            return c;
        }
        throw InvalidProtocolBufferException.m12806h();
    }

    /* renamed from: U */
    private void m13285U(int i) {
        if (this.f20771a.getTotalBytesRead() != i) {
            throw InvalidProtocolBufferException.m12808j();
        }
    }

    /* renamed from: V */
    private void m13286V(int i) {
        if (WireFormat.getTagWireType(this.f20772b) != i) {
            throw InvalidProtocolBufferException.m12802d();
        }
    }

    /* renamed from: W */
    private void m13287W(int i) {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.m12805g();
        }
    }

    /* renamed from: X */
    private void m13288X(int i) {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.m12805g();
        }
    }

    /* renamed from: A */
    public <T> T mo23813A(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
        m13286V(3);
        return m13283R(C3707h0.m13389a().mo23886d(cls), extensionRegistryLite);
    }

    /* renamed from: B */
    public int mo23814B() {
        int i = this.f20774d;
        if (i != 0) {
            this.f20772b = i;
            this.f20774d = 0;
        } else {
            this.f20772b = this.f20771a.readTag();
        }
        int i2 = this.f20772b;
        if (i2 == 0 || i2 == this.f20773c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i2);
    }

    /* renamed from: C */
    public <T> T mo23815C(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        m13286V(2);
        return m13284S(m0Var, extensionRegistryLite);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (mo23821I() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        throw new com.google.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* renamed from: D */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void mo23816D(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.C3657b<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) {
        /*
            r7 = this;
            r0 = 2
            r7.m13286V(r0)
            com.google.protobuf.CodedInputStream r1 = r7.f20771a
            int r1 = r1.readUInt32()
            com.google.protobuf.CodedInputStream r2 = r7.f20771a
            int r1 = r2.pushLimit(r1)
            K r2 = r9.f20629b
            V r3 = r9.f20631d
        L_0x0014:
            int r4 = r7.mo23814B()     // Catch:{ all -> 0x0065 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005c
            com.google.protobuf.CodedInputStream r5 = r7.f20771a     // Catch:{ all -> 0x0065 }
            boolean r5 = r5.isAtEnd()     // Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x0026
            goto L_0x005c
        L_0x0026:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0047
            if (r4 == r0) goto L_0x003a
            boolean r4 = r7.mo23821I()     // Catch:{ InvalidWireTypeException -> 0x004f }
            if (r4 == 0) goto L_0x0034
            goto L_0x0014
        L_0x0034:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004f }
            r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004f }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x004f }
        L_0x003a:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f20630c     // Catch:{ InvalidWireTypeException -> 0x004f }
            V r5 = r9.f20631d     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Object r3 = r7.m13282Q(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x0047:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f20628a     // Catch:{ InvalidWireTypeException -> 0x004f }
            r5 = 0
            java.lang.Object r2 = r7.m13282Q(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x004f:
            boolean r4 = r7.mo23821I()     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0065 }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0065 }
            throw r8     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r8.put(r2, r3)     // Catch:{ all -> 0x0065 }
            com.google.protobuf.CodedInputStream r8 = r7.f20771a
            r8.popLimit(r1)
            return
        L_0x0065:
            r8 = move-exception
            com.google.protobuf.CodedInputStream r9 = r7.f20771a
            r9.popLimit(r1)
            goto L_0x006d
        L_0x006c:
            throw r8
        L_0x006d:
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3700f.mo23816D(java.util.Map, com.google.protobuf.MapEntryLite$b, com.google.protobuf.ExtensionRegistryLite):void");
    }

    /* renamed from: E */
    public void mo23817E(List<String> list) {
        mo23874T(list, true);
    }

    /* renamed from: F */
    public ByteString mo23818F() {
        m13286V(2);
        return this.f20771a.readBytes();
    }

    /* renamed from: G */
    public void mo23819G(List<Float> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3721m) {
            C3721m mVar = (C3721m) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13287W(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    mVar.addFloat(this.f20771a.readFloat());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else if (tagWireType == 5) {
                do {
                    mVar.addFloat(this.f20771a.readFloat());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13287W(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Float.valueOf(this.f20771a.readFloat()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else if (tagWireType2 == 5) {
                do {
                    list.add(Float.valueOf(this.f20771a.readFloat()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: H */
    public int mo23820H() {
        m13286V(0);
        return this.f20771a.readInt32();
    }

    /* renamed from: I */
    public boolean mo23821I() {
        int i;
        if (this.f20771a.isAtEnd() || (i = this.f20772b) == this.f20773c) {
            return false;
        }
        return this.f20771a.skipField(i);
    }

    /* renamed from: J */
    public int mo23822J() {
        m13286V(5);
        return this.f20771a.readSFixed32();
    }

    /* renamed from: K */
    public void mo23823K(List<ByteString> list) {
        int readTag;
        if (WireFormat.getTagWireType(this.f20772b) == 2) {
            do {
                list.add(mo23818F());
                if (!this.f20771a.isAtEnd()) {
                    readTag = this.f20771a.readTag();
                } else {
                    return;
                }
            } while (readTag == this.f20772b);
            this.f20774d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.m12802d();
    }

    /* renamed from: L */
    public void mo23824L(List<Double> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3706h) {
            C3706h hVar = (C3706h) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 1) {
                do {
                    hVar.addDouble(this.f20771a.readDouble());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13288X(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    hVar.addDouble(this.f20771a.readDouble());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 1) {
                do {
                    list.add(Double.valueOf(this.f20771a.readDouble()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13288X(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Double.valueOf(this.f20771a.readDouble()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: M */
    public long mo23825M() {
        m13286V(0);
        return this.f20771a.readInt64();
    }

    /* renamed from: N */
    public String mo23826N() {
        m13286V(2);
        return this.f20771a.readStringRequireUtf8();
    }

    /* renamed from: O */
    public void mo23827O(List<Long> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 1) {
                do {
                    rVar.addLong(this.f20771a.readFixed64());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13288X(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    rVar.addLong(this.f20771a.readFixed64());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 1) {
                do {
                    list.add(Long.valueOf(this.f20771a.readFixed64()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13288X(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.f20771a.readFixed64()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: T */
    public void mo23874T(List<String> list, boolean z) {
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.f20772b) != 2) {
            throw InvalidProtocolBufferException.m12802d();
        } else if (!(list instanceof LazyStringList) || z) {
            do {
                list.add(z ? mo23826N() : mo23835e());
                if (!this.f20771a.isAtEnd()) {
                    readTag = this.f20771a.readTag();
                } else {
                    return;
                }
            } while (readTag == this.f20772b);
            this.f20774d = readTag;
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.add(mo23818F());
                if (!this.f20771a.isAtEnd()) {
                    readTag2 = this.f20771a.readTag();
                } else {
                    return;
                }
            } while (readTag2 == this.f20772b);
            this.f20774d = readTag2;
        }
    }

    /* renamed from: a */
    public void mo23829a(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    oVar.addInt(this.f20771a.readSInt32());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    oVar.addInt(this.f20771a.readSInt32());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readSInt32()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f20771a.readSInt32()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: b */
    public long mo23831b() {
        m13286V(0);
        return this.f20771a.readUInt64();
    }

    /* renamed from: c */
    public long mo23832c() {
        m13286V(1);
        return this.f20771a.readFixed64();
    }

    /* renamed from: d */
    public void mo23834d(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13287W(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    oVar.addInt(this.f20771a.readSFixed32());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else if (tagWireType == 5) {
                do {
                    oVar.addInt(this.f20771a.readSFixed32());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13287W(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Integer.valueOf(this.f20771a.readSFixed32()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readSFixed32()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: e */
    public String mo23835e() {
        m13286V(2);
        return this.f20771a.readString();
    }

    /* renamed from: f */
    public void mo23836f(List<String> list) {
        mo23874T(list, false);
    }

    /* renamed from: g */
    public void mo23837g(List<Long> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    rVar.addLong(this.f20771a.readSInt64());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    rVar.addLong(this.f20771a.readSInt64());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20771a.readSInt64()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f20771a.readSInt64()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    public int getTag() {
        return this.f20772b;
    }

    /* renamed from: h */
    public <T> void mo23839h(List<T> list, C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        int readTag;
        if (WireFormat.getTagWireType(this.f20772b) == 3) {
            int i = this.f20772b;
            do {
                list.add(m13283R(m0Var, extensionRegistryLite));
                if (!this.f20771a.isAtEnd() && this.f20774d == 0) {
                    readTag = this.f20771a.readTag();
                } else {
                    return;
                }
            } while (readTag == i);
            this.f20774d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.m12802d();
    }

    /* renamed from: i */
    public void mo23840i(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    oVar.addInt(this.f20771a.readUInt32());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    oVar.addInt(this.f20771a.readUInt32());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readUInt32()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f20771a.readUInt32()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: j */
    public <T> T mo23841j(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
        m13286V(2);
        return m13284S(C3707h0.m13389a().mo23886d(cls), extensionRegistryLite);
    }

    /* renamed from: k */
    public int mo23842k() {
        m13286V(5);
        return this.f20771a.readFixed32();
    }

    /* renamed from: l */
    public boolean mo23843l() {
        m13286V(0);
        return this.f20771a.readBool();
    }

    /* renamed from: m */
    public <T> void mo23844m(List<T> list, C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        int readTag;
        if (WireFormat.getTagWireType(this.f20772b) == 2) {
            int i = this.f20772b;
            do {
                list.add(m13284S(m0Var, extensionRegistryLite));
                if (!this.f20771a.isAtEnd() && this.f20774d == 0) {
                    readTag = this.f20771a.readTag();
                } else {
                    return;
                }
            } while (readTag == i);
            this.f20774d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.m12802d();
    }

    /* renamed from: n */
    public long mo23845n() {
        m13286V(1);
        return this.f20771a.readSFixed64();
    }

    /* renamed from: o */
    public void mo23846o(List<Long> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    rVar.addLong(this.f20771a.readUInt64());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    rVar.addLong(this.f20771a.readUInt64());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20771a.readUInt64()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f20771a.readUInt64()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: p */
    public <T> T mo23847p(C3722m0<T> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        m13286V(3);
        return m13283R(m0Var, extensionRegistryLite);
    }

    /* renamed from: q */
    public int mo23848q() {
        m13286V(0);
        return this.f20771a.readUInt32();
    }

    /* renamed from: r */
    public void mo23849r(List<Long> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    rVar.addLong(this.f20771a.readInt64());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    rVar.addLong(this.f20771a.readInt64());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20771a.readInt64()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f20771a.readInt64()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    public double readDouble() {
        m13286V(1);
        return this.f20771a.readDouble();
    }

    public float readFloat() {
        m13286V(5);
        return this.f20771a.readFloat();
    }

    /* renamed from: s */
    public void mo23852s(List<Long> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 1) {
                do {
                    rVar.addLong(this.f20771a.readSFixed64());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13288X(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    rVar.addLong(this.f20771a.readSFixed64());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 1) {
                do {
                    list.add(Long.valueOf(this.f20771a.readSFixed64()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13288X(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.f20771a.readSFixed64()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: t */
    public void mo23853t(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    oVar.addInt(this.f20771a.readInt32());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    oVar.addInt(this.f20771a.readInt32());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readInt32()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f20771a.readInt32()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: u */
    public void mo23854u(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    oVar.addInt(this.f20771a.readEnum());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    oVar.addInt(this.f20771a.readEnum());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readEnum()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f20771a.readEnum()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: v */
    public int mo23855v() {
        m13286V(0);
        return this.f20771a.readEnum();
    }

    /* renamed from: w */
    public void mo23856w(List<Integer> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 2) {
                int readUInt32 = this.f20771a.readUInt32();
                m13287W(readUInt32);
                int totalBytesRead = this.f20771a.getTotalBytesRead() + readUInt32;
                do {
                    oVar.addInt(this.f20771a.readFixed32());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
            } else if (tagWireType == 5) {
                do {
                    oVar.addInt(this.f20771a.readFixed32());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 2) {
                int readUInt322 = this.f20771a.readUInt32();
                m13287W(readUInt322);
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Integer.valueOf(this.f20771a.readFixed32()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
            } else if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20771a.readFixed32()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }

    /* renamed from: x */
    public int mo23857x() {
        m13286V(0);
        return this.f20771a.readSInt32();
    }

    /* renamed from: y */
    public long mo23858y() {
        m13286V(0);
        return this.f20771a.readSInt64();
    }

    /* renamed from: z */
    public void mo23859z(List<Boolean> list) {
        int readTag;
        int readTag2;
        if (list instanceof C3697e) {
            C3697e eVar = (C3697e) list;
            int tagWireType = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType == 0) {
                do {
                    eVar.addBoolean(this.f20771a.readBool());
                    if (!this.f20771a.isAtEnd()) {
                        readTag2 = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.f20772b);
                this.f20774d = readTag2;
            } else if (tagWireType == 2) {
                int totalBytesRead = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    eVar.addBoolean(this.f20771a.readBool());
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead);
                m13285U(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.f20772b);
            if (tagWireType2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f20771a.readBool()));
                    if (!this.f20771a.isAtEnd()) {
                        readTag = this.f20771a.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.f20772b);
                this.f20774d = readTag;
            } else if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f20771a.getTotalBytesRead() + this.f20771a.readUInt32();
                do {
                    list.add(Boolean.valueOf(this.f20771a.readBool()));
                } while (this.f20771a.getTotalBytesRead() < totalBytesRead2);
                m13285U(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.m12802d();
            }
        }
    }
}
