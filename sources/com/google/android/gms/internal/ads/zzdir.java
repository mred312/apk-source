package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdir implements zzp, zzbrz, zzbto, zzdki {

    /* renamed from: a */
    private final zzdpa f15675a;

    /* renamed from: b */
    private final AtomicReference<zzsl> f15676b = new AtomicReference<>();

    /* renamed from: c */
    private final AtomicReference<zzsm> f15677c = new AtomicReference<>();

    /* renamed from: d */
    private final AtomicReference<zzsq> f15678d = new AtomicReference<>();

    /* renamed from: e */
    private final AtomicReference<zzbto> f15679e = new AtomicReference<>();

    /* renamed from: f */
    private final AtomicReference<zzp> f15680f = new AtomicReference<>();

    /* renamed from: g */
    private zzdir f15681g = null;

    public zzdir(zzdpa zzdpa) {
        this.f15675a = zzdpa;
    }

    public static zzdir zzb(zzdir zzdir) {
        zzdir zzdir2 = new zzdir(zzdir.f15675a);
        zzdir2.zzb((zzdki) zzdir);
        return zzdir2;
    }

    public final void onAdClosed() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdir.f15675a.onAdClosed();
                zzdkb.zza(zzdir.f15677c, C1746aw.f7854a);
                zzdkb.zza(zzdir.f15678d, C2677zv.f12323a);
                return;
            }
        }
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15680f, C1968gw.f8811a);
                return;
            }
        }
    }

    public final void zza(zzsq zzsq) {
        this.f15678d.set(zzsq);
    }

    public final void zzakz() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15679e, C1820cw.f8038a);
                return;
            }
        }
    }

    public final void zzk(zzve zzve) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15676b, new C2640yv(zzve));
                zzdkb.zza(zzdir.f15676b, new C2602xv(zzve));
                return;
            }
        }
    }

    public final void zzux() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15680f, C1783bw.f7943a);
                zzdkb.zza(zzdir.f15678d, C1894ew.f8405a);
                return;
            }
        }
    }

    public final void zza(zzbto zzbto) {
        this.f15679e.set(zzbto);
    }

    public final void zza(zzp zzp) {
        this.f15680f.set(zzp);
    }

    public final void zzb(zzsl zzsl) {
        this.f15676b.set(zzsl);
    }

    public final void zza(zzl zzl) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15680f, new C1857dw(zzl));
                return;
            }
        }
    }

    public final void zzb(zzsm zzsm) {
        this.f15677c.set(zzsm);
    }

    public final void zzb(zzsg zzsg) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.f15681g;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.f15676b, new C2564wv(zzsg));
                return;
            }
        }
    }

    public final void zzb(zzdki zzdki) {
        this.f15681g = (zzdir) zzdki;
    }
}
