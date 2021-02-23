package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class i20<K, V> extends zzdwt<Map.Entry<K, V>> {

    /* renamed from: c */
    private final transient zzdwq<K, V> f9249c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final transient Object[] f9250d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final transient int f9251e;

    i20(zzdwq<K, V> zzdwq, Object[] objArr, int i, int i2) {
        this.f9249c = zzdwq;
        this.f9250d = objArr;
        this.f9251e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo14074a(Object[] objArr, int i) {
        return zzayt().mo14074a(objArr, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f9249c.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzdwm<Map.Entry<K, V>> mo14234h() {
        return new l20(this);
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f9251e;
    }

    public final zzdxh<Map.Entry<K, V>> zzayp() {
        return (zzdxh) zzayt().iterator();
    }
}
