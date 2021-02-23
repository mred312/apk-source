package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.g4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2768g4 extends C2731c3<Integer> implements zzig, C2757f5, RandomAccess {

    /* renamed from: d */
    private static final C2768g4 f17322d;

    /* renamed from: b */
    private int[] f17323b;

    /* renamed from: c */
    private int f17324c;

    static {
        C2768g4 g4Var = new C2768g4(new int[0], 0);
        f17322d = g4Var;
        g4Var.zzb();
    }

    C2768g4() {
        this(new int[10], 0);
    }

    /* renamed from: b */
    public static C2768g4 m9488b() {
        return f17322d;
    }

    /* renamed from: d */
    private final void m9489d(int i) {
        if (i < 0 || i >= this.f17324c) {
            throw new IndexOutOfBoundsException(m9490e(i));
        }
    }

    /* renamed from: e */
    private final String m9490e(int i) {
        int i2 = this.f17324c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public final int mo18653a(int i) {
        m9489d(i);
        return this.f17323b[i];
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzc();
        if (i < 0 || i > (i2 = this.f17324c)) {
            throw new IndexOutOfBoundsException(m9490e(i));
        }
        int[] iArr = this.f17323b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f17323b, i, iArr2, i + 1, this.f17324c - i);
            this.f17323b = iArr2;
        }
        this.f17323b[i] = intValue;
        this.f17324c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzc();
        zzic.m10383b(collection);
        if (!(collection instanceof C2768g4)) {
            return super.addAll(collection);
        }
        C2768g4 g4Var = (C2768g4) collection;
        int i = g4Var.f17324c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17324c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f17323b;
            if (i3 > iArr.length) {
                this.f17323b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(g4Var.f17323b, 0, this.f17323b, this.f17324c, g4Var.f17324c);
            this.f17324c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public final void mo18654c(int i) {
        zzc();
        int i2 = this.f17324c;
        int[] iArr = this.f17323b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f17323b = iArr2;
        }
        int[] iArr3 = this.f17323b;
        int i3 = this.f17324c;
        this.f17324c = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2768g4)) {
            return super.equals(obj);
        }
        C2768g4 g4Var = (C2768g4) obj;
        if (this.f17324c != g4Var.f17324c) {
            return false;
        }
        int[] iArr = g4Var.f17323b;
        for (int i = 0; i < this.f17324c; i++) {
            if (this.f17323b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(mo18653a(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17324c; i2++) {
            i = (i * 31) + this.f17323b[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f17323b[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        m9489d(i);
        int[] iArr = this.f17323b;
        int i2 = iArr[i];
        int i3 = this.f17324c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f17324c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            int[] iArr = this.f17323b;
            System.arraycopy(iArr, i2, iArr, i, this.f17324c - i2);
            this.f17324c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzc();
        m9489d(i);
        int[] iArr = this.f17323b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f17324c;
    }

    /* renamed from: zzb */
    public final zzig zza(int i) {
        if (i >= this.f17324c) {
            return new C2768g4(Arrays.copyOf(this.f17323b, i), this.f17324c);
        }
        throw new IllegalArgumentException();
    }

    private C2768g4(int[] iArr, int i) {
        this.f17323b = iArr;
        this.f17324c = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        mo18654c(((Integer) obj).intValue());
        return true;
    }
}
