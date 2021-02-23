package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.a0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2712a0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Bundle f17212e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17213f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2712a0(zzag zzag, Bundle bundle) {
        super(zzag);
        this.f17213f = zzag;
        this.f17212e = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17213f.f17566h.setDefaultEventParameters(this.f17212e);
    }
}
