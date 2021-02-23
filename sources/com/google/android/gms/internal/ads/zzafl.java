package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafl extends zzgu implements zzafj {
    zzafl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zza(zzaex zzaex) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaex);
        zzb(1, zzdo);
    }
}
