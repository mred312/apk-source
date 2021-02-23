package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.n4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2824n4 extends C2731c3<Long> implements zzif, C2757f5, RandomAccess {

    /* renamed from: d */
    private static final C2824n4 f17391d;

    /* renamed from: b */
    private long[] f17392b;

    /* renamed from: c */
    private int f17393c;

    static {
        C2824n4 n4Var = new C2824n4(new long[0], 0);
        f17391d = n4Var;
        n4Var.zzb();
    }

    C2824n4() {
        this(new long[10], 0);
    }

    /* renamed from: b */
    public static C2824n4 m9670b() {
        return f17391d;
    }

    /* renamed from: c */
    private final void m9671c(int i) {
        if (i < 0 || i >= this.f17393c) {
            throw new IndexOutOfBoundsException(m9672d(i));
        }
    }

    /* renamed from: d */
    private final String m9672d(int i) {
        int i2 = this.f17393c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo18765a(long j) {
        zzc();
        int i = this.f17393c;
        long[] jArr = this.f17392b;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f17392b = jArr2;
        }
        long[] jArr3 = this.f17392b;
        int i2 = this.f17393c;
        this.f17393c = i2 + 1;
        jArr3[i2] = j;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzc();
        if (i < 0 || i > (i2 = this.f17393c)) {
            throw new IndexOutOfBoundsException(m9672d(i));
        }
        long[] jArr = this.f17392b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f17392b, i, jArr2, i + 1, this.f17393c - i);
            this.f17392b = jArr2;
        }
        this.f17392b[i] = longValue;
        this.f17393c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzc();
        zzic.m10383b(collection);
        if (!(collection instanceof C2824n4)) {
            return super.addAll(collection);
        }
        C2824n4 n4Var = (C2824n4) collection;
        int i = n4Var.f17393c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17393c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f17392b;
            if (i3 > jArr.length) {
                this.f17392b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(n4Var.f17392b, 0, this.f17392b, this.f17393c, n4Var.f17393c);
            this.f17393c = i3;
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
        if (!(obj instanceof C2824n4)) {
            return super.equals(obj);
        }
        C2824n4 n4Var = (C2824n4) obj;
        if (this.f17393c != n4Var.f17393c) {
            return false;
        }
        long[] jArr = n4Var.f17392b;
        for (int i = 0; i < this.f17393c; i++) {
            if (this.f17392b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(zzb(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17393c; i2++) {
            i = (i * 31) + zzic.zza(this.f17392b[i2]);
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
            if (this.f17392b[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        m9671c(i);
        long[] jArr = this.f17392b;
        long j = jArr[i];
        int i2 = this.f17393c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f17393c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            long[] jArr = this.f17392b;
            System.arraycopy(jArr, i2, jArr, i, this.f17393c - i2);
            this.f17393c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzc();
        m9671c(i);
        long[] jArr = this.f17392b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f17393c;
    }

    public final long zzb(int i) {
        m9671c(i);
        return this.f17392b[i];
    }

    /* renamed from: zzc */
    public final zzif zza(int i) {
        if (i >= this.f17393c) {
            return new C2824n4(Arrays.copyOf(this.f17392b, i), this.f17393c);
        }
        throw new IllegalArgumentException();
    }

    private C2824n4(long[] jArr, int i) {
        this.f17392b = jArr;
        this.f17393c = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo18765a(((Long) obj).longValue());
        return true;
    }
}
