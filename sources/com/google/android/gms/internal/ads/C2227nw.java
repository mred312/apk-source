package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ads.nw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2227nw implements zzdyb {

    /* renamed from: a */
    private final zzdpn f10228a;

    /* renamed from: b */
    private final zzboz f10229b;

    C2227nw(zzdjk zzdjk, zzdpn zzdpn, zzboz zzboz) {
        this.f10228a = zzdpn;
        this.f10229b = zzboz;
    }

    public final zzdyz zzf(Object obj) {
        zzdpn zzdpn = this.f10228a;
        zzboz zzboz = this.f10229b;
        zzdnj zzdnj = (zzdnj) obj;
        zzdpn.zzext = zzdnj;
        Iterator<zzdmu> it = zzdnj.zzhik.zzhih.iterator();
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            Iterator<String> it2 = it.next().zzhgo.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!it2.next().contains("FirstPartyRenderer")) {
                        break loop0;
                    }
                    z2 = true;
                }
            }
        }
        if (!z) {
            return zzdyr.zzag(null);
        }
        return zzboz.zzb((zzdyz<zzdnj>) zzdyr.zzag(zzdnj));
    }
}
