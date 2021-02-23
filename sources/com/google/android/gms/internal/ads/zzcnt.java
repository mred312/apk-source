package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzas;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcnt extends zzate {

    /* renamed from: a */
    private final /* synthetic */ zzcnu f14644a;

    protected zzcnt(zzcnu zzcnu) {
        this.f14644a = zzcnu;
    }

    public final void zza(zzap zzap) {
        this.f14644a.zzdkm.setException(new zzas(zzap.zzacm, zzap.errorCode));
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.f14644a.zzdkm.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
