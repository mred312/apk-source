package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.h */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2771h extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Boolean f17330e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17331f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2771h(zzag zzag, Boolean bool) {
        super(zzag);
        this.f17331f = zzag;
        this.f17330e = bool;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        if (this.f17330e != null) {
            this.f17331f.f17566h.setMeasurementEnabled(this.f17330e.booleanValue(), this.f17568a);
        } else {
            this.f17331f.f17566h.clearMeasurementEnabled(this.f17568a);
        }
    }
}
