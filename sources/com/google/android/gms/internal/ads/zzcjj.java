package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjj implements zzbrz, zzbsm, zzbtj, zzbui, zzbwl, zzva {

    /* renamed from: a */
    private final zzts f14463a;
    @GuardedBy("this")

    /* renamed from: b */
    private boolean f14464b = false;

    public zzcjj(zzts zzts, @Nullable zzdkt zzdkt) {
        this.f14463a = zzts;
        zzts.zza(zztu.zza.C3991zza.AD_REQUEST);
        if (zzdkt != null) {
            zzts.zza(zztu.zza.C3991zza.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.f14464b) {
            this.f14463a.zza(zztu.zza.C3991zza.AD_FIRST_CLICK);
            this.f14464b = true;
            return;
        }
        this.f14463a.zza(zztu.zza.C3991zza.AD_SUBSEQUENT_CLICK);
    }

    public final synchronized void onAdImpression() {
        this.f14463a.zza(zztu.zza.C3991zza.AD_IMPRESSION);
    }

    public final void onAdLoaded() {
        this.f14463a.zza(zztu.zza.C3991zza.AD_LOADED);
    }

    public final void zzalg() {
        this.f14463a.zza(zztu.zza.C3991zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzb(zzdnj zzdnj) {
        this.f14463a.zza((zztv) new C2215nk(zzdnj));
    }

    public final void zzbf(boolean z) {
        zztu.zza.C3991zza zza;
        zzts zzts = this.f14463a;
        if (z) {
            zza = zztu.zza.C3991zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zza = zztu.zza.C3991zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zzts.zza(zza);
    }

    public final void zzbg(boolean z) {
        zztu.zza.C3991zza zza;
        zzts zzts = this.f14463a;
        if (z) {
            zza = zztu.zza.C3991zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zza = zztu.zza.C3991zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zzts.zza(zza);
    }

    public final void zzc(zzue.zzb zzb) {
        this.f14463a.zza((zztv) new C2178mk(zzb));
        this.f14463a.zza(zztu.zza.C3991zza.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzd(zzatl zzatl) {
    }

    public final void zzd(zzue.zzb zzb) {
        this.f14463a.zza((zztv) new C2290pk(zzb));
        this.f14463a.zza(zztu.zza.C3991zza.REQUEST_SAVED_TO_CACHE);
    }

    public final void zze(zzue.zzb zzb) {
        this.f14463a.zza((zztv) new C2253ok(zzb));
        this.f14463a.zza(zztu.zza.C3991zza.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzk(zzve zzve) {
        switch (zzve.errorCode) {
            case 1:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.f14463a.zza(zztu.zza.C3991zza.AD_FAILED_TO_LOAD);
                return;
        }
    }
}
