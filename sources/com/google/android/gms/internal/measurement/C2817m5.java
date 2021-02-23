package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.m5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2817m5 {

    /* renamed from: a */
    private static final Class<?> f17380a = m9613F();

    /* renamed from: b */
    private static final C2734c6<?, ?> f17381b = m9644g(false);

    /* renamed from: c */
    private static final C2734c6<?, ?> f17382c = m9644g(true);

    /* renamed from: d */
    private static final C2734c6<?, ?> f17383d = new C2742d6();

    /* renamed from: A */
    static int m9608A(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzf(n4Var.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: B */
    public static C2734c6<?, ?> m9609B() {
        return f17383d;
    }

    /* renamed from: C */
    public static void m9610C(int i, List<Long> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18886d(i, list, z);
        }
    }

    /* renamed from: D */
    static int m9611D(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9612E(list) + (size * zzhg.zze(i));
    }

    /* renamed from: E */
    static int m9612E(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzk(g4Var.mo18653a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: F */
    private static Class<?> m9613F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: G */
    public static void m9614G(int i, List<Long> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18896n(i, list, z);
        }
    }

    /* renamed from: H */
    static int m9615H(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9616I(list) + (size * zzhg.zze(i));
    }

    /* renamed from: I */
    static int m9616I(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzf(g4Var.mo18653a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: J */
    private static Class<?> m9617J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: K */
    public static void m9618K(int i, List<Long> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18895m(i, list, z);
        }
    }

    /* renamed from: L */
    static int m9619L(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9620M(list) + (size * zzhg.zze(i));
    }

    /* renamed from: M */
    static int m9620M(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzg(g4Var.mo18653a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: N */
    public static void m9621N(int i, List<Long> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18894l(i, list, z);
        }
    }

    /* renamed from: O */
    static int m9622O(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9623P(list) + (size * zzhg.zze(i));
    }

    /* renamed from: P */
    static int m9623P(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzh(g4Var.mo18653a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: Q */
    public static void m9624Q(int i, List<Long> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18887e(i, list, z);
        }
    }

    /* renamed from: R */
    static int m9625R(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhg.zzi(i, 0);
    }

    /* renamed from: S */
    static int m9626S(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: T */
    public static void m9627T(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18884b(i, list, z);
        }
    }

    /* renamed from: U */
    static int m9628U(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhg.zzg(i, 0);
    }

    /* renamed from: V */
    static int m9629V(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: W */
    public static void m9630W(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18890h(i, list, z);
        }
    }

    /* renamed from: X */
    static int m9631X(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhg.zzb(i, true);
    }

    /* renamed from: Y */
    static int m9632Y(List<?> list) {
        return list.size();
    }

    /* renamed from: Z */
    public static void m9633Z(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18897o(i, list, z);
        }
    }

    /* renamed from: a */
    static int m9634a(int i, Object obj, C2793j5 j5Var) {
        if (obj instanceof zziq) {
            return zzhg.zza(i, (zziq) obj);
        }
        return zzhg.m10361d(i, (zzjh) obj, j5Var);
    }

    /* renamed from: a0 */
    public static void m9635a0(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18888f(i, list, z);
        }
    }

    /* renamed from: b */
    static int m9636b(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhg.zze(i) * size;
        if (list instanceof zzis) {
            zzis zzis = (zzis) list;
            while (i4 < size) {
                Object zzb = zzis.zzb(i4);
                if (zzb instanceof zzgr) {
                    i3 = zzhg.zzb((zzgr) zzb);
                } else {
                    i3 = zzhg.zzb((String) zzb);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgr) {
                    i2 = zzhg.zzb((zzgr) obj);
                } else {
                    i2 = zzhg.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    /* renamed from: b0 */
    public static void m9637b0(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18891i(i, list, z);
        }
    }

    /* renamed from: c */
    static int m9638c(int i, List<?> list, C2793j5 j5Var) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhg.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zziq) {
                i2 = zzhg.zza((zziq) obj);
            } else {
                i2 = zzhg.m10360a((zzjh) obj, j5Var);
            }
            zze += i2;
        }
        return zze;
    }

    /* renamed from: c0 */
    public static void m9639c0(int i, List<Integer> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18885c(i, list, z);
        }
    }

    /* renamed from: d */
    static int m9640d(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m9642e(list) + (list.size() * zzhg.zze(i));
    }

    /* renamed from: d0 */
    public static void m9641d0(int i, List<Boolean> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18883a(i, list, z);
        }
    }

    /* renamed from: e */
    static int m9642e(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zzd(n4Var.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: f */
    public static C2734c6<?, ?> m9643f() {
        return f17381b;
    }

    /* renamed from: g */
    private static C2734c6<?, ?> m9644g(boolean z) {
        try {
            Class<?> J = m9617J();
            if (J == null) {
                return null;
            }
            return (C2734c6) J.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: h */
    static <UT, UB> UB m9645h(int i, int i2, UB ub, C2734c6<UT, UB> c6Var) {
        if (ub == null) {
            ub = c6Var.mo18584a();
        }
        c6Var.mo18587d(ub, i, (long) i2);
        return ub;
    }

    /* renamed from: i */
    static <UT, UB> UB m9646i(int i, List<Integer> list, zzid zzid, UB ub, C2734c6<UT, UB> c6Var) {
        if (zzid == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzid.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = m9645h(i, intValue, ub, c6Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzid.zza(intValue2)) {
                    ub = m9645h(i, intValue2, ub, c6Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* renamed from: j */
    public static void m9647j(int i, List<String> list, C2882u6 u6Var) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18902t(i, list);
        }
    }

    /* renamed from: k */
    public static void m9648k(int i, List<?> list, C2882u6 u6Var, C2793j5 j5Var) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18908z(i, list, j5Var);
        }
    }

    /* renamed from: l */
    public static void m9649l(int i, List<Double> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18898p(i, list, z);
        }
    }

    /* renamed from: m */
    static <T, FT extends zzhr<FT>> void m9650m(C2902x3<FT> x3Var, T t, T t2) {
        C2909y3<FT> b = x3Var.mo18939b(t2);
        if (!b.f17526a.isEmpty()) {
            x3Var.mo18946i(t).mo18984g(b);
        }
    }

    /* renamed from: n */
    static <T> void m9651n(C2880u4 u4Var, T t, T t2, long j) {
        C2758f6.m9432j(t, j, u4Var.mo18862d(C2758f6.m9413F(t, j), C2758f6.m9413F(t2, j)));
    }

    /* renamed from: o */
    static <T, UT, UB> void m9652o(C2734c6<UT, UB> c6Var, T t, T t2) {
        c6Var.mo18591h(t, c6Var.mo18599p(c6Var.mo18594k(t), c6Var.mo18594k(t2)));
    }

    /* renamed from: p */
    public static void m9653p(Class<?> cls) {
        Class<?> cls2;
        if (!zzhz.class.isAssignableFrom(cls) && (cls2 = f17380a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: q */
    static boolean m9654q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: r */
    static int m9655r(int i, List<zzgr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzhg.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhg.zzb(list.get(i2));
        }
        return zze;
    }

    /* renamed from: s */
    static int m9656s(int i, List<zzjh> list, C2793j5 j5Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhg.m10362f(i, list.get(i3), j5Var);
        }
        return i2;
    }

    /* renamed from: t */
    static int m9657t(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9658u(list) + (size * zzhg.zze(i));
    }

    /* renamed from: u */
    static int m9658u(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            i = 0;
            while (i2 < size) {
                i += zzhg.zze(n4Var.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhg.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: v */
    public static C2734c6<?, ?> m9659v() {
        return f17382c;
    }

    /* renamed from: w */
    public static void m9660w(int i, List<zzgr> list, C2882u6 u6Var) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18899q(i, list);
        }
    }

    /* renamed from: x */
    public static void m9661x(int i, List<?> list, C2882u6 u6Var, C2793j5 j5Var) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18878D(i, list, j5Var);
        }
    }

    /* renamed from: y */
    public static void m9662y(int i, List<Float> list, C2882u6 u6Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            u6Var.mo18901s(i, list, z);
        }
    }

    /* renamed from: z */
    static int m9663z(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m9608A(list) + (size * zzhg.zze(i));
    }
}
