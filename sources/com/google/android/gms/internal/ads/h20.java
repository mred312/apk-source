package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class h20<E> extends zzdwm<E> {

    /* renamed from: e */
    static final zzdwm<Object> f8823e = new h20(new Object[0], 0);

    /* renamed from: c */
    private final transient Object[] f8824c;

    /* renamed from: d */
    private final transient int f8825d;

    h20(Object[] objArr, int i) {
        this.f8824c = objArr;
        this.f8825d = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo14074a(Object[] objArr, int i) {
        System.arraycopy(this.f8824c, 0, objArr, i, this.f8825d);
        return i + this.f8825d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo13933b() {
        return this.f8824c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo13934c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo13935d() {
        return this.f8825d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return false;
    }

    public final E get(int i) {
        zzdvv.zzt(i, this.f8825d);
        return this.f8824c[i];
    }

    public final int size() {
        return this.f8825d;
    }
}
