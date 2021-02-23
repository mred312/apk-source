package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.l8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2129l8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f9810a;

    /* renamed from: b */
    private final /* synthetic */ String f9811b;

    /* renamed from: c */
    private final /* synthetic */ String f9812c;

    /* renamed from: d */
    private final /* synthetic */ String f9813d;

    /* renamed from: e */
    private final /* synthetic */ zzbcx f9814e;

    C2129l8(zzbcx zzbcx, String str, String str2, String str3, String str4) {
        this.f9814e = zzbcx;
        this.f9810a = str;
        this.f9811b = str2;
        this.f9812c = str3;
        this.f9813d = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.f9810a);
        if (!TextUtils.isEmpty(this.f9811b)) {
            hashMap.put("cachedSrc", this.f9811b);
        }
        hashMap.put("type", zzbcx.m7714d(this.f9812c));
        hashMap.put("reason", this.f9812c);
        if (!TextUtils.isEmpty(this.f9813d)) {
            hashMap.put("message", this.f9813d);
        }
        this.f9814e.m7713c("onPrecacheEvent", hashMap);
    }
}
