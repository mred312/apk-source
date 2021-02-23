package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfd {
    public final int type = 2;
    public final String zzck;
    public final String zzdpv;
    public final zzadv zzggw;

    @VisibleForTesting
    public zzcfd(String str, String str2) {
        this.zzck = str;
        this.zzdpv = str2;
        this.zzggw = null;
    }

    @VisibleForTesting
    public zzcfd(String str, zzadv zzadv) {
        this.zzck = str;
        this.zzdpv = null;
        this.zzggw = zzadv;
    }
}
