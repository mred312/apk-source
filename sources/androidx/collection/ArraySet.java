package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: e */
    private static final int[] f1843e = new int[0];

    /* renamed from: f */
    private static final Object[] f1844f = new Object[0];
    @Nullable

    /* renamed from: g */
    private static Object[] f1845g;

    /* renamed from: h */
    private static int f1846h;
    @Nullable

    /* renamed from: i */
    private static Object[] f1847i;

    /* renamed from: j */
    private static int f1848j;

    /* renamed from: a */
    private int[] f1849a;

    /* renamed from: b */
    Object[] f1850b;

    /* renamed from: c */
    int f1851c;

    /* renamed from: d */
    private C0387b<E, E> f1852d;

    /* renamed from: androidx.collection.ArraySet$a */
    class C0385a extends C0387b<E, E> {
        C0385a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3241a() {
            ArraySet.this.clear();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo3242b(int i, int i2) {
            return ArraySet.this.f1850b[i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Map<E, E> mo3243c() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public int mo3244d() {
            return ArraySet.this.f1851c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public int mo3245e(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public int mo3246f(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo3247g(E e, E e2) {
            ArraySet.this.add(e);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo3248h(int i) {
            ArraySet.this.removeAt(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public E mo3249i(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public ArraySet() {
        this(0);
    }

    /* renamed from: a */
    private void m1217a(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = f1847i;
                if (objArr != null) {
                    this.f1850b = objArr;
                    f1847i = (Object[]) objArr[0];
                    this.f1849a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1848j--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = f1845g;
                if (objArr2 != null) {
                    this.f1850b = objArr2;
                    f1845g = (Object[]) objArr2[0];
                    this.f1849a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1846h--;
                    return;
                }
            }
        }
        this.f1849a = new int[i];
        this.f1850b = new Object[i];
    }

    /* renamed from: b */
    private static void m1218b(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f1848j < 10) {
                    objArr[0] = f1847i;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1847i = objArr;
                    f1848j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f1846h < 10) {
                    objArr[0] = f1845g;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1845g = objArr;
                    f1846h++;
                }
            }
        }
    }

    /* renamed from: c */
    private C0387b<E, E> m1219c() {
        if (this.f1852d == null) {
            this.f1852d = new C0385a();
        }
        return this.f1852d;
    }

    /* renamed from: d */
    private int m1220d(Object obj, int i) {
        int i2 = this.f1851c;
        if (i2 == 0) {
            return -1;
        }
        int a = C0386a.m1242a(this.f1849a, i2, i);
        if (a < 0 || obj.equals(this.f1850b[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1849a[i3] == i) {
            if (obj.equals(this.f1850b[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f1849a[i4] == i) {
            if (obj.equals(this.f1850b[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* renamed from: e */
    private int m1221e() {
        int i = this.f1851c;
        if (i == 0) {
            return -1;
        }
        int a = C0386a.m1242a(this.f1849a, i, 0);
        if (a < 0 || this.f1850b[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1849a[i2] == 0) {
            if (this.f1850b[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f1849a[i3] == 0) {
            if (this.f1850b[i3] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    public boolean add(@Nullable E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = m1221e();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = m1220d(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = i2 ^ -1;
        int i4 = this.f1851c;
        int[] iArr = this.f1849a;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.f1850b;
            m1217a(i5);
            int[] iArr2 = this.f1849a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1850b, 0, objArr.length);
            }
            m1218b(iArr, objArr, this.f1851c);
        }
        int i6 = this.f1851c;
        if (i3 < i6) {
            int[] iArr3 = this.f1849a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1850b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1851c - i3);
        }
        this.f1849a[i3] = i;
        this.f1850b[i3] = e;
        this.f1851c++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i = arraySet.f1851c;
        ensureCapacity(this.f1851c + i);
        if (this.f1851c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(arraySet.f1849a, 0, this.f1849a, 0, i);
            System.arraycopy(arraySet.f1850b, 0, this.f1850b, 0, i);
            this.f1851c = i;
        }
    }

    public void clear() {
        int i = this.f1851c;
        if (i != 0) {
            m1218b(this.f1849a, this.f1850b, i);
            this.f1849a = f1843e;
            this.f1850b = f1844f;
            this.f1851c = 0;
        }
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i) {
        int[] iArr = this.f1849a;
        if (iArr.length < i) {
            Object[] objArr = this.f1850b;
            m1217a(i);
            int i2 = this.f1851c;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f1849a, 0, i2);
                System.arraycopy(objArr, 0, this.f1850b, 0, this.f1851c);
            }
            m1218b(iArr, objArr, this.f1851c);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1851c) {
                try {
                    if (!set.contains(valueAt(i))) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f1849a;
        int i = this.f1851c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? m1221e() : m1220d(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1851c <= 0;
    }

    public Iterator<E> iterator() {
        return m1219c().mo3390m().iterator();
    }

    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i = arraySet.f1851c;
        int i2 = this.f1851c;
        for (int i3 = 0; i3 < i; i3++) {
            remove(arraySet.valueAt(i3));
        }
        if (i2 != this.f1851c) {
            return true;
        }
        return false;
    }

    public E removeAt(int i) {
        E[] eArr = this.f1850b;
        E e = eArr[i];
        int i2 = this.f1851c;
        if (i2 <= 1) {
            m1218b(this.f1849a, eArr, i2);
            this.f1849a = f1843e;
            this.f1850b = f1844f;
            this.f1851c = 0;
        } else {
            int[] iArr = this.f1849a;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i4 = i2 - 1;
                this.f1851c = i4;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr, i5, iArr, i, i4 - i);
                    Object[] objArr = this.f1850b;
                    System.arraycopy(objArr, i5, objArr, i, this.f1851c - i);
                }
                this.f1850b[this.f1851c] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                m1217a(i3);
                this.f1851c--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f1849a, 0, i);
                    System.arraycopy(eArr, 0, this.f1850b, 0, i);
                }
                int i6 = this.f1851c;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr, i7, this.f1849a, i, i6 - i);
                    System.arraycopy(eArr, i7, this.f1850b, i, this.f1851c - i);
                }
            }
        }
        return e;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1851c - 1; i >= 0; i--) {
            if (!collection.contains(this.f1850b[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f1851c;
    }

    @NonNull
    public Object[] toArray() {
        int i = this.f1851c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f1850b, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1851c * 14);
        sb.append('{');
        for (int i = 0; i < this.f1851c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Nullable
    public E valueAt(int i) {
        return this.f1850b[i];
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.f1849a = f1843e;
            this.f1850b = f1844f;
        } else {
            m1217a(i);
        }
        this.f1851c = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f1851c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1851c);
        }
        System.arraycopy(this.f1850b, 0, tArr, 0, this.f1851c);
        int length = tArr.length;
        int i = this.f1851c;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.f1851c + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }
}
