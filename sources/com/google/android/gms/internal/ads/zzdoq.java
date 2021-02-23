package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdoq implements zzepf<zzdon> {

    /* renamed from: a */
    private final zzeps<Context> f15829a;

    /* renamed from: b */
    private final zzeps<zzayq> f15830b;

    private zzdoq(zzeps<Context> zzeps, zzeps<zzayq> zzeps2) {
        this.f15829a = zzeps;
        this.f15830b = zzeps2;
    }

    public static zzdoq zzbk(zzeps<Context> zzeps, zzeps<zzayq> zzeps2) {
        return new zzdoq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdon(this.f15829a.get(), this.f15830b.get());
    }
}
