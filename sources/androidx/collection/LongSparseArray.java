package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LongSparseArray<E> implements Cloneable {

    /* renamed from: e */
    private static final Object f1862e = new Object();

    /* renamed from: a */
    private boolean f1863a;

    /* renamed from: b */
    private long[] f1864b;

    /* renamed from: c */
    private Object[] f1865c;

    /* renamed from: d */
    private int f1866d;

    public LongSparseArray() {
        this(10);
    }

    /* renamed from: a */
    private void m1233a() {
        int i = this.f1866d;
        long[] jArr = this.f1864b;
        Object[] objArr = this.f1865c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1862e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1863a = false;
        this.f1866d = i2;
    }

    public void append(long j, E e) {
        int i = this.f1866d;
        if (i == 0 || j > this.f1864b[i - 1]) {
            if (this.f1863a && i >= this.f1864b.length) {
                m1233a();
            }
            int i2 = this.f1866d;
            if (i2 >= this.f1864b.length) {
                int f = C0386a.m1247f(i2 + 1);
                long[] jArr = new long[f];
                Object[] objArr = new Object[f];
                long[] jArr2 = this.f1864b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1865c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1864b = jArr;
                this.f1865c = objArr;
            }
            this.f1864b[i2] = j;
            this.f1865c[i2] = e;
            this.f1866d = i2 + 1;
            return;
        }
        put(j, e);
    }

    public void clear() {
        int i = this.f1866d;
        Object[] objArr = this.f1865c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1866d = 0;
        this.f1863a = false;
    }

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    @Deprecated
    public void delete(long j) {
        remove(j);
    }

    @Nullable
    public E get(long j) {
        return get(j, (Object) null);
    }

    public int indexOfKey(long j) {
        if (this.f1863a) {
            m1233a();
        }
        return C0386a.m1243b(this.f1864b, this.f1866d, j);
    }

    public int indexOfValue(E e) {
        if (this.f1863a) {
            m1233a();
        }
        for (int i = 0; i < this.f1866d; i++) {
            if (this.f1865c[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i) {
        if (this.f1863a) {
            m1233a();
        }
        return this.f1864b[i];
    }

    public void put(long j, E e) {
        int b = C0386a.m1243b(this.f1864b, this.f1866d, j);
        if (b >= 0) {
            this.f1865c[b] = e;
            return;
        }
        int i = b ^ -1;
        int i2 = this.f1866d;
        if (i < i2) {
            Object[] objArr = this.f1865c;
            if (objArr[i] == f1862e) {
                this.f1864b[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f1863a && i2 >= this.f1864b.length) {
            m1233a();
            i = C0386a.m1243b(this.f1864b, this.f1866d, j) ^ -1;
        }
        int i3 = this.f1866d;
        if (i3 >= this.f1864b.length) {
            int f = C0386a.m1247f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.f1864b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1865c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1864b = jArr;
            this.f1865c = objArr2;
        }
        int i4 = this.f1866d;
        if (i4 - i != 0) {
            long[] jArr3 = this.f1864b;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f1865c;
            System.arraycopy(objArr4, i, objArr4, i5, this.f1866d - i);
        }
        this.f1864b[i] = j;
        this.f1865c[i] = e;
        this.f1866d++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
    }

    @Nullable
    public E putIfAbsent(long j, E e) {
        E e2 = get(j);
        if (e2 == null) {
            put(j, e);
        }
        return e2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f1865c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f1864b
            int r1 = r2.f1866d
            int r3 = androidx.collection.C0386a.m1243b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f1865c
            r0 = r4[r3]
            java.lang.Object r1 = f1862e
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f1863a = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.remove(long):void");
    }

    public void removeAt(int i) {
        Object[] objArr = this.f1865c;
        Object obj = objArr[i];
        Object obj2 = f1862e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1863a = true;
        }
    }

    @Nullable
    public E replace(long j, E e) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.f1865c;
        E e2 = eArr[indexOfKey];
        eArr[indexOfKey] = e;
        return e2;
    }

    public void setValueAt(int i, E e) {
        if (this.f1863a) {
            m1233a();
        }
        this.f1865c[i] = e;
    }

    public int size() {
        if (this.f1863a) {
            m1233a();
        }
        return this.f1866d;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1866d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1866d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append('=');
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        if (this.f1863a) {
            m1233a();
        }
        return this.f1865c[i];
    }

    public LongSparseArray(int i) {
        this.f1863a = false;
        if (i == 0) {
            this.f1864b = C0386a.f1888b;
            this.f1865c = C0386a.f1889c;
            return;
        }
        int f = C0386a.m1247f(i);
        this.f1864b = new long[f];
        this.f1865c = new Object[f];
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f1864b = (long[]) this.f1864b.clone();
            longSparseArray.f1865c = (Object[]) this.f1865c.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E get(long j, E e) {
        int b = C0386a.m1243b(this.f1864b, this.f1866d, j);
        if (b >= 0) {
            E[] eArr = this.f1865c;
            if (eArr[b] != f1862e) {
                return eArr[b];
            }
        }
        return e;
    }

    public boolean replace(long j, E e, E e2) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return false;
        }
        E e3 = this.f1865c[indexOfKey];
        if (e3 != e && (e == null || !e.equals(e3))) {
            return false;
        }
        this.f1865c[indexOfKey] = e2;
        return true;
    }

    public boolean remove(long j, Object obj) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
