package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.c */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2727c extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17238e;

    /* renamed from: f */
    private final /* synthetic */ String f17239f;

    /* renamed from: g */
    private final /* synthetic */ zzt f17240g;

    /* renamed from: h */
    private final /* synthetic */ zzag f17241h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2727c(zzag zzag, String str, String str2, zzt zzt) {
        super(zzag);
        this.f17241h = zzag;
        this.f17238e = str;
        this.f17239f = str2;
        this.f17240g = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17241h.f17566h.getConditionalUserProperties(this.f17238e, this.f17239f, this.f17240g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17240g.zza((Bundle) null);
    }
}
