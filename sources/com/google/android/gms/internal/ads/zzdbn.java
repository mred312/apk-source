package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbn implements zzdfj<Bundle> {

    /* renamed from: a */
    private final int f15182a;

    /* renamed from: b */
    private final boolean f15183b;

    /* renamed from: c */
    private final boolean f15184c;

    /* renamed from: d */
    private final int f15185d;

    /* renamed from: e */
    private final int f15186e;

    /* renamed from: f */
    private final int f15187f;

    /* renamed from: g */
    private final float f15188g;

    /* renamed from: h */
    private final boolean f15189h;

    public zzdbn(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.f15182a = i;
        this.f15183b = z;
        this.f15184c = z2;
        this.f15185d = i2;
        this.f15186e = i3;
        this.f15187f = i4;
        this.f15188g = f;
        this.f15189h = z3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.f15182a);
        bundle.putBoolean("ma", this.f15183b);
        bundle.putBoolean("sp", this.f15184c);
        bundle.putInt("muv", this.f15185d);
        bundle.putInt("rm", this.f15186e);
        bundle.putInt("riv", this.f15187f);
        bundle.putFloat("android_app_volume", this.f15188g);
        bundle.putBoolean("android_app_muted", this.f15189h);
    }
}
