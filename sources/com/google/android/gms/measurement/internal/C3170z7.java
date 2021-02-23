package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.z7 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
final class C3170z7 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzw f18484a;

    /* renamed from: b */
    private final /* synthetic */ String f18485b;

    /* renamed from: c */
    private final /* synthetic */ String f18486c;

    /* renamed from: d */
    private final /* synthetic */ AppMeasurementDynamiteService f18487d;

    C3170z7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2) {
        this.f18487d = appMeasurementDynamiteService;
        this.f18484a = zzw;
        this.f18485b = str;
        this.f18486c = str2;
    }

    public final void run() {
        this.f18487d.f17925a.zzv().zza(this.f18484a, this.f18485b, this.f18486c);
    }
}
