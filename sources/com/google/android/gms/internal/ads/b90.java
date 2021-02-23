package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class b90 extends g80<Double> implements zzekp<Double>, na0, RandomAccess {

    /* renamed from: b */
    private double[] f7885b;

    /* renamed from: c */
    private int f7886c;

    static {
        new b90(new double[0], 0).zzbfl();
    }

    b90() {
        this(new double[10], 0);
    }

    /* renamed from: b */
    private final void m5831b(int i) {
        if (i < 0 || i >= this.f7886c) {
            throw new IndexOutOfBoundsException(m5832c(i));
        }
    }

    /* renamed from: c */
    private final String m5832c(int i) {
        int i2 = this.f7886c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo13639a(double d) {
        zzbfm();
        int i = this.f7886c;
        double[] dArr = this.f7885b;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f7885b = dArr2;
        }
        double[] dArr3 = this.f7885b;
        int i2 = this.f7886c;
        this.f7886c = i2 + 1;
        dArr3[i2] = d;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.f7886c)) {
            throw new IndexOutOfBoundsException(m5832c(i));
        }
        double[] dArr = this.f7885b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f7885b, i, dArr2, i + 1, this.f7886c - i);
            this.f7885b = dArr2;
        }
        this.f7885b[i] = doubleValue;
        this.f7886c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzbfm();
        zzekk.m8823a(collection);
        if (!(collection instanceof b90)) {
            return super.addAll(collection);
        }
        b90 b90 = (b90) collection;
        int i = b90.f7886c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f7886c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f7885b;
            if (i3 > dArr.length) {
                this.f7885b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(b90.f7885b, 0, this.f7885b, this.f7886c, b90.f7886c);
            this.f7886c = i3;
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
        if (!(obj instanceof b90)) {
            return super.equals(obj);
        }
        b90 b90 = (b90) obj;
        if (this.f7886c != b90.f7886c) {
            return false;
        }
        double[] dArr = b90.f7885b;
        for (int i = 0; i < this.f7886c; i++) {
            if (Double.doubleToLongBits(this.f7885b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m5831b(i);
        return Double.valueOf(this.f7885b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f7886c; i2++) {
            i = (i * 31) + zzekk.zzfq(Double.doubleToLongBits(this.f7885b[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f7885b[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.f7886c; i++) {
            if (obj.equals(Double.valueOf(this.f7885b[i]))) {
                double[] dArr = this.f7885b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f7886c - i) - 1);
                this.f7886c--;
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
            double[] dArr = this.f7885b;
            System.arraycopy(dArr, i2, dArr, i, this.f7886c - i2);
            this.f7886c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbfm();
        m5831b(i);
        double[] dArr = this.f7885b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.f7886c;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.f7886c) {
            return new b90(Arrays.copyOf(this.f7885b, i), this.f7886c);
        }
        throw new IllegalArgumentException();
    }

    private b90(double[] dArr, int i) {
        this.f7885b = dArr;
        this.f7886c = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        m5831b(i);
        double[] dArr = this.f7885b;
        double d = dArr[i];
        int i2 = this.f7886c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f7886c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo13639a(((Double) obj).doubleValue());
        return true;
    }
}
