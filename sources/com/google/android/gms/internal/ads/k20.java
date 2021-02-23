package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class k20<K> extends zzdwt<K> {

    /* renamed from: c */
    private final transient zzdwq<K, ?> f9560c;

    /* renamed from: d */
    private final transient zzdwm<K> f9561d;

    k20(zzdwq<K, ?> zzdwq, zzdwm<K> zzdwm) {
        this.f9560c = zzdwq;
        this.f9561d = zzdwm;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo14074a(Object[] objArr, int i) {
        return zzayt().mo14074a(objArr, i);
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.f9560c.get(obj) != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f9560c.size();
    }

    public final zzdxh<K> zzayp() {
        return (zzdxh) zzayt().iterator();
    }

    public final zzdwm<K> zzayt() {
        return this.f9561d;
    }
}
