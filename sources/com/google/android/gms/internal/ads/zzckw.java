package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckw implements zzepf<zzcku> {

    /* renamed from: a */
    private final zzeps<zzcko> f14521a;

    /* renamed from: b */
    private final zzeps<Set<C2591xk>> f14522b;

    /* renamed from: c */
    private final zzeps<Clock> f14523c;

    private zzckw(zzeps<zzcko> zzeps, zzeps<Set<C2591xk>> zzeps2, zzeps<Clock> zzeps3) {
        this.f14521a = zzeps;
        this.f14522b = zzeps2;
        this.f14523c = zzeps3;
    }

    public static zzckw zzo(zzeps<zzcko> zzeps, zzeps<Set<C2591xk>> zzeps2, zzeps<Clock> zzeps3) {
        return new zzckw(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcku(this.f14521a.get(), this.f14522b.get(), this.f14523c.get());
    }
}
