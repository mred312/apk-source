package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.w */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2891w extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17493e;

    /* renamed from: f */
    private final /* synthetic */ zzt f17494f;

    /* renamed from: g */
    private final /* synthetic */ zzag f17495g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2891w(zzag zzag, String str, zzt zzt) {
        super(zzag);
        this.f17495g = zzag;
        this.f17493e = str;
        this.f17494f = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17495g.f17566h.getMaxUserProperties(this.f17493e, this.f17494f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17494f.zza((Bundle) null);
    }
}
