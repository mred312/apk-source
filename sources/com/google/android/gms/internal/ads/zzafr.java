package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafr extends zzgu implements zzafp {
    zzafr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zza(zzaff zzaff, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaff);
        zzdo.writeString(str);
        zzb(1, zzdo);
    }
}
