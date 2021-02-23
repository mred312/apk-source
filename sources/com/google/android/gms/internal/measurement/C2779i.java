package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.i */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2779i extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ long f17340e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17341f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2779i(zzag zzag, long j) {
        super(zzag);
        this.f17341f = zzag;
        this.f17340e = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17341f.f17566h.setMinimumSessionDuration(this.f17340e);
    }
}
