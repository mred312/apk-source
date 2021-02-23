package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* renamed from: com.google.android.gms.internal.ads.rf */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2359rf implements zzbwm {

    /* renamed from: a */
    private final String f10792a;

    /* renamed from: b */
    private final String f10793b;

    C2359rf(String str, String str2) {
        this.f10792a = str;
        this.f10793b = str2;
    }

    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.f10792a, this.f10793b);
    }
}
