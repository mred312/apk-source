package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyd implements zzva {
    @GuardedBy("this")

    /* renamed from: a */
    private zzws f15048a;

    public final synchronized void onAdClicked() {
        zzws zzws = this.f15048a;
        if (zzws != null) {
            try {
                zzws.onAdClicked();
            } catch (RemoteException e) {
                zzaza.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zzb(zzws zzws) {
        this.f15048a = zzws;
    }
}
