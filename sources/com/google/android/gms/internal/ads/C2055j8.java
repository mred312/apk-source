package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.j8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2055j8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f9377a;

    /* renamed from: b */
    private final /* synthetic */ String f9378b;

    /* renamed from: c */
    private final /* synthetic */ long f9379c;

    /* renamed from: d */
    private final /* synthetic */ zzbcx f9380d;

    C2055j8(zzbcx zzbcx, String str, String str2, long j) {
        this.f9380d = zzbcx;
        this.f9377a = str;
        this.f9378b = str2;
        this.f9379c = j;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.f9377a);
        hashMap.put("cachedSrc", this.f9378b);
        hashMap.put("totalDuration", Long.toString(this.f9379c));
        this.f9380d.m7713c("onPrecacheEvent", hashMap);
    }
}
