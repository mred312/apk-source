package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.x1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2900x1<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Object f17504j = new Object();
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: a */
    public transient Object f17505a;
    @NullableDecl

    /* renamed from: b */
    transient int[] f17506b;
    @NullableDecl

    /* renamed from: c */
    transient Object[] f17507c;
    @NullableDecl

    /* renamed from: d */
    transient Object[] f17508d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public transient int f17509e = zzfz.zza(3, 1, 1073741823);

    /* renamed from: f */
    private transient int f17510f;
    @NullableDecl

    /* renamed from: g */
    private transient Set<K> f17511g;
    @NullableDecl

    /* renamed from: h */
    private transient Set<Map.Entry<K, V>> f17512h;
    @NullableDecl

    /* renamed from: i */
    private transient Collection<V> f17513i;

    C2900x1() {
        zzeb.zza(true, (Object) "Expected size must be >= 0");
    }

    /* renamed from: b */
    private final int m9898b(int i, int i2, int i3, int i4) {
        Object d = C2782i2.m9508d(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            C2782i2.m9509e(d, i3 & i5, i4 + 1);
        }
        Object obj = this.f17505a;
        int[] iArr = this.f17506b;
        for (int i6 = 0; i6 <= i; i6++) {
            int b = C2782i2.m9506b(obj, i6);
            while (b != 0) {
                int i7 = b - 1;
                int i8 = iArr[i7];
                int i9 = ((i ^ -1) & i8) | i6;
                int i10 = i9 & i5;
                int b2 = C2782i2.m9506b(d, i10);
                C2782i2.m9509e(d, i10, b);
                iArr[i7] = C2782i2.m9505a(i9, b2, i5);
                b = i8 & i;
            }
        }
        this.f17505a = d;
        m9906m(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final int m9900d(@NullableDecl Object obj) {
        if (mo18962g()) {
            return -1;
        }
        int b = C2790j2.m9520b(obj);
        int v = m9910v();
        int b2 = C2782i2.m9506b(this.f17505a, b & v);
        if (b2 == 0) {
            return -1;
        }
        int i = v ^ -1;
        int i2 = b & i;
        do {
            int i3 = b2 - 1;
            int i4 = this.f17506b[i3];
            if ((i4 & i) == i2 && zzdz.zza(obj, this.f17507c[i3])) {
                return i3;
            }
            b2 = i4 & v;
        } while (b2 != 0);
        return -1;
    }

    /* renamed from: h */
    static int m9902h(int i, int i2) {
        return i - 1;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    /* renamed from: k */
    public final Object m9905k(@NullableDecl Object obj) {
        if (mo18962g()) {
            return f17504j;
        }
        int v = m9910v();
        int c = C2782i2.m9507c(obj, (Object) null, v, this.f17505a, this.f17506b, this.f17507c, (Object[]) null);
        if (c == -1) {
            return f17504j;
        }
        Object obj2 = this.f17508d[c];
        mo18961f(c, v);
        this.f17510f--;
        mo18967o();
        return obj2;
    }

    /* renamed from: m */
    private final void m9906m(int i) {
        this.f17509e = C2782i2.m9505a(this.f17509e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* renamed from: q */
    static /* synthetic */ int m9908q(C2900x1 x1Var) {
        int i = x1Var.f17510f;
        x1Var.f17510f = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public final int m9910v() {
        return (1 << (this.f17509e & 31)) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18956a(int i) {
        int i2 = i + 1;
        if (i2 < this.f17510f) {
            return i2;
        }
        return -1;
    }

    public final void clear() {
        if (!mo18962g()) {
            mo18967o();
            Map l = mo18966l();
            if (l != null) {
                this.f17509e = zzfz.zza(size(), 3, 1073741823);
                l.clear();
                this.f17505a = null;
                this.f17510f = 0;
                return;
            }
            Arrays.fill(this.f17507c, 0, this.f17510f, (Object) null);
            Arrays.fill(this.f17508d, 0, this.f17510f, (Object) null);
            Object obj = this.f17505a;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.f17506b, 0, this.f17510f, 0);
            this.f17510f = 0;
        }
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map l = mo18966l();
        if (l != null) {
            return l.containsKey(obj);
        }
        return m9900d(obj) != -1;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map l = mo18966l();
        if (l != null) {
            return l.containsValue(obj);
        }
        for (int i = 0; i < this.f17510f; i++) {
            if (zzdz.zza(obj, this.f17508d[i])) {
                return true;
            }
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f17512h;
        if (set != null) {
            return set;
        }
        C2722b2 b2Var = new C2722b2(this);
        this.f17512h = b2Var;
        return b2Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo18961f(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.f17507c;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.f17508d;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.f17506b;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int b = C2790j2.m9520b(obj) & i2;
            int b2 = C2782i2.m9506b(this.f17505a, b);
            int i3 = size + 1;
            if (b2 == i3) {
                C2782i2.m9509e(this.f17505a, b, i + 1);
                return;
            }
            while (true) {
                int i4 = b2 - 1;
                int[] iArr2 = this.f17506b;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == i3) {
                    iArr2[i4] = C2782i2.m9505a(i5, i + 1, i2);
                    return;
                }
                b2 = i6;
            }
        } else {
            this.f17507c[i] = null;
            this.f17508d[i] = null;
            this.f17506b[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo18962g() {
        return this.f17505a == null;
    }

    public final V get(@NullableDecl Object obj) {
        Map l = mo18966l();
        if (l != null) {
            return l.get(obj);
        }
        int d = m9900d(obj);
        if (d == -1) {
            return null;
        }
        return this.f17508d[d];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set<K> keySet() {
        Set<K> set = this.f17511g;
        if (set != null) {
            return set;
        }
        C2738d2 d2Var = new C2738d2(this);
        this.f17511g = d2Var;
        return d2Var;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    /* renamed from: l */
    public final Map<K, V> mo18966l() {
        Object obj = this.f17505a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final void mo18967o() {
        this.f17509e += 32;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final int mo18968p() {
        return isEmpty() ? -1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002f, code lost:
        r7 = r7 << 1;
     */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K r19, @org.checkerframework.checker.nullness.compatqual.NullableDecl V r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r18.mo18962g()
            r4 = 1
            if (r3 == 0) goto L_0x0051
            boolean r3 = r18.mo18962g()
            java.lang.String r5 = "Arrays already allocated"
            com.google.android.gms.internal.measurement.zzeb.zzb((boolean) r3, (java.lang.Object) r5)
            int r3 = r0.f17509e
            r5 = 4
            int r6 = r3 + 1
            r7 = 2
            int r6 = java.lang.Math.max(r6, r7)
            int r7 = java.lang.Integer.highestOneBit(r6)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = (double) r7
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r8
            int r8 = (int) r10
            if (r6 <= r8) goto L_0x0036
            int r7 = r7 << 1
            if (r7 > 0) goto L_0x0036
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x0037
        L_0x0036:
            r6 = r7
        L_0x0037:
            int r5 = java.lang.Math.max(r5, r6)
            java.lang.Object r6 = com.google.android.gms.internal.measurement.C2782i2.m9508d(r5)
            r0.f17505a = r6
            int r5 = r5 - r4
            r0.m9906m(r5)
            int[] r5 = new int[r3]
            r0.f17506b = r5
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r0.f17507c = r5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.f17508d = r3
        L_0x0051:
            java.util.Map r3 = r18.mo18966l()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r1 = r3.put(r1, r2)
            return r1
        L_0x005c:
            int[] r3 = r0.f17506b
            java.lang.Object[] r5 = r0.f17507c
            java.lang.Object[] r6 = r0.f17508d
            int r7 = r0.f17510f
            int r8 = r7 + 1
            int r9 = com.google.android.gms.internal.measurement.C2790j2.m9520b(r19)
            int r10 = r18.m9910v()
            r11 = r9 & r10
            java.lang.Object r12 = r0.f17505a
            int r12 = com.google.android.gms.internal.measurement.C2782i2.m9506b(r12, r11)
            if (r12 != 0) goto L_0x008a
            if (r8 <= r10) goto L_0x0084
            int r3 = com.google.android.gms.internal.measurement.C2782i2.m9510f(r10)
            int r10 = r0.m9898b(r10, r3, r9, r7)
            goto L_0x00f4
        L_0x0084:
            java.lang.Object r3 = r0.f17505a
            com.google.android.gms.internal.measurement.C2782i2.m9509e(r3, r11, r8)
            goto L_0x00f4
        L_0x008a:
            r11 = r10 ^ -1
            r15 = r9 & r11
            r16 = 0
        L_0x0090:
            int r12 = r12 - r4
            r13 = r3[r12]
            r14 = r13 & r11
            if (r14 != r15) goto L_0x00a4
            r14 = r5[r12]
            boolean r14 = com.google.android.gms.internal.measurement.zzdz.zza(r1, r14)
            if (r14 == 0) goto L_0x00a4
            r1 = r6[r12]
            r6[r12] = r2
            return r1
        L_0x00a4:
            r14 = r13 & r10
            r17 = r5
            int r5 = r16 + 1
            if (r14 != 0) goto L_0x013a
            r6 = 9
            if (r5 < r6) goto L_0x00e3
            int r3 = r18.m9910v()
            int r3 = r3 + r4
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r5 = 1065353216(0x3f800000, float:1.0)
            r4.<init>(r3, r5)
            int r3 = r18.mo18968p()
        L_0x00c0:
            if (r3 < 0) goto L_0x00d2
            java.lang.Object[] r5 = r0.f17507c
            r5 = r5[r3]
            java.lang.Object[] r6 = r0.f17508d
            r6 = r6[r3]
            r4.put(r5, r6)
            int r3 = r0.mo18956a(r3)
            goto L_0x00c0
        L_0x00d2:
            r0.f17505a = r4
            r3 = 0
            r0.f17506b = r3
            r0.f17507c = r3
            r0.f17508d = r3
            r18.mo18967o()
            java.lang.Object r1 = r4.put(r1, r2)
            return r1
        L_0x00e3:
            if (r8 <= r10) goto L_0x00ee
            int r3 = com.google.android.gms.internal.measurement.C2782i2.m9510f(r10)
            int r10 = r0.m9898b(r10, r3, r9, r7)
            goto L_0x00f4
        L_0x00ee:
            int r5 = com.google.android.gms.internal.measurement.C2782i2.m9505a(r13, r8, r10)
            r3[r12] = r5
        L_0x00f4:
            int[] r3 = r0.f17506b
            int r3 = r3.length
            if (r8 <= r3) goto L_0x0122
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            int r6 = r3 >>> 1
            int r6 = java.lang.Math.max(r4, r6)
            int r6 = r6 + r3
            r4 = r4 | r6
            int r4 = java.lang.Math.min(r5, r4)
            if (r4 == r3) goto L_0x0122
            int[] r3 = r0.f17506b
            int[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f17506b = r3
            java.lang.Object[] r3 = r0.f17507c
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f17507c = r3
            java.lang.Object[] r3 = r0.f17508d
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f17508d = r3
        L_0x0122:
            int[] r3 = r0.f17506b
            r12 = 0
            int r4 = com.google.android.gms.internal.measurement.C2782i2.m9505a(r9, r12, r10)
            r3[r7] = r4
            java.lang.Object[] r3 = r0.f17507c
            r3[r7] = r1
            java.lang.Object[] r1 = r0.f17508d
            r1[r7] = r2
            r0.f17510f = r8
            r18.mo18967o()
            r13 = 0
            return r13
        L_0x013a:
            r16 = r5
            r12 = r14
            r5 = r17
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2900x1.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final Iterator<K> mo18970r() {
        Map l = mo18966l();
        if (l != null) {
            return l.keySet().iterator();
        }
        return new C2714a2(this);
    }

    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map l = mo18966l();
        if (l != null) {
            return l.remove(obj);
        }
        V k = m9905k(obj);
        if (k == f17504j) {
            return null;
        }
        return k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public final Iterator<Map.Entry<K, V>> mo18972s() {
        Map l = mo18966l();
        if (l != null) {
            return l.entrySet().iterator();
        }
        return new C2914z1(this);
    }

    public final int size() {
        Map l = mo18966l();
        return l != null ? l.size() : this.f17510f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final Iterator<V> mo18974t() {
        Map l = mo18966l();
        if (l != null) {
            return l.values().iterator();
        }
        return new C2730c2(this);
    }

    public final Collection<V> values() {
        Collection<V> collection = this.f17513i;
        if (collection != null) {
            return collection;
        }
        C2754f2 f2Var = new C2754f2(this);
        this.f17513i = f2Var;
        return f2Var;
    }
}
