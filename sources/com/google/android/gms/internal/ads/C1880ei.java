package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* renamed from: com.google.android.gms.internal.ads.ei */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1880ei implements zzdvm<zzy, Bitmap> {

    /* renamed from: a */
    private final /* synthetic */ double f8364a;

    /* renamed from: b */
    private final /* synthetic */ boolean f8365b;

    /* renamed from: c */
    private final /* synthetic */ zzcej f8366c;

    C1880ei(zzcej zzcej, double d, boolean z) {
        this.f8366c = zzcej;
        this.f8364a = d;
        this.f8365b = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.f8366c.m7942b(((zzy) obj).data, this.f8364a, this.f8365b);
    }
}
