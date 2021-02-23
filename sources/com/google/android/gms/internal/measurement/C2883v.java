package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.v */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2883v extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ int f17486e = 5;

    /* renamed from: f */
    private final /* synthetic */ String f17487f;

    /* renamed from: g */
    private final /* synthetic */ Object f17488g;

    /* renamed from: h */
    private final /* synthetic */ zzag f17489h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2883v(zzag zzag, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f17489h = zzag;
        this.f17487f = str;
        this.f17488g = obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17489h.f17566h.logHealthData(this.f17486e, this.f17487f, ObjectWrapper.wrap(this.f17488g), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
