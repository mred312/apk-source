package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzgv;
import com.google.android.gms.internal.ads.zzgw;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzbi extends zzgw implements zzbf {
    public zzbi() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            boolean zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            zzgv.writeBoolean(parcel2, zzd);
        } else if (i != 2) {
            return false;
        } else {
            zzap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        }
        return true;
    }
}
