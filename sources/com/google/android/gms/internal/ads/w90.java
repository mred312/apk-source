package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class w90 extends g80<Long> implements zzekq, na0, RandomAccess {

    /* renamed from: d */
    private static final w90 f11684d;

    /* renamed from: b */
    private long[] f11685b;

    /* renamed from: c */
    private int f11686c;

    static {
        w90 w90 = new w90(new long[0], 0);
        f11684d = w90;
        w90.zzbfl();
    }

    w90() {
        this(new long[10], 0);
    }

    /* renamed from: a */
    public static w90 m7116a() {
        return f11684d;
    }

    /* renamed from: c */
    private final void m7117c(int i) {
        if (i < 0 || i >= this.f11686c) {
            throw new IndexOutOfBoundsException(m7118d(i));
        }
    }

    /* renamed from: d */
    private final String m7118d(int i) {
        int i2 = this.f11686c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.f11686c)) {
            throw new IndexOutOfBoundsException(m7118d(i));
        }
        long[] jArr = this.f11685b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f11685b, i, jArr2, i + 1, this.f11686c - i);
            this.f11685b = jArr2;
        }
        this.f11685b[i] = longValue;
        this.f11686c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbfm();
        zzekk.m8823a(collection);
        if (!(collection instanceof w90)) {
            return super.addAll(collection);
        }
        w90 w90 = (w90) collection;
        int i = w90.f11686c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f11686c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f11685b;
            if (i3 > jArr.length) {
                this.f11685b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(w90.f11685b, 0, this.f11685b, this.f11686c, w90.f11686c);
            this.f11686c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: b */
    public final void mo14960b(long j) {
        zzbfm();
        int i = this.f11686c;
        long[] jArr = this.f11685b;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f11685b = jArr2;
        }
        long[] jArr3 = this.f11685b;
        int i2 = this.f11686c;
        this.f11686c = i2 + 1;
        jArr3[i2] = j;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w90)) {
            return super.equals(obj);
        }
        w90 w90 = (w90) obj;
        if (this.f11686c != w90.f11686c) {
            return false;
        }
        long[] jArr = w90.f11685b;
        for (int i = 0; i < this.f11686c; i++) {
            if (this.f11685b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        m7117c(i);
        return this.f11685b[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f11686c; i2++) {
            i = (i * 31) + zzekk.zzfq(this.f11685b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f11685b[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.f11686c; i++) {
            if (obj.equals(Long.valueOf(this.f11685b[i]))) {
                long[] jArr = this.f11685b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f11686c - i) - 1);
                this.f11686c--;
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
            long[] jArr = this.f11685b;
            System.arraycopy(jArr, i2, jArr, i, this.f11686c - i2);
            this.f11686c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbfm();
        m7117c(i);
        long[] jArr = this.f11685b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f11686c;
    }

    /* renamed from: zzhh */
    public final zzekq zzfx(int i) {
        if (i >= this.f11686c) {
            return new w90(Arrays.copyOf(this.f11685b, i), this.f11686c);
        }
        throw new IllegalArgumentException();
    }

    private w90(long[] jArr, int i) {
        this.f11685b = jArr;
        this.f11686c = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        m7117c(i);
        long[] jArr = this.f11685b;
        long j = jArr[i];
        int i2 = this.f11686c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f11686c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo14960b(((Long) obj).longValue());
        return true;
    }
}
