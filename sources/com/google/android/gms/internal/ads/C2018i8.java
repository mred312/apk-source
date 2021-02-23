package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.i8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2018i8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f9264a;

    /* renamed from: b */
    private final /* synthetic */ String f9265b;

    /* renamed from: c */
    private final /* synthetic */ long f9266c;

    /* renamed from: d */
    private final /* synthetic */ long f9267d;

    /* renamed from: e */
    private final /* synthetic */ long f9268e;

    /* renamed from: f */
    private final /* synthetic */ long f9269f;

    /* renamed from: g */
    private final /* synthetic */ long f9270g;

    /* renamed from: h */
    private final /* synthetic */ boolean f9271h;

    /* renamed from: i */
    private final /* synthetic */ int f9272i;

    /* renamed from: j */
    private final /* synthetic */ int f9273j;

    /* renamed from: k */
    private final /* synthetic */ zzbcx f9274k;

    C2018i8(zzbcx zzbcx, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.f9274k = zzbcx;
        this.f9264a = str;
        this.f9265b = str2;
        this.f9266c = j;
        this.f9267d = j2;
        this.f9268e = j3;
        this.f9269f = j4;
        this.f9270g = j5;
        this.f9271h = z;
        this.f9272i = i;
        this.f9273j = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.f9264a);
        hashMap.put("cachedSrc", this.f9265b);
        hashMap.put("bufferedDuration", Long.toString(this.f9266c));
        hashMap.put("totalDuration", Long.toString(this.f9267d));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.f9268e));
            hashMap.put("qoeCachedBytes", Long.toString(this.f9269f));
            hashMap.put("totalBytes", Long.toString(this.f9270g));
            hashMap.put("reportTime", Long.toString(zzp.zzkx().currentTimeMillis()));
        }
        hashMap.put("cacheReady", this.f9271h ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.f9272i));
        hashMap.put("playerPreparedCount", Integer.toString(this.f9273j));
        this.f9274k.m7713c("onPrecacheEvent", hashMap);
    }
}
