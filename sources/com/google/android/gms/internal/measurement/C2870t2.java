package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.t2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2870t2 extends zzfb<Object> {

    /* renamed from: c */
    private final transient Object[] f17470c;

    /* renamed from: d */
    private final transient int f17471d;

    /* renamed from: e */
    private final transient int f17472e;

    C2870t2(Object[] objArr, int i, int i2) {
        this.f17470c = objArr;
        this.f17471d = i;
        this.f17472e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return true;
    }

    public final Object get(int i) {
        zzeb.zza(i, this.f17472e);
        return this.f17470c[(i * 2) + this.f17471d];
    }

    public final int size() {
        return this.f17472e;
    }
}
