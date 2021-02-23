package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzara extends zzgw implements zzarb {
    public static zzarb zzah(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
        if (queryLocalInterface instanceof zzarb) {
            return (zzarb) queryLocalInterface;
        }
        return new zzarc(iBinder);
    }
}
