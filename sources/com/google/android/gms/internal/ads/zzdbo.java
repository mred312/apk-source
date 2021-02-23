package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbo implements zzepf<zzdbm> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15190a;

    /* renamed from: b */
    private final zzeps<Context> f15191b;

    private zzdbo(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.f15190a = zzeps;
        this.f15191b = zzeps2;
    }

    public static zzdbo zzba(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdbo(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdbm(this.f15190a.get(), this.f15191b.get());
    }
}
