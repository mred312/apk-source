package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class o20<E> extends zzdwt<E> {

    /* renamed from: c */
    private final transient E f10246c;

    /* renamed from: d */
    private transient int f10247d;

    o20(E e) {
        this.f10246c = zzdvv.checkNotNull(e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo14074a(Object[] objArr, int i) {
        objArr[i] = this.f10246c;
        return i + 1;
    }

    public final boolean contains(Object obj) {
        return this.f10246c.equals(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo14411g() {
        return this.f10247d != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzdwm<E> mo14234h() {
        return zzdwm.zzad(this.f10246c);
    }

    public final int hashCode() {
        int i = this.f10247d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f10246c.hashCode();
        this.f10247d = hashCode;
        return hashCode;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f10246c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final zzdxh<E> zzayp() {
        return new g20(this.f10246c);
    }

    o20(E e, int i) {
        this.f10246c = e;
        this.f10247d = i;
    }
}
