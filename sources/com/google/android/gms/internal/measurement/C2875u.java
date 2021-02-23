package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgx;

/* renamed from: com.google.android.gms.internal.measurement.u */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2875u extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzgx f17475e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17476f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2875u(zzag zzag, zzgx zzgx) {
        super(zzag);
        this.f17476f = zzag;
        this.f17475e = zzgx;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17476f.f17566h.setEventInterceptor(new zzag.C2919a(this.f17475e));
    }
}
