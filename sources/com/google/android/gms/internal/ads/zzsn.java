package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzsn extends zzgu implements zzsl {
    zzsn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void onAppOpenAdFailedToLoad(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(2, zzdo);
    }

    public final void zza(zzsg zzsg) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzsg);
        zzb(1, zzdo);
    }

    public final void zza(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(3, zzdo);
    }
}
