package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafs extends zzgu implements zzafq {
    zzafs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zza(zzaff zzaff) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaff);
        zzb(1, zzdo);
    }
}
