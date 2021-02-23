package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.k8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2092k8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f9571a;

    /* renamed from: b */
    private final /* synthetic */ String f9572b;

    /* renamed from: c */
    private final /* synthetic */ int f9573c;

    /* renamed from: d */
    private final /* synthetic */ zzbcx f9574d;

    C2092k8(zzbcx zzbcx, String str, String str2, int i) {
        this.f9574d = zzbcx;
        this.f9571a = str;
        this.f9572b = str2;
        this.f9573c = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.f9571a);
        hashMap.put("cachedSrc", this.f9572b);
        hashMap.put("totalBytes", Integer.toString(this.f9573c));
        this.f9574d.m7713c("onPrecacheEvent", hashMap);
    }
}
