package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    @Nullable

    /* renamed from: h */
    C0387b<K, V> f1841h;

    /* renamed from: androidx.collection.ArrayMap$a */
    class C0384a extends C0387b<K, V> {
        C0384a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3241a() {
            ArrayMap.this.clear();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object mo3242b(int i, int i2) {
            return ArrayMap.this.f1880b[(i << 1) + i2];
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Map<K, V> mo3243c() {
            return ArrayMap.this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public int mo3244d() {
            return ArrayMap.this.f1881c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public int mo3245e(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public int mo3246f(Object obj) {
            return ArrayMap.this.mo3345f(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo3247g(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo3248h(int i) {
            ArrayMap.this.removeAt(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public V mo3249i(int i, V v) {
            return ArrayMap.this.setValueAt(i, v);
        }
    }

    public ArrayMap() {
    }

    /* renamed from: g */
    private C0387b<K, V> m1207g() {
        if (this.f1841h == null) {
            this.f1841h = new C0384a();
        }
        return this.f1841h;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return C0387b.m1248j(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m1207g().mo3389l();
    }

    public Set<K> keySet() {
        return m1207g().mo3390m();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.f1881c + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return C0387b.m1250o(this, collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return C0387b.m1251p(this, collection);
    }

    public Collection<V> values() {
        return m1207g().mo3391n();
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
