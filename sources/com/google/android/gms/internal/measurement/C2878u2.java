package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.u2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2878u2<E> extends zzfg<E> {

    /* renamed from: c */
    private final transient E f17480c;

    /* renamed from: d */
    private transient int f17481d;

    C2878u2(E e) {
        this.f17480c = zzeb.zza(e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18762a(Object[] objArr, int i) {
        objArr[i] = this.f17480c;
        return i + 1;
    }

    public final boolean contains(Object obj) {
        return this.f17480c.equals(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo18848g() {
        return this.f17481d != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzfb<E> mo18776h() {
        return zzfb.zza(this.f17480c);
    }

    public final int hashCode() {
        int i = this.f17481d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f17480c.hashCode();
        this.f17481d = hashCode;
        return hashCode;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f17480c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final zzfx<E> zza() {
        return new C2814m2(this.f17480c);
    }

    C2878u2(E e, int i) {
        this.f17480c = e;
        this.f17481d = i;
    }
}
