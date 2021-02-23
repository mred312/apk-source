package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzapm extends zzgw implements zzapn {
    public zzapm() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzuw();
        } else if (i == 3) {
            zzdm(parcel.readString());
        } else if (i != 4) {
            return false;
        } else {
            zzf((zzve) zzgv.zza(parcel, zzve.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
