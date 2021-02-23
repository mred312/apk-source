package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzapv extends zzgu implements zzapt {
    zzapv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    public final void onFailure(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    public final void zzdo(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(1, zzdo);
    }

    public final void zzg(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(3, zzdo);
    }
}
