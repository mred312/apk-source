package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.v3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2887v3 extends C2731c3<Double> implements zzii<Double>, C2757f5, RandomAccess {

    /* renamed from: b */
    private double[] f17491b;

    /* renamed from: c */
    private int f17492c;

    static {
        new C2887v3(new double[0], 0).zzb();
    }

    C2887v3() {
        this(new double[10], 0);
    }

    /* renamed from: b */
    private final void m9875b(int i) {
        if (i < 0 || i >= this.f17492c) {
            throw new IndexOutOfBoundsException(m9876c(i));
        }
    }

    /* renamed from: c */
    private final String m9876c(int i) {
        int i2 = this.f17492c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo18923a(double d) {
        zzc();
        int i = this.f17492c;
        double[] dArr = this.f17491b;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f17491b = dArr2;
        }
        double[] dArr3 = this.f17491b;
        int i2 = this.f17492c;
        this.f17492c = i2 + 1;
        dArr3[i2] = d;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zzc();
        if (i < 0 || i > (i2 = this.f17492c)) {
            throw new IndexOutOfBoundsException(m9876c(i));
        }
        double[] dArr = this.f17491b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f17491b, i, dArr2, i + 1, this.f17492c - i);
            this.f17491b = dArr2;
        }
        this.f17491b[i] = doubleValue;
        this.f17492c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzc();
        zzic.m10383b(collection);
        if (!(collection instanceof C2887v3)) {
            return super.addAll(collection);
        }
        C2887v3 v3Var = (C2887v3) collection;
        int i = v3Var.f17492c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17492c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f17491b;
            if (i3 > dArr.length) {
                this.f17491b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(v3Var.f17491b, 0, this.f17491b, this.f17492c, v3Var.f17492c);
            this.f17492c = i3;
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
        if (!(obj instanceof C2887v3)) {
            return super.equals(obj);
        }
        C2887v3 v3Var = (C2887v3) obj;
        if (this.f17492c != v3Var.f17492c) {
            return false;
        }
        double[] dArr = v3Var.f17491b;
        for (int i = 0; i < this.f17492c; i++) {
            if (Double.doubleToLongBits(this.f17491b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m9875b(i);
        return Double.valueOf(this.f17491b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17492c; i2++) {
            i = (i * 31) + zzic.zza(Double.doubleToLongBits(this.f17491b[i2]));
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
            if (this.f17491b[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        m9875b(i);
        double[] dArr = this.f17491b;
        double d = dArr[i];
        int i2 = this.f17492c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f17492c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            double[] dArr = this.f17491b;
            System.arraycopy(dArr, i2, dArr, i, this.f17492c - i2);
            this.f17492c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzc();
        m9875b(i);
        double[] dArr = this.f17491b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.f17492c;
    }

    public final /* synthetic */ zzii zza(int i) {
        if (i >= this.f17492c) {
            return new C2887v3(Arrays.copyOf(this.f17491b, i), this.f17492c);
        }
        throw new IllegalArgumentException();
    }

    private C2887v3(double[] dArr, int i) {
        this.f17491b = dArr;
        this.f17492c = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo18923a(((Double) obj).doubleValue());
        return true;
    }
}
