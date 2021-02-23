package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.h8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1981h8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f8841a;

    /* renamed from: b */
    private final /* synthetic */ String f8842b;

    /* renamed from: c */
    private final /* synthetic */ int f8843c;

    /* renamed from: d */
    private final /* synthetic */ int f8844d;

    /* renamed from: e */
    private final /* synthetic */ long f8845e;

    /* renamed from: f */
    private final /* synthetic */ long f8846f;

    /* renamed from: g */
    private final /* synthetic */ boolean f8847g;

    /* renamed from: h */
    private final /* synthetic */ int f8848h;

    /* renamed from: i */
    private final /* synthetic */ int f8849i;

    /* renamed from: j */
    private final /* synthetic */ zzbcx f8850j;

    C1981h8(zzbcx zzbcx, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.f8850j = zzbcx;
        this.f8841a = str;
        this.f8842b = str2;
        this.f8843c = i;
        this.f8844d = i2;
        this.f8845e = j;
        this.f8846f = j2;
        this.f8847g = z;
        this.f8848h = i3;
        this.f8849i = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.f8841a);
        hashMap.put("cachedSrc", this.f8842b);
        hashMap.put("bytesLoaded", Integer.toString(this.f8843c));
        hashMap.put("totalBytes", Integer.toString(this.f8844d));
        hashMap.put("bufferedDuration", Long.toString(this.f8845e));
        hashMap.put("totalDuration", Long.toString(this.f8846f));
        hashMap.put("cacheReady", this.f8847g ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.f8848h));
        hashMap.put("playerPreparedCount", Integer.toString(this.f8849i));
        this.f8850j.m7713c("onPrecacheEvent", hashMap);
    }
}
