package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ya0 {

    /* renamed from: a */
    private static final Class<?> f12171a = m7373y();

    /* renamed from: b */
    private static final pb0<?, ?> f12172b = m7319A(false);

    /* renamed from: c */
    private static final pb0<?, ?> f12173c = m7319A(true);

    /* renamed from: d */
    private static final pb0<?, ?> f12174d = new qb0();

    /* renamed from: A */
    private static pb0<?, ?> m7319A(boolean z) {
        try {
            Class<?> z2 = m7374z();
            if (z2 == null) {
                return null;
            }
            return (pb0) z2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: B */
    static int m7320B(int i, Object obj, wa0 wa0) {
        if (obj instanceof zzekx) {
            return zzejo.zza(i, (zzekx) obj);
        }
        return zzejo.m8799d(i, (zzels) obj, wa0);
    }

    /* renamed from: C */
    static int m7321C(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgu = zzejo.zzgu(i) * size;
        if (list instanceof zzekz) {
            zzekz zzekz = (zzekz) list;
            while (i4 < size) {
                Object zzhi = zzekz.zzhi(i4);
                if (zzhi instanceof zzeiu) {
                    i3 = zzejo.zzaj((zzeiu) zzhi);
                } else {
                    i3 = zzejo.zzhu((String) zzhi);
                }
                zzgu += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzeiu) {
                    i2 = zzejo.zzaj((zzeiu) obj);
                } else {
                    i2 = zzejo.zzhu((String) obj);
                }
                zzgu += i2;
                i4++;
            }
        }
        return zzgu;
    }

    /* renamed from: D */
    static int m7322D(int i, List<?> list, wa0 wa0) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgu = zzejo.zzgu(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzekx) {
                i2 = zzejo.zza((zzekx) obj);
            } else {
                i2 = zzejo.m8798a((zzels) obj, wa0);
            }
            zzgu += i2;
        }
        return zzgu;
    }

    /* renamed from: E */
    public static void m7323E(int i, List<Long> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13564d(i, list, z);
        }
    }

    /* renamed from: F */
    static int m7324F(int i, List<zzeiu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgu = size * zzejo.zzgu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgu += zzejo.zzaj(list.get(i2));
        }
        return zzgu;
    }

    /* renamed from: G */
    static int m7325G(int i, List<zzels> list, wa0 wa0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzejo.m8801f(i, list.get(i3), wa0);
        }
        return i2;
    }

    /* renamed from: H */
    public static void m7326H(int i, List<Long> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13572n(i, list, z);
        }
    }

    /* renamed from: I */
    public static void m7327I(int i, List<Long> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13571m(i, list, z);
        }
    }

    /* renamed from: J */
    public static void m7328J(int i, List<Long> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13570l(i, list, z);
        }
    }

    /* renamed from: K */
    public static void m7329K(int i, List<Long> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13565e(i, list, z);
        }
    }

    /* renamed from: L */
    public static void m7330L(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13562b(i, list, z);
        }
    }

    /* renamed from: M */
    static boolean m7331M(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: N */
    public static void m7332N(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13567h(i, list, z);
        }
    }

    /* renamed from: O */
    public static void m7333O(Class<?> cls) {
        Class<?> cls2;
        if (!zzekh.class.isAssignableFrom(cls) && (cls2 = f12171a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: P */
    public static void m7334P(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13573o(i, list, z);
        }
    }

    /* renamed from: Q */
    public static void m7335Q(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13566f(i, list, z);
        }
    }

    /* renamed from: R */
    public static void m7336R(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13568i(i, list, z);
        }
    }

    /* renamed from: S */
    public static void m7337S(int i, List<Integer> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13563c(i, list, z);
        }
    }

    /* renamed from: T */
    public static void m7338T(int i, List<Boolean> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13561a(i, list, z);
        }
    }

    /* renamed from: U */
    static int m7339U(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m7357i(list) + (list.size() * zzejo.zzgu(i));
    }

    /* renamed from: V */
    static int m7340V(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7358j(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: W */
    static int m7341W(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7359k(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: X */
    static int m7342X(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7360l(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: Y */
    static int m7343Y(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7361m(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: Z */
    static int m7344Z(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7362n(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: a */
    static <UT, UB> UB m7345a(int i, int i2, UB ub, pb0<UT, UB> pb0) {
        if (ub == null) {
            ub = pb0.mo14599n();
        }
        pb0.mo14586a(ub, i, (long) i2);
        return ub;
    }

    /* renamed from: a0 */
    static int m7346a0(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m7363o(list) + (size * zzejo.zzgu(i));
    }

    /* renamed from: b */
    static <UT, UB> UB m7347b(int i, List<Integer> list, zzekl zzekl, UB ub, pb0<UT, UB> pb0) {
        if (zzekl == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzekl.zzi(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = m7345a(i, intValue, ub, pb0);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzekl.zzi(intValue2)) {
                    ub = m7345a(i, intValue2, ub, pb0);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* renamed from: b0 */
    static int m7348b0(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzaj(i, 0);
    }

    /* renamed from: c */
    public static void m7349c(int i, List<String> list, hc0 hc0) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13577t(i, list);
        }
    }

    /* renamed from: c0 */
    static int m7350c0(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzo(i, 0);
    }

    /* renamed from: d */
    public static void m7351d(int i, List<?> list, hc0 hc0, wa0 wa0) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13579v(i, list, wa0);
        }
    }

    /* renamed from: d0 */
    static int m7352d0(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzi(i, true);
    }

    /* renamed from: e */
    public static void m7353e(int i, List<Double> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13574p(i, list, z);
        }
    }

    /* renamed from: f */
    static <T, FT extends zzejz<FT>> void m7354f(d90<FT> d90, T t, T t2) {
        e90<FT> g = d90.mo13758g(t2);
        if (!g.f8327a.isEmpty()) {
            d90.mo13759h(t).mo13882h(g);
        }
    }

    /* renamed from: g */
    static <T> void m7355g(aa0 aa0, T t, T t2, long j) {
        sb0.m6911f(t, j, aa0.mo13588e(sb0.m6897G(t, j), sb0.m6897G(t2, j)));
    }

    /* renamed from: h */
    static <T, UT, UB> void m7356h(pb0<UT, UB> pb0, T t, T t2) {
        pb0.mo14602q(t, pb0.mo14604s(pb0.mo14595j(t), pb0.mo14595j(t2)));
    }

    /* renamed from: i */
    static int m7357i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfk(w90.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfk(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: j */
    static int m7358j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfl(w90.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: k */
    static int m7359k(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfm(w90.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: l */
    static int m7360l(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzha(m90.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzha(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: m */
    static int m7361m(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgv(m90.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: n */
    static int m7362n(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgw(m90.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: o */
    static int m7363o(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgx(m90.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgx(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: p */
    static int m7364p(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: q */
    static int m7365q(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: r */
    static int m7366r(List<?> list) {
        return list.size();
    }

    /* renamed from: s */
    public static void m7367s(int i, List<zzeiu> list, hc0 hc0) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13575q(i, list);
        }
    }

    /* renamed from: t */
    public static void m7368t(int i, List<?> list, hc0 hc0, wa0 wa0) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13583z(i, list, wa0);
        }
    }

    /* renamed from: u */
    public static void m7369u(int i, List<Float> list, hc0 hc0, boolean z) {
        if (list != null && !list.isEmpty()) {
            hc0.mo13576s(i, list, z);
        }
    }

    /* renamed from: v */
    public static pb0<?, ?> m7370v() {
        return f12172b;
    }

    /* renamed from: w */
    public static pb0<?, ?> m7371w() {
        return f12173c;
    }

    /* renamed from: x */
    public static pb0<?, ?> m7372x() {
        return f12174d;
    }

    /* renamed from: y */
    private static Class<?> m7373y() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: z */
    private static Class<?> m7374z() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }
}
