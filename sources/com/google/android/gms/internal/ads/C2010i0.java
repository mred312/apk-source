package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.i0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2010i0 implements zzahv<zzbdv> {
    C2010i0() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (zzbdv.zzadg() != null) {
            zzbdv.zzadg().zzms();
        }
        zze zzaco = zzbdv.zzaco();
        if (zzaco != null) {
            zzaco.close();
            return;
        }
        zze zzacp = zzbdv.zzacp();
        if (zzacp != null) {
            zzacp.close();
        } else {
            zzaza.zzfa("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
