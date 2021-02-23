package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.u5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3123u5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Bundle f18394a;

    /* renamed from: b */
    private final /* synthetic */ zzig f18395b;

    /* renamed from: c */
    private final /* synthetic */ zzig f18396c;

    /* renamed from: d */
    private final /* synthetic */ long f18397d;

    /* renamed from: e */
    private final /* synthetic */ zzij f18398e;

    C3123u5(zzij zzij, Bundle bundle, zzig zzig, zzig zzig2, long j) {
        this.f18398e = zzij;
        this.f18394a = bundle;
        this.f18395b = zzig;
        this.f18396c = zzig2;
        this.f18397d = j;
    }

    public final void run() {
        this.f18398e.m10856e(this.f18394a, this.f18395b, this.f18396c, this.f18397d);
    }
}
