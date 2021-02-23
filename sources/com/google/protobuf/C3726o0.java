package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.o0 */
/* compiled from: SchemaUtil */
final class C3726o0 {

    /* renamed from: a */
    private static final Class<?> f20821a = m13525B();

    /* renamed from: b */
    private static final C3746r0<?, ?> f20822b = m13526C(false);

    /* renamed from: c */
    private static final C3746r0<?, ?> f20823c = m13526C(true);

    /* renamed from: d */
    private static final C3746r0<?, ?> f20824d = new C3750s0();

    /* renamed from: A */
    static <UT, UB> UB m13524A(int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, C3746r0<UT, UB> r0Var) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = m13535L(i, intValue, ub, r0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = m13535L(i, intValue2, ub, r0Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* renamed from: B */
    private static Class<?> m13525B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: C */
    private static C3746r0<?, ?> m13526C(boolean z) {
        try {
            Class<?> D = m13527D();
            if (D == null) {
                return null;
            }
            return (C3746r0) D.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: D */
    private static Class<?> m13527D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: E */
    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void m13528E(C3710j<FT> jVar, T t, T t2) {
        FieldSet<FT> c = jVar.mo23893c(t2);
        if (!c.mo23293r()) {
            jVar.mo23894d(t).mo23298y(c);
        }
    }

    /* renamed from: F */
    static <T> void m13529F(C3751t tVar, T t, T t2, long j) {
        C3752t0.m13733V(t, j, tVar.mo24031a(C3752t0.m13717F(t, j), C3752t0.m13717F(t2, j)));
    }

    /* renamed from: G */
    static <T, UT, UB> void m13530G(C3746r0<UT, UB> r0Var, T t, T t2) {
        r0Var.mo24010p(t, r0Var.mo24005k(r0Var.mo24001g(t), r0Var.mo24001g(t2)));
    }

    /* renamed from: H */
    public static C3746r0<?, ?> m13531H() {
        return f20822b;
    }

    /* renamed from: I */
    public static C3746r0<?, ?> m13532I() {
        return f20823c;
    }

    /* renamed from: J */
    public static void m13533J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f20821a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: K */
    static boolean m13534K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: L */
    static <UT, UB> UB m13535L(int i, int i2, UB ub, C3746r0<UT, UB> r0Var) {
        if (ub == null) {
            ub = r0Var.mo24008n();
        }
        r0Var.mo23999e(ub, i, (long) i2);
        return ub;
    }

    /* renamed from: M */
    public static C3746r0<?, ?> m13536M() {
        return f20824d;
    }

    /* renamed from: N */
    public static void m13537N(int i, List<Boolean> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23760B(i, list, z);
        }
    }

    /* renamed from: O */
    public static void m13538O(int i, List<ByteString> list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.mo23773O(i, list);
        }
    }

    /* renamed from: P */
    public static void m13539P(int i, List<Double> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23771M(i, list, z);
        }
    }

    /* renamed from: Q */
    public static void m13540Q(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23770L(i, list, z);
        }
    }

