package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzdwt<E> extends zzdwl<E> implements Set<E> {
    @NullableDecl

    /* renamed from: b */
    private transient zzdwm<E> f16038b;

    zzdwt() {
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static <E> zzdwt<E> m8549f(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zzae(objArr[0]);
            }
            int j = m8551j(i);
            Object[] objArr2 = new Object[j];
            int i2 = j - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zzdwx.m8556a(obj, i5);
                int hashCode = obj.hashCode();
                int a = c20.m5878a(hashCode);
                while (true) {
                    int i6 = a & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        a++;
                    } else {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new o20(objArr[0], i3);
            }
            if (m8551j(i4) < j / 2) {
                i = i4;
            } else {
                if (m8552k(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new m20(objArr, i3, objArr2, i2, i4);
            }
        }
        return m20.f9902h;
    }

    /* renamed from: j */
    static int m8551j(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzdvv.checkArgument(z, "collection too large");
            return 1073741824;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static boolean m8552k(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @SafeVarargs
    public static <E> zzdwt<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdvv.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return m8549f(length, objArr);
    }

    public static <E> zzdwt<E> zzae(E e) {
        return new o20(e);
    }

    public static <E> zzdws<E> zzer(int i) {
        a20.m5747b(i, "expectedSize");
        return new zzdws<>(i);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdwt) || !mo14411g() || !((zzdwt) obj).mo14411g() || hashCode() == obj.hashCode()) {
            return zzdxf.m8565a(this, obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo14411g() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public zzdwm<E> mo14234h() {
        return zzdwm.m8544g(toArray());
    }

    public int hashCode() {
        return zzdxf.m8566b(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzdwm<E> zzayt() {
        zzdwm<E> zzdwm = this.f16038b;
        if (zzdwm != null) {
            return zzdwm;
        }
        zzdwm<E> h = mo14234h();
        this.f16038b = h;
        return h;
    }
}
