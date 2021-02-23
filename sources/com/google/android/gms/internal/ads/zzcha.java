package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcha implements zzaij {

    /* renamed from: a */
    private final zzbsu f14360a;
    @Nullable

    /* renamed from: b */
    private final zzava f14361b;

    /* renamed from: c */
    private final String f14362c;

    /* renamed from: d */
    private final String f14363d;

    public zzcha(zzbsu zzbsu, zzdmu zzdmu) {
        this.f14360a = zzbsu;
        this.f14361b = zzdmu.zzdvb;
        this.f14362c = zzdmu.zzdli;
        this.f14363d = zzdmu.zzdlj;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzava zzava) {
        int i;
        String str;
        zzava zzava2 = this.f14361b;
        if (zzava2 != null) {
            zzava = zzava2;
        }
        if (zzava != null) {
            str = zzava.type;
            i = zzava.zzdxu;
        } else {
            str = "";
            i = 1;
        }
        this.f14360a.zzb(new zzaud(str, i), this.f14362c, this.f14363d);
    }

    public final void zztl() {
        this.f14360a.onRewardedVideoStarted();
    }

    public final void zztm() {
        this.f14360a.onRewardedVideoCompleted();
    }
}
