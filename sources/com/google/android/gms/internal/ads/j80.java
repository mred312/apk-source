package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class j80 extends g80<Boolean> implements zzekp<Boolean>, na0, RandomAccess {

    /* renamed from: b */
    private boolean[] f9381b;

    /* renamed from: c */
    private int f9382c;

    static {
        new j80(new boolean[0], 0).zzbfl();
    }

    j80() {
        this(new boolean[10], 0);
    }

    /* renamed from: a */
    private final void m6355a(int i) {
        if (i < 0 || i >= this.f9382c) {
            throw new IndexOutOfBoundsException(m6356b(i));
        }
    }

    /* renamed from: b */
    private final String m6356b(int i) {
        int i2 = this.f9382c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.f9382c)) {
            throw new IndexOutOfBoundsException(m6356b(i));
        }
        boolean[] zArr = this.f9381b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f9381b, i, zArr2, i + 1, this.f9382c - i);
            this.f9381b = zArr2;
        }
        this.f9381b[i] = booleanValue;
        this.f9382c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbfm();
        zzekk.m8823a(collection);
        if (!(collection instanceof j80)) {
            return super.addAll(collection);
        }
        j80 j80 = (j80) collection;
        int i = j80.f9382c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f9382c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f9381b;
            if (i3 > zArr.length) {
                this.f9381b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(j80.f9381b, 0, this.f9381b, this.f9382c, j80.f9382c);
            this.f9382c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzbfm();
        int i = this.f9382c;
        boolean[] zArr = this.f9381b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f9381b = zArr2;
        }
        boolean[] zArr3 = this.f9381b;
        int i2 = this.f9382c;
        this.f9382c = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j80)) {
            return super.equals(obj);
        }
        j80 j80 = (j80) obj;
        if (this.f9382c != j80.f9382c) {
            return false;
        }
        boolean[] zArr = j80.f9381b;
        for (int i = 0; i < this.f9382c; i++) {
            if (this.f9381b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m6355a(i);
        return Boolean.valueOf(this.f9381b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f9382c; i2++) {
            i = (i * 31) + zzekk.zzbu(this.f9381b[i2]);
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
            if (this.f9381b[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.f9382c; i++) {
            if (obj.equals(Boolean.valueOf(this.f9381b[i]))) {
                boolean[] zArr = this.f9381b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f9382c - i) - 1);
                this.f9382c--;
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
            boolean[] zArr = this.f9381b;
            System.arraycopy(zArr, i2, zArr, i, this.f9382c - i2);
            this.f9382c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbfm();
        m6355a(i);
        boolean[] zArr = this.f9381b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f9382c;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.f9382c) {
            return new j80(Arrays.copyOf(this.f9381b, i), this.f9382c);
        }
        throw new IllegalArgumentException();
    }

    private j80(boolean[] zArr, int i) {
        this.f9381b = zArr;
        this.f9382c = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        m6355a(i);
        boolean[] zArr = this.f9381b;
        boolean z = zArr[i];
        int i2 = this.f9382c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f9382c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
