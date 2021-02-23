package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: e */
    private static final Object f1882e = new Object();

    /* renamed from: a */
    private boolean f1883a;

    /* renamed from: b */
    private int[] f1884b;

    /* renamed from: c */
    private Object[] f1885c;

    /* renamed from: d */
    private int f1886d;

    public SparseArrayCompat() {
        this(10);
    }

    /* renamed from: a */
    private void m1241a() {
        int i = this.f1886d;
        int[] iArr = this.f1884b;
        Object[] objArr = this.f1885c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1882e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1883a = false;
        this.f1886d = i2;
    }

    public void append(int i, E e) {
        int i2 = this.f1886d;
        if (i2 == 0 || i > this.f1884b[i2 - 1]) {
            if (this.f1883a && i2 >= this.f1884b.length) {
                m1241a();
            }
            int i3 = this.f1886d;
            if (i3 >= this.f1884b.length) {
                int e2 = C0386a.m1246e(i3 + 1);
                int[] iArr = new int[e2];
                Object[] objArr = new Object[e2];
                int[] iArr2 = this.f1884b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1885c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1884b = iArr;
                this.f1885c = objArr;
            }
            this.f1884b[i3] = i;
            this.f1885c[i3] = e;
            this.f1886d = i3 + 1;
            return;
        }
        put(i, e);
    }

    public void clear() {
        int i = this.f1886d;
        Object[] objArr = this.f1885c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1886d = 0;
        this.f1883a = false;
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    @Deprecated
    public void delete(int i) {
        remove(i);
    }

    @Nullable
    public E get(int i) {
        return get(i, (Object) null);
    }

    public int indexOfKey(int i) {
        if (this.f1883a) {
            m1241a();
        }
        return C0386a.m1242a(this.f1884b, this.f1886d, i);
    }

    public int indexOfValue(E e) {
        if (this.f1883a) {
            m1241a();
        }
        for (int i = 0; i < this.f1886d; i++) {
            if (this.f1885c[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i) {
        if (this.f1883a) {
            m1241a();
        }
        return this.f1884b[i];
    }

    public void put(int i, E e) {
        int a = C0386a.m1242a(this.f1884b, this.f1886d, i);
        if (a >= 0) {
            this.f1885c[a] = e;
            return;
        }
        int i2 = a ^ -1;
        int i3 = this.f1886d;
        if (i2 < i3) {
            Object[] objArr = this.f1885c;
            if (objArr[i2] == f1882e) {
                this.f1884b[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f1883a && i3 >= this.f1884b.length) {
            m1241a();
            i2 = C0386a.m1242a(this.f1884b, this.f1886d, i) ^ -1;
        }
        int i4 = this.f1886d;
        if (i4 >= this.f1884b.length) {
            int e2 = C0386a.m1246e(i4 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.f1884b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1885c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1884b = iArr;
            this.f1885c = objArr2;
        }
        int i5 = this.f1886d;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f1884b;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1885c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f1886d - i2);
        }
        this.f1884b[i2] = i;
        this.f1885c[i2] = e;
        this.f1886d++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
        }
    }

    @Nullable
    public E putIfAbsent(int i, E e) {
        E e2 = get(i);
        if (e2 == null) {
            put(i, e);
        }
        return e2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f1885c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f1884b
            int r1 = r3.f1886d
            int r4 = androidx.collection.C0386a.m1242a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f1885c
            r1 = r0[r4]
            java.lang.Object r2 = f1882e
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f1883a = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.remove(int):void");
    }

    public void removeAt(int i) {
        Object[] objArr = this.f1885c;
        Object obj = objArr[i];
        Object obj2 = f1882e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1883a = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f1886d, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    @Nullable
    public E replace(int i, E e) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.f1885c;
        E e2 = eArr[indexOfKey];
        eArr[indexOfKey] = e;
        return e2;
    }

    public void setValueAt(int i, E e) {
        if (this.f1883a) {
            m1241a();
        }
        this.f1885c[i] = e;
    }

    public int size() {
        if (this.f1883a) {
            m1241a();
        }
        return this.f1886d;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1886d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1886d; i++) {
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
        if (this.f1883a) {
            m1241a();
        }
        return this.f1885c[i];
    }

    public SparseArrayCompat(int i) {
        this.f1883a = false;
        if (i == 0) {
            this.f1884b = C0386a.f1887a;
            this.f1885c = C0386a.f1889c;
            return;
        }
        int e = C0386a.m1246e(i);
        this.f1884b = new int[e];
        this.f1885c = new Object[e];
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1884b = (int[]) this.f1884b.clone();
            sparseArrayCompat.f1885c = (Object[]) this.f1885c.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E get(int i, E e) {
        int a = C0386a.m1242a(this.f1884b, this.f1886d, i);
        if (a >= 0) {
            E[] eArr = this.f1885c;
            if (eArr[a] != f1882e) {
                return eArr[a];
            }
        }
        return e;
    }

    public boolean replace(int i, E e, E e2) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0) {
            return false;
        }
        E e3 = this.f1885c[indexOfKey];
        if (e3 != e && (e == null || !e.equals(e3))) {
            return false;
        }
        this.f1885c[indexOfKey] = e2;
        return true;
    }

    public boolean remove(int i, Object obj) {
        int indexOfKey = indexOfKey(i);
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
