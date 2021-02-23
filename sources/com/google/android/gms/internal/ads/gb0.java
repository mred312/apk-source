package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class gb0 implements Comparable<gb0>, Map.Entry<K, V> {

    /* renamed from: a */
    private final K f8737a;

    /* renamed from: b */
    private V f8738b;

    /* renamed from: c */
    private final /* synthetic */ bb0 f8739c;

    gb0(bb0 bb0, Map.Entry<K, V> entry) {
        this(bb0, (Comparable) entry.getKey(), entry.getValue());
    }

    /* renamed from: a */
    private static boolean m6082a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((gb0) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m6082a(this.f8737a, entry.getKey()) && m6082a(this.f8738b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f8737a;
    }

    public final V getValue() {
        return this.f8738b;
    }

    public final int hashCode() {
        K k = this.f8737a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f8738b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.f8739c.m5842k();
        V v2 = this.f8738b;
        this.f8738b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f8737a);
        String valueOf2 = String.valueOf(this.f8738b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    gb0(bb0 bb0, K k, V v) {
        this.f8739c = bb0;
        this.f8737a = k;
        this.f8738b = v;
    }
}
