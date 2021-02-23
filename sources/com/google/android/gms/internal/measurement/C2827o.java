package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.o */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2827o extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ zzt f17394e;

    /* renamed from: f */
    private final /* synthetic */ zzag f17395f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2827o(zzag zzag, zzt zzt) {
        super(zzag);
        this.f17395f = zzag;
        this.f17394e = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17395f.f17566h.getCachedAppInstanceId(this.f17394e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17394e.zza((Bundle) null);
    }
}
