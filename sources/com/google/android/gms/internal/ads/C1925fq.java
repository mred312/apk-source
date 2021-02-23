package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.fq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1925fq extends zzauz {

    /* renamed from: a */
    private final /* synthetic */ zzbtr f8485a;

    /* renamed from: b */
    private final /* synthetic */ zzbrt f8486b;

    /* renamed from: c */
    private final /* synthetic */ zzbsu f8487c;

    /* renamed from: d */
    private final /* synthetic */ zzbyi f8488d;

    C1925fq(zzcvo zzcvo, zzbtr zzbtr, zzbrt zzbrt, zzbsu zzbsu, zzbyi zzbyi) {
        this.f8485a = zzbtr;
        this.f8486b = zzbrt;
        this.f8487c = zzbsu;
        this.f8488d = zzbyi;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzava zzava) {
        this.f8488d.zza(zzava);
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.f8485a.zzux();
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.f8488d.zztl();
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.f8485a.zza(zzl.OTHER);
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.f8486b.onAdClicked();
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.f8487c.onAdLeftApplication();
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.f8487c.onRewardedVideoCompleted();
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
