package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.g8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1944g8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f8519a;

    /* renamed from: b */
    private final /* synthetic */ String f8520b;

    /* renamed from: c */
    private final /* synthetic */ int f8521c;

    /* renamed from: d */
    private final /* synthetic */ int f8522d;

    /* renamed from: e */
    private final /* synthetic */ zzbcx f8523e;

    C1944g8(zzbcx zzbcx, String str, String str2, int i, int i2, boolean z) {
        this.f8523e = zzbcx;
        this.f8519a = str;
        this.f8520b = str2;
        this.f8521c = i;
        this.f8522d = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.f8519a);
        hashMap.put("cachedSrc", this.f8520b);
        hashMap.put("bytesLoaded", Integer.toString(this.f8521c));
        hashMap.put("totalBytes", Integer.toString(this.f8522d));
        hashMap.put("cacheReady", "0");
        this.f8523e.m7713c("onPrecacheEvent", hashMap);
    }
}
