package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.j0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2788j0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Activity f17351e;

    /* renamed from: f */
    private final /* synthetic */ zzag.C2921c f17352f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2788j0(zzag.C2921c cVar, Activity activity) {
        super(zzag.this);
        this.f17352f = cVar;
        this.f17351e = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        zzag.this.f17566h.onActivityResumed(ObjectWrapper.wrap(this.f17351e), this.f17569b);
    }
}
