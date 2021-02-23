package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzboi {
    public final List<? extends zzdyz<? extends zzboc>> zzfuy;

    public zzboi(List<? extends zzdyz<? extends zzboc>> list) {
        this.zzfuy = list;
    }

    public static zzcqz<zzboi> zza(@NonNull zzcto<? extends zzboc> zzcto) {
        return new zzcrc(zzcto, C2170mc.f9934a);
    }

    public static zzcqz<zzboi> zza(@NonNull zzcqz<? extends zzboc> zzcqz) {
        return new zzcrc(zzcqz, C2207nc.f10148a);
    }

    public zzboi(zzboc zzboc) {
        this.zzfuy = Collections.singletonList(zzdyr.zzag(zzboc));
    }
}
