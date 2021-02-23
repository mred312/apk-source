package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class f20 extends zzdwm<E> {

    /* renamed from: c */
    private final transient int f8420c;

    /* renamed from: d */
    private final transient int f8421d;

    /* renamed from: e */
    private final /* synthetic */ zzdwm f8422e;

    f20(zzdwm zzdwm, int i, int i2) {
        this.f8422e = zzdwm;
        this.f8420c = i;
        this.f8421d = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object[] mo13933b() {
        return this.f8422e.mo13933b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo13934c() {
        return this.f8422e.mo13934c() + this.f8420c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo13935d() {
        return this.f8422e.mo13934c() + this.f8420c + this.f8421d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo13936e() {
        return true;
    }

    public final E get(int i) {
        zzdvv.zzt(i, this.f8421d);
        return this.f8422e.get(i + this.f8420c);
    }

    public final int size() {
        return this.f8421d;
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final zzdwm<E> zzv(int i, int i2) {
        zzdvv.zzf(i, i2, this.f8421d);
        zzdwm zzdwm = this.f8422e;
        int i3 = this.f8420c;
        return (zzdwm) zzdwm.subList(i + i3, i2 + i3);
    }
}
