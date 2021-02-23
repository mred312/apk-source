package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdob {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzaza.zzez(sb.toString());
        zzd.zza(str, th);
        if (i != 3) {
            zzp.zzku().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzaza.zzez("This request is sent from a test device.");
            return;
        }
        zzwq.zzqa();
        String zzbn = zzayr.zzbn(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbn).length() + 101);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzbn);
        sb.append("\") to get test ads on this device.");
        zzaza.zzez(sb.toString());
    }
}
