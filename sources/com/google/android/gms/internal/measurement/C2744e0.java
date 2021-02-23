package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.e0 */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2744e0 extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17272e;

    /* renamed from: f */
    private final /* synthetic */ String f17273f;

    /* renamed from: g */
    private final /* synthetic */ Object f17274g;

    /* renamed from: h */
    private final /* synthetic */ boolean f17275h;

    /* renamed from: i */
    private final /* synthetic */ zzag f17276i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2744e0(zzag zzag, String str, String str2, Object obj, boolean z) {
        super(zzag);
        this.f17276i = zzag;
        this.f17272e = str;
        this.f17273f = str2;
        this.f17274g = obj;
        this.f17275h = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17276i.f17566h.setUserProperty(this.f17272e, this.f17273f, ObjectWrapper.wrap(this.f17274g), this.f17275h, this.f17568a);
    }
}
