package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.c4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2732c4 extends C2731c3<Float> implements zzii<Float>, C2757f5, RandomAccess {

    /* renamed from: b */
    private float[] f17246b;

    /* renamed from: c */
    private int f17247c;

    static {
        new C2732c4(new float[0], 0).zzb();
    }

    C2732c4() {
        this(new float[10], 0);
    }

    /* renamed from: b */
    private final void m9327b(int i) {
        if (i < 0 || i >= this.f17247c) {
            throw new IndexOutOfBoundsException(m9328c(i));
        }
    }

    /* renamed from: c */
    private final String m9328c(int i) {
        int i2 = this.f17247c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo18576a(float f) {
        zzc();
        int i = this.f17247c;
        float[] fArr = this.f17246b;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f17246b = fArr2;
        }
        float[] fArr3 = this.f17246b;
        int i2 = this.f17247c;
        this.f17247c = i2 + 1;
        fArr3[i2] = f;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zzc();
        if (i < 0 || i > (i2 = this.f17247c)) {
            throw new IndexOutOfBoundsException(m9328c(i));
        }
        float[] fArr = this.f17246b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f17246b, i, fArr2, i + 1, this.f17247c - i);
            this.f17246b = fArr2;
        }
        this.f17246b[i] = floatValue;
        this.f17247c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzc();
        zzic.m10383b(collection);
        if (!(collection instanceof C2732c4)) {
            return super.addAll(collection);
        }
        C2732c4 c4Var = (C2732c4) collection;
        int i = c4Var.f17247c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17247c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f17246b;
            if (i3 > fArr.length) {
                this.f17246b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(c4Var.f17246b, 0, this.f17246b, this.f17247c, c4Var.f17247c);
            this.f17247c = i3;
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
        if (!(obj instanceof C2732c4)) {
            return super.equals(obj);
        }
        C2732c4 c4Var = (C2732c4) obj;
        if (this.f17247c != c4Var.f17247c) {
            return false;
        }
        float[] fArr = c4Var.f17246b;
        for (int i = 0; i < this.f17247c; i++) {
            if (Float.floatToIntBits(this.f17246b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m9327b(i);
        return Float.valueOf(this.f17246b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17247c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f17246b[i2]);
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
            if (this.f17246b[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        m9327b(i);
        float[] fArr = this.f17246b;
        float f = fArr[i];
        int i2 = this.f17247c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f17247c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            float[] fArr = this.f17246b;
            System.arraycopy(fArr, i2, fArr, i, this.f17247c - i2);
            this.f17247c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzc();
        m9327b(i);
        float[] fArr = this.f17246b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.f17247c;
    }

    public final /* synthetic */ zzii zza(int i) {
        if (i >= this.f17247c) {
            return new C2732c4(Arrays.copyOf(this.f17246b, i), this.f17247c);
        }
        throw new IllegalArgumentException();
    }

    private C2732c4(float[] fArr, int i) {
        this.f17246b = fArr;
        this.f17247c = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo18576a(((Float) obj).floatValue());
        return true;
    }
}
