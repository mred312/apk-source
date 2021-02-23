package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdev implements zzepf<zzdet> {

    /* renamed from: a */
    private final zzeps<zzawx> f15518a;

    /* renamed from: b */
    private final zzeps<zzdzc> f15519b;

    /* renamed from: c */
    private final zzeps<Context> f15520c;

    private zzdev(zzeps<zzawx> zzeps, zzeps<zzdzc> zzeps2, zzeps<Context> zzeps3) {
        this.f15518a = zzeps;
        this.f15519b = zzeps2;
        this.f15520c = zzeps3;
    }

    public static zzdev zzv(zzeps<zzawx> zzeps, zzeps<zzdzc> zzeps2, zzeps<Context> zzeps3) {
        return new zzdev(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdet(this.f15518a.get(), this.f15519b.get(), this.f15520c.get());
    }
}
