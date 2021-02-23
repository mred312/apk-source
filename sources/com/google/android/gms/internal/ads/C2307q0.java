package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.q0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2307q0 implements zzahv<zzbdv> {
    C2307q0() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map.keySet().contains("start")) {
            zzbdv.zzbb(true);
        }
        if (map.keySet().contains("stop")) {
            zzbdv.zzbb(false);
        }
    }
}
