package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzm extends zzb implements zzl {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final IObjectWrapper zzb() {
        Parcel zza = zza(1, mo18531a_());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final int zzc() {
        Parcel zza = zza(2, mo18531a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