    /* renamed from: R */
    public static void m13541R(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23759A(i, list, z);
        }
    }

    /* renamed from: S */
    public static void m13542S(int i, List<Long> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23797x(i, list, z);
        }
    }

    /* renamed from: T */
    public static void m13543T(int i, List<Float> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23776c(i, list, z);
        }
    }

    /* renamed from: U */
    public static void m13544U(int i, List<?> list, Writer writer, C3722m0 m0Var) {
        if (list != null && !list.isEmpty()) {
            writer.mo23775b(i, list, m0Var);
        }
    }

    /* renamed from: V */
    public static void m13545V(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23789p(i, list, z);
        }
    }

    /* renamed from: W */
    public static void m13546W(int i, List<Long> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23769K(i, list, z);
        }
    }

    /* renamed from: X */
    public static void m13547X(int i, List<?> list, Writer writer, C3722m0 m0Var) {
        if (list != null && !list.isEmpty()) {
            writer.mo23774a(i, list, m0Var);
        }
    }

    /* renamed from: Y */
    public static void m13548Y(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23798y(i, list, z);
        }
    }

    /* renamed from: Z */
    public static void m13549Z(int i, List<Long> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23781h(i, list, z);
        }
    }

    /* renamed from: a */
    static int m13550a(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(size);
        }
        return size * CodedOutputStream.computeBoolSize(i, true);
    }

    /* renamed from: a0 */
    public static void m13551a0(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23767I(i, list, z);
        }
    }

    /* renamed from: b */
    static int m13552b(List<?> list) {
        return list.size();
    }

    /* renamed from: b0 */
    public static void m13553b0(int i, List<Long> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23763E(i, list, z);
        }
    }

    /* renamed from: c */
    static int m13554c(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i2));
        }
        return computeTagSize;
    }

    /* renamed from: c0 */
    public static void m13555c0(int i, List<String> list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.mo23786m(i, list);
        }
    }

    /* renamed from: d */
    static int m13556d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = m13558e(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(e);
        }
        return e + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: d0 */
    public static void m13557d0(int i, List<Integer> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23762D(i, list, z);
        }
    }

    /* renamed from: e */
    static int m13558e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeEnumSizeNoTag(oVar.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeEnumSizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: e0 */
    public static void m13559e0(int i, List<Long> list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.mo23782i(i, list, z);
        }
    }

    /* renamed from: f */
    static int m13560f(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i, 0);
    }

    /* renamed from: g */
    static int m13561g(List<?> list) {
        return list.size() * 4;
    }

    /* renamed from: h */
    static int m13562h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i, 0);
    }

    /* renamed from: i */
    static int m13563i(List<?> list) {
        return list.size() * 8;
    }

    /* renamed from: j */
    static int m13564j(int i, List<MessageLite> list, C3722m0 m0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.m12479b(i, list.get(i3), m0Var);
        }
        return i2;
    }

    /* renamed from: k */
    static int m13565k(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = m13566l(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(l);
        }
        return l + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: l */
    static int m13566l(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(oVar.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: m */
    static int m13567m(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int n = m13568n(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(n);
        }
        return n + (list.size() * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: n */
    static int m13568n(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt64SizeNoTag(rVar.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: o */
    static int m13569o(int i, Object obj, C3722m0 m0Var) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj);
        }
        return CodedOutputStream.m12482e(i, (MessageLite) obj, m0Var);
    }

    /* renamed from: p */
    static int m13570p(int i, List<?> list, C3722m0 m0Var) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof LazyFieldLite) {
                i2 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i2 = CodedOutputStream.m12483f((MessageLite) obj, m0Var);
            }
            computeTagSize += i2;
        }
        return computeTagSize;
    }

    /* renamed from: q */
    static int m13571q(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = m13572r(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(r);
        }
        return r + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: r */
    static int m13572r(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt32SizeNoTag(oVar.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: s */
    static int m13573s(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = m13574t(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(t);
        }
        return t + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: t */
    static int m13574t(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt64SizeNoTag(rVar.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: u */
    static int m13575u(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i4 < size) {
                Object raw = lazyStringList.getRaw(i4);
                if (raw instanceof ByteString) {
                    i3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    i3 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof ByteString) {
                    i2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    i2 = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += i2;
                i4++;
            }
        }
        return computeTagSize;
    }

    /* renamed from: v */
    static int m13576v(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = m13577w(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(w);
        }
        return w + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: w */
    static int m13577w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3725o) {
            C3725o oVar = (C3725o) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt32SizeNoTag(oVar.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: x */
    static int m13578x(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = m13579y(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.m12481d(y);
        }
        return y + (size * CodedOutputStream.computeTagSize(i));
    }

    /* renamed from: y */
    static int m13579y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3745r) {
            C3745r rVar = (C3745r) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(rVar.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: z */
    static <UT, UB> UB m13580z(int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, C3746r0<UT, UB> r0Var) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = m13535L(i, intValue, ub, r0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = m13535L(i, intValue2, ub, r0Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
