package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzwx extends zzgw implements zzwy {
    public zzwx() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((zzvk) zzgv.zza(parcel, zzvk.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzgv.writeBoolean(parcel2, isLoading);
        } else if (i == 4) {
            String zzkg = zzkg();
            parcel2.writeNoException();
            parcel2.writeString(zzkg);
        } else if (i != 5) {
            return false;
        } else {
            zza((zzvk) zzgv.zza(parcel, zzvk.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
