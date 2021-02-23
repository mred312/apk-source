package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdf implements zzepf<zzcdd> {

    /* renamed from: a */
    private final zzeps<zzcgh> f14140a;

    /* renamed from: b */
    private final zzeps<Clock> f14141b;

    public zzcdf(zzeps<zzcgh> zzeps, zzeps<Clock> zzeps2) {
        this.f14140a = zzeps;
        this.f14141b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcdd(this.f14140a.get(), this.f14141b.get());
    }
}
