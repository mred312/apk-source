package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzajr extends zzgw implements zzajo {
    public zzajr() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zztn();
        } else if (i != 2) {
            return false;
        } else {
            zzdb(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
