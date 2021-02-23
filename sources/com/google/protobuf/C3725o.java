package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.o */
/* compiled from: IntArrayList */
final class C3725o extends C3685a<Integer> implements Internal.IntList, RandomAccess, C3705g0 {

    /* renamed from: d */
    private static final C3725o f20818d;

    /* renamed from: b */
    private int[] f20819b;

    /* renamed from: c */
    private int f20820c;

    static {
        C3725o oVar = new C3725o(new int[0], 0);
        f20818d = oVar;
        oVar.makeImmutable();
    }

    C3725o() {
        this(new int[10], 0);
    }

    /* renamed from: c */
    private void m13515c(int i, int i2) {
        int i3;
        ensureIsMutable();
        if (i < 0 || i > (i3 = this.f20820c)) {
            throw new IndexOutOfBoundsException(m13518g(i));
        }
        int[] iArr = this.f20819b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f20819b, i, iArr2, i + 1, this.f20820c - i);
            this.f20819b = iArr2;
        }
        this.f20819b[i] = i2;
        this.f20820c++;
        this.modCount++;
    }

    /* renamed from: d */
    public static C3725o m13516d() {
        return f20818d;
    }

    /* renamed from: e */
    private void m13517e(int i) {
        if (i < 0 || i >= this.f20820c) {
            throw new IndexOutOfBoundsException(m13518g(i));
        }
    }

    /* renamed from: g */
    private String m13518g(int i) {
        return "Index:" + i + ", Size:" + this.f20820c;
    }

    /* renamed from: a */
    public void add(int i, Integer num) {
        m13515c(i, num.intValue());
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.m12790a(collection);
        if (!(collection instanceof C3725o)) {
            return super.addAll(collection);
        }
        C3725o oVar = (C3725o) collection;
        int i = oVar.f20820c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f20820c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f20819b;
            if (i3 > iArr.length) {
                this.f20819b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(oVar.f20819b, 0, this.f20819b, this.f20820c, oVar.f20820c);
            this.f20820c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i) {
        ensureIsMutable();
        int i2 = this.f20820c;
        int[] iArr = this.f20819b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f20819b = iArr2;
        }
        int[] iArr3 = this.f20819b;
        int i3 = this.f20820c;
        this.f20820c = i3 + 1;
        iArr3[i3] = i;
    }

    /* renamed from: b */
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3725o)) {
            return super.equals(obj);
        }
        C3725o oVar = (C3725o) obj;
        if (this.f20820c != oVar.f20820c) {
            return false;
        }
        int[] iArr = oVar.f20819b;
        for (int i = 0; i < this.f20820c; i++) {
            if (this.f20819b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public int getInt(int i) {
        m13517e(i);
        return this.f20819b[i];
    }

    /* renamed from: h */
    public Integer remove(int i) {
        ensureIsMutable();
        m13517e(i);
        int[] iArr = this.f20819b;
        int i2 = iArr[i];
        int i3 = this.f20820c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f20820c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f20820c; i2++) {
            i = (i * 31) + this.f20819b[i2];
        }
        return i;
    }

    /* renamed from: i */
    public Integer set(int i, Integer num) {
        return Integer.valueOf(setInt(i, num.intValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            int[] iArr = this.f20819b;
            System.arraycopy(iArr, i2, iArr, i, this.f20820c - i2);
            this.f20820c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int setInt(int i, int i2) {
        ensureIsMutable();
        m13517e(i);
        int[] iArr = this.f20819b;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public int size() {
        return this.f20820c;
    }

    private C3725o(int[] iArr, int i) {
        this.f20819b = iArr;
        this.f20820c = i;
    }

    public Internal.IntList mutableCopyWithCapacity(int i) {
        if (i >= this.f20820c) {
            return new C3725o(Arrays.copyOf(this.f20819b, i), this.f20820c);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.f20820c; i++) {
            if (obj.equals(Integer.valueOf(this.f20819b[i]))) {
                int[] iArr = this.f20819b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f20820c - i) - 1);
                this.f20820c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
