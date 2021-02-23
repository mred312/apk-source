package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.il */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2031il implements zzdyo<String> {

    /* renamed from: a */
    final /* synthetic */ zzclp f9337a;

    C2031il(zzclp zzclp) {
        this.f9337a = zzclp;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.f9337a.f14561b = true;
            this.f9337a.m8190g("com.google.android.gms.ads.MobileAds", true, "", (int) (zzp.zzkx().elapsedRealtime() - this.f9337a.f14562c));
            this.f9337a.f14567h.execute(new C1994hl(this, str));
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this) {
            boolean unused = this.f9337a.f14561b = true;
            this.f9337a.m8190g("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzp.zzkx().elapsedRealtime() - this.f9337a.f14562c));
            this.f9337a.f14563d.setException(new Exception());
        }
    }
}
