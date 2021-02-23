package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.e */
/* compiled from: BooleanArrayList */
final class C3697e extends C3685a<Boolean> implements Internal.BooleanList, RandomAccess, C3705g0 {

    /* renamed from: d */
    private static final C3697e f20765d;

    /* renamed from: b */
    private boolean[] f20766b;

    /* renamed from: c */
    private int f20767c;

    static {
        C3697e eVar = new C3697e(new boolean[0], 0);
        f20765d = eVar;
        eVar.makeImmutable();
    }

    C3697e() {
        this(new boolean[10], 0);
    }

    /* renamed from: c */
    private void m13267c(int i, boolean z) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.f20767c)) {
            throw new IndexOutOfBoundsException(m13270g(i));
        }
        boolean[] zArr = this.f20766b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f20766b, i, zArr2, i + 1, this.f20767c - i);
            this.f20766b = zArr2;
        }
        this.f20766b[i] = z;
        this.f20767c++;
        this.modCount++;
    }

    /* renamed from: d */
    public static C3697e m13268d() {
        return f20765d;
    }

    /* renamed from: e */
    private void m13269e(int i) {
        if (i < 0 || i >= this.f20767c) {
            throw new IndexOutOfBoundsException(m13270g(i));
        }
    }

    /* renamed from: g */
    private String m13270g(int i) {
        return "Index:" + i + ", Size:" + this.f20767c;
    }

    /* renamed from: a */
    public void add(int i, Boolean bool) {
        m13267c(i, bool.booleanValue());
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.m12790a(collection);
        if (!(collection instanceof C3697e)) {
            return super.addAll(collection);
        }
        C3697e eVar = (C3697e) collection;
        int i = eVar.f20767c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f20767c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f20766b;
            if (i3 > zArr.length) {
                this.f20766b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(eVar.f20766b, 0, this.f20766b, this.f20767c, eVar.f20767c);
            this.f20767c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z) {
        ensureIsMutable();
        int i = this.f20767c;
        boolean[] zArr = this.f20766b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f20766b = zArr2;
        }
        boolean[] zArr3 = this.f20766b;
        int i2 = this.f20767c;
        this.f20767c = i2 + 1;
        zArr3[i2] = z;
    }

    /* renamed from: b */
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3697e)) {
            return super.equals(obj);
        }
        C3697e eVar = (C3697e) obj;
        if (this.f20767c != eVar.f20767c) {
            return false;
        }
        boolean[] zArr = eVar.f20766b;
        for (int i = 0; i < this.f20767c; i++) {
            if (this.f20766b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public Boolean get(int i) {
        return Boolean.valueOf(getBoolean(i));
    }

    public boolean getBoolean(int i) {
        m13269e(i);
        return this.f20766b[i];
    }

    /* renamed from: h */
    public Boolean remove(int i) {
        ensureIsMutable();
        m13269e(i);
        boolean[] zArr = this.f20766b;
        boolean z = zArr[i];
        int i2 = this.f20767c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f20767c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f20767c; i2++) {
            i = (i * 31) + Internal.hashBoolean(this.f20766b[i2]);
        }
        return i;
    }

    /* renamed from: i */
    public Boolean set(int i, Boolean bool) {
        return Boolean.valueOf(setBoolean(i, bool.booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            boolean[] zArr = this.f20766b;
            System.arraycopy(zArr, i2, zArr, i, this.f20767c - i2);
            this.f20767c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i, boolean z) {
        ensureIsMutable();
        m13269e(i);
        boolean[] zArr = this.f20766b;
        boolean z2 = zArr[i];
        zArr[i] = z;
        return z2;
    }

    public int size() {
        return this.f20767c;
    }

    private C3697e(boolean[] zArr, int i) {
        this.f20766b = zArr;
        this.f20767c = i;
    }

    public Internal.BooleanList mutableCopyWithCapacity(int i) {
        if (i >= this.f20767c) {
            return new C3697e(Arrays.copyOf(this.f20766b, i), this.f20767c);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.f20767c; i++) {
            if (obj.equals(Boolean.valueOf(this.f20766b[i]))) {
                boolean[] zArr = this.f20766b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f20767c - i) - 1);
                this.f20767c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
