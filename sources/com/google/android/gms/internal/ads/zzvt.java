package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvt extends zzxn {

    /* renamed from: a */
    private final AppEventListener f17079a;

    public zzvt(AppEventListener appEventListener) {
        this.f17079a = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.f17079a;
    }

    public final void onAppEvent(String str, String str2) {
        this.f17079a.onAppEvent(str, str2);
    }
}
