package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.f3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2755f3 extends C2731c3<Boolean> implements zzii<Boolean>, C2757f5, RandomAccess {

    /* renamed from: b */
    private boolean[] f17296b;

    /* renamed from: c */
    private int f17297c;

    static {
        new C2755f3(new boolean[0], 0).zzb();
    }

    C2755f3() {
        this(new boolean[10], 0);
    }

    /* renamed from: b */
    private final void m9403b(int i) {
        if (i < 0 || i >= this.f17297c) {
            throw new IndexOutOfBoundsException(m9404c(i));
        }
    }

    /* renamed from: c */
    private final String m9404c(int i) {
        int i2 = this.f17297c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo18628a(boolean z) {
        zzc();
        int i = this.f17297c;
        boolean[] zArr = this.f17296b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f17296b = zArr2;
        }
        boolean[] zArr3 = this.f17296b;
        int i2 = this.f17297c;
        this.f17297c = i2 + 1;
        zArr3[i2] = z;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzc();
        if (i < 0 || i > (i2 = this.f17297c)) {
            throw new IndexOutOfBoundsException(m9404c(i));
        }
        boolean[] zArr = this.f17296b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f17296b, i, zArr2, i + 1, this.f17297c - i);
            this.f17296b = zArr2;
        }
        this.f17296b[i] = booleanValue;
        this.f17297c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzc();
        zzic.m10383b(collection);
        if (!(collection instanceof C2755f3)) {
            return super.addAll(collection);
        }
        C2755f3 f3Var = (C2755f3) collection;
        int i = f3Var.f17297c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17297c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f17296b;
            if (i3 > zArr.length) {
                this.f17296b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(f3Var.f17296b, 0, this.f17296b, this.f17297c, f3Var.f17297c);
            this.f17297c = i3;
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
        if (!(obj instanceof C2755f3)) {
            return super.equals(obj);
        }
        C2755f3 f3Var = (C2755f3) obj;
        if (this.f17297c != f3Var.f17297c) {
            return false;
        }
        boolean[] zArr = f3Var.f17296b;
        for (int i = 0; i < this.f17297c; i++) {
            if (this.f17296b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m9403b(i);
        return Boolean.valueOf(this.f17296b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17297c; i2++) {
            i = (i * 31) + zzic.zza(this.f17296b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f17296b[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        m9403b(i);
        boolean[] zArr = this.f17296b;
        boolean z = zArr[i];
        int i2 = this.f17297c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f17297c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            boolean[] zArr = this.f17296b;
            System.arraycopy(zArr, i2, zArr, i, this.f17297c - i2);
            this.f17297c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzc();
        m9403b(i);
        boolean[] zArr = this.f17296b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f17297c;
    }

    public final /* synthetic */ zzii zza(int i) {
        if (i >= this.f17297c) {
            return new C2755f3(Arrays.copyOf(this.f17296b, i), this.f17297c);
        }
        throw new IllegalArgumentException();
    }

    private C2755f3(boolean[] zArr, int i) {
        this.f17296b = zArr;
        this.f17297c = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo18628a(((Boolean) obj).booleanValue());
        return true;
    }
}
