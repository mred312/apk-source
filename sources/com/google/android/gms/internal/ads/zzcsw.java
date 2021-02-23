package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsw extends zzauz implements zzbtc {
    @GuardedBy("this")

    /* renamed from: a */
    private zzauw f14814a;
    @GuardedBy("this")

    /* renamed from: b */
    private zzbtf f14815b;
    @GuardedBy("this")

    /* renamed from: c */
    private zzbyl f14816c;

    public final synchronized void zza(zzauw zzauw) {
        this.f14814a = zzauw;
    }

    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzaf(iObjectWrapper);
        }
        zzbyl zzbyl = this.f14816c;
        if (zzbyl != null) {
            zzbyl.onInitializationSucceeded();
        }
    }

    public final synchronized void zzag(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzag(iObjectWrapper);
        }
        zzbtf zzbtf = this.f14815b;
        if (zzbtf != null) {
            zzbtf.onAdLoaded();
        }
    }

    public final synchronized void zzah(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzah(iObjectWrapper);
        }
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzai(iObjectWrapper);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzaj(iObjectWrapper);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zzam(IObjectWrapper iObjectWrapper) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzam(iObjectWrapper);
        }
    }

    public final synchronized void zzb(Bundle bundle) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzb(bundle);
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zzd(iObjectWrapper, i);
        }
        zzbyl zzbyl = this.f14816c;
        if (zzbyl != null) {
            zzbyl.zzdy(i);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zze(iObjectWrapper, i);
        }
        zzbtf zzbtf = this.f14815b;
        if (zzbtf != null) {
            zzbtf.onAdFailedToLoad(i);
        }
    }

    public final synchronized void zza(zzbtf zzbtf) {
        this.f14815b = zzbtf;
    }

    public final synchronized void zza(zzbyl zzbyl) {
        this.f14816c = zzbyl;
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzava zzava) {
        zzauw zzauw = this.f14814a;
        if (zzauw != null) {
            zzauw.zza(iObjectWrapper, zzava);
        }
    }
}
