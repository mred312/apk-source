package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.g */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2763g extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Bundle f17311e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17312f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2763g(zzag zzag, Bundle bundle) {
        super(zzag);
        this.f17312f = zzag;
        this.f17311e = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17312f.f17566h.setConsent(this.f17311e, this.f17568a);
    }
}
