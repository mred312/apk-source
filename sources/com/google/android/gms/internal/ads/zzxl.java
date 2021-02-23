package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzxl extends zzgu implements zzxj {
    zzxl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public final void onAdMetadataChanged() {
        zzb(1, zzdo());
    }
}
