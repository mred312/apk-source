package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.protobuf.p0 */
/* compiled from: SmallSortedMap */
class C3728p0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f20834a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C3728p0<K, V>.e> f20835b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f20836c;

    /* renamed from: d */
    private boolean f20837d;

    /* renamed from: e */
    private volatile C3728p0<K, V>.g f20838e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<K, V> f20839f;

    /* renamed from: g */
    private volatile C3728p0<K, V>.c f20840g;

    /* renamed from: com.google.protobuf.p0$a */
    /* compiled from: SmallSortedMap */
    static class C3729a extends C3728p0<FieldDescriptorType, Object> {
        C3729a(int i) {
            super(i, (C3729a) null);
        }

        /* renamed from: p */
        public void mo23949p() {
            if (!mo23948o()) {
                for (int i = 0; i < mo23945k(); i++) {
                    Map.Entry j = mo23944j(i);
                    if (((FieldSet.FieldDescriptorLite) j.getKey()).isRepeated()) {
                        j.setValue(Collections.unmodifiableList((List) j.getValue()));
                    }
                }
                for (Map.Entry entry : mo23947m()) {
                    if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            C3728p0.super.mo23949p();
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return C3728p0.super.put((FieldSet.FieldDescriptorLite) obj, obj2);
        }
    }

    /* renamed from: com.google.protobuf.p0$c */
    /* compiled from: SmallSortedMap */
    private class C3731c extends C3728p0<K, V>.g {
        private C3731c() {
            super(C3728p0.this, (C3729a) null);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C3730b(C3728p0.this, (C3729a) null);
        }

        /* synthetic */ C3731c(C3728p0 p0Var, C3729a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.p0$d */
    /* compiled from: SmallSortedMap */
    private static class C3732d {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final Iterator<Object> f20845a = new C3733a();

        /* renamed from: b */
        private static final Iterable<Object> f20846b = new C3734b();

        /* renamed from: com.google.protobuf.p0$d$a */
        /* compiled from: SmallSortedMap */
        static class C3733a implements Iterator<Object> {
            C3733a() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.protobuf.p0$d$b */
        /* compiled from: SmallSortedMap */
        static class C3734b implements Iterable<Object> {
            C3734b() {
            }

            public Iterator<Object> iterator() {
                return C3732d.f20845a;
            }
        }

        /* renamed from: b */
        static <T> Iterable<T> m13606b() {
            return f20846b;
        }
    }

    /* renamed from: com.google.protobuf.p0$e */
    /* compiled from: SmallSortedMap */
    private class C3735e implements Map.Entry<K, V>, Comparable<C3728p0<K, V>.e> {

        /* renamed from: a */
        private final K f20847a;

        /* renamed from: b */
        private V f20848b;

        C3735e(C3728p0 p0Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        /* renamed from: b */
        private boolean m13607b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(C3728p0<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        /* renamed from: c */
        public K getKey() {
            return this.f20847a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!m13607b(this.f20847a, entry.getKey()) || !m13607b(this.f20848b, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.f20848b;
        }

        public int hashCode() {
            K k = this.f20847a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f20848b;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            C3728p0.this.m13589g();
            V v2 = this.f20848b;
            this.f20848b = v;
            return v2;
        }

        public String toString() {
            return this.f20847a + "=" + this.f20848b;
        }

        C3735e(K k, V v) {
            this.f20847a = k;
            this.f20848b = v;
        }
    }

    /* renamed from: com.google.protobuf.p0$g */
    /* compiled from: SmallSortedMap */
    private class C3737g extends AbstractSet<Map.Entry<K, V>> {
        private C3737g() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            C3728p0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            C3728p0.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = C3728p0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C3736f(C3728p0.this, (C3729a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            C3728p0.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return C3728p0.this.size();
        }

        /* synthetic */ C3737g(C3728p0 p0Var, C3729a aVar) {
            this();
        }
    }

    /* synthetic */ C3728p0(int i, C3729a aVar) {
        this(i);
    }

    /* renamed from: f */
    private int m13588f(K k) {
        int size = this.f20835b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f20835b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f20835b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m13589g() {
        if (this.f20837d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: i */
    private void m13590i() {
        m13589g();
        if (this.f20835b.isEmpty() && !(this.f20835b instanceof ArrayList)) {
            this.f20835b = new ArrayList(this.f20834a);
        }
    }

    /* renamed from: n */
    private SortedMap<K, V> m13591n() {
        m13589g();
        if (this.f20836c.isEmpty() && !(this.f20836c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f20836c = treeMap;
            this.f20839f = treeMap.descendingMap();
        }
        return (SortedMap) this.f20836c;
    }

    /* renamed from: q */
    static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> C3728p0<FieldDescriptorType, Object> m13592q(int i) {
        return new C3729a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public V m13593s(int i) {
        m13589g();
        V value = this.f20835b.remove(i).getValue();
        if (!this.f20836c.isEmpty()) {
            Iterator it = m13591n().entrySet().iterator();
            this.f20835b.add(new C3735e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        m13589g();
        if (!this.f20835b.isEmpty()) {
            this.f20835b.clear();
        }
        if (!this.f20836c.isEmpty()) {
            this.f20836c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m13588f(comparable) >= 0 || this.f20836c.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f20838e == null) {
            this.f20838e = new C3737g(this, (C3729a) null);
        }
        return this.f20838e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3728p0)) {
            return super.equals(obj);
        }
        C3728p0 p0Var = (C3728p0) obj;
        int size = size();
        if (size != p0Var.size()) {
            return false;
        }
        int k = mo23945k();
        if (k != p0Var.mo23945k()) {
            return entrySet().equals(p0Var.entrySet());
        }
        for (int i = 0; i < k; i++) {
            if (!mo23944j(i).equals(p0Var.mo23944j(i))) {
                return false;
            }
        }
        if (k != size) {
            return this.f20836c.equals(p0Var.f20836c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f = m13588f(comparable);
        if (f >= 0) {
            return this.f20835b.get(f).getValue();
        }
        return this.f20836c.get(comparable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Set<Map.Entry<K, V>> mo23942h() {
        if (this.f20840g == null) {
            this.f20840g = new C3731c(this, (C3729a) null);
        }
        return this.f20840g;
    }

    public int hashCode() {
        int k = mo23945k();
        int i = 0;
        for (int i2 = 0; i2 < k; i2++) {
            i += this.f20835b.get(i2).hashCode();
        }
        return mo23946l() > 0 ? i + this.f20836c.hashCode() : i;
    }

    /* renamed from: j */
    public Map.Entry<K, V> mo23944j(int i) {
        return this.f20835b.get(i);
    }

    /* renamed from: k */
    public int mo23945k() {
        return this.f20835b.size();
    }

    /* renamed from: l */
    public int mo23946l() {
        return this.f20836c.size();
    }

    /* renamed from: m */
    public Iterable<Map.Entry<K, V>> mo23947m() {
        if (this.f20836c.isEmpty()) {
            return C3732d.m13606b();
        }
        return this.f20836c.entrySet();
    }

    /* renamed from: o */
    public boolean mo23948o() {
        return this.f20837d;
    }

    /* renamed from: p */
    public void mo23949p() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f20837d) {
            if (this.f20836c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f20836c);
            }
            this.f20836c = map;
            if (this.f20839f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f20839f);
            }
            this.f20839f = map2;
            this.f20837d = true;
        }
    }

    /* renamed from: r */
    public V put(K k, V v) {
        m13589g();
        int f = m13588f(k);
        if (f >= 0) {
            return this.f20835b.get(f).setValue(v);
        }
        m13590i();
        int i = -(f + 1);
        if (i >= this.f20834a) {
            return m13591n().put(k, v);
        }
        int size = this.f20835b.size();
        int i2 = this.f20834a;
        if (size == i2) {
            C3735e remove = this.f20835b.remove(i2 - 1);
            m13591n().put(remove.getKey(), remove.getValue());
        }
        this.f20835b.add(i, new C3735e(k, v));
        return null;
    }

    public V remove(Object obj) {
        m13589g();
        Comparable comparable = (Comparable) obj;
        int f = m13588f(comparable);
        if (f >= 0) {
            return m13593s(f);
        }
        if (this.f20836c.isEmpty()) {
            return null;
        }
        return this.f20836c.remove(comparable);
    }

    public int size() {
        return this.f20835b.size() + this.f20836c.size();
    }

    /* renamed from: com.google.protobuf.p0$b */
    /* compiled from: SmallSortedMap */
    private class C3730b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        private int f20841a;

        /* renamed from: b */
        private Iterator<Map.Entry<K, V>> f20842b;

        private C3730b() {
            this.f20841a = C3728p0.this.f20835b.size();
        }

        /* renamed from: a */
        private Iterator<Map.Entry<K, V>> m13603a() {
            if (this.f20842b == null) {
                this.f20842b = C3728p0.this.f20839f.entrySet().iterator();
            }
            return this.f20842b;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (m13603a().hasNext()) {
                return (Map.Entry) m13603a().next();
            }
            List b = C3728p0.this.f20835b;
            int i = this.f20841a - 1;
            this.f20841a = i;
            return (Map.Entry) b.get(i);
        }

        public boolean hasNext() {
            int i = this.f20841a;
            return (i > 0 && i <= C3728p0.this.f20835b.size()) || m13603a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ C3730b(C3728p0 p0Var, C3729a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.p0$f */
    /* compiled from: SmallSortedMap */
    private class C3736f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        private int f20850a;

        /* renamed from: b */
        private boolean f20851b;

        /* renamed from: c */
        private Iterator<Map.Entry<K, V>> f20852c;

        private C3736f() {
            this.f20850a = -1;
        }

        /* renamed from: a */
        private Iterator<Map.Entry<K, V>> m13610a() {
            if (this.f20852c == null) {
                this.f20852c = C3728p0.this.f20836c.entrySet().iterator();
            }
            return this.f20852c;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f20851b = true;
            int i = this.f20850a + 1;
            this.f20850a = i;
            if (i < C3728p0.this.f20835b.size()) {
                return (Map.Entry) C3728p0.this.f20835b.get(this.f20850a);
            }
            return (Map.Entry) m13610a().next();
        }

        public boolean hasNext() {
            if (this.f20850a + 1 < C3728p0.this.f20835b.size()) {
                return true;
            }
            if (C3728p0.this.f20836c.isEmpty() || !m13610a().hasNext()) {
                return false;
            }
            return true;
        }

        public void remove() {
            if (this.f20851b) {
                this.f20851b = false;
                C3728p0.this.m13589g();
                if (this.f20850a < C3728p0.this.f20835b.size()) {
                    C3728p0 p0Var = C3728p0.this;
                    int i = this.f20850a;
                    this.f20850a = i - 1;
                    Object unused = p0Var.m13593s(i);
                    return;
                }
                m13610a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ C3736f(C3728p0 p0Var, C3729a aVar) {
            this();
        }
    }

    private C3728p0(int i) {
        this.f20834a = i;
        this.f20835b = Collections.emptyList();
        this.f20836c = Collections.emptyMap();
        this.f20839f = Collections.emptyMap();
    }
}
