package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class m20<E> extends zzdwt<E> {

    /* renamed from: h */
    static final m20<Object> f9902h = new m20(new Object[0], 0, (Object[]) null, 0, 0);

    /* renamed from: c */
    private final transient Object[] f9903c;

    /* renamed from: d */
    private final transient Object[] f9904d;

    /* renamed from: e */
    private final transient int f9905e;

    /* renamed from: f */
    private final transient int f9906f;

    /* renamed from: g */
    private final transient int f9907g;

    m20(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f9903c = objArr;
        this.f9904d = objArr2;
        this.f9905e = i2;
        this.f9906f = i;
        this.f9907g = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo14074a(Object[] objArr, int i) {
        System.arraycopy(this.f9903c, 0, objArr, i, this.f9907g);
        return i + this.f9907g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo13933b() {
        return this.f9903c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo13934c() {
        return 0;
    }

    public final boolean contains(@NullableDecl Object obj) {
        int i;
        Object[] objArr = this.f9904d;
        if (obj == null || objArr == null) {
            return false;
        }
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int a = c20.m5878a(i);
        while (true) {
            int i2 = a & this.f9905e;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo13935d() {
        return this.f9907g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo14411g() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzdwm<E> mo14234h() {
        return zzdwm.m8543f(this.f9903c, this.f9907g);
    }

    public final int hashCode() {
        return this.f9906f;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f9907g;
    }

    public final zzdxh<E> zzayp() {
        return (zzdxh) zzayt().iterator();
    }
}
