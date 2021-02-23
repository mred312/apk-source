package androidx.collection;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: androidx.collection.b */
/* compiled from: MapCollections */
abstract class C0387b<K, V> {
    @Nullable

    /* renamed from: a */
    C0387b<K, V>.b f1890a;
    @Nullable

    /* renamed from: b */
    C0387b<K, V>.c f1891b;
    @Nullable

    /* renamed from: c */
    C0387b<K, V>.e f1892c;

    /* renamed from: androidx.collection.b$a */
    /* compiled from: MapCollections */
    final class C0388a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f1893a;

        /* renamed from: b */
        int f1894b;

        /* renamed from: c */
        int f1895c;

        /* renamed from: d */
        boolean f1896d = false;

        C0388a(int i) {
            this.f1893a = i;
            this.f1894b = C0387b.this.mo3244d();
        }

        public boolean hasNext() {
            return this.f1895c < this.f1894b;
        }

        public T next() {
            if (hasNext()) {
                T b = C0387b.this.mo3242b(this.f1895c, this.f1893a);
                this.f1895c++;
                this.f1896d = true;
                return b;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1896d) {
                int i = this.f1895c - 1;
                this.f1895c = i;
                this.f1894b--;
                this.f1896d = false;
                C0387b.this.mo3248h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.collection.b$b */
    /* compiled from: MapCollections */
    final class C0389b implements Set<Map.Entry<K, V>> {
        C0389b() {
        }

        /* renamed from: a */
        public boolean mo3397a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            mo3397a((Map.Entry) obj);
            throw null;
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d = C0387b.this.mo3244d();
            for (Map.Entry entry : collection) {
                C0387b.this.mo3247g(entry.getKey(), entry.getValue());
            }
            return d != C0387b.this.mo3244d();
        }

        public void clear() {
            C0387b.this.mo3241a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = C0387b.this.mo3245e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return C0386a.m1244c(C0387b.this.mo3242b(e, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C0387b.m1249k(this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int d = C0387b.this.mo3244d() - 1; d >= 0; d--) {
                Object b = C0387b.this.mo3242b(d, 0);
                Object b2 = C0387b.this.mo3242b(d, 1);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                if (b2 == null) {
                    i2 = 0;
                } else {
                    i2 = b2.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public boolean isEmpty() {
            return C0387b.this.mo3244d() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0391d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return C0387b.this.mo3244d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: androidx.collection.b$c */
    /* compiled from: MapCollections */
    final class C0390c implements Set<K> {
        C0390c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0387b.this.mo3241a();
        }

        public boolean contains(Object obj) {
            return C0387b.this.mo3245e(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0387b.m1248j(C0387b.this.mo3243c(), collection);
        }

        public boolean equals(Object obj) {
            return C0387b.m1249k(this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int d = C0387b.this.mo3244d() - 1; d >= 0; d--) {
                Object b = C0387b.this.mo3242b(d, 0);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        public boolean isEmpty() {
            return C0387b.this.mo3244d() == 0;
        }

        public Iterator<K> iterator() {
            return new C0388a(0);
        }

        public boolean remove(Object obj) {
            int e = C0387b.this.mo3245e(obj);
            if (e < 0) {
                return false;
            }
            C0387b.this.mo3248h(e);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0387b.m1250o(C0387b.this.mo3243c(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0387b.m1251p(C0387b.this.mo3243c(), collection);
        }

        public int size() {
            return C0387b.this.mo3244d();
        }

        public Object[] toArray() {
            return C0387b.this.mo3392q(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0387b.this.mo3393r(tArr, 0);
        }
    }

    /* renamed from: androidx.collection.b$d */
    /* compiled from: MapCollections */
    final class C0391d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f1900a;

        /* renamed from: b */
        int f1901b;

        /* renamed from: c */
        boolean f1902c = false;

        C0391d() {
            this.f1900a = C0387b.this.mo3244d() - 1;
            this.f1901b = -1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> mo3428a() {
            if (hasNext()) {
                this.f1901b++;
                this.f1902c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f1902c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!C0386a.m1244c(entry.getKey(), C0387b.this.mo3242b(this.f1901b, 0)) || !C0386a.m1244c(entry.getValue(), C0387b.this.mo3242b(this.f1901b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f1902c) {
                return C0387b.this.mo3242b(this.f1901b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1902c) {
                return C0387b.this.mo3242b(this.f1901b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1901b < this.f1900a;
        }

        public int hashCode() {
            int i;
            if (this.f1902c) {
                int i2 = 0;
                Object b = C0387b.this.mo3242b(this.f1901b, 0);
                Object b2 = C0387b.this.mo3242b(this.f1901b, 1);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                if (b2 != null) {
                    i2 = b2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* bridge */ /* synthetic */ Object next() {
            mo3428a();
            return this;
        }

        public void remove() {
            if (this.f1902c) {
                C0387b.this.mo3248h(this.f1901b);
                this.f1901b--;
                this.f1900a--;
                this.f1902c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f1902c) {
                return C0387b.this.mo3249i(this.f1901b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: androidx.collection.b$e */
    /* compiled from: MapCollections */
    final class C0392e implements Collection<V> {
        C0392e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0387b.this.mo3241a();
        }

        public boolean contains(Object obj) {
            return C0387b.this.mo3246f(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C0387b.this.mo3244d() == 0;
        }

        public Iterator<V> iterator() {
            return new C0388a(1);
        }

        public boolean remove(Object obj) {
            int f = C0387b.this.mo3246f(obj);
            if (f < 0) {
                return false;
            }
            C0387b.this.mo3248h(f);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int d = C0387b.this.mo3244d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(C0387b.this.mo3242b(i, 1))) {
                    C0387b.this.mo3248h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int d = C0387b.this.mo3244d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(C0387b.this.mo3242b(i, 1))) {
                    C0387b.this.mo3248h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return C0387b.this.mo3244d();
        }

        public Object[] toArray() {
            return C0387b.this.mo3392q(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0387b.this.mo3393r(tArr, 1);
        }
    }

    C0387b() {
    }

    /* renamed from: j */
    public static <K, V> boolean m1248j(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static <T> boolean m1249k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: o */
    public static <K, V> boolean m1250o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: p */
    public static <K, V> boolean m1251p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3241a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Object mo3242b(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract Map<K, V> mo3243c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract int mo3244d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract int mo3245e(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract int mo3246f(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract void mo3247g(K k, V v);

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract void mo3248h(int i);

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract V mo3249i(int i, V v);

    /* renamed from: l */
    public Set<Map.Entry<K, V>> mo3389l() {
        if (this.f1890a == null) {
            this.f1890a = new C0389b();
        }
        return this.f1890a;
    }

    /* renamed from: m */
    public Set<K> mo3390m() {
        if (this.f1891b == null) {
            this.f1891b = new C0390c();
        }
        return this.f1891b;
    }

    /* renamed from: n */
    public Collection<V> mo3391n() {
        if (this.f1892c == null) {
            this.f1892c = new C0392e();
        }
        return this.f1892c;
    }

    /* renamed from: q */
    public Object[] mo3392q(int i) {
        int d = mo3244d();
        Object[] objArr = new Object[d];
        for (int i2 = 0; i2 < d; i2++) {
            objArr[i2] = mo3242b(i2, i);
        }
        return objArr;
    }

    /* renamed from: r */
    public <T> T[] mo3393r(T[] tArr, int i) {
        int d = mo3244d();
        if (tArr.length < d) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d);
        }
        for (int i2 = 0; i2 < d; i2++) {
            tArr[i2] = mo3242b(i2, i);
        }
        if (tArr.length > d) {
            tArr[d] = null;
        }
        return tArr;
    }
}
