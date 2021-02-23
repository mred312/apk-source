package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class sh0 implements ValueCallback<String> {

    /* renamed from: a */
    private final /* synthetic */ ph0 f11088a;

    sh0(ph0 ph0) {
        this.f11088a = ph0;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ph0 ph0 = this.f11088a;
        ph0.f10633e.mo18193b(ph0.f10630b, ph0.f10631c, (String) obj, ph0.f10632d);
    }
}
