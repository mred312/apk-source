package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.l0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2804l0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Activity f17364e;

    /* renamed from: f */
    private final /* synthetic */ zzag.C2921c f17365f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2804l0(zzag.C2921c cVar, Activity activity) {
        super(zzag.this);
        this.f17365f = cVar;
        this.f17364e = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        zzag.this.f17566h.onActivityStopped(ObjectWrapper.wrap(this.f17364e), this.f17569b);
    }
}
