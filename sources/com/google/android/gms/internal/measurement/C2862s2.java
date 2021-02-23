package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.s2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2862s2<E> extends zzfg<E> {

    /* renamed from: h */
    static final C2862s2<Object> f17456h = new C2862s2(new Object[0], 0, (Object[]) null, 0, 0);

    /* renamed from: c */
    private final transient Object[] f17457c;

    /* renamed from: d */
    private final transient Object[] f17458d;

    /* renamed from: e */
    private final transient int f17459e;

    /* renamed from: f */
    private final transient int f17460f;

    /* renamed from: g */
    private final transient int f17461g;

    C2862s2(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f17457c = objArr;
        this.f17458d = objArr2;
        this.f17459e = i2;
        this.f17460f = i;
        this.f17461g = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18762a(Object[] objArr, int i) {
        System.arraycopy(this.f17457c, 0, objArr, i, this.f17461g);
        return i + this.f17461g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo18702b() {
        return this.f17457c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo18703c() {
        return 0;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f17458d;
        if (obj == null || objArr == null) {
            return false;
        }
        int b = C2790j2.m9520b(obj);
        while (true) {
            int i = b & this.f17459e;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b = i + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo18704d() {
        return this.f17461g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo18848g() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzfb<E> mo18776h() {
        return zzfb.m10333g(this.f17457c, this.f17461g);
    }

    public final int hashCode() {
        return this.f17460f;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f17461g;
    }

    public final zzfx<E> zza() {
        return (zzfx) zze().iterator();
    }
}
