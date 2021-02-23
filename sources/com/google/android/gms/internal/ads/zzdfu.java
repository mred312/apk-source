package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfu implements zzepf<zzdfs> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15561a;

    /* renamed from: b */
    private final zzeps<Context> f15562b;

    private zzdfu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.f15561a = zzeps;
        this.f15562b = zzeps2;
    }

    public static zzdfu zzbj(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdfu(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdfs(this.f15561a.get(), this.f15562b.get());
    }
}
