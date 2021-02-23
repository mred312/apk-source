package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzfc<K, V> implements Serializable, Map<K, V> {

    /* renamed from: a */
    private transient zzfg<Map.Entry<K, V>> f17647a;

    /* renamed from: b */
    private transient zzfg<K> f17648b;

    /* renamed from: c */
    private transient zzey<V> f17649c;

    zzfc() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract zzfg<Map.Entry<K, V>> mo18790a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract zzfg<K> mo18791b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract zzey<V> mo18792c();

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzey) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzfg<Map.Entry<K, V>> zzfg = this.f17647a;
        if (zzfg != null) {
            return zzfg;
        }
        zzfg<Map.Entry<K, V>> a = mo18790a();
        this.f17647a = a;
        return a;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public int hashCode() {
        return zzfv.m10342a((zzfg) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzfg<K> zzfg = this.f17648b;
        if (zzfg != null) {
            return zzfg;
        }
        zzfg<K> b = mo18791b();
        this.f17648b = b;
        return b;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("size".length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Collection values() {
        zzey<V> zzey = this.f17649c;
        if (zzey != null) {
            return zzey;
        }
        zzey<V> c = mo18792c();
        this.f17649c = c;
        return c;
    }
}
