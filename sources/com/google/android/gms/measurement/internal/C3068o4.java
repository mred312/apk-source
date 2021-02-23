package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.o4 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
final class C3068o4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18280a;

    /* renamed from: b */
    private final /* synthetic */ AppMeasurementDynamiteService f18281b;

    C3068o4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw) {
        this.f18281b = appMeasurementDynamiteService;
        this.f18280a = zzw;
    }

    public final void run() {
        this.f18281b.f17925a.zzv().zza(this.f18280a);
    }
}
