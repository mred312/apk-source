package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.j0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2047j0 implements zzahv<Object> {
    C2047j0() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzaza.zzez(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
