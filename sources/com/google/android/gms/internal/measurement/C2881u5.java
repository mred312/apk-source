package com.google.android.gms.internal.measurement;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.u5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2881u5 implements Comparable<C2881u5>, Map.Entry<K, V> {

    /* renamed from: a */
    private final K f17483a;

    /* renamed from: b */
    private V f17484b;

    /* renamed from: c */
    private final /* synthetic */ C2841p5 f17485c;

    C2881u5(C2841p5 p5Var, Map.Entry<K, V> entry) {
        this(p5Var, (Comparable) entry.getKey(), entry.getValue());
    }

    /* renamed from: a */
    private static boolean m9839a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((C2881u5) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m9839a(this.f17483a, entry.getKey()) && m9839a(this.f17484b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f17483a;
    }

    public final V getValue() {
        return this.f17484b;
    }

    public final int hashCode() {
        K k = this.f17483a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f17484b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.f17485c.m9711p();
        V v2 = this.f17484b;
        this.f17484b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17483a);
        String valueOf2 = String.valueOf(this.f17484b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    C2881u5(C2841p5 p5Var, K k, V v) {
        this.f17485c = p5Var;
        this.f17483a = k;
        this.f17484b = v;
    }
}
