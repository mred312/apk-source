package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    @Nullable

    /* renamed from: d */
    static Object[] f1875d;

    /* renamed from: e */
    static int f1876e;
    @Nullable

    /* renamed from: f */
    static Object[] f1877f;

    /* renamed from: g */
    static int f1878g;

    /* renamed from: a */
    int[] f1879a;

    /* renamed from: b */
    Object[] f1880b;

    /* renamed from: c */
    int f1881c;

    public SimpleArrayMap() {
        this.f1879a = C0386a.f1887a;
        this.f1880b = C0386a.f1889c;
        this.f1881c = 0;
    }

    /* renamed from: a */
    private void m1235a(int i) {
        Class<SimpleArrayMap> cls = SimpleArrayMap.class;
        if (i == 8) {
            synchronized (cls) {
                Object[] objArr = f1877f;
                if (objArr != null) {
                    this.f1880b = objArr;
                    f1877f = (Object[]) objArr[0];
                    this.f1879a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1878g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (cls) {
                Object[] objArr2 = f1875d;
                if (objArr2 != null) {
                    this.f1880b = objArr2;
                    f1875d = (Object[]) objArr2[0];
                    this.f1879a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1876e--;
                    return;
                }
            }
        }
        this.f1879a = new int[i];
        this.f1880b = new Object[(i << 1)];
    }

    /* renamed from: b */
    private static int m1236b(int[] iArr, int i, int i2) {
        try {
            return C0386a.m1242a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: c */
    private static void m1237c(int[] iArr, Object[] objArr, int i) {
        Class<SimpleArrayMap> cls = SimpleArrayMap.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f1878g < 10) {
                    objArr[0] = f1877f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1877f = objArr;
                    f1878g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f1876e < 10) {
                    objArr[0] = f1875d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1875d = objArr;
                    f1876e++;
                }
            }
        }
    }

    public void clear() {
        int i = this.f1881c;
        if (i > 0) {
            int[] iArr = this.f1879a;
            Object[] objArr = this.f1880b;
            this.f1879a = C0386a.f1887a;
            this.f1880b = C0386a.f1889c;
            this.f1881c = 0;
            m1237c(iArr, objArr, i);
        }
        if (this.f1881c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo3345f(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3341d(Object obj, int i) {
        int i2 = this.f1881c;
        if (i2 == 0) {
            return -1;
        }
        int b = m1236b(this.f1879a, i2, i);
        if (b < 0 || obj.equals(this.f1880b[b << 1])) {
            return b;
        }
        int i3 = b + 1;
        while (i3 < i2 && this.f1879a[i3] == i) {
            if (obj.equals(this.f1880b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = b - 1;
        while (i4 >= 0 && this.f1879a[i4] == i) {
            if (obj.equals(this.f1880b[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo3342e() {
        int i = this.f1881c;
        if (i == 0) {
            return -1;
        }
        int b = m1236b(this.f1879a, i, 0);
        if (b < 0 || this.f1880b[b << 1] == null) {
            return b;
        }
        int i2 = b + 1;
        while (i2 < i && this.f1879a[i2] == 0) {
            if (this.f1880b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = b - 1;
        while (i3 >= 0 && this.f1879a[i3] == 0) {
            if (this.f1880b[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    public void ensureCapacity(int i) {
        int i2 = this.f1881c;
        int[] iArr = this.f1879a;
        if (iArr.length < i) {
            Object[] objArr = this.f1880b;
            m1235a(i);
            if (this.f1881c > 0) {
                System.arraycopy(iArr, 0, this.f1879a, 0, i2);
                System.arraycopy(objArr, 0, this.f1880b, 0, i2 << 1);
            }
            m1237c(iArr, objArr, i2);
        }
        if (this.f1881c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1881c) {
                try {
                    Object keyAt = keyAt(i);
                    Object valueAt = valueAt(i);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f1881c) {
                try {
                    Object keyAt2 = keyAt(i2);
                    Object valueAt2 = valueAt(i2);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo3345f(Object obj) {
        int i = this.f1881c * 2;
        Object[] objArr = this.f1880b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.f1880b[(indexOfKey << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f1879a;
        Object[] objArr = this.f1880b;
        int i = this.f1881c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public int indexOfKey(@Nullable Object obj) {
        return obj == null ? mo3342e() : mo3341d(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1881c <= 0;
    }

    public K keyAt(int i) {
        return this.f1880b[i << 1];
    }

    @Nullable
    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.f1881c;
        if (k == null) {
            i2 = mo3342e();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = mo3341d(k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.f1880b;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        int[] iArr = this.f1879a;
        if (i3 >= iArr.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f1880b;
            m1235a(i6);
            if (i3 == this.f1881c) {
                int[] iArr2 = this.f1879a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1880b, 0, objArr.length);
                }
                m1237c(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f1879a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.f1880b;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.f1881c - i5) << 1);
        }
        int i8 = this.f1881c;
        if (i3 == i8) {
            int[] iArr4 = this.f1879a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.f1880b;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.f1881c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f1881c;
        ensureCapacity(this.f1881c + i);
        if (this.f1881c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f1879a, 0, this.f1879a, 0, i);
            System.arraycopy(simpleArrayMap.f1880b, 0, this.f1880b, 0, i << 1);
            this.f1881c = i;
        }
    }

    @Nullable
    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        V[] vArr = this.f1880b;
        int i2 = i << 1;
        V v = vArr[i2 + 1];
        int i3 = this.f1881c;
        int i4 = 0;
        if (i3 <= 1) {
            m1237c(this.f1879a, vArr, i3);
            this.f1879a = C0386a.f1887a;
            this.f1880b = C0386a.f1889c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f1879a;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr = this.f1880b;
                    System.arraycopy(objArr, i7 << 1, objArr, i2, i8 << 1);
                }
                Object[] objArr2 = this.f1880b;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                m1235a(i6);
                if (i3 == this.f1881c) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.f1879a, 0, i);
                        System.arraycopy(vArr, 0, this.f1880b, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.f1879a, i, i11);
                        System.arraycopy(vArr, i10 << 1, this.f1880b, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.f1881c) {
            this.f1881c = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.f1880b;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public int size() {
        return this.f1881c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1881c * 28);
        sb.append('{');
        for (int i = 0; i < this.f1881c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
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

    public V valueAt(int i) {
        return this.f1880b[(i << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v && (v == null || !v.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v2);
        return true;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f1879a = C0386a.f1887a;
            this.f1880b = C0386a.f1889c;
        } else {
            m1235a(i);
        }
        this.f1881c = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
