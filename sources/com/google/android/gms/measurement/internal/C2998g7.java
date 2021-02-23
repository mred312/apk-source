package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.g7 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
final class C2998g7 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18085a;

    /* renamed from: b */
    private final /* synthetic */ AppMeasurementDynamiteService f18086b;

    C2998g7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw) {
        this.f18086b = appMeasurementDynamiteService;
        this.f18085a = zzw;
    }

    public final void run() {
        this.f18086b.f17925a.zzh().zza(this.f18085a, this.f18086b.f17925a.zzz());
    }
}
