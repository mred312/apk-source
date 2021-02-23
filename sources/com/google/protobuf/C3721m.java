package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.m */
/* compiled from: FloatArrayList */
final class C3721m extends C3685a<Float> implements Internal.FloatList, RandomAccess, C3705g0 {

    /* renamed from: d */
    private static final C3721m f20814d;

    /* renamed from: b */
    private float[] f20815b;

    /* renamed from: c */
    private int f20816c;

    static {
        C3721m mVar = new C3721m(new float[0], 0);
        f20814d = mVar;
        mVar.makeImmutable();
    }

    C3721m() {
        this(new float[10], 0);
    }

    /* renamed from: c */
    private void m13492c(int i, float f) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.f20816c)) {
            throw new IndexOutOfBoundsException(m13495g(i));
        }
        float[] fArr = this.f20815b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f20815b, i, fArr2, i + 1, this.f20816c - i);
            this.f20815b = fArr2;
        }
        this.f20815b[i] = f;
        this.f20816c++;
        this.modCount++;
    }

    /* renamed from: d */
    public static C3721m m13493d() {
        return f20814d;
    }

    /* renamed from: e */
    private void m13494e(int i) {
        if (i < 0 || i >= this.f20816c) {
            throw new IndexOutOfBoundsException(m13495g(i));
        }
    }

    /* renamed from: g */
    private String m13495g(int i) {
        return "Index:" + i + ", Size:" + this.f20816c;
    }

    /* renamed from: a */
    public void add(int i, Float f) {
        m13492c(i, f.floatValue());
    }

    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.m12790a(collection);
        if (!(collection instanceof C3721m)) {
            return super.addAll(collection);
        }
        C3721m mVar = (C3721m) collection;
        int i = mVar.f20816c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f20816c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f20815b;
            if (i3 > fArr.length) {
                this.f20815b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(mVar.f20815b, 0, this.f20815b, this.f20816c, mVar.f20816c);
            this.f20816c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f) {
        ensureIsMutable();
        int i = this.f20816c;
        float[] fArr = this.f20815b;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f20815b = fArr2;
        }
        float[] fArr3 = this.f20815b;
        int i2 = this.f20816c;
        this.f20816c = i2 + 1;
        fArr3[i2] = f;
    }

    /* renamed from: b */
    public boolean add(Float f) {
        addFloat(f.floatValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3721m)) {
            return super.equals(obj);
        }
        C3721m mVar = (C3721m) obj;
        if (this.f20816c != mVar.f20816c) {
            return false;
        }
        float[] fArr = mVar.f20815b;
        for (int i = 0; i < this.f20816c; i++) {
            if (Float.floatToIntBits(this.f20815b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public Float get(int i) {
        return Float.valueOf(getFloat(i));
    }

    public float getFloat(int i) {
        m13494e(i);
        return this.f20815b[i];
    }

    /* renamed from: h */
    public Float remove(int i) {
        ensureIsMutable();
        m13494e(i);
        float[] fArr = this.f20815b;
        float f = fArr[i];
        int i2 = this.f20816c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f20816c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f20816c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f20815b[i2]);
        }
        return i;
    }

    /* renamed from: i */
    public Float set(int i, Float f) {
        return Float.valueOf(setFloat(i, f.floatValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            float[] fArr = this.f20815b;
            System.arraycopy(fArr, i2, fArr, i, this.f20816c - i2);
            this.f20816c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i, float f) {
        ensureIsMutable();
        m13494e(i);
        float[] fArr = this.f20815b;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    public int size() {
        return this.f20816c;
    }

    private C3721m(float[] fArr, int i) {
        this.f20815b = fArr;
        this.f20816c = i;
    }

    public Internal.FloatList mutableCopyWithCapacity(int i) {
        if (i >= this.f20816c) {
            return new C3721m(Arrays.copyOf(this.f20815b, i), this.f20816c);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.f20816c; i++) {
            if (obj.equals(Float.valueOf(this.f20815b[i]))) {
                float[] fArr = this.f20815b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f20816c - i) - 1);
                this.f20816c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
