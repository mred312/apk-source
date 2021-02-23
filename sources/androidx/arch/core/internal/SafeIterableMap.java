package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    C0348c<K, V> f1744a;

    /* renamed from: b */
    private C0348c<K, V> f1745b;

    /* renamed from: c */
    private WeakHashMap<C0351f<K, V>, Boolean> f1746c = new WeakHashMap<>();

    /* renamed from: d */
    private int f1747d = 0;

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$a */
    static class C0346a<K, V> extends C0350e<K, V> {
        C0346a(C0348c<K, V> cVar, C0348c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0348c<K, V> mo3118b(C0348c<K, V> cVar) {
            return cVar.f1751d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C0348c<K, V> mo3119c(C0348c<K, V> cVar) {
            return cVar.f1750c;
        }
    }

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$b */
    private static class C0347b<K, V> extends C0350e<K, V> {
        C0347b(C0348c<K, V> cVar, C0348c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0348c<K, V> mo3118b(C0348c<K, V> cVar) {
            return cVar.f1750c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C0348c<K, V> mo3119c(C0348c<K, V> cVar) {
            return cVar.f1751d;
        }
    }

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$c */
    static class C0348c<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: a */
        final K f1748a;
        @NonNull

        /* renamed from: b */
        final V f1749b;

        /* renamed from: c */
        C0348c<K, V> f1750c;

        /* renamed from: d */
        C0348c<K, V> f1751d;

        C0348c(@NonNull K k, @NonNull V v) {
            this.f1748a = k;
            this.f1749b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0348c)) {
                return false;
            }
            C0348c cVar = (C0348c) obj;
            if (!this.f1748a.equals(cVar.f1748a) || !this.f1749b.equals(cVar.f1749b)) {
                return false;
            }
            return true;
        }

        @NonNull
        public K getKey() {
            return this.f1748a;
        }

        @NonNull
        public V getValue() {
            return this.f1749b;
        }

        public int hashCode() {
            return this.f1748a.hashCode() ^ this.f1749b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f1748a + "=" + this.f1749b;
        }
    }

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$d */
    private class C0349d implements Iterator<Map.Entry<K, V>>, C0351f<K, V> {

        /* renamed from: a */
        private C0348c<K, V> f1752a;

        /* renamed from: b */
        private boolean f1753b = true;

        C0349d() {
        }

        /* renamed from: a */
        public void mo3126a(@NonNull C0348c<K, V> cVar) {
            C0348c<K, V> cVar2 = this.f1752a;
            if (cVar == cVar2) {
                C0348c<K, V> cVar3 = cVar2.f1751d;
                this.f1752a = cVar3;
                this.f1753b = cVar3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.f1753b) {
                this.f1753b = false;
                this.f1752a = SafeIterableMap.this.f1744a;
            } else {
                C0348c<K, V> cVar = this.f1752a;
                this.f1752a = cVar != null ? cVar.f1750c : null;
            }
            return this.f1752a;
        }

        public boolean hasNext() {
            if (!this.f1753b) {
                C0348c<K, V> cVar = this.f1752a;
                if (cVar == null || cVar.f1750c == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.f1744a != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$e */
    private static abstract class C0350e<K, V> implements Iterator<Map.Entry<K, V>>, C0351f<K, V> {

        /* renamed from: a */
        C0348c<K, V> f1755a;

        /* renamed from: b */
        C0348c<K, V> f1756b;

        C0350e(C0348c<K, V> cVar, C0348c<K, V> cVar2) {
            this.f1755a = cVar2;
            this.f1756b = cVar;
        }

        /* renamed from: e */
        private C0348c<K, V> m1182e() {
            C0348c<K, V> cVar = this.f1756b;
            C0348c<K, V> cVar2 = this.f1755a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo3119c(cVar);
        }

        /* renamed from: a */
        public void mo3126a(@NonNull C0348c<K, V> cVar) {
            if (this.f1755a == cVar && cVar == this.f1756b) {
                this.f1756b = null;
                this.f1755a = null;
            }
            C0348c<K, V> cVar2 = this.f1755a;
            if (cVar2 == cVar) {
                this.f1755a = mo3118b(cVar2);
            }
            if (this.f1756b == cVar) {
                this.f1756b = m1182e();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C0348c<K, V> mo3118b(C0348c<K, V> cVar);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C0348c<K, V> mo3119c(C0348c<K, V> cVar);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            C0348c<K, V> cVar = this.f1756b;
            this.f1756b = m1182e();
            return cVar;
        }

        public boolean hasNext() {
            return this.f1756b != null;
        }
    }

    /* renamed from: androidx.arch.core.internal.SafeIterableMap$f */
    interface C0351f<K, V> {
        /* renamed from: a */
        void mo3126a(@NonNull C0348c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0347b bVar = new C0347b(this.f1745b, this.f1744a);
        this.f1746c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public Map.Entry<K, V> eldest() {
        return this.f1744a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public C0348c<K, V> get(K k) {
        C0348c<K, V> cVar = this.f1744a;
        while (cVar != null && !cVar.f1748a.equals(k)) {
            cVar = cVar.f1750c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        C0346a aVar = new C0346a(this.f1744a, this.f1745b);
        this.f1746c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public SafeIterableMap<K, V>.d iteratorWithAdditions() {
        SafeIterableMap<K, V>.d dVar = new C0349d();
        this.f1746c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> newest() {
        return this.f1745b;
    }

    /* access modifiers changed from: protected */
    public C0348c<K, V> put(@NonNull K k, @NonNull V v) {
        C0348c<K, V> cVar = new C0348c<>(k, v);
        this.f1747d++;
        C0348c<K, V> cVar2 = this.f1745b;
        if (cVar2 == null) {
            this.f1744a = cVar;
            this.f1745b = cVar;
            return cVar;
        }
        cVar2.f1750c = cVar;
        cVar.f1751d = cVar2;
        this.f1745b = cVar;
        return cVar;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        C0348c cVar = get(k);
        if (cVar != null) {
            return cVar.f1749b;
        }
        put(k, v);
        return null;
    }

    public V remove(@NonNull K k) {
        C0348c cVar = get(k);
        if (cVar == null) {
            return null;
        }
        this.f1747d--;
        if (!this.f1746c.isEmpty()) {
            for (C0351f<K, V> a : this.f1746c.keySet()) {
                a.mo3126a(cVar);
            }
        }
        C0348c<K, V> cVar2 = cVar.f1751d;
        if (cVar2 != null) {
            cVar2.f1750c = cVar.f1750c;
        } else {
            this.f1744a = cVar.f1750c;
        }
        C0348c<K, V> cVar3 = cVar.f1750c;
        if (cVar3 != null) {
            cVar3.f1751d = cVar2;
        } else {
            this.f1745b = cVar2;
        }
        cVar.f1750c = null;
        cVar.f1751d = null;
        return cVar.f1749b;
    }

    public int size() {
        return this.f1747d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
