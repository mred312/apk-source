package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfg implements zzepf<zzdfd> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15531a;

    /* renamed from: b */
    private final zzeps<Context> f15532b;

    private zzdfg(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.f15531a = zzeps;
        this.f15532b = zzeps2;
    }

    public static zzdfd zza(zzdzc zzdzc, Context context) {
        return new zzdfd(zzdzc, context);
    }

    public static zzdfg zzbh(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdfg(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15531a.get(), this.f15532b.get());
    }
}
