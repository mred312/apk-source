package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.i5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2785i5<E> extends C2731c3<E> implements RandomAccess {

    /* renamed from: d */
    private static final C2785i5<Object> f17347d;

    /* renamed from: b */
    private E[] f17348b;

    /* renamed from: c */
    private int f17349c;

    static {
        C2785i5<Object> i5Var = new C2785i5<>(new Object[0], 0);
        f17347d = i5Var;
        i5Var.zzb();
    }

    private C2785i5(E[] eArr, int i) {
        this.f17348b = eArr;
        this.f17349c = i;
    }

    /* renamed from: a */
    private final void m9513a(int i) {
        if (i < 0 || i >= this.f17349c) {
            throw new IndexOutOfBoundsException(m9514b(i));
        }
    }

    /* renamed from: b */
    private final String m9514b(int i) {
        int i2 = this.f17349c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: c */
    public static <E> C2785i5<E> m9515c() {
        return f17347d;
    }

    public final boolean add(E e) {
        zzc();
        int i = this.f17349c;
        E[] eArr = this.f17348b;
        if (i == eArr.length) {
            this.f17348b = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f17348b;
        int i2 = this.f17349c;
        this.f17349c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final E get(int i) {
        m9513a(i);
        return this.f17348b[i];
    }

    public final E remove(int i) {
        zzc();
        m9513a(i);
        E[] eArr = this.f17348b;
        E e = eArr[i];
        int i2 = this.f17349c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f17349c--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzc();
        m9513a(i);
        E[] eArr = this.f17348b;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.f17349c;
    }

    public final /* synthetic */ zzii zza(int i) {
        if (i >= this.f17349c) {
            return new C2785i5(Arrays.copyOf(this.f17348b, i), this.f17349c);
        }
        throw new IllegalArgumentException();
    }

    public final void add(int i, E e) {
        int i2;
        zzc();
        if (i < 0 || i > (i2 = this.f17349c)) {
            throw new IndexOutOfBoundsException(m9514b(i));
        }
        E[] eArr = this.f17348b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f17348b, i, eArr2, i + 1, this.f17349c - i);
            this.f17348b = eArr2;
        }
        this.f17348b[i] = e;
        this.f17349c++;
        this.modCount++;
    }
}
