package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzaqz extends zzgw implements zzaqw {
    public zzaqz() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzaqw zzag(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzaqw) {
            return (zzaqw) queryLocalInterface;
        }
        return new zzaqy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzc((Intent) zzgv.zza(parcel, Intent.CREATOR));
        } else if (i == 2) {
            zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzuz();
        }
        parcel2.writeNoException();
        return true;
    }
}
