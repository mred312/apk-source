package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.g */
/* compiled from: CodedOutputStreamWriter */
final class C3703g implements Writer {

    /* renamed from: a */
    private final CodedOutputStream f20776a;

    /* renamed from: com.google.protobuf.g$a */
    /* compiled from: CodedOutputStreamWriter */
    static /* synthetic */ class C3704a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20777a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20777a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20777a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3703g.C3704a.<clinit>():void");
        }
    }

    private C3703g(CodedOutputStream codedOutputStream) {
        Internal.m12791b(codedOutputStream, "output");
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        this.f20776a = codedOutputStream2;
        codedOutputStream2.f20428a = this;
    }

    /* renamed from: P */
    public static C3703g m13332P(CodedOutputStream codedOutputStream) {
        C3703g gVar = codedOutputStream.f20428a;
        if (gVar != null) {
            return gVar;
        }
        return new C3703g(codedOutputStream);
    }

    /* renamed from: Q */
    private <V> void m13333Q(int i, boolean z, V v, MapEntryLite.C3657b<Boolean, V> bVar) {
        this.f20776a.writeTag(i, 2);
        this.f20776a.writeUInt32NoTag(MapEntryLite.m12848a(bVar, Boolean.valueOf(z), v));
        MapEntryLite.m12851e(this.f20776a, bVar, Boolean.valueOf(z), v);
    }

    /* renamed from: R */
    private <V> void m13334R(int i, MapEntryLite.C3657b<Integer, V> bVar, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            V v = map.get(Integer.valueOf(i4));
            this.f20776a.writeTag(i, 2);
            this.f20776a.writeUInt32NoTag(MapEntryLite.m12848a(bVar, Integer.valueOf(i4), v));
            MapEntryLite.m12851e(this.f20776a, bVar, Integer.valueOf(i4), v);
        }
    }

    /* renamed from: S */
    private <V> void m13335S(int i, MapEntryLite.C3657b<Long, V> bVar, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        int i2 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i2] = longValue.longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            V v = map.get(Long.valueOf(j));
            this.f20776a.writeTag(i, 2);
            this.f20776a.writeUInt32NoTag(MapEntryLite.m12848a(bVar, Long.valueOf(j), v));
            MapEntryLite.m12851e(this.f20776a, bVar, Long.valueOf(j), v);
        }
    }

    /* renamed from: T */
    private <K, V> void m13336T(int i, MapEntryLite.C3657b<K, V> bVar, Map<K, V> map) {
        switch (C3704a.f20777a[bVar.f20628a.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    m13333Q(i, false, v, bVar);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    m13333Q(i, true, v2, bVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                m13334R(i, bVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                m13335S(i, bVar, map);
                return;
            case 12:
                m13337U(i, bVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + bVar.f20628a);
        }
    }

    /* renamed from: U */
    private <V> void m13337U(int i, MapEntryLite.C3657b<String, V> bVar, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        int i2 = 0;
        for (String str : map.keySet()) {
            strArr[i2] = str;
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = strArr[i3];
            V v = map.get(str2);
            this.f20776a.writeTag(i, 2);
            this.f20776a.writeUInt32NoTag(MapEntryLite.m12848a(bVar, str2, v));
            MapEntryLite.m12851e(this.f20776a, bVar, str2, v);
        }
    }

    /* renamed from: V */
    private void m13338V(int i, Object obj) {
        if (obj instanceof String) {
            this.f20776a.writeString(i, (String) obj);
        } else {
            this.f20776a.writeBytes(i, (ByteString) obj);
        }
    }

    /* renamed from: A */
    public void mo23759A(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeFixed32(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: B */
    public void mo23760B(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeBoolSizeNoTag(list.get(i4).booleanValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeBoolNoTag(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeBool(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    /* renamed from: C */
    public <K, V> void mo23761C(int i, MapEntryLite.C3657b<K, V> bVar, Map<K, V> map) {
        if (this.f20776a.mo23032i()) {
            m13336T(i, bVar, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.f20776a.writeTag(i, 2);
            this.f20776a.writeUInt32NoTag(MapEntryLite.m12848a(bVar, next.getKey(), next.getValue()));
            MapEntryLite.m12851e(this.f20776a, bVar, next.getKey(), next.getValue());
        }
    }

    /* renamed from: D */
    public void mo23762D(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeUInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeUInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: E */
    public void mo23763E(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeSInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeSInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: F */
    public void mo23764F(int i, long j) {
        this.f20776a.writeSInt64(i, j);
    }

    /* renamed from: G */
    public void mo23765G(int i, float f) {
        this.f20776a.writeFloat(i, f);
    }

    /* renamed from: H */
    public void mo23766H(int i) {
        this.f20776a.writeTag(i, 4);
    }

    /* renamed from: I */
    public void mo23767I(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeSInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeSInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: J */
    public void mo23768J(int i, int i2) {
        this.f20776a.writeEnum(i, i2);
    }

    /* renamed from: K */
    public void mo23769K(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeInt64SizeNoTag(list.get(i4).longValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: L */
    public void mo23770L(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeEnumSizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeEnumNoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeEnum(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: M */
    public void mo23771M(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i4).doubleValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeDoubleNoTag(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeDouble(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    /* renamed from: N */
    public void mo23772N(int i, int i2) {
        this.f20776a.writeSInt32(i, i2);
    }

    /* renamed from: O */
    public void mo23773O(int i, List<ByteString> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f20776a.writeBytes(i, list.get(i2));
        }
    }

    /* renamed from: a */
    public void mo23774a(int i, List<?> list, C3722m0 m0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo23783j(i, list.get(i2), m0Var);
        }
    }

    /* renamed from: b */
    public void mo23775b(int i, List<?> list, C3722m0 m0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo23792s(i, list.get(i2), m0Var);
        }
    }

    /* renamed from: c */
    public void mo23776c(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFloatSizeNoTag(list.get(i4).floatValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeFloatNoTag(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeFloat(i, list.get(i2).floatValue());
            i2++;
        }
    }

    /* renamed from: d */
    public void mo23777d(int i, int i2) {
        this.f20776a.writeUInt32(i, i2);
    }

    /* renamed from: e */
    public final void mo23778e(int i, Object obj) {
        if (obj instanceof ByteString) {
            this.f20776a.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.f20776a.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    /* renamed from: f */
    public void mo23779f(int i, int i2) {
        this.f20776a.writeFixed32(i, i2);
    }

    /* renamed from: g */
    public void mo23780g(int i, double d) {
        this.f20776a.writeDouble(i, d);
    }

    /* renamed from: h */
    public void mo23781h(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i4).longValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeSFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeSFixed64(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: i */
    public void mo23782i(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeUInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeUInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: j */
    public void mo23783j(int i, Object obj, C3722m0 m0Var) {
        this.f20776a.mo23036o(i, (MessageLite) obj, m0Var);
    }

    /* renamed from: k */
    public void mo23784k(int i, long j) {
        this.f20776a.writeFixed64(i, j);
    }

    /* renamed from: l */
    public Writer.FieldOrder mo23785l() {
        return Writer.FieldOrder.ASCENDING;
    }

    /* renamed from: m */
    public void mo23786m(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                m13338V(i, lazyStringList.getRaw(i2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeString(i, list.get(i2));
            i2++;
        }
    }

    /* renamed from: n */
    public void mo23787n(int i, String str) {
        this.f20776a.writeString(i, str);
    }

    /* renamed from: o */
    public void mo23788o(int i, long j) {
        this.f20776a.writeUInt64(i, j);
    }

    /* renamed from: p */
    public void mo23789p(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: q */
    public void mo23790q(int i, long j) {
        this.f20776a.writeInt64(i, j);
    }

    /* renamed from: r */
    public void mo23791r(int i, boolean z) {
        this.f20776a.writeBool(i, z);
    }

    /* renamed from: s */
    public void mo23792s(int i, Object obj, C3722m0 m0Var) {
        this.f20776a.mo23034m(i, (MessageLite) obj, m0Var);
    }

    /* renamed from: t */
    public void mo23793t(int i, int i2) {
        this.f20776a.writeSFixed32(i, i2);
    }

    /* renamed from: u */
    public void mo23794u(int i) {
        this.f20776a.writeTag(i, 3);
    }

    /* renamed from: v */
    public void mo23795v(int i, ByteString byteString) {
        this.f20776a.writeBytes(i, byteString);
    }

    /* renamed from: w */
    public void mo23796w(int i, int i2) {
        this.f20776a.writeInt32(i, i2);
    }

    /* renamed from: x */
    public void mo23797x(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i4).longValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeFixed64(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: y */
    public void mo23798y(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f20776a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i4).intValue());
            }
            this.f20776a.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.f20776a.writeSFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20776a.writeSFixed32(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: z */
    public void mo23799z(int i, long j) {
        this.f20776a.writeSFixed64(i, j);
    }
}
