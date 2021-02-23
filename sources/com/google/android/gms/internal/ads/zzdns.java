package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdns {
    public static zzdmx zza(List<zzdmx> list, zzdmx zzdmx) {
        return list.get(0);
    }

    public static zzvn zzb(Context context, List<zzdmx> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdmx next : list) {
            if (next.zzhhw) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.width, next.height));
            }
        }
        return new zzvn(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdmx zzg(zzvn zzvn) {
        if (zzvn.zzchr) {
            return new zzdmx(-3, 0, true);
        }
        return new zzdmx(zzvn.width, zzvn.height, false);
    }
}
