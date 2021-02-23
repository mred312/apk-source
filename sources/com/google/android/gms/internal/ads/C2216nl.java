package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.nl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2216nl implements Callable {

    /* renamed from: a */
    private final CookieManager f10212a;

    C2216nl(CookieManager cookieManager) {
        this.f10212a = cookieManager;
    }

    public final Object call() {
        CookieManager cookieManager = this.f10212a;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzwq.zzqe().zzd(zzabf.zzcoi));
    }
}
