package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzajf extends zzgw implements zzajc {
    public zzajf() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzajc zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzajc) {
            return (zzajc) queryLocalInterface;
        }
        return new zzaje(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zze(parcel.createTypedArrayList(zzaiz.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
