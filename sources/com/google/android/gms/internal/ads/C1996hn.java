package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzd;

/* renamed from: com.google.android.gms.internal.ads.hn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1996hn implements zzdyo<ParcelFileDescriptor> {

    /* renamed from: a */
    private final /* synthetic */ zzatf f9228a;

    C1996hn(zzcou zzcou, zzatf zzatf) {
        this.f9228a = zzatf;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.f9228a.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            this.f9228a.zza(zzap.zzc(th));
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }
}
