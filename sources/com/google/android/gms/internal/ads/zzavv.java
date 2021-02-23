package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzavv implements RewardItem {

    /* renamed from: a */
    private final zzavc f12871a;

    public zzavv(zzavc zzavc) {
        this.f12871a = zzavc;
    }

    public final int getAmount() {
        zzavc zzavc = this.f12871a;
        if (zzavc == null) {
            return 0;
        }
        try {
            return zzavc.getAmount();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzavc zzavc = this.f12871a;
        if (zzavc == null) {
            return null;
        }
        try {
            return zzavc.getType();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
