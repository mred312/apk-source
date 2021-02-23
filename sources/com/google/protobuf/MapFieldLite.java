package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b */
    private static final MapFieldLite f20632b;

    /* renamed from: a */
    private boolean f20633a = true;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f20632b = mapFieldLite;
        mapFieldLite.makeImmutable();
    }

    private MapFieldLite() {
    }

    /* renamed from: a */
    static <K, V> int m12853a(Map<K, V> map) {
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            i += m12854b(next.getValue()) ^ m12854b(next.getKey());
        }
        return i;
    }

    /* renamed from: b */
    private static int m12854b(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.hashCode((byte[]) obj);
        }
        if (!(obj instanceof Internal.EnumLite)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    private static void m12855c(Map<?, ?> map) {
        for (Object next : map.keySet()) {
            Internal.m12790a(next);
            Internal.m12790a(map.get(next));
        }
    }

    /* renamed from: d */
    private void m12856d() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: e */
    private static boolean m12857e(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return obj.equals(obj2);
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return f20632b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> boolean m12858f(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.size()
            int r2 = r5.size()
            r3 = 0
            if (r1 == r2) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.Object r2 = r1.getValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.Object r1 = r5.get(r1)
            boolean r1 = m12857e(r2, r1)
            if (r1 != 0) goto L_0x0018
            return r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MapFieldLite.m12858f(java.util.Map, java.util.Map):boolean");
    }

    public void clear() {
        m12856d();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && m12858f(this, (Map) obj);
    }

    public int hashCode() {
        return m12853a(this);
    }

    public boolean isMutable() {
        return this.f20633a;
    }

    public void makeImmutable() {
        this.f20633a = false;
    }

    public void mergeFrom(MapFieldLite<K, V> mapFieldLite) {
        m12856d();
        if (!mapFieldLite.isEmpty()) {
            putAll(mapFieldLite);
        }
    }

    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public V put(K k, V v) {
        m12856d();
        Internal.m12790a(k);
        Internal.m12790a(v);
        return super.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m12856d();
        m12855c(map);
        super.putAll(map);
    }

    public V remove(Object obj) {
        m12856d();
        return super.remove(obj);
    }

    private MapFieldLite(Map<K, V> map) {
        super(map);
    }

    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }
}
