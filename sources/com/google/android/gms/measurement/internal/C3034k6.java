package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.k6 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
final class C3034k6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18197a;

    /* renamed from: b */
    private final /* synthetic */ zzar f18198b;

    /* renamed from: c */
    private final /* synthetic */ String f18199c;

    /* renamed from: d */
    private final /* synthetic */ AppMeasurementDynamiteService f18200d;

    C3034k6(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, zzar zzar, String str) {
        this.f18200d = appMeasurementDynamiteService;
        this.f18197a = zzw;
        this.f18198b = zzar;
        this.f18199c = str;
    }

    public final void run() {
        this.f18200d.f17925a.zzv().zza(this.f18197a, this.f18198b, this.f18199c);
    }
}
