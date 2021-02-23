package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzauq implements RewardItem {

    /* renamed from: a */
    private final zzauf f12855a;

    public zzauq(zzauf zzauf) {
        this.f12855a = zzauf;
    }

    public final int getAmount() {
        zzauf zzauf = this.f12855a;
        if (zzauf == null) {
            return 0;
        }
        try {
            return zzauf.getAmount();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzauf zzauf = this.f12855a;
        if (zzauf == null) {
            return null;
        }
        try {
            return zzauf.getType();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
