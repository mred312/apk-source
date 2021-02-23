package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class i90 extends g80<Float> implements zzekp<Float>, na0, RandomAccess {

    /* renamed from: b */
    private float[] f9278b;

    /* renamed from: c */
    private int f9279c;

    static {
        new i90(new float[0], 0).zzbfl();
    }

    i90() {
        this(new float[10], 0);
    }

    /* renamed from: a */
    private final void m6316a(int i) {
        if (i < 0 || i >= this.f9279c) {
            throw new IndexOutOfBoundsException(m6317b(i));
        }
    }

    /* renamed from: b */
    private final String m6317b(int i) {
        int i2 = this.f9279c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.f9279c)) {
            throw new IndexOutOfBoundsException(m6317b(i));
        }
        float[] fArr = this.f9278b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f9278b, i, fArr2, i + 1, this.f9279c - i);
            this.f9278b = fArr2;
        }
        this.f9278b[i] = floatValue;
        this.f9279c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzbfm();
        zzekk.m8823a(collection);
        if (!(collection instanceof i90)) {
            return super.addAll(collection);
        }
        i90 i90 = (i90) collection;
        int i = i90.f9279c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f9279c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f9278b;
            if (i3 > fArr.length) {
                this.f9278b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(i90.f9278b, 0, this.f9278b, this.f9279c, i90.f9279c);
            this.f9279c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public final void mo14255c(float f) {
        zzbfm();
        int i = this.f9279c;
        float[] fArr = this.f9278b;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f9278b = fArr2;
        }
        float[] fArr3 = this.f9278b;
        int i2 = this.f9279c;
        this.f9279c = i2 + 1;
        fArr3[i2] = f;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i90)) {
            return super.equals(obj);
        }
        i90 i90 = (i90) obj;
        if (this.f9279c != i90.f9279c) {
            return false;
        }
        float[] fArr = i90.f9278b;
        for (int i = 0; i < this.f9279c; i++) {
            if (Float.floatToIntBits(this.f9278b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m6316a(i);
        return Float.valueOf(this.f9278b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f9279c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f9278b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f9278b[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.f9279c; i++) {
            if (obj.equals(Float.valueOf(this.f9278b[i]))) {
                float[] fArr = this.f9278b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f9279c - i) - 1);
                this.f9279c--;
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
            float[] fArr = this.f9278b;
            System.arraycopy(fArr, i2, fArr, i, this.f9279c - i2);
            this.f9279c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbfm();
        m6316a(i);
        float[] fArr = this.f9278b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.f9279c;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.f9279c) {
            return new i90(Arrays.copyOf(this.f9278b, i), this.f9279c);
        }
        throw new IllegalArgumentException();
    }

    private i90(float[] fArr, int i) {
        this.f9278b = fArr;
        this.f9279c = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        m6316a(i);
        float[] fArr = this.f9278b;
        float f = fArr[i];
        int i2 = this.f9279c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f9279c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo14255c(((Float) obj).floatValue());
        return true;
    }
}
