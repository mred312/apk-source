package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class oa0<E> extends g80<E> implements RandomAccess {

    /* renamed from: d */
    private static final oa0<Object> f10351d;

    /* renamed from: b */
    private E[] f10352b;

    /* renamed from: c */
    private int f10353c;

    static {
        oa0<Object> oa0 = new oa0<>(new Object[0], 0);
        f10351d = oa0;
        oa0.zzbfl();
    }

    private oa0(E[] eArr, int i) {
        this.f10352b = eArr;
        this.f10353c = i;
    }

    /* renamed from: a */
    public static <E> oa0<E> m6577a() {
        return f10351d;
    }

    /* renamed from: b */
    private final void m6578b(int i) {
        if (i < 0 || i >= this.f10353c) {
            throw new IndexOutOfBoundsException(m6579c(i));
        }
    }

    /* renamed from: c */
    private final String m6579c(int i) {
        int i2 = this.f10353c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final boolean add(E e) {
        zzbfm();
        int i = this.f10353c;
        E[] eArr = this.f10352b;
        if (i == eArr.length) {
            this.f10352b = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f10352b;
        int i2 = this.f10353c;
        this.f10353c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final E get(int i) {
        m6578b(i);
        return this.f10352b[i];
    }

    public final E remove(int i) {
        zzbfm();
        m6578b(i);
        E[] eArr = this.f10352b;
        E e = eArr[i];
        int i2 = this.f10353c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f10353c--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzbfm();
        m6578b(i);
        E[] eArr = this.f10352b;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.f10353c;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.f10353c) {
            return new oa0(Arrays.copyOf(this.f10352b, i), this.f10353c);
        }
        throw new IllegalArgumentException();
    }

    public final void add(int i, E e) {
        int i2;
        zzbfm();
        if (i < 0 || i > (i2 = this.f10353c)) {
            throw new IndexOutOfBoundsException(m6579c(i));
        }
        E[] eArr = this.f10352b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f10352b, i, eArr2, i + 1, this.f10353c - i);
            this.f10352b = eArr2;
        }
        this.f10352b[i] = e;
        this.f10353c++;
        this.modCount++;
    }
}
