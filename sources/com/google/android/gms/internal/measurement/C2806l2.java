package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.l2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2806l2 extends zzfb<E> {

    /* renamed from: c */
    private final transient int f17367c;

    /* renamed from: d */
    private final transient int f17368d;

    /* renamed from: e */
    private final /* synthetic */ zzfb f17369e;

    C2806l2(zzfb zzfb, int i, int i2) {
        this.f17369e = zzfb;
        this.f17367c = i;
        this.f17368d = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo18702b() {
        return this.f17369e.mo18702b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo18703c() {
        return this.f17369e.mo18703c() + this.f17367c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo18704d() {
        return this.f17369e.mo18703c() + this.f17367c + this.f17368d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return true;
    }

    public final E get(int i) {
        zzeb.zza(i, this.f17368d);
        return this.f17369e.get(i + this.f17367c);
    }

    public final int size() {
        return this.f17368d;
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final zzfb<E> zza(int i, int i2) {
        zzeb.zza(i, i2, this.f17368d);
        zzfb zzfb = this.f17369e;
        int i3 = this.f17367c;
        return (zzfb) zzfb.subList(i + i3, i2 + i3);
    }
}
