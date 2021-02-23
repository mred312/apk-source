package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbll extends zzboc {

    /* renamed from: f */
    private final View f13463f;
    @Nullable

    /* renamed from: g */
    private final zzbdv f13464g;

    /* renamed from: h */
    private final zzdmx f13465h;

    /* renamed from: i */
    private final int f13466i;

    /* renamed from: j */
    private final boolean f13467j;

    /* renamed from: k */
    private final boolean f13468k;
    @Nullable

    /* renamed from: l */
    private zzsm f13469l;

    /* renamed from: m */
    private final zzble f13470m;

    zzbll(zzbob zzbob, View view, @Nullable zzbdv zzbdv, zzdmx zzdmx, int i, boolean z, boolean z2, zzble zzble) {
        super(zzbob);
        this.f13463f = view;
        this.f13464g = zzbdv;
        this.f13465h = zzdmx;
        this.f13466i = i;
        this.f13467j = z;
        this.f13468k = z2;
        this.f13470m = zzble;
    }

    public final void zza(zzsc zzsc) {
        zzbdv zzbdv = this.f13464g;
        if (zzbdv != null) {
            zzbdv.zza(zzsc);
        }
    }

    public final boolean zzaby() {
        zzbdv zzbdv = this.f13464g;
        return (zzbdv == null || zzbdv.zzacs() == null || !this.f13464g.zzacs().zzaby()) ? false : true;
    }

    public final int zzaip() {
        return this.f13466i;
    }

    public final boolean zzaiq() {
        return this.f13467j;
    }

    public final boolean zzair() {
        return this.f13468k;
    }

    public final zzdmx zzaiy() {
        return zzdns.zza(this.zzeri.zzhgw, this.f13465h);
    }

    public final View zzaiz() {
        return this.f13463f;
    }

    public final boolean zzaja() {
        zzbdv zzbdv = this.f13464g;
        return zzbdv != null && zzbdv.zzacu();
    }

    @Nullable
    public final zzsm zzajb() {
        return this.f13469l;
    }

    public final void zzb(long j, int i) {
        this.f13470m.zzb(j, i);
    }

    public final void zza(zzsm zzsm) {
        this.f13469l = zzsm;
    }
}
