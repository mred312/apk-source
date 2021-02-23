package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkb {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdka<T> zzdka) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdka.zzq(t);
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
