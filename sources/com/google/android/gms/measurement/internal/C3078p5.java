package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.p5 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
final class C3078p5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18295a;

    /* renamed from: b */
    private final /* synthetic */ String f18296b;

    /* renamed from: c */
    private final /* synthetic */ String f18297c;

    /* renamed from: d */
    private final /* synthetic */ boolean f18298d;

    /* renamed from: e */
    private final /* synthetic */ AppMeasurementDynamiteService f18299e;

    C3078p5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2, boolean z) {
        this.f18299e = appMeasurementDynamiteService;
        this.f18295a = zzw;
        this.f18296b = str;
        this.f18297c = str2;
        this.f18298d = z;
    }

    public final void run() {
        this.f18299e.f17925a.zzv().zza(this.f18295a, this.f18296b, this.f18297c, this.f18298d);
    }
}
