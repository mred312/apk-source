package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.r */
/* compiled from: LongArrayList */
final class C3745r extends C3685a<Long> implements Internal.LongList, RandomAccess, C3705g0 {

    /* renamed from: d */
    private static final C3745r f20859d;

    /* renamed from: b */
    private long[] f20860b;

    /* renamed from: c */
    private int f20861c;

    static {
        C3745r rVar = new C3745r(new long[0], 0);
        f20859d = rVar;
        rVar.makeImmutable();
    }

    C3745r() {
        this(new long[10], 0);
    }

    /* renamed from: c */
    private void m13632c(int i, long j) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.f20861c)) {
            throw new IndexOutOfBoundsException(m13635g(i));
        }
        long[] jArr = this.f20860b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f20860b, i, jArr2, i + 1, this.f20861c - i);
            this.f20860b = jArr2;
        }
        this.f20860b[i] = j;
        this.f20861c++;
        this.modCount++;
    }

    /* renamed from: d */
    public static C3745r m13633d() {
        return f20859d;
    }

    /* renamed from: e */
    private void m13634e(int i) {
        if (i < 0 || i >= this.f20861c) {
            throw new IndexOutOfBoundsException(m13635g(i));
        }
    }

    /* renamed from: g */
    private String m13635g(int i) {
        return "Index:" + i + ", Size:" + this.f20861c;
    }

    /* renamed from: a */
    public void add(int i, Long l) {
        m13632c(i, l.longValue());
    }

    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.m12790a(collection);
        if (!(collection instanceof C3745r)) {
            return super.addAll(collection);
        }
        C3745r rVar = (C3745r) collection;
        int i = rVar.f20861c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f20861c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f20860b;
            if (i3 > jArr.length) {
                this.f20860b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(rVar.f20860b, 0, this.f20860b, this.f20861c, rVar.f20861c);
            this.f20861c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j) {
        ensureIsMutable();
        int i = this.f20861c;
        long[] jArr = this.f20860b;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f20860b = jArr2;
        }
        long[] jArr3 = this.f20860b;
        int i2 = this.f20861c;
        this.f20861c = i2 + 1;
        jArr3[i2] = j;
    }

    /* renamed from: b */
    public boolean add(Long l) {
        addLong(l.longValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3745r)) {
            return super.equals(obj);
        }
        C3745r rVar = (C3745r) obj;
        if (this.f20861c != rVar.f20861c) {
            return false;
        }
        long[] jArr = rVar.f20860b;
        for (int i = 0; i < this.f20861c; i++) {
            if (this.f20860b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public Long get(int i) {
        return Long.valueOf(getLong(i));
    }

    public long getLong(int i) {
        m13634e(i);
        return this.f20860b[i];
    }

    /* renamed from: h */
    public Long remove(int i) {
        ensureIsMutable();
        m13634e(i);
        long[] jArr = this.f20860b;
        long j = jArr[i];
        int i2 = this.f20861c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f20861c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f20861c; i2++) {
            i = (i * 31) + Internal.hashLong(this.f20860b[i2]);
        }
        return i;
    }

    /* renamed from: i */
    public Long set(int i, Long l) {
        return Long.valueOf(setLong(i, l.longValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            long[] jArr = this.f20860b;
            System.arraycopy(jArr, i2, jArr, i, this.f20861c - i2);
            this.f20861c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i, long j) {
        ensureIsMutable();
        m13634e(i);
        long[] jArr = this.f20860b;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    public int size() {
        return this.f20861c;
    }

    private C3745r(long[] jArr, int i) {
        this.f20860b = jArr;
        this.f20861c = i;
    }

    public Internal.LongList mutableCopyWithCapacity(int i) {
        if (i >= this.f20861c) {
            return new C3745r(Arrays.copyOf(this.f20860b, i), this.f20861c);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.f20861c; i++) {
            if (obj.equals(Long.valueOf(this.f20860b[i]))) {
                long[] jArr = this.f20860b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f20861c - i) - 1);
                this.f20861c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
