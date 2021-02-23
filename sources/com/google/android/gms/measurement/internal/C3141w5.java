package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.w5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3141w5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzig f18435a;

    /* renamed from: b */
    private final /* synthetic */ zzig f18436b;

    /* renamed from: c */
    private final /* synthetic */ long f18437c;

    /* renamed from: d */
    private final /* synthetic */ boolean f18438d;

    /* renamed from: e */
    private final /* synthetic */ zzij f18439e;

    C3141w5(zzij zzij, zzig zzig, zzig zzig2, long j, boolean z) {
        this.f18439e = zzij;
        this.f18435a = zzig;
        this.f18436b = zzig2;
        this.f18437c = j;
        this.f18438d = z;
    }

    public final void run() {
        this.f18439e.m10857f(this.f18435a, this.f18436b, this.f18437c, this.f18438d, (Bundle) null);
    }
}
