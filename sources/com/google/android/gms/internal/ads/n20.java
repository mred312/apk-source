package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class n20 extends zzdwm<Object> {

    /* renamed from: c */
    private final transient Object[] f10030c;

    /* renamed from: d */
    private final transient int f10031d;

    /* renamed from: e */
    private final transient int f10032e;

    n20(Object[] objArr, int i, int i2) {
        this.f10030c = objArr;
        this.f10031d = i;
        this.f10032e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return true;
    }

    public final Object get(int i) {
        zzdvv.zzt(i, this.f10032e);
        return this.f10030c[(i * 2) + this.f10031d];
    }

    public final int size() {
        return this.f10032e;
    }
}
