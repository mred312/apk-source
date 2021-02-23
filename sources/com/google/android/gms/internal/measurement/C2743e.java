package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.e */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2743e extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ Activity f17268e;

    /* renamed from: f */
    private final /* synthetic */ String f17269f;

    /* renamed from: g */
    private final /* synthetic */ String f17270g;

    /* renamed from: h */
    private final /* synthetic */ zzag f17271h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2743e(zzag zzag, Activity activity, String str, String str2) {
        super(zzag);
        this.f17271h = zzag;
        this.f17268e = activity;
        this.f17269f = str;
        this.f17270g = str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18537a() {
        this.f17271h.f17566h.setCurrentScreen(ObjectWrapper.wrap(this.f17268e), this.f17269f, this.f17270g, this.f17568a);
    }
}
