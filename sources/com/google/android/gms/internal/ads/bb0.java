package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
class bb0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f7899a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<gb0> f7900b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f7901c;

    /* renamed from: d */
    private boolean f7902d;

    /* renamed from: e */
    private volatile ib0 f7903e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<K, V> f7904f;

    /* renamed from: g */
    private volatile cb0 f7905g;

    private bb0(int i) {
        this.f7899a = i;
        this.f7900b = Collections.emptyList();
        this.f7901c = Collections.emptyMap();
        this.f7904f = Collections.emptyMap();
    }

    /* renamed from: b */
    private final int m5838b(K k) {
        int size = this.f7900b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f7900b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f7900b.get(i2).getKey());
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
    /* renamed from: k */
    public final void m5842k() {
        if (this.f7902d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: l */
    private final SortedMap<K, V> m5843l() {
        m5842k();
        if (this.f7901c.isEmpty() && !(this.f7901c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7901c = treeMap;
            this.f7904f = treeMap.descendingMap();
        }
        return (SortedMap) this.f7901c;
    }

    /* renamed from: o */
    static <FieldDescriptorType extends zzejz<FieldDescriptorType>> bb0<FieldDescriptorType, Object> m5846o(int i) {
        return new ab0(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public final V m5847q(int i) {
        m5842k();
        V value = this.f7900b.remove(i).getValue();
        if (!this.f7901c.isEmpty()) {
            Iterator it = m5843l().entrySet().iterator();
            this.f7900b.add(new gb0(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* renamed from: a */
    public final boolean mo13656a() {
        return this.f7902d;
    }

    public void clear() {
        m5842k();
        if (!this.f7900b.isEmpty()) {
            this.f7900b.clear();
        }
        if (!this.f7901c.isEmpty()) {
            this.f7901c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m5838b(comparable) >= 0 || this.f7901c.containsKey(comparable);
    }

    /* renamed from: d */
    public final V put(K k, V v) {
        m5842k();
        int b = m5838b(k);
        if (b >= 0) {
            return this.f7900b.get(b).setValue(v);
        }
        m5842k();
        if (this.f7900b.isEmpty() && !(this.f7900b instanceof ArrayList)) {
            this.f7900b = new ArrayList(this.f7899a);
        }
        int i = -(b + 1);
        if (i >= this.f7899a) {
            return m5843l().put(k, v);
        }
        int size = this.f7900b.size();
        int i2 = this.f7899a;
        if (size == i2) {
            gb0 remove = this.f7900b.remove(i2 - 1);
            m5843l().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f7900b.add(i, new gb0(this, k, v));
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f7903e == null) {
            this.f7903e = new ib0(this, (ab0) null);
        }
        return this.f7903e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bb0)) {
            return super.equals(obj);
        }
        bb0 bb0 = (bb0) obj;
        int size = size();
        if (size != bb0.size()) {
            return false;
        }
        int h = mo13663h();
        if (h != bb0.mo13663h()) {
            return entrySet().equals(bb0.entrySet());
        }
        for (int i = 0; i < h; i++) {
            if (!mo13667p(i).equals(bb0.mo13667p(i))) {
                return false;
            }
        }
        if (h != size) {
            return this.f7901c.equals(bb0.f7901c);
        }
        return true;
    }

    /* renamed from: g */
    public void mo13596g() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f7902d) {
            if (this.f7901c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f7901c);
            }
            this.f7901c = map;
            if (this.f7904f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f7904f);
            }
            this.f7904f = map2;
            this.f7902d = true;
        }
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b = m5838b(comparable);
        if (b >= 0) {
            return this.f7900b.get(b).getValue();
        }
        return this.f7901c.get(comparable);
    }

    /* renamed from: h */
    public final int mo13663h() {
        return this.f7900b.size();
    }

    public int hashCode() {
        int h = mo13663h();
        int i = 0;
        for (int i2 = 0; i2 < h; i2++) {
            i += this.f7900b.get(i2).hashCode();
        }
        return this.f7901c.size() > 0 ? i + this.f7901c.hashCode() : i;
    }

    /* renamed from: i */
    public final Iterable<Map.Entry<K, V>> mo13665i() {
        if (this.f7901c.isEmpty()) {
            return fb0.m6062a();
        }
        return this.f7901c.entrySet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final Set<Map.Entry<K, V>> mo13666j() {
        if (this.f7905g == null) {
            this.f7905g = new cb0(this, (ab0) null);
        }
        return this.f7905g;
    }

    /* renamed from: p */
    public final Map.Entry<K, V> mo13667p(int i) {
        return this.f7900b.get(i);
    }

    public V remove(Object obj) {
        m5842k();
        Comparable comparable = (Comparable) obj;
        int b = m5838b(comparable);
        if (b >= 0) {
            return m5847q(b);
        }
        if (this.f7901c.isEmpty()) {
            return null;
        }
        return this.f7901c.remove(comparable);
    }

    public int size() {
        return this.f7900b.size() + this.f7901c.size();
    }

    /* synthetic */ bb0(int i, ab0 ab0) {
        this(i);
    }
}
