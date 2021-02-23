package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafz extends zzgu implements zzafx {
    zzafz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public final void zza(zzxg zzxg, IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxg);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(1, zzdo);
    }
}
