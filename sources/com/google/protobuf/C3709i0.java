package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.i0 */
/* compiled from: ProtobufArrayList */
final class C3709i0<E> extends C3685a<E> implements RandomAccess {

    /* renamed from: d */
    private static final C3709i0<Object> f20785d;

    /* renamed from: b */
    private E[] f20786b;

    /* renamed from: c */
    private int f20787c;

    static {
        C3709i0<Object> i0Var = new C3709i0<>(new Object[0], 0);
        f20785d = i0Var;
        i0Var.makeImmutable();
    }

    private C3709i0(E[] eArr, int i) {
        this.f20786b = eArr;
        this.f20787c = i;
    }

    /* renamed from: a */
    private static <E> E[] m13399a(int i) {
        return new Object[i];
    }

    /* renamed from: b */
    public static <E> C3709i0<E> m13400b() {
        return f20785d;
    }

    /* renamed from: c */
    private void m13401c(int i) {
        if (i < 0 || i >= this.f20787c) {
            throw new IndexOutOfBoundsException(m13402d(i));
        }
    }

    /* renamed from: d */
    private String m13402d(int i) {
        return "Index:" + i + ", Size:" + this.f20787c;
    }

    public boolean add(E e) {
        ensureIsMutable();
        int i = this.f20787c;
        E[] eArr = this.f20786b;
        if (i == eArr.length) {
            this.f20786b = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f20786b;
        int i2 = this.f20787c;
        this.f20787c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    /* renamed from: e */
    public C3709i0<E> mutableCopyWithCapacity(int i) {
        if (i >= this.f20787c) {
            return new C3709i0<>(Arrays.copyOf(this.f20786b, i), this.f20787c);
        }
        throw new IllegalArgumentException();
    }

    public E get(int i) {
        m13401c(i);
        return this.f20786b[i];
    }

    public E remove(int i) {
        ensureIsMutable();
        m13401c(i);
        E[] eArr = this.f20786b;
        E e = eArr[i];
        int i2 = this.f20787c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f20787c--;
        this.modCount++;
        return e;
    }

    public E set(int i, E e) {
        ensureIsMutable();
        m13401c(i);
        E[] eArr = this.f20786b;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public int size() {
        return this.f20787c;
    }

    public void add(int i, E e) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.f20787c)) {
            throw new IndexOutOfBoundsException(m13402d(i));
        }
        E[] eArr = this.f20786b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] a = m13399a(((i2 * 3) / 2) + 1);
            System.arraycopy(this.f20786b, 0, a, 0, i);
            System.arraycopy(this.f20786b, i, a, i + 1, this.f20787c - i);
            this.f20786b = a;
        }
        this.f20786b[i] = e;
        this.f20787c++;
        this.modCount++;
    }
}
