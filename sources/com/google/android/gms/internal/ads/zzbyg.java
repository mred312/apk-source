package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbyg implements zzbyd {

    /* renamed from: a */
    private final List<String> f13852a;

    /* renamed from: b */
    private final zzdrz f13853b;

    /* renamed from: c */
    private boolean f13854c;

    public zzbyg(zzdmu zzdmu, zzdrz zzdrz) {
        this.f13852a = zzdmu.zzdup;
        this.f13853b = zzdrz;
    }

    public final void zzalx() {
        if (!this.f13854c) {
            this.f13853b.zzj(this.f13852a);
            this.f13854c = true;
        }
    }
}
