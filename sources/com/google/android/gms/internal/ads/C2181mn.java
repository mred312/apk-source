package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.mn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2181mn implements zzdyo<Bundle> {

    /* renamed from: a */
    private final /* synthetic */ boolean f9998a;

    /* renamed from: b */
    final /* synthetic */ zzcqe f9999b;

    C2181mn(zzcqe zzcqe, boolean z) {
        this.f9999b = zzcqe;
        this.f9998a = z;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList b = zzcqe.m8240j(bundle);
        zzue.zzo.zzc e = zzcqe.m8239i(bundle);
        this.f9999b.f14709e.zza(new C2218nn(this, this.f9998a, b, this.f9999b.m8238h(bundle), e));
    }

    public final void zzb(Throwable th) {
        zzaza.zzey("Failed to get signals bundle");
    }
}
