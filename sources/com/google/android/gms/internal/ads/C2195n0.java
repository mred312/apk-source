package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.n0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2195n0 implements zzahv<zzbdv> {
    C2195n0() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map.keySet().contains("start")) {
            zzbdv.zzacs().zzacf();
        } else if (map.keySet().contains("stop")) {
            zzbdv.zzacs().zzacg();
        } else if (map.keySet().contains("cancel")) {
            zzbdv.zzacs().zzach();
        }
    }
}
