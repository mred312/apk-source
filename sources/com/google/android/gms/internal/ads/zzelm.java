package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzelm<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b */
    private static final zzelm f16278b;

    /* renamed from: a */
    private boolean f16279a = true;

    static {
        zzelm zzelm = new zzelm();
        f16278b = zzelm;
        zzelm.f16279a = false;
    }

    private zzelm() {
    }

    /* renamed from: a */
    private static int m8841a(Object obj) {
        if (obj instanceof byte[]) {
            return zzekk.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzekj)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    private final void m8842b() {
        if (!this.f16279a) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> zzelm<K, V> zzbja() {
        return f16278b;
    }

    public final void clear() {
        m8842b();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x005d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x0059
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
        L_0x0014:
            r7 = 0
            goto L_0x005a
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0056
        L_0x0052:
            boolean r3 = r4.equals(r3)
        L_0x0056:
            if (r3 != 0) goto L_0x001e
            goto L_0x0014
        L_0x0059:
            r7 = 1
        L_0x005a:
            if (r7 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelm.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += m8841a(entry.getValue()) ^ m8841a(entry.getKey());
        }
        return i;
    }

    public final boolean isMutable() {
        return this.f16279a;
    }

    public final V put(K k, V v) {
        m8842b();
        zzekk.m8823a(k);
        zzekk.m8823a(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        m8842b();
        for (Object next : map.keySet()) {
            zzekk.m8823a(next);
            zzekk.m8823a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        m8842b();
        return super.remove(obj);
    }

    public final void zza(zzelm<K, V> zzelm) {
        m8842b();
        if (!zzelm.isEmpty()) {
            putAll(zzelm);
        }
    }

    public final void zzbfl() {
        this.f16279a = false;
    }

    public final zzelm<K, V> zzbjb() {
        return isEmpty() ? new zzelm<>() : new zzelm<>(this);
    }

    private zzelm(Map<K, V> map) {
        super(map);
    }
}
