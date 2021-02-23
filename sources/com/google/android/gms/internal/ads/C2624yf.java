package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.yf */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2624yf implements Runnable {

    /* renamed from: a */
    private final zzbwm f12194a;

    /* renamed from: b */
    private final Object f12195b;

    C2624yf(zzbwm zzbwm, Object obj) {
        this.f12194a = zzbwm;
        this.f12195b = obj;
    }

    public final void run() {
        try {
            this.f12194a.zzp(this.f12195b);
        } catch (Throwable th) {
            zzp.zzku().zzb(th, "EventEmitter.notify");
            zzd.zza("Event emitter exception.", th);
        }
    }
}
