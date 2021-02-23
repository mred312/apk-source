package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.z */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2912z extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzt f17547e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17548f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2912z(zzag zzag, zzt zzt) {
        super(zzag);
        this.f17548f = zzag;
        this.f17547e = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17548f.f17566h.getAppInstanceId(this.f17547e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17547e.zza((Bundle) null);
    }
}
