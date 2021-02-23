package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.s */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2859s extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17447e;

    /* renamed from: f */
    private final /* synthetic */ String f17448f;

    /* renamed from: g */
    private final /* synthetic */ boolean f17449g;

    /* renamed from: h */
    private final /* synthetic */ zzt f17450h;

    /* renamed from: i */
    private final /* synthetic */ zzag f17451i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2859s(zzag zzag, String str, String str2, boolean z, zzt zzt) {
        super(zzag);
        this.f17451i = zzag;
        this.f17447e = str;
        this.f17448f = str2;
        this.f17449g = z;
        this.f17450h = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17451i.f17566h.getUserProperties(this.f17447e, this.f17448f, this.f17449g, this.f17450h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18559b() {
        this.f17450h.zza((Bundle) null);
    }
}
