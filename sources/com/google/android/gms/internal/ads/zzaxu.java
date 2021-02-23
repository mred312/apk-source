package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzaxu extends zzgw implements zzaxv {
    public static zzaxv zzat(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (queryLocalInterface instanceof zzaxv) {
            return (zzaxv) queryLocalInterface;
        }
        return new zzaxx(iBinder);
    }
}
