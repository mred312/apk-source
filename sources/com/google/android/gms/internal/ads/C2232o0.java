package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.o0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2232o0 implements zzahv<zzbdv> {
    C2232o0() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbdv.zzkm();
        } else if ("resume".equals(str)) {
            zzbdv.zzkn();
        }
    }
}
