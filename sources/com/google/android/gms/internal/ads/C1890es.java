package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.es */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1890es implements zzdyo<zzczx> {

    /* renamed from: a */
    private final /* synthetic */ zzaxp f8397a;

    /* renamed from: b */
    private final /* synthetic */ zzcyx f8398b;

    C1890es(zzcyx zzcyx, zzaxp zzaxp) {
        this.f8398b = zzcyx;
        this.f8397a = zzaxp;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        zzczx zzczx = (zzczx) obj;
        try {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
                if (this.f8398b.f15082d.zzegm >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcyb)).intValue()) {
                    if (zzczx == null) {
                        this.f8397a.zza((String) null, (String) null, (Bundle) null);
                        return;
                    } else {
                        this.f8397a.zza(zzczx.zzgxz, zzczx.zzgya, zzczx.zzgyb);
                        return;
                    }
                }
            }
            if (zzczx == null) {
                this.f8397a.zzk((String) null, (String) null);
            } else {
                this.f8397a.zzk(zzczx.zzgxz, zzczx.zzgya);
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzaxp zzaxp = this.f8397a;
            String valueOf = String.valueOf(th.getMessage());
            zzaxp.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
