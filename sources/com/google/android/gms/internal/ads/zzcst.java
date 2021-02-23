package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcst extends zzanr implements zzbtc {
    @GuardedBy("this")

    /* renamed from: a */
    private zzano f14801a;
    @GuardedBy("this")

    /* renamed from: b */
    private zzbtf f14802b;

    public final synchronized void onAdClicked() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdFailedToLoad(i);
        }
        zzbtf zzbtf = this.f14802b;
        if (zzbtf != null) {
            zzbtf.onAdFailedToLoad(i);
        }
    }

    public final synchronized void onAdImpression() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdImpression();
        }
    }

    public final synchronized void onAdLeftApplication() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdLeftApplication();
        }
    }

    public final synchronized void onAdLoaded() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdLoaded();
        }
        zzbtf zzbtf = this.f14802b;
        if (zzbtf != null) {
            zzbtf.onAdLoaded();
        }
    }

    public final synchronized void onAdOpened() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAdOpened();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onAppEvent(str, str2);
        }
    }

    public final synchronized void onVideoEnd() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onVideoEnd();
        }
    }

    public final synchronized void onVideoPause() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onVideoPause();
        }
    }

    public final synchronized void onVideoPlay() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.onVideoPlay();
        }
    }

    public final synchronized void zza(zzbtf zzbtf) {
        this.f14802b = zzbtf;
    }

    public final synchronized void zzb(zzano zzano) {
        this.f14801a = zzano;
    }

    public final synchronized void zzc(int i, String str) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzc(i, str);
        }
        zzbtf zzbtf = this.f14802b;
        if (zzbtf != null) {
            zzbtf.zzf(i, str);
        }
    }

    public final synchronized void zzdc(int i) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzdc(i);
        }
    }

    public final synchronized void zzdj(String str) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzdj(str);
        }
    }

    public final synchronized void zzdk(String str) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzdk(str);
        }
    }

    public final synchronized void zze(zzve zzve) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zze(zzve);
        }
    }

    public final synchronized void zzun() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzun();
        }
    }

    public final synchronized void zzuo() {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzuo();
        }
    }

    public final synchronized void zza(zzant zzant) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zza(zzant);
        }
    }

    public final synchronized void zzb(zzava zzava) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzb(zzava);
        }
    }

    public final synchronized void zza(zzaff zzaff, String str) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zza(zzaff, str);
        }
    }

    public final synchronized void zzb(Bundle bundle) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzb(bundle);
        }
    }

    public final synchronized void zzc(zzve zzve) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zzc(zzve);
        }
        zzbtf zzbtf = this.f14802b;
        if (zzbtf != null) {
            zzbtf.zzk(zzve);
        }
    }

    public final synchronized void zza(zzavc zzavc) {
        zzano zzano = this.f14801a;
        if (zzano != null) {
            zzano.zza(zzavc);
        }
    }
}
