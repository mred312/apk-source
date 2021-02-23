package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzate extends zzgw implements zzatf {
    public zzate() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((ParcelFileDescriptor) zzgv.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza((zzap) zzgv.zza(parcel, zzap.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
