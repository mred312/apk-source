package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzapf extends zzgw implements zzapc {
    public zzapf() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzx(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzdm(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzf((zzve) zzgv.zza(parcel, zzve.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
