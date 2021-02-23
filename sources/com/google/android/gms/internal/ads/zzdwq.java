package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzdwq<K, V> implements Serializable, Map<K, V> {

    /* renamed from: a */
    private transient zzdwt<Map.Entry<K, V>> f16033a;

    /* renamed from: b */
    private transient zzdwt<K> f16034b;

    /* renamed from: c */
    private transient zzdwl<V> f16035c;

    zzdwq() {
    }

    public static <K, V> zzdwq<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a20.m5746a(k, v);
        a20.m5746a(k2, v2);
        a20.m5746a(k3, v3);
        a20.m5746a(k4, v4);
        return j20.m6342e(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> zzdwq<K, V> zzc(K k, V v) {
        a20.m5746a(k, v);
        return j20.m6342e(1, new Object[]{k, v});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract zzdwt<Map.Entry<K, V>> mo14285a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract zzdwt<K> mo14286b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract zzdwl<V> mo14287c();

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdwl) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzdwt<Map.Entry<K, V>> zzdwt = this.f16033a;
        if (zzdwt != null) {
            return zzdwt;
        }
        zzdwt<Map.Entry<K, V>> a = mo14285a();
        this.f16033a = a;
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
        return zzdxf.m8566b((zzdwt) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzdwt<K> zzdwt = this.f16034b;
        if (zzdwt != null) {
            return zzdwt;
        }
        zzdwt<K> b = mo14286b();
        this.f16034b = b;
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
        a20.m5747b(size, "size");
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

    public /* synthetic */ Collection values() {
        zzdwl<V> zzdwl = this.f16035c;
        if (zzdwl != null) {
            return zzdwl;
        }
        zzdwl<V> c = mo14287c();
        this.f16035c = c;
        return c;
    }
}
