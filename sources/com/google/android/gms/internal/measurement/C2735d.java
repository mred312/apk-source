package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.d */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2735d extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17248e;

    /* renamed from: f */
    private final /* synthetic */ String f17249f;

    /* renamed from: g */
    private final /* synthetic */ Bundle f17250g;

    /* renamed from: h */
    private final /* synthetic */ zzag f17251h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2735d(zzag zzag, String str, String str2, Bundle bundle) {
        super(zzag);
        this.f17251h = zzag;
        this.f17248e = str;
        this.f17249f = str2;
        this.f17250g = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17251h.f17566h.clearConditionalUserProperty(this.f17248e, this.f17249f, this.f17250g);
    }
}
