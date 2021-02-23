package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzao;
import com.google.android.gms.internal.ads.zzaza;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzaz implements zzai {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ zzbe zzeet;

    zzaz(zzax zzax, String str, zzbe zzbe) {
        this.zzees = str;
        this.zzeet = zzbe;
    }

    public final void zzc(zzao zzao) {
        String str = this.zzees;
        String exc = zzao.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzaza.zzfa(sb.toString());
        this.zzeet.zzb(null);
    }
}
