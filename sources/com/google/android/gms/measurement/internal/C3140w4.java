package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.w4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3140w4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18426a;

    /* renamed from: b */
    private final /* synthetic */ String f18427b;

    /* renamed from: c */
    private final /* synthetic */ long f18428c;

    /* renamed from: d */
    private final /* synthetic */ Bundle f18429d;

    /* renamed from: e */
    private final /* synthetic */ boolean f18430e;

    /* renamed from: f */
    private final /* synthetic */ boolean f18431f;

    /* renamed from: g */
    private final /* synthetic */ boolean f18432g;

    /* renamed from: h */
    private final /* synthetic */ String f18433h;

    /* renamed from: i */
    private final /* synthetic */ zzgy f18434i;

    C3140w4(zzgy zzgy, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f18434i = zzgy;
        this.f18426a = str;
        this.f18427b = str2;
        this.f18428c = j;
        this.f18429d = bundle;
        this.f18430e = z;
        this.f18431f = z2;
        this.f18432g = z3;
        this.f18433h = str3;
    }

    public final void run() {
        this.f18434i.zza(this.f18426a, this.f18427b, this.f18428c, this.f18429d, this.f18430e, this.f18431f, this.f18432g, this.f18433h);
    }
}
