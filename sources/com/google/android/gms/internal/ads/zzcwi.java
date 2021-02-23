package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwi implements zzg {

    /* renamed from: a */
    private final zzbrt f14979a;

    /* renamed from: b */
    private final zzbsl f14980b;

    /* renamed from: c */
    private final zzbyc f14981c;

    /* renamed from: d */
    private final zzbxx f14982d;

    /* renamed from: e */
    private final zzbki f14983e;

    /* renamed from: f */
    private AtomicBoolean f14984f = new AtomicBoolean(false);

    zzcwi(zzbrt zzbrt, zzbsl zzbsl, zzbyc zzbyc, zzbxx zzbxx, zzbki zzbki) {
        this.f14979a = zzbrt;
        this.f14980b = zzbsl;
        this.f14981c = zzbyc;
        this.f14982d = zzbxx;
        this.f14983e = zzbki;
    }

    public final synchronized void zzh(View view) {
        if (this.f14984f.compareAndSet(false, true)) {
            this.f14983e.onAdImpression();
            this.f14982d.zzv(view);
        }
    }

    public final void zzkb() {
        if (this.f14984f.get()) {
            this.f14979a.onAdClicked();
        }
    }

    public final void zzkc() {
        if (this.f14984f.get()) {
            this.f14980b.onAdImpression();
            this.f14981c.zzalx();
        }
    }
}
