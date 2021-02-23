package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.k */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2795k extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ long f17355e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17356f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2795k(zzag zzag, long j) {
        super(zzag);
        this.f17356f = zzag;
        this.f17355e = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17356f.f17566h.setSessionTimeoutDuration(this.f17355e);
    }
}
