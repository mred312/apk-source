package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzave extends zzgu implements zzavc {
    zzave(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final int getAmount() {
        Parcel zza = zza(2, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final String getType() {
        Parcel zza = zza(1, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
