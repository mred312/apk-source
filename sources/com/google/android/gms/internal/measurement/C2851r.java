package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.r */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2851r extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzt f17431e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17432f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2851r(zzag zzag, zzt zzt) {
        super(zzag);
        this.f17432f = zzag;
        this.f17431e = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17432f.f17566h.generateEventId(this.f17431e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17431e.zza((Bundle) null);
    }
}
