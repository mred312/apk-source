package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.f0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2752f0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Long f17288e;

    /* renamed from: f */
    private final /* synthetic */ String f17289f;

    /* renamed from: g */
    private final /* synthetic */ String f17290g;

    /* renamed from: h */
    private final /* synthetic */ Bundle f17291h;

    /* renamed from: i */
    private final /* synthetic */ boolean f17292i;

    /* renamed from: j */
    private final /* synthetic */ boolean f17293j;

    /* renamed from: k */
    private final /* synthetic */ zzag f17294k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2752f0(zzag zzag, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzag);
        this.f17294k = zzag;
        this.f17288e = l;
        this.f17289f = str;
        this.f17290g = str2;
        this.f17291h = bundle;
        this.f17292i = z;
        this.f17293j = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        Long l = this.f17288e;
        this.f17294k.f17566h.logEvent(this.f17289f, this.f17290g, this.f17291h, this.f17292i, this.f17293j, l == null ? this.f17568a : l.longValue());
    }
}
