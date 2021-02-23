package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzanl extends zzgw implements zzani {
    public zzanl() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzani zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzani) {
            return (zzani) queryLocalInterface;
        }
        return new zzank(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzann zzde = zzde(parcel.readString());
            parcel2.writeNoException();
            zzgv.zza(parcel2, (IInterface) zzde);
        } else if (i == 2) {
            boolean zzdf = zzdf(parcel.readString());
            parcel2.writeNoException();
            zzgv.writeBoolean(parcel2, zzdf);
        } else if (i != 3) {
            return false;
        } else {
            zzapo zzdg = zzdg(parcel.readString());
            parcel2.writeNoException();
            zzgv.zza(parcel2, (IInterface) zzdg);
        }
        return true;
    }
}
