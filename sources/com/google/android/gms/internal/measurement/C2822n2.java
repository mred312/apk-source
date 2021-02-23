package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.n2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2822n2<E> extends zzfb<E> {

    /* renamed from: e */
    static final zzfb<Object> f17388e = new C2822n2(new Object[0], 0);

    /* renamed from: c */
    private final transient Object[] f17389c;

    /* renamed from: d */
    private final transient int f17390d;

    C2822n2(Object[] objArr, int i) {
        this.f17389c = objArr;
        this.f17390d = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18762a(Object[] objArr, int i) {
        System.arraycopy(this.f17389c, 0, objArr, i, this.f17390d);
        return i + this.f17390d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo18702b() {
        return this.f17389c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo18703c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo18704d() {
        return this.f17390d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return false;
    }

    public final E get(int i) {
        zzeb.zza(i, this.f17390d);
        return this.f17389c[i];
    }

    public final int size() {
        return this.f17390d;
    }
}
