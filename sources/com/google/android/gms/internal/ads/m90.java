package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class m90 extends g80<Integer> implements zzeko, na0, RandomAccess {

    /* renamed from: d */
    private static final m90 f9922d;

    /* renamed from: b */
    private int[] f9923b;

    /* renamed from: c */
    private int f9924c;

    static {
        m90 m90 = new m90(new int[0], 0);
        f9922d = m90;
        m90.zzbfl();
    }

    m90() {
        this(new int[10], 0);
    }

    /* renamed from: a */
    public static m90 m6487a() {
        return f9922d;
    }

    /* renamed from: b */
    private final void m6488b(int i) {
        if (i < 0 || i >= this.f9924c) {
            throw new IndexOutOfBoundsException(m6489c(i));
        }
    }

    /* renamed from: c */
    private final String m6489c(int i) {
        int i2 = this.f9924c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.f9924c)) {
            throw new IndexOutOfBoundsException(m6489c(i));
        }
        int[] iArr = this.f9923b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f9923b, i, iArr2, i + 1, this.f9924c - i);
            this.f9923b = iArr2;
        }
        this.f9923b[i] = intValue;
        this.f9924c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbfm();
        zzekk.m8823a(collection);
        if (!(collection instanceof m90)) {
            return super.addAll(collection);
        }
        m90 m90 = (m90) collection;
        int i = m90.f9924c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f9924c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f9923b;
            if (i3 > iArr.length) {
                this.f9923b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(m90.f9923b, 0, this.f9923b, this.f9924c, m90.f9924c);
            this.f9924c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m90)) {
            return super.equals(obj);
        }
        m90 m90 = (m90) obj;
        if (this.f9924c != m90.f9924c) {
            return false;
        }
        int[] iArr = m90.f9923b;
        for (int i = 0; i < this.f9924c; i++) {
            if (this.f9923b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        m6488b(i);
        return this.f9923b[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f9924c; i2++) {
            i = (i * 31) + this.f9923b[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f9923b[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.f9924c; i++) {
            if (obj.equals(Integer.valueOf(this.f9923b[i]))) {
                int[] iArr = this.f9923b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f9924c - i) - 1);
                this.f9924c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbfm();
        if (i2 >= i) {
            int[] iArr = this.f9923b;
            System.arraycopy(iArr, i2, iArr, i, this.f9924c - i2);
            this.f9924c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbfm();
        m6488b(i);
        int[] iArr = this.f9923b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f9924c;
    }

    /* renamed from: zzhf */
    public final zzeko zzfx(int i) {
        if (i >= this.f9924c) {
            return new m90(Arrays.copyOf(this.f9923b, i), this.f9924c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzhg(int i) {
        zzbfm();
        int i2 = this.f9924c;
        int[] iArr = this.f9923b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f9923b = iArr2;
        }
        int[] iArr3 = this.f9923b;
        int i3 = this.f9924c;
        this.f9924c = i3 + 1;
        iArr3[i3] = i;
    }

    private m90(int[] iArr, int i) {
        this.f9923b = iArr;
        this.f9924c = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        m6488b(i);
        int[] iArr = this.f9923b;
        int i2 = iArr[i];
        int i3 = this.f9924c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f9924c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzhg(((Integer) obj).intValue());
        return true;
    }
}
