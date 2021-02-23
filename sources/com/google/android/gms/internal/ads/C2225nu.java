package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.nu */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2225nu implements Runnable {

    /* renamed from: a */
    private final zzdfi f10225a;

    /* renamed from: b */
    private final long f10226b;

    C2225nu(zzdfi zzdfi, long j) {
        this.f10225a = zzdfi;
        this.f10226b = j;
    }

    public final void run() {
        zzdfi zzdfi = this.f10225a;
        long j = this.f10226b;
        String canonicalName = zzdfi.getClass().getCanonicalName();
        long elapsedRealtime = zzp.zzkx().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzd.zzee(sb.toString());
    }
}
