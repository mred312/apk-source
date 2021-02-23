package com.google.android.gms.internal.measurement;

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

/* renamed from: com.google.android.gms.internal.measurement.p5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
class C2841p5<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f17409a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C2881u5> f17410b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f17411c;

    /* renamed from: d */
    private boolean f17412d;

    /* renamed from: e */
    private volatile C2897w5 f17413e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<K, V> f17414f;

    /* renamed from: g */
    private volatile C2849q5 f17415g;

    private C2841p5(int i) {
        this.f17409a = i;
        this.f17410b = Collections.emptyList();
        this.f17411c = Collections.emptyMap();
        this.f17414f = Collections.emptyMap();
    }

    /* renamed from: a */
    private final int m9703a(K k) {
        int size = this.f17410b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f17410b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f17410b.get(i2).getKey());
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

    /* renamed from: b */
    static <FieldDescriptorType extends zzhr<FieldDescriptorType>> C2841p5<FieldDescriptorType, Object> m9704b(int i) {
        return new C2833o5(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final V m9708k(int i) {
        m9711p();
        V value = this.f17410b.remove(i).getValue();
        if (!this.f17411c.isEmpty()) {
            Iterator it = m9712q().entrySet().iterator();
            this.f17410b.add(new C2881u5(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public final void m9711p() {
        if (this.f17412d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: q */
    private final SortedMap<K, V> m9712q() {
        m9711p();
        if (this.f17411c.isEmpty() && !(this.f17411c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f17411c = treeMap;
            this.f17414f = treeMap.descendingMap();
        }
        return (SortedMap) this.f17411c;
    }

    public void clear() {
        m9711p();
        if (!this.f17410b.isEmpty()) {
            this.f17410b.clear();
        }
        if (!this.f17411c.isEmpty()) {
            this.f17411c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m9703a(comparable) >= 0 || this.f17411c.containsKey(comparable);
    }

    /* renamed from: d */
    public final V put(K k, V v) {
        m9711p();
        int a = m9703a(k);
        if (a >= 0) {
            return this.f17410b.get(a).setValue(v);
        }
        m9711p();
        if (this.f17410b.isEmpty() && !(this.f17410b instanceof ArrayList)) {
            this.f17410b = new ArrayList(this.f17409a);
        }
        int i = -(a + 1);
        if (i >= this.f17409a) {
            return m9712q().put(k, v);
        }
        int size = this.f17410b.size();
        int i2 = this.f17409a;
        if (size == i2) {
            C2881u5 remove = this.f17410b.remove(i2 - 1);
            m9712q().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f17410b.add(i, new C2881u5(this, k, v));
        return null;
    }

    /* renamed from: e */
    public void mo18786e() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f17412d) {
            if (this.f17411c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f17411c);
            }
            this.f17411c = map;
            if (this.f17414f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f17414f);
            }
            this.f17414f = map2;
            this.f17412d = true;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f17413e == null) {
            this.f17413e = new C2897w5(this, (C2833o5) null);
        }
        return this.f17413e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2841p5)) {
            return super.equals(obj);
        }
        C2841p5 p5Var = (C2841p5) obj;
        int size = size();
        if (size != p5Var.size()) {
            return false;
        }
        int j = mo18804j();
        if (j != p5Var.mo18804j()) {
            return entrySet().equals(p5Var.entrySet());
        }
        for (int i = 0; i < j; i++) {
            if (!mo18801h(i).equals(p5Var.mo18801h(i))) {
                return false;
            }
        }
        if (j != size) {
            return this.f17411c.equals(p5Var.f17411c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m9703a(comparable);
        if (a >= 0) {
            return this.f17410b.get(a).getValue();
        }
        return this.f17411c.get(comparable);
    }

    /* renamed from: h */
    public final Map.Entry<K, V> mo18801h(int i) {
        return this.f17410b.get(i);
    }

    public int hashCode() {
        int j = mo18804j();
        int i = 0;
        for (int i2 = 0; i2 < j; i2++) {
            i += this.f17410b.get(i2).hashCode();
        }
        return this.f17411c.size() > 0 ? i + this.f17411c.hashCode() : i;
    }

    /* renamed from: i */
    public final boolean mo18803i() {
        return this.f17412d;
    }

    /* renamed from: j */
    public final int mo18804j() {
        return this.f17410b.size();
    }

    /* renamed from: m */
    public final Iterable<Map.Entry<K, V>> mo18805m() {
        if (this.f17411c.isEmpty()) {
            return C2873t5.m9791a();
        }
        return this.f17411c.entrySet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final Set<Map.Entry<K, V>> mo18806o() {
        if (this.f17415g == null) {
            this.f17415g = new C2849q5(this, (C2833o5) null);
        }
        return this.f17415g;
    }

    public V remove(Object obj) {
        m9711p();
        Comparable comparable = (Comparable) obj;
        int a = m9703a(comparable);
        if (a >= 0) {
            return m9708k(a);
        }
        if (this.f17411c.isEmpty()) {
            return null;
        }
        return this.f17411c.remove(comparable);
    }

    public int size() {
        return this.f17410b.size() + this.f17411c.size();
    }

    /* synthetic */ C2841p5(int i, C2833o5 o5Var) {
        this(i);
    }
}
