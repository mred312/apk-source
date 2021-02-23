package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzyb extends zzgu implements zzxz {
    zzyb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public final void onAdMuted() {
        zzb(1, zzdo());
    }
}
