package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.k0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2796k0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Activity f17357e;

    /* renamed from: f */
    private final /* synthetic */ zzt f17358f;

    /* renamed from: g */
    private final /* synthetic */ zzag.C2921c f17359g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2796k0(zzag.C2921c cVar, Activity activity, zzt zzt) {
        super(zzag.this);
        this.f17359g = cVar;
        this.f17357e = activity;
        this.f17358f = zzt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        zzag.this.f17566h.onActivitySaveInstanceState(ObjectWrapper.wrap(this.f17357e), this.f17358f, this.f17569b);
    }
}
