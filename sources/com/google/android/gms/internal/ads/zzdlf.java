package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdlf extends AdMetadataListener implements zzbru, zzbrz, zzbsi, zzbtj, zzbub, zzdki {

    /* renamed from: a */
    private final zzdpa f15739a;

    /* renamed from: b */
    private final AtomicReference<AdMetadataListener> f15740b = new AtomicReference<>();

    /* renamed from: c */
    private final AtomicReference<zzavp> f15741c = new AtomicReference<>();

    /* renamed from: d */
    private final AtomicReference<zzavi> f15742d = new AtomicReference<>();

    /* renamed from: e */
    private final AtomicReference<zzaup> f15743e = new AtomicReference<>();

    /* renamed from: f */
    private final AtomicReference<zzavq> f15744f = new AtomicReference<>();

    /* renamed from: g */
    private final AtomicReference<zzaug> f15745g = new AtomicReference<>();

    /* renamed from: h */
    private final AtomicReference<zzym> f15746h = new AtomicReference<>();

    /* renamed from: i */
    private zzdlf f15747i = null;

    public zzdlf(zzdpa zzdpa) {
        this.f15739a = zzdpa;
    }

    public static zzdlf zzb(zzdlf zzdlf) {
        zzdlf zzdlf2 = new zzdlf(zzdlf.f15739a);
        zzdlf2.zzb((zzdki) zzdlf);
        return zzdlf2;
    }

    public final void onAdClosed() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdlf.f15739a.onAdClosed();
                zzdkb.zza(zzdlf.f15742d, C1748ay.f7856a);
                zzdkb.zza(zzdlf.f15743e, C2679zx.f12325a);
                return;
            }
        }
    }

    public final void onAdLeftApplication() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15743e, C1785by.f7945a);
                return;
            }
        }
    }

    public final void onAdLoaded() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15741c, C2043ix.f9355a);
                zzdkb.zza(zzdlf.f15743e, C2117kx.f9781a);
                return;
            }
        }
    }

    public final void onAdMetadataChanged() {
        zzdlf zzdlf = this.f15747i;
        if (zzdlf != null) {
            zzdlf.onAdMetadataChanged();
        } else {
            zzdkb.zza(this.f15740b, C2377rx.f10834a);
        }
    }

    public final void onAdOpened() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15742d, C2642yx.f12239a);
                zzdkb.zza(zzdlf.f15743e, C2604xx.f11962a);
                return;
            }
        }
    }

    public final void onRewardedVideoCompleted() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15743e, C2340qx.f10742a);
                return;
            }
        }
    }

    public final void onRewardedVideoStarted() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15743e, C2080jx.f9547a);
                return;
            }
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.f15740b.set(adMetadataListener);
    }

    public final void zzd(zzym zzym) {
        this.f15746h.set(zzym);
    }

    public final void zzj(zzve zzve) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15742d, new C2303px(zzve));
                zzdkb.zza(zzdlf.f15742d, new C2418sx(zzve));
                return;
            }
        }
    }

    public final void zzk(zzve zzve) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                int i = zzve.errorCode;
                zzdkb.zza(zzdlf.f15741c, new C2455tx(zzve));
                zzdkb.zza(zzdlf.f15741c, new C2566wx(i));
                zzdkb.zza(zzdlf.f15743e, new C2529vx(i));
                return;
            }
        }
    }

    public final void zzb(zzavp zzavp) {
        this.f15741c.set(zzavp);
    }

    public final void zzb(zzavi zzavi) {
        this.f15742d.set(zzavi);
    }

    public final void zzb(zzavq zzavq) {
        this.f15744f.set(zzavq);
    }

    @Deprecated
    public final void zzb(zzaup zzaup) {
        this.f15743e.set(zzaup);
    }

    @Deprecated
    public final void zzb(zzaug zzaug) {
        this.f15745g.set(zzaug);
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15742d, new C2191mx(zzauf));
                zzdkb.zza(zzdlf.f15744f, new C2154lx(zzauf, str, str2));
                zzdkb.zza(zzdlf.f15743e, new C2266ox(zzauf));
                zzdkb.zza(zzdlf.f15745g, new C2228nx(zzauf, str, str2));
                return;
            }
        }
    }

    public final void zzb(@NonNull zzvp zzvp) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.f15747i;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.f15746h, new C2492ux(zzvp));
                return;
            }
        }
    }

    public final void zzb(zzdki zzdki) {
        this.f15747i = (zzdlf) zzdki;
    }
}
