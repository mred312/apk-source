package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.h */
/* compiled from: DoubleArrayList */
final class C3706h extends C3685a<Double> implements Internal.DoubleList, RandomAccess, C3705g0 {

    /* renamed from: d */
    private static final C3706h f20778d;

    /* renamed from: b */
    private double[] f20779b;

    /* renamed from: c */
    private int f20780c;

    static {
        C3706h hVar = new C3706h(new double[0], 0);
        f20778d = hVar;
        hVar.makeImmutable();
    }

    C3706h() {
        this(new double[10], 0);
    }

    /* renamed from: c */
    private void m13380c(int i, double d) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.f20780c)) {
            throw new IndexOutOfBoundsException(m13383g(i));
        }
        double[] dArr = this.f20779b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f20779b, i, dArr2, i + 1, this.f20780c - i);
            this.f20779b = dArr2;
        }
        this.f20779b[i] = d;
        this.f20780c++;
        this.modCount++;
    }

    /* renamed from: d */
    public static C3706h m13381d() {
        return f20778d;
    }

    /* renamed from: e */
    private void m13382e(int i) {
        if (i < 0 || i >= this.f20780c) {
            throw new IndexOutOfBoundsException(m13383g(i));
        }
    }

    /* renamed from: g */
    private String m13383g(int i) {
        return "Index:" + i + ", Size:" + this.f20780c;
    }

    /* renamed from: a */
    public void add(int i, Double d) {
        m13380c(i, d.doubleValue());
    }

    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.m12790a(collection);
        if (!(collection instanceof C3706h)) {
            return super.addAll(collection);
        }
        C3706h hVar = (C3706h) collection;
        int i = hVar.f20780c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f20780c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f20779b;
            if (i3 > dArr.length) {
                this.f20779b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(hVar.f20779b, 0, this.f20779b, this.f20780c, hVar.f20780c);
            this.f20780c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addDouble(double d) {
        ensureIsMutable();
        int i = this.f20780c;
        double[] dArr = this.f20779b;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f20779b = dArr2;
        }
        double[] dArr3 = this.f20779b;
        int i2 = this.f20780c;
        this.f20780c = i2 + 1;
        dArr3[i2] = d;
    }

    /* renamed from: b */
    public boolean add(Double d) {
        addDouble(d.doubleValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3706h)) {
            return super.equals(obj);
        }
        C3706h hVar = (C3706h) obj;
        if (this.f20780c != hVar.f20780c) {
            return false;
        }
        double[] dArr = hVar.f20779b;
        for (int i = 0; i < this.f20780c; i++) {
            if (Double.doubleToLongBits(this.f20779b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public Double get(int i) {
        return Double.valueOf(getDouble(i));
    }

    public double getDouble(int i) {
        m13382e(i);
        return this.f20779b[i];
    }

    /* renamed from: h */
    public Double remove(int i) {
        ensureIsMutable();
        m13382e(i);
        double[] dArr = this.f20779b;
        double d = dArr[i];
        int i2 = this.f20780c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f20780c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f20780c; i2++) {
            i = (i * 31) + Internal.hashLong(Double.doubleToLongBits(this.f20779b[i2]));
        }
        return i;
    }

    /* renamed from: i */
    public Double set(int i, Double d) {
        return Double.valueOf(setDouble(i, d.doubleValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            double[] dArr = this.f20779b;
            System.arraycopy(dArr, i2, dArr, i, this.f20780c - i2);
            this.f20780c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double setDouble(int i, double d) {
        ensureIsMutable();
        m13382e(i);
        double[] dArr = this.f20779b;
        double d2 = dArr[i];
        dArr[i] = d;
        return d2;
    }

    public int size() {
        return this.f20780c;
    }

    private C3706h(double[] dArr, int i) {
        this.f20779b = dArr;
        this.f20780c = i;
    }

    public Internal.DoubleList mutableCopyWithCapacity(int i) {
        if (i >= this.f20780c) {
            return new C3706h(Arrays.copyOf(this.f20779b, i), this.f20780c);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.f20780c; i++) {
            if (obj.equals(Double.valueOf(this.f20779b[i]))) {
                double[] dArr = this.f20779b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f20780c - i) - 1);
                this.f20780c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
