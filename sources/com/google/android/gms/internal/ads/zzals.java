package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzals extends zzazx<zzako> {

    /* renamed from: c */
    private final Object f12514c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzau<zzako> f12515d;

    /* renamed from: e */
    private boolean f12516e;

    /* renamed from: f */
    private int f12517f;

    public zzals(zzau<zzako> zzau) {
        this.f12515d = zzau;
        this.f12516e = false;
        this.f12517f = 0;
    }

    /* renamed from: c */
    private final void m7493c() {
        synchronized (this.f12514c) {
            Preconditions.checkState(this.f12517f >= 0);
            if (!this.f12516e || this.f12517f != 0) {
                zzd.zzee("There are still references to the engine. Not destroying.");
            } else {
                zzd.zzee("No reference is left (including root). Cleaning up engine.");
                zza(new C2049j2(this), new zzazv());
            }
        }
    }

    public final zzalo zztv() {
        zzalo zzalo = new zzalo(this);
        synchronized (this.f12514c) {
            zza(new C1975h2(this, zzalo), new C1938g2(this, zzalo));
            Preconditions.checkState(this.f12517f >= 0);
            this.f12517f++;
        }
        return zzalo;
    }

    /* access modifiers changed from: protected */
    public final void zztw() {
        synchronized (this.f12514c) {
            Preconditions.checkState(this.f12517f > 0);
            zzd.zzee("Releasing 1 reference for JS Engine");
            this.f12517f--;
            m7493c();
        }
    }

    public final void zztx() {
        synchronized (this.f12514c) {
            Preconditions.checkState(this.f12517f >= 0);
            zzd.zzee("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f12516e = true;
            m7493c();
        }
    }
}
