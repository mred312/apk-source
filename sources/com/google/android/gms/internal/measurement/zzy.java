package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzy extends zza implements zzw {
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void zza(Bundle bundle) {
        Parcel a_ = mo18994a_();
        zzb.zza(a_, (Parcelable) bundle);
        zzb(1, a_);
    }
}
